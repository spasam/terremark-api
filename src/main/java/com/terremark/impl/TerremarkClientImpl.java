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

import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.apache.wink.client.ClientConfig;
import org.apache.wink.client.RestClient;
import org.apache.wink.client.handlers.ClientHandler;
import org.apache.wink.client.httpclient.ApacheHttpClientConfig;

import com.terremark.ComputePoolHandler;
import com.terremark.EnvironmentHandler;
import com.terremark.NetworkHandler;
import com.terremark.OrganizationHandler;
import com.terremark.TerremarkClient;
import com.terremark.api.SupportedVersions;
import com.terremark.api.Time;
import com.terremark.api.VersionInfo;
import com.terremark.config.ContentType;
import com.terremark.config.PropertiesBuilder;
import com.terremark.config.Version;
import com.terremark.exception.InternalServerException;
import com.terremark.exception.TerremarkException;
import com.terremark.handlers.BasicAuthenticationHandler;
import com.terremark.handlers.CloudApiAuthenticationHandler;
import com.terremark.handlers.CustomHeadersHandler;
import com.terremark.handlers.HTTPLoggingHandler;
import com.terremark.impl.jaxrs.TerremarkJAXBJsonProvider;
import com.terremark.impl.jaxrs.TerremarkJAXBXmlProvider;

