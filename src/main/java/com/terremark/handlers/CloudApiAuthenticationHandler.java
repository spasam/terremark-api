/**
 * Copyright 2012 Terremark Worldwide Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.terremark.handlers;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.core.HttpHeaders;

import org.apache.commons.codec.binary.Base64;
import org.apache.wink.client.ClientRequest;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.handlers.ClientHandler;
import org.apache.wink.client.handlers.HandlerContext;
import org.apache.wink.client.internal.handlers.ClientRequestImpl;

import com.terremark.annotations.AuthenticationNotRequired;
import com.terremark.config.SignatureAlgorithm;

/**
 * Cloud API authentication handler. If the client is configured for Cloud API authentication this handler should be
 * added to the chain. This handler will add the {@code x-tmrk-authorization} header before the request is sent to the
 * server.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class CloudApiAuthenticationHandler implements ClientHandler {
    /** Terremark specific headers prefix */
    private static final String TERREMARK_HEADER_PREFIX = "x-tmrk-";
    /** Terremark specific authorization header */
    private static final String TERREMARK_AUTHORIZATION_HEADER = "x-tmrk-authorization";
    /** Access key for Cloud API signing */
    private final String accessKey;
    /** Private key for Cloud API signing */
    private transient final String privateKey;
    /** Signing algorithm */
    private final SignatureAlgorithm algorithm;

    /**
     * Default constructor.
     *
     * @param accessKey Access key.
     * @param privateKey Private key.
     * @param algorithm Signing algorithm.
     */
    public CloudApiAuthenticationHandler(final String accessKey, final String privateKey,
                    final SignatureAlgorithm algorithm) {
        this.accessKey = accessKey;
        this.privateKey = privateKey;
        this.algorithm = algorithm;
    }

    /**
     * Method invoked in the chain. If the request entity class is not annotated with
     * {@link com.terremark.annotations.AuthenticationNotRequired AuthenticationNotRequired} this method will add the
     * {@code x-tmrk-authorization} header.
     *
     * @param request Client request.
     * @param context Request context.
     * @return Client response.
     * @throws Exception If there is a problem invoking the chain.
     */
    @Override
    @SuppressWarnings("PMD.SignatureDeclareThrowsException")
    public final ClientResponse handle(final ClientRequest request, final HandlerContext context) throws Exception {
        final Class<?> responseEntityClass = (Class<?>) request.getAttributes().get(
                        ClientRequestImpl.RESPONSE_ENTITY_CLASS_TYPE);
        if (responseEntityClass == null || !responseEntityClass.isAnnotationPresent(AuthenticationNotRequired.class)) {
            request.getHeaders().putSingle(TERREMARK_AUTHORIZATION_HEADER,
                            getTerremarkAuthorizationHeaderValue(request));
        }

        return context.doChain(request);
    }

    /**
     * Builds a formatted string a Terremark specific headers (excluding x-tmrk-authorization).
     *
     * @param request Client request.
     * @return Formatted string of Terremark specific headers and values.
     */
    private static String getCanonicalizedHeaders(final ClientRequest request) {
        final Map<String, String> headers = new TreeMap<String, String>();

        for (final Map.Entry<String, List<String>> entry : request.getHeaders().entrySet()) {
            final String headerName = entry.getKey().toLowerCase();

            if (!headerName.startsWith(TERREMARK_HEADER_PREFIX) || TERREMARK_AUTHORIZATION_HEADER.equals(headerName)) {
                continue;
            }

            if (entry.getValue() != null && entry.getValue().size() > 0) {
                headers.put(headerName, entry.getValue().get(0));
            }
        }

        final StringBuilder builder = new StringBuilder();
        for (final Map.Entry<String, String> entry : headers.entrySet()) {
            builder.append(entry.getKey()).append(':').append(entry.getValue()).append('\n');
        }

        if (builder.length() < 1) {
            builder.append('\n');
        }

        return builder.toString();
    }

    /**
     * Builds a formatted string for the URI and the query string.
     *
     * @param request Client request.
     * @return Formatted URI and query arguments.
     */
    private static String getCanonicalizedResource(final ClientRequest request) {
        final Map<String, String> queryMap = new TreeMap<String, String>();
        final URI uri = request.getURI();
        final String query = uri.getQuery();

        if (query != null && query.length() > 0) {
            final String[] parts = query.split("&");

            for (final String part : parts) {
                final String[] nameValue = part.split("=");
                if (nameValue.length == 2) {
                    queryMap.put(nameValue[0].toLowerCase(), nameValue[1]);
                }
            }
        }

        final StringBuilder builder = new StringBuilder();
        builder.append(uri.getPath().toLowerCase()).append('\n');

        for (final Map.Entry<String, String> entry : queryMap.entrySet()) {
            builder.append(entry.getKey()).append(':').append(entry.getValue()).append('\n');
        }

        return builder.toString();
    }

    /**
     * Returns the content length header value.
     *
     * @param request Client request.
     * @return Content length.
     */
    private static String getContentLength(final ClientRequest request) {
        return getHeaderValue(request, HttpHeaders.CONTENT_LENGTH);
    }

    /**
     * Returns the content type header value.
     *
     * @param request Client request.
     * @return Content type.
     */
    private static String getContentType(final ClientRequest request) {
        return getHeaderValue(request, HttpHeaders.CONTENT_TYPE);
    }

    /**
     * Returns the date header value.
     *
     * @param request Client request.
     * @return Date.
     */
    private static String getDate(final ClientRequest request) {
        return getHeaderValue(request, HttpHeaders.DATE);
    }

    /**
     * Generic method to return header value. If the header is not set, a new line is returned.
     *
     * @param request Client request.
     * @param headerName Header name.
     * @return Header value with new line appended.
     */
    private static String getHeaderValue(final ClientRequest request, final String headerName) {
        final List<String> value = request.getHeaders().get(headerName);

        return (value == null || value.isEmpty()) ? "\n" : (value.get(0) + '\n');
    }

    /**
     * Returns HMAC instance initialized with the private key.
     *
     * @return HMAC instance.
     * @throws NoSuchAlgorithmException If the HMAC algorithm is not available.
     * @throws InvalidKeyException If the private key is malformed.
     * @throws UnsupportedEncodingException If UTF-8 character encoding is not supported.
     */
    private Mac getMac() throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        String algo;
        switch (algorithm) {
        case HMAC_SHA1:
            algo = "HmacSHA1";
            break;
        case HMAC_SHA256:
            algo = "HmacSHA256";
            break;
        case HMAC_SHA512:
            algo = "HmacSHA512";
            break;
        default:
            throw new UnsupportedOperationException("Not implemented: " + algorithm.toString());
        }

        final Mac mac = Mac.getInstance(algo);
        mac.init(new SecretKeySpec(privateKey.getBytes("UTF-8"), algo));

        return mac;
    }

    /**
     * Builds the string to sign and signs it.
     *
     * @param request Client request.
     * @return Signature.
     * @throws NoSuchAlgorithmException If the HMAC algorithm is not available.
     * @throws InvalidKeyException If the private key is malformed.
     * @throws UnsupportedEncodingException If UTF-8 character encoding is not supported.
     */
    private String getSignature(final ClientRequest request) throws NoSuchAlgorithmException,
                    UnsupportedEncodingException, InvalidKeyException {
        final StringBuilder stringToSign = new StringBuilder().append(getVerb(request))
                        .append(getContentLength(request)).append(getContentType(request)).append(getDate(request))
                        .append(getCanonicalizedHeaders(request)).append(getCanonicalizedResource(request));

        final byte[] digest = getMac().doFinal(stringToSign.toString().getBytes("UTF-8"));

        return Base64.encodeBase64String(digest);
    }

    /**
     * Returns the signature type that should be specified in the {@code x-tmrk-authorization} header.
     *
     * @return Signature type used.
     */
    private String getSignatureType() {
        switch (algorithm) {
        case HMAC_SHA1:
            return "HmacSha1";
        case HMAC_SHA256:
            return "HmacSha256";
        case HMAC_SHA512:
            return "HmacSha512";
        default:
            throw new UnsupportedOperationException("Not implemented: " + algorithm.toString());
        }
    }

    /**
     * Returns the value of the {@code x-tmrk-authorization} header.
     *
     * @param request Client request.
     * @return {@code x-tmrk-authorization} header value.
     * @throws NoSuchAlgorithmException If the HMAC algorithm is not available.
     * @throws InvalidKeyException If the private key is malformed.
     * @throws UnsupportedEncodingException If UTF-8 character encoding is not supported.
     */
    private String getTerremarkAuthorizationHeaderValue(final ClientRequest request) throws InvalidKeyException,
                    NoSuchAlgorithmException, IllegalStateException, UnsupportedEncodingException {
        return "CloudApi AccessKey=\"" + accessKey + "\" SignatureType=\"" + getSignatureType() + "\" Signature=\""
                        + getSignature(request) + "\"";
    }

    /**
     * The HTTP request type.
     *
     * @param request Client request.
     * @return Request verb
     */
    private static String getVerb(final ClientRequest request) {
        return request.getMethod().toUpperCase() + '\n';
    }
}