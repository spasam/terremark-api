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
package com.terremark.config;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;

import com.terremark.impl.ClientConfiguration;

/**
 * Properties necessary to instantiate Terremark client. Most of the property use appropriate default values. At a
 * minimum {@link #setEndPoint(String)}, {@link #setAccessKey(String)} and {@link #setPrivateKey(String)} should be set.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 * @see com.terremark.TerremarkFactory#getClient(PropertiesBuilder)
 */
public class PropertiesBuilder {
    /** Default Terremark eCloud API end point URL */
    public static final String ENDPOINT_URL = "https://services.enterprisecloud.terremark.com/cloudapi/ecloud";
    /** API end point URL */
    private String uri;
    /** User name for basic authentication */
    private String userName;
    /** Password for basic authentication */
    private transient String password;
    /** Access key for Cloud API authentication */
    private String accessKey;
    /** Private key for Cloud API authentication */
    private transient String privateKey;
    /** Content type */
    private ContentType contentType;
    /** Signature algorithm */
    private SignatureAlgorithm signatureAlgorithm;
    /** API version */
    private Version version;
    /** Proxy host name */
    private String proxyHost;
    /** Proxy port */
    private int proxyPort;
    /** Apache HttpClient */
    private HttpClient httpClient;
    /** Retry handler for retrying failed GET calls */
    private RetryHandler retryHandler;

    /**
     * Default constructor. Sets the context type to {@link ContentType#XML}, signature algorithm to
     * {@link SignatureAlgorithm#HMAC_SHA256} and API version to {@link Version#VERSION_2_12}. API end point URL is set
     * to the default value (https://services.enterprisecloud.terremark.com/cloudapi/ecloud).
     */
    public PropertiesBuilder() {
        this.uri = ENDPOINT_URL;
        this.contentType = ContentType.XML;
        this.signatureAlgorithm = SignatureAlgorithm.HMAC_SHA256;
        this.version = Version.VERSION_2_12;
    }

    /**
     * Used internally to retrieve the configuration set by the user. Validates the arguments and throws
     * {@link IllegalArgumentException} if the arguments are invalid or missing.
     *
     * @return Client configuration.
     * @throws MalformedURLException If the API end point URL is invalid.
     */
    public final ClientConfiguration build() throws MalformedURLException {
        if (httpClient == null) {
            throw new IllegalArgumentException("Invalid HTTP client");
        }
        if (StringUtils.isEmpty(uri)) {
            throw new IllegalArgumentException("Invalid endpoint URI");
        }
        if (!StringUtils.isEmpty(userName) && StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("Invalid password");
        }
        if (!StringUtils.isEmpty(accessKey) && StringUtils.isEmpty(privateKey)) {
            throw new IllegalArgumentException("Invalid private key");
        }
        if (StringUtils.isEmpty(userName) && StringUtils.isEmpty(accessKey)) {
            throw new IllegalArgumentException("Either username/password or access/private keys must be specified");
        }
        if (contentType == null) {
            throw new IllegalArgumentException("Invalid content type");
        }
        if (signatureAlgorithm == null) {
            throw new IllegalArgumentException("Invalid signature algorithm");
        }
        if (!"https".equalsIgnoreCase(new URL(uri).getProtocol())) {
            throw new IllegalArgumentException("API end point URL must use 'https' protocol");
        }

        return new ClientConfiguration(uri, userName, password, accessKey, privateKey, contentType, signatureAlgorithm,
                        version, proxyHost, proxyPort, httpClient, retryHandler);
    }

    /**
     * Set the API end point URL. This is required property.
     *
     * @param uri API end point URL.
     * @return The builder object reference.
     */
    public final PropertiesBuilder setEndPoint(final String uri) {
        if (StringUtils.isEmpty(uri)) {
            throw new IllegalArgumentException("Invalid endpoint URI");
        }

        URI.create(uri); // Validate
        this.uri = uri;
        return this;
    }