/**
 * Terremark Java API client implementation. This is responsible for creating the rest client from the provided
 * properties. It automatically gets and validates the supported versions. The server time is retrieved upon the
 * creation of the rest client and the clock drift between the server and the client is calculated. Various handlers are
 * made available to expose the API calls.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public final class TerremarkClientImpl implements TerremarkClient {
    /** Rest client */
    private final RestClient client;
    /** Compute pools handler */
    private final ComputePoolHandler cpHandler;
    /** Environment handler */
    private final EnvironmentHandler envHandler;
    /** Network handler */
    private final NetworkHandler netHandler;
    /** Organization handler */
    private final OrganizationHandler orgHandler;
    /** Client properties */
    private final ClientConfiguration properties;
    /** Version and date provider */
    private final VersionAndDateProvider versionAndDateProvider;

    /**
     * Default constructor. Creates the rest client and handlers. Get the server time and API versions. Validates the
     * client API version (if one is specified)
     *
     * @param builder Client properties.
     * @throws TerremarkException If error occurs while retrieving the server time and/or API versions.
     * @throws MalformedURLException If the API end point URL is malformed.
     */
    public TerremarkClientImpl(final PropertiesBuilder builder) throws TerremarkException, MalformedURLException {
        this.versionAndDateProvider = new VersionAndDateProvider();
        this.properties = builder.build();
        this.client = getClient();

        this.orgHandler = new OrganizationHandlerImpl(this.client, properties);
        this.envHandler = new EnvironmentHandlerImpl(this.client, properties);
        this.cpHandler = new ComputePoolHandlerImpl(this.client, properties);
        this.netHandler = new NetworkHandlerImpl(this.client, properties);

        initialize(properties.getVersion());
    }

    /**
     * Internal method to retrieve the server supported API versions and time. If client specified a specific API
     * version, it is checked to see if the server supports it. {@link java.lang.IllegalArgumentException} is thrown if
     * the client API version is not supported by the server. If client did not specify a version, the latest version in
     * the server provided list is chosen for the client. The time difference between the server and the client is
     * computed and cached.
     *
     * @param clientVersion Client specified API version. Can be null.
     * @throws TerremarkException If error occurs while retrieving the server time and/or API versions.
     */
    private void initialize(final Version clientVersion) throws TerremarkException {
        final SupportedVersions versions = getSupportedVersions();
        final TreeMap<Date, String> versionDates = new TreeMap<Date, String>();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        for (final VersionInfo vi : versions.getVersionInfos()) {
            try {
                versionDates.put(sdf.parse(vi.getVersion()), vi.getVersion());
            } catch (final ParseException ex) {
                throw new InternalServerException("While validating the API version, got invalid version from server: "
                                + vi.getVersion(), ex);
            }
        }

        String clientVersionStr = clientVersion == null ? null : clientVersion.toString();
        if (clientVersionStr == null) {
            clientVersionStr = versionDates.lastEntry().getValue();
        } else {
            if (!versionDates.values().contains(clientVersionStr)) {
                throw new IllegalArgumentException("Invalid API version: " + clientVersionStr);
            }
        }

        final Date serverDateTime = getTime().getCurrentServerTime().toGregorianCalendar().getTime();

        versionAndDateProvider.setVersion(clientVersionStr);
        versionAndDateProvider.calculateClockSkew(serverDateTime);
    }

    /**
     * Returns the rest client instance. Configures the proxy, handlers and applications.
     *
     * @return Rest client.
     */
    private RestClient getClient() {
        final ClientConfig config = new ApacheHttpClientConfig(properties.getHttpClient());

        setProxy(config, properties);
        setHandlers(config, properties);
        setApplications(config, properties);

        return new RestClient(config);
    }

    /**
     * Configures the handlers as necessary. One of Cloud API or basic authentication handler is added. Custom headers
     * handler (for setting the API version and current date/time) and logging handlers are also added.
     *
     * @param config Apache Wink client configuration.
     * @param properties Terremark API configuration.
     */
    private void setHandlers(final ClientConfig config, final ClientConfiguration properties) {
        ClientHandler authHandler;
        if (StringUtils.isEmpty(properties.getAccessKey())) {
            authHandler = new BasicAuthenticationHandler(properties.getUserName(), properties.getPassword());
        } else {
            authHandler = new CloudApiAuthenticationHandler(properties.getAccessKey(), properties.getPrivateKey(),
                            properties.getSignatureAlgorithm());
        }

        config.handlers(new CustomHeadersHandler(versionAndDateProvider), authHandler, new HTTPLoggingHandler());
    }

    /**
     * Configures the application for the rest client. If the content type is XML, the custom JAXB XML provider is
     * added. If the content type is JSON, the custom JAXB JSON provider is added. These will aid in deserialization of
     * the responses.
     *
     * @param config Apache Wink client configuration.
     * @param properties Terremark API configuration.
     */
    private static void setApplications(final ClientConfig config, final ClientConfiguration properties) {
        config.applications(new Application() {
            @Override
            public Set<Object> getSingletons() {
                final ContentType contentType = properties.getContentType();
                final Set<Object> set = new HashSet<Object>();

                if (contentType == ContentType.XML) {
                    set.add(new TerremarkJAXBXmlProvider());
                } else if (contentType == ContentType.JSON) {
                    set.add(new TerremarkJAXBJsonProvider());
                } else {
                    throw new IllegalArgumentException("Invalid content type: " + contentType);
                }

                return set;
            }
        });
    }

    /**
     * Configures the proxy host and port, if necessary.
     *
     * @param config Apache Wink client configuration.
     * @param properties Terremark API configuration.
     */
    private static void setProxy(final ClientConfig config, final ClientConfiguration properties) {
        if (properties.getProxyHost() != null) {
            config.proxyHost(properties.getProxyHost());
            config.proxyPort(properties.getProxyPort());
        }
    }

    /**
     * Internally used only in this class to retrieve server date/time and supported versions.
     *
     * @param relativePath Relative path.
     * @param cls Expected response type.
     * @return Response.
     */
    private <T> T get(final String relativePath, final Class<T> cls) {
        // NOTE: No version check is performed here. So make sure only API calls that are supported by all versions are
        // using this method
        final String contentType = properties.getContentType() == ContentType.XML ? MediaType.APPLICATION_XML
                        : MediaType.APPLICATION_JSON;
        return client.resource(properties.getUri() + relativePath).accept(contentType).get(cls);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputePoolHandler getComputePoolHandler() {
        return cpHandler;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnvironmentHandler getEnvironmentHandler() {
        return envHandler;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NetworkHandler getNetworkHandler() {
        return netHandler;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationHandler getOrganizationHandler() {
        return orgHandler;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SupportedVersions getSupportedVersions() {
        return get("/versions/", SupportedVersions.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Time getTime() {
        return get("/time/", Time.class);
    }

    /**
     * This method should not be used by clients. This is exposed purely for testing purposes.
     *
     * @return Version and date provider.
     */
    public VersionAndDateProvider getVersionAndDateProvider() {
        return versionAndDateProvider;
    }
}