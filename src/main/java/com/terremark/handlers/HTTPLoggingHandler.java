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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.wink.client.ClientRequest;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.handlers.ClientHandler;
import org.apache.wink.client.handlers.HandlerContext;
import org.apache.wink.client.handlers.InputStreamAdapter;
import org.apache.wink.client.handlers.OutputStreamAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logging handler. Logger {@code com.terremark.data} is active only when category is set to {@code DEBUG} level. Setting logger to debug
 * level will log the HTTP headers and data (if any).
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class HTTPLoggingHandler implements ClientHandler
{
    /** Logger */
    private static final Logger LOGGER = LoggerFactory.getLogger("com.terremark.data");
    /** Platform specified new line */
    private static final String NL = System.getProperty("line.separator");

    /**
     * Method invoked in the chain. The request is logged, if necessary. The chain is invoked. Once the response is received, it is logged.
     *
     * @param request Client request.
     * @param context Request context.
     * @return Client response.
     * @throws Exception If there is a problem invoking the chain.
     */
    @Override
    @SuppressWarnings("PMD.SignatureDeclareThrowsException")
    public final ClientResponse handle(final ClientRequest request, final HandlerContext context) throws Exception
    {
        if (LOGGER.isDebugEnabled()) {
            if (request.getEntity() == null) {
                // Log headers here since the adapter for output stream will not be called without an entity
                StringBuilder builder = new StringBuilder().append("Request").append(NL).append(request.getMethod()).append(' ')
                        .append(request.getURI().toString()).append(NL);

                for (final Map.Entry<String, List<String>> entry : request.getHeaders().entrySet()) {
                    if (entry.getKey() != null) {
                        builder.append(entry.getKey()).append(": ").append(entry.getValue()).append(NL);
                    }
                }

                LOGGER.debug("{}", builder);
            } else {
                // Add adapters for output stream
                context.addOutputStreamAdapter(new OutputStreamAdapter() {
                    @Override
                    public OutputStream adapt(final OutputStream os, final ClientRequest request) throws IOException
                    {
                        return new LoggingOutputStream(os, request.getMethod(), request.getURI(), request.getHeaders());
                    }
                });
            }

            // Add adapters for input stream
            context.addInputStreamAdapter(new InputStreamAdapter() {
                @Override
                public InputStream adapt(final InputStream is, final ClientResponse response) throws IOException
                {
                    return new LoggingInputStream(is, response.getStatusCode(), response.getStatusType(), response.getHeaders());
                }
            });
        }

        // Invoke the chain
        return context.doChain(request);
    }

    /**
     * Output stream delegate wrapper.
     *
     * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
     */
    static class LoggingOutputStream extends OutputStream
    {
        /** Actual output stream */
        private final OutputStream os;
        /** String builder to aggregate data */
        private final StringBuilder builder;

        /**
         * Default constructor.
         *
         * @param os Actual output stream.
         * @param method Request method.
         * @param uri Request URI.
         * @param headers Request headers.
         */
        LoggingOutputStream(final OutputStream os, String method, URI uri, MultivaluedMap<String, String> headers)
        {
            this.os = os;
            this.builder = new StringBuilder().append("Request").append(NL).append(method).append(' ').append(uri.toString()).append(NL);

            for (final Map.Entry<String, List<String>> entry : headers.entrySet()) {
                if (entry.getKey() != null) {
                    this.builder.append(entry.getKey()).append(": ").append(entry.getValue()).append(NL);
                }
            }
            this.builder.append(NL);
        }

        /**
         * If there is data, log it and close the output stream.
         *
         * @see java.io.OutputStream#close()
         */
        @Override
        public void close() throws IOException
        {
            LOGGER.debug("{}{}", builder, NL);
            super.close();
        }

        /**
         * Writes the specified byte to the actual output stream. The data is appended to the string aggregator. If the byte is a new line
         * or line feed, it is logged.
         *
         * @see java.io.OutputStream#write(int)
         */
        @Override
        public void write(final int i) throws IOException
        {
            os.write(i);
            builder.append((char) i);
        }
    }

    /**
     * Input stream delegate wrapper.
     *
     * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
     */
    static class LoggingInputStream extends InputStream
    {
        /** Actual input stream */
        private final InputStream is;
        /** String builder to aggregate data */
        private final StringBuilder builder;

        /**
         * Default constructor.
         *
         * @param code Response code.
         * @param status Response status type.
         * @param headers Response headers.
         * @param is Actual input stream.
         */
        LoggingInputStream(final InputStream is, final int code, final Response.StatusType status, MultivaluedMap<String, String> headers)
        {
            this.is = is;
            this.builder = new StringBuilder().append("Response").append(NL).append(code).append(' ').append(status.toString()).append(NL);

            for (final Map.Entry<String, List<String>> entry : headers.entrySet()) {
                if (entry.getKey() != null) {
                    this.builder.append(entry.getKey()).append(": ").append(entry.getValue()).append(NL);
                }
            }
            this.builder.append(NL);

        }

        /**
         * If there is data, log it and close the input stream.
         *
         * @see java.io.InputStream#close()
         */
        @Override
        public void close() throws IOException
        {
            LOGGER.debug("{}{}", builder, NL);
            super.close();
        }

        /**
         * Reads one byte from the actual input stream. The data is appended to the string aggregator. If EOF is reached or if the byte read
         * is a new line or line feed, it is logged.
         *
         * @see java.io.InputStream#read()
         */
        @Override
        public int read() throws IOException
        {
            final int i = is.read();
            if (i > 0) {
                builder.append((char) i);
            }

            return i;
        }
    }
}