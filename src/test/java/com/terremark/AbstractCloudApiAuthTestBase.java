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
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.junit.BeforeClass;

import com.terremark.config.PropertiesBuilder;

/**
 * TODO
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public abstract class AbstractCloudApiAuthTestBase extends AbstractTestBase {
    /**
     * TODO
     *
     * @throws Exception If there is a problem authenticating using Cloud API auth.
     */
    @BeforeClass
    public static void cloudApiAuth() throws Exception {
        ThreadSafeClientConnManager httpConnectionManager = new ThreadSafeClientConnManager(
                        SchemeRegistryFactory.createDefault());
        httpConnectionManager.setMaxTotal(10);
        httpConnectionManager.setDefaultMaxPerRoute(10);

        final PropertiesBuilder props = new PropertiesBuilder().setEndPoint(ENDPOINT_URL).setAccessKey(ACCESS_KEY)
                        .setAPIVersion(VERSION).setContentType(CONTENT_TYPE).setPrivateKey(PRIVATE_KEY)
                        .setHttpClient(new DefaultHttpClient(httpConnectionManager));
        client = TerremarkFactory.getClient(props);
    }
}