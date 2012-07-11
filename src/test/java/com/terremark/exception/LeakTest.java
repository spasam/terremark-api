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
package com.terremark.exception;

import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.SyncBasicHttpParams;
import org.apache.wink.client.ClientRuntimeException;
import org.apache.wink.client.ClientWebException;
import org.apache.wink.client.MockHttpServer;
import org.apache.wink.client.MockHttpServer.MockHttpServerResponse;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.apache.wink.client.httpclient.ApacheHttpClientConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.terremark.AbstractTestBase;

/**
 * TODO
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class LeakTest extends AbstractTestBase {
    /** TODO */
    private MockHttpServer httpServer;

    /**
     * TODO
     */
    @Before
    public void startHttpSerer() {
        final MockHttpServerResponse[] responses = new MockHttpServerResponse[20];
        for (int i = 0; i < responses.length; i++) {
            responses[i] = new MockHttpServerResponse();
            responses[i].setMockResponseCode(503);
            responses[i].setMockResponseContentType("text/html");
            responses[i].setMockResponseContent("Unavailable");
        }

        httpServer = new MockHttpServer(44290);
        httpServer.setMockHttpServerResponses(responses);
        httpServer.startServer();
    }

    /**
     * TODO
     */
    @After
    public void stopHttpSerer() {
        httpServer.stopServer();
    }

    /**
     * TODO
     */
    @Test
    public void test503Errors() {
        httpServer.setDelayResponse(0);

        final DefaultHttpClient httpClient = getHttpClient();
        final RestClient client = new RestClient(new ApacheHttpClientConfig(httpClient));

        try {
            for (int i = 0; i < 10; i++) {
                try {
                    Resource resource = client.resource("http://localhost:" + httpServer.getServerPort());
                    resource.get(Object.class);
                } catch (ClientWebException ex) {
                    ex.getResponse().consumeContent();
                }
            }
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    /**
     * TODO
     */
    @Test
    public void testConnectionTimeouts() {
        httpServer.setDelayResponse(10000);

        final DefaultHttpClient httpClient = getHttpClient();
        final RestClient client = new RestClient(new ApacheHttpClientConfig(httpClient));

        try {
            for (int i = 0; i < 10; i++) {
                try {
                    Resource resource = client.resource("http://localhost:" + httpServer.getServerPort());
                    resource.get(Object.class);
                } catch (ClientRuntimeException ex) {
                    // Ignore
                }
            }
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    /**
     * TODO
     *
     * @return TODO
     */
    private static DefaultHttpClient getHttpClient() {
        final HttpParams params = new SyncBasicHttpParams();
        params.setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 1000);
        params.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 1000);

        final SchemeRegistry schemeRegistry = SchemeRegistryFactory.createDefault();
        final ThreadSafeClientConnManager httpConnectionManager = new ThreadSafeClientConnManager(schemeRegistry);

        httpConnectionManager.setMaxTotal(3);
        httpConnectionManager.setDefaultMaxPerRoute(3);

        return new DefaultHttpClient(httpConnectionManager, params);
    }
}