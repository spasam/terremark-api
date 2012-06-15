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

import javax.ws.rs.core.HttpHeaders;

import org.apache.commons.codec.binary.Base64;
import org.apache.wink.client.ClientRequest;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.handlers.ClientHandler;
import org.apache.wink.client.handlers.HandlerContext;
import org.apache.wink.client.internal.handlers.ClientRequestImpl;

import com.terremark.annotations.AuthenticationNotRequired;

/**
 * Basic authentication handler. If the client is configured for basic authentication this handler should be added to
 * the chain. This handler will add the {@code Authorization} header before the request is sent to the server.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class BasicAuthenticationHandler implements ClientHandler {
    /** Authorization header value, computed once and saved */
    private transient final String authHeader;

    /**
     * Default constructor. Takes the credentials and pre-computes the {@code Authorization} header.
     *
     * @param userName User name.
     * @param password Password.
     */
    public BasicAuthenticationHandler(final String userName, final String password) {
        try {
            final String credentials = userName + ":" + password;
            final byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes("UTF-8"), false);
            this.authHeader = "Basic " + new String(encodedCredentials, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    /**
     * Method invoked in the chain. If the request entity class is not annotated with
     * {@link com.terremark.annotations.AuthenticationNotRequired AuthenticationNotRequired} this method will add the
     * {@code Authorization} header.
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
        if (!responseEntityClass.isAnnotationPresent(AuthenticationNotRequired.class)) {
            request.getHeaders().putSingle(HttpHeaders.AUTHORIZATION, authHeader);
        }

        return context.doChain(request);
    }
}
