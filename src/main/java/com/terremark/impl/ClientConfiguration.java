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
package com.terremark.impl;

import org.apache.http.client.HttpClient;

import com.terremark.config.ContentType;
import com.terremark.config.RetryHandler;
import com.terremark.config.SignatureAlgorithm;
import com.terremark.config.Version;

/**
 * Configuration used internally for creating {@link com.terremark.TerremarkClient TerremarkClient}.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public final class ClientConfiguration {
    /** End point URL */
    private final String uri;
    /** User name for basic authentication */
    private final String userName;
    /** Password for basic authentication */
    private final transient String password;
    /** Access key for Cloud API authentication */
    private final String accessKey;
    /** Private key for Cloud API authentication */
    private final transient String privateKey;
    /** Content type (XML or JSON) */
    private final ContentType contentType;
    /** Signature algorithm (Cloud API authentication) */
    private final SignatureAlgorithm signatureAlgorithm;
    /** API version to use */
    private final Version version;
    /** Proxy host */
    private final String proxyHost;
    /** Proxy port */
    private final int proxyPort;
    /** Apache HttpClient */
    private final HttpClient httpClient;
    /** Retry handler */
    private final RetryHandler retryHandler;

    /**
     * Default constructor.
     *
     * @param uri End point URL.
     * @param userName User name for basic authentication.
     * @param password Password for basic authentication.
     * @param accessKey Access key for Cloud API authentication.
     * @param privateKey Private key for Cloud API authentication.
     * @param contentType Content type (XML or JSON).
     * @param signatureAlgorithm Signature algorithm (Cloud API authentication).
     * @param version API version.
     * @param proxyHost Proxy host name or IP address.
     * @param proxyPort Proxy port.
     * @param httpClient Apache HttpClient.
     * @param retryHandler Retry handler.
     */
    @SuppressWarnings("PMD.ExcessiveParameterList")
    public ClientConfiguration(final String uri, final String userName, final String password, final String accessKey,
                    final String privateKey, final ContentType contentType,
                    final SignatureAlgorithm signatureAlgorithm, final Version version, final String proxyHost,
                    final int proxyPort, final HttpClient httpClient, final RetryHandler retryHandler) {
        this.uri = uri;
        this.userName = userName;
        this.password = password;
        this.accessKey = accessKey;
        this.privateKey = privateKey;
        this.contentType = contentType;
        this.signatureAlgorithm = signatureAlgorithm;
        this.version = version;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.httpClient = httpClient;
        this.retryHandler = retryHandler;
    }

    /**
     * Returns the API access key for Cloud API authentication.
     *
     * @return API access key.
     */
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * Return the user password for basic authentication.
     *
     * @return User password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the proxy host.
     *
     * @return Proxy host.
     */
    public String getProxyHost() {
        return proxyHost;
    }

    /**
     * Returns the proxy port.
     *
     * @return Proxy port.
     */
    public int getProxyPort() {
        return proxyPort;
    }

    /**
     * Returns the private key used for Cloud API authentication.
     *
     * @return Private key.
     */
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * Returns the content type to use when communicating with the endpoint.
     *
     * @return Content type.
     */
    public ContentType getContentType() {
        return contentType;
    }

    /**
     * Returns the signature algorithm to use for Cloud API authentication.
     *
     * @return Signature algorithm.
     */
    public SignatureAlgorithm getSignatureAlgorithm() {
        return signatureAlgorithm;
    }

    /**
     * Returns the API endpoint URI.
     *
     * @return API endpoint URI.
     */
    public String getUri() {
        return uri;
    }

    /**
     * Returns the user name for performing the basic authentication.
     *
     * @return User name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns the API version to use.
     *
     * @return API version.
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Returns the Apache HttpClient to use for communicating with the Terremark API end point.
     *
     * @return Http client to use.
     */
    public HttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * Returns the optional retry handler.
     *
     * @return Retry handler.
     */
    public RetryHandler getRetryHandler() {
        return retryHandler;
    }
}