    /**
     * Set the proxy host (name or IP address) to use, when connecting to the API end point. This is optional property.
     *
     * @param proxyHost Proxy host (name or IP address).
     * @return The builder object reference.
     * @see #setProxyPort(int)
     */
    public final PropertiesBuilder setProxyHost(final String proxyHost) {
        this.proxyHost = proxyHost;
        return this;
    }

    /**
     * Set the proxy port to use, when connecting to the API end point. This is optional property, but required if
     * {@code proxy host} is set.
     *
     * @param proxyPort Proxy port number.
     * @return The builder object reference.
     * @see #setProxyHost(String)
     */
    public final PropertiesBuilder setProxyPort(final int proxyPort) {
        this.proxyPort = proxyPort;
        return this;
    }

    /**
     * Set the access key for performing the Cloud API authentication. This is required, if Cloud API authentication
     * should be used. Either this or {@code user name} are required.
     *
     * @param accessKey Access key for Cloud API authentication.
     * @return The builder object reference.
     * @see #setPrivateKey(String)
     * @see #setUserName(String)
     */
    public final PropertiesBuilder setAccessKey(final String accessKey) {
        this.accessKey = accessKey;
        return this;
    }

    /**
     * Set the private key for performing the Cloud API authentication. This is required, if the {@code access key} is
     * set.
     *
     * @param privateKey Private key for Cloud API authentication.
     * @return The builder object reference.
     * @see #setAccessKey(String)
     */
    public final PropertiesBuilder setPrivateKey(final String privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    /**
     * Set the content type to use. Currently only {@link ContentType#XML} is valid. This is optional and defaults to
     * {@link ContentType#XML}.
     *
     * @param contentType Content type to use.
     * @return The builder object reference.
     * @see ContentType
     */
    public final PropertiesBuilder setContentType(final ContentType contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     * Signature algorithm to use when Cloud API authentication is configured. This is optional and defaults to
     * {@link SignatureAlgorithm#HMAC_SHA256}. This is not applicable when basic user name/password authentication is
     * used.
     *
     * @param signatureAlgorithm Signature algorithm to use.
     * @return The builder object reference.
     */
    public final PropertiesBuilder setSignatureAlgorithm(final SignatureAlgorithm signatureAlgorithm) {
        this.signatureAlgorithm = signatureAlgorithm;
        return this;
    }

    /**
     * {@code Apache HttpClient} to use for connecting to the API end point. It is recommended to configure connection
     * pooling on the client. This is required.
     *
     * @param httpClient HttpClient to use for connecting to the API end point.
     * @return The builder object reference.
     */
    public final PropertiesBuilder setHttpClient(final HttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    /**
     * Retry handler to use for determining if failed {@code GET} calls should be retried. Only {@code HTTP GET} calls
     * can be retried. This handler will not be invoked for other types of HTTP requests (POST, PUT, DELETE). This is
     * optional. If not specified, HTTP GET calls that fail with 500+ error codes will not be retried.
     *
     * @param retryHandler Retry handler.
     * @return The builder object reference.
     */
    public final PropertiesBuilder setRetryHandler(final RetryHandler retryHandler) {
        this.retryHandler = retryHandler;
        return this;
    }

    /**
     * Set the user name to use for performing basic authentication. This is not recommended authentication method.
     * Instead Cloud API authentication should be used.
     *
     * @param userName User name for basic authentication.
     * @return The builder object reference.
     * @see #setAccessKey(String)
     * @see #setPassword(String)
     */
    public final PropertiesBuilder setUserName(final String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Set the user password for performing basic authentication. This is not recommended authentication method. Instead
     * Cloud API authentication should be used.
     *
     * @param password Password for basic authentication.
     * @return The builder object reference.
     * @see #setUserName(String)
     */
    public final PropertiesBuilder setPassword(final String password) {
        this.password = password;
        return this;
    }

    /**
     * Set the API version to use. This is optional. If not specified, {@link Version#VERSION_2_12} will be used.
     *
     * @param version API version to use.
     * @return The builder object reference.
     * @see Version
     */
    public final PropertiesBuilder setAPIVersion(final Version version) {
        this.version = version;
        return this;
    }
}
