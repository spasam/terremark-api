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
package com.terremark;

import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import com.terremark.annotations.Order;
import com.terremark.config.PropertiesBuilder;
import com.terremark.config.SignatureAlgorithm;

/**
 * TODO
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class AuthenticationTest extends AbstractTestBase {
    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(1)
    @Test
    public void testCloudApiAuthentication() throws Exception {
        for (SignatureAlgorithm algorithm : SignatureAlgorithm.values()) {
            final PropertiesBuilder props = new PropertiesBuilder().setEndPoint(ENDPOINT_URL).setAccessKey(ACCESS_KEY)
                            .setAPIVersion(VERSION).setContentType(CONTENT_TYPE).setPrivateKey(PRIVATE_KEY)
                            .setSignatureAlgorithm(algorithm).setHttpClient(new DefaultHttpClient());
            client = TerremarkFactory.getClient(props);

            getOrganizations();
        }
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(2)
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidUri() throws Exception {
        new PropertiesBuilder().setAccessKey(ACCESS_KEY).setAPIVersion(VERSION).setContentType(CONTENT_TYPE)
                        .setPrivateKey(PRIVATE_KEY).setHttpClient(new DefaultHttpClient()).build();
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(3)
    @Test(expected = IllegalArgumentException.class)
    public void testUserNoPassword() throws Exception {
        new PropertiesBuilder().setEndPoint(ENDPOINT_URL).setAPIVersion(VERSION).setContentType(CONTENT_TYPE)
                        .setUserName(USER).setHttpClient(new DefaultHttpClient()).build();
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(4)
    @Test(expected = IllegalArgumentException.class)
    public void testAccessKeyNoPrivateKey() throws Exception {
        new PropertiesBuilder().setEndPoint(ENDPOINT_URL).setAPIVersion(VERSION).setContentType(CONTENT_TYPE)
                        .setAccessKey(ACCESS_KEY).setHttpClient(new DefaultHttpClient()).build();
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(5)
    @Test(expected = IllegalArgumentException.class)
    public void testNoCredentials() throws Exception {
        new PropertiesBuilder().setEndPoint(ENDPOINT_URL).setAPIVersion(VERSION).setContentType(CONTENT_TYPE)
                        .setHttpClient(new DefaultHttpClient()).build();
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(6)
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContentType() throws Exception {
        new PropertiesBuilder().setEndPoint(ENDPOINT_URL).setAccessKey(ACCESS_KEY).setAPIVersion(VERSION)
                        .setContentType(null).setPrivateKey(PRIVATE_KEY).setHttpClient(new DefaultHttpClient()).build();
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(7)
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSignatureAlgorithm() throws Exception {
        new PropertiesBuilder().setEndPoint(ENDPOINT_URL).setAccessKey(ACCESS_KEY).setAPIVersion(VERSION)
                        .setContentType(CONTENT_TYPE).setSignatureAlgorithm(null).setPrivateKey(PRIVATE_KEY)
                        .setHttpClient(new DefaultHttpClient()).build();
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(8)
    @Test
    public void testBasicAuthentication() throws Exception {
        final PropertiesBuilder props = new PropertiesBuilder().setEndPoint(ENDPOINT_URL).setUserName(USER)
                        .setPassword(PASSWORD).setAPIVersion(VERSION).setContentType(CONTENT_TYPE)
                        .setHttpClient(new DefaultHttpClient());
        client = TerremarkFactory.getClient(props);

        getOrganizations();
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(9)
    @Test(expected = IllegalArgumentException.class)
    public void testNoHttpClient() throws Exception {
        final PropertiesBuilder props = new PropertiesBuilder().setEndPoint(ENDPOINT_URL).setUserName(USER)
                        .setPassword(PASSWORD).setAPIVersion(VERSION).setContentType(CONTENT_TYPE);
        client = TerremarkFactory.getClient(props);

        getOrganizations();
    }
}