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
import java.util.List;
import java.util.Map;

import org.apache.wink.client.ClientRequest;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.handlers.ClientHandler;
import org.apache.wink.client.handlers.HandlerContext;
import org.apache.wink.client.handlers.InputStreamAdapter;
import org.apache.wink.client.handlers.OutputStreamAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logging handler. Two separate loggers are used to log headers and wire data. Logger are active only when category is
 * set to {@code DEBUG} level.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class HTTPLoggingHandler implements ClientHandler {
    /** Headers logger */
    static final Logger HEADERS_LOGGER = LoggerFactory.getLogger("com.terremark.headers");
    /** Data logger */
    static final Logger DATA_LOGGER = LoggerFactory.getLogger("com.terremark.data");

    /**
     * Method invoked in the chain. The request is logged, if necessary. The chain is invoked. Once the response is
     * received, it is logged.
     *
     * @param request Client request.
     * @param context Request context.
     * @return Client response.
     * @throws Exception If there is a problem invoking the chain.
     */
    @Override
    @SuppressWarnings("PMD.SignatureDeclareThrowsException")
    public final ClientResponse handle(final ClientRequest request, final HandlerContext context) throws Exception {
        if (HEADERS_LOGGER.isDebugEnabled()) {
            // Log request headers
            HEADERS_LOGGER.debug(">> HTTP Request {} {}", request.getMethod(), request.getURI());
            for (final Map.Entry<String, List<String>> entry : request.getHeaders().entrySet()) {
                HEADERS_LOGGER.debug(">> {}: {}", entry.getKey(), entry.getValue());
            }
        }

        if (DATA_LOGGER.isDebugEnabled()) {
            // Add adapters for input and output streams
            context.addInputStreamAdapter(new InputStreamAdapter() {
                @Override
                public InputStream adapt(final InputStream is, final ClientResponse response) throws IOException {
                    return new LoggingInputStream(is);
                }
            });

            context.addOutputStreamAdapter(new OutputStreamAdapter() {
                @Override
                public OutputStream adapt(final OutputStream os, final ClientRequest request) throws IOException {
                    return new LoggingOutputStream(os);
                }
            });
        }

        // Invoke the chain
        final ClientResponse response = context.doChain(request);

        if (HEADERS_LOGGER.isDebugEnabled()) {
            // Log the response and headers
            HEADERS_LOGGER.debug("<< HTTP Response: {} {}", Integer.valueOf(response.getStatusCode()),
                            response.getMessage());
            HEADERS_LOGGER.debug("<< Status: {}/{}/{}",
                            new Object[] {Integer.valueOf(response.getStatusType().getStatusCode()),
                                            response.getStatusType().getFamily(),
                                            response.getStatusType().getReasonPhrase()});
            for (final Map.Entry<String, List<String>> entry : response.getHeaders().entrySet()) {
                if (entry.getKey() != null) {
                    HEADERS_LOGGER.debug("<< {}: {}", entry.getKey(), entry.getValue());
                }
            }
        }

        return response;
    }

    /**
     * Output stream delegate wrapper.
     *
     * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
     */
    static class LoggingOutputStream extends OutputStream {
        /** Actual output stream */
        private final OutputStream os;
        /** String builder to aggregate data */
        private StringBuilder builder;

        /**
         * Default constructor.
         *
         * @param os Actual output stream.
         */
        LoggingOutputStream(final OutputStream os) {
            this.os = os;
            this.builder = new StringBuilder();
        }

        /**
         * If there is data, log it and close the output stream.
         *
         * @see java.io.OutputStream#close()
         */
        @Override
        public void close() throws IOException {
            if (DATA_LOGGER.isDebugEnabled() && builder.length() > 0) {
                DATA_LOGGER.debug(">> {}", builder);
            }

            super.close();
        }

        /**
         * Writes the specified byte to the actual output stream. The data is appended to the string aggregator. If the
         * byte is a new line or line feed, it is logged.
         *
         * @see java.io.OutputStream#write(int)
         */
        @Override
        public void write(final int i) throws IOException {
            os.write(i);

            if (DATA_LOGGER.isDebugEnabled()) {
                if (i == 10 || i == 13) {
                    if (builder.length() > 0) {
                        DATA_LOGGER.debug(">> {}", builder);
                        builder = new StringBuilder();
                    }
                } else {
                    builder.append((char) i);
                }
            }
        }
    }

    /**
     * Input stream delegate wrapper.
     *
     * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
     */
    static class LoggingInputStream extends InputStream {
        /** Actual input stream */
        private final InputStream is;
        /** String builder to aggregate data */
        private StringBuilder builder;

        /**
         * Default constructor.
         *
         * @param is Actual input stream.
         */
        LoggingInputStream(final InputStream is) {
            this.is = is;
            this.builder = new StringBuilder();
        }

        /**
         * If there is data, log it and close the input stream.
         *
         * @see java.io.InputStream#close()
         */
        @Override
        public void close() throws IOException {
            if (DATA_LOGGER.isDebugEnabled() && builder.length() > 0) {
                DATA_LOGGER.debug("<< {}", builder);
            }

            super.close();
        }

        /**
         * Reads one byte from the actual input stream. The data is appended to the string aggregator. If EOF is reached
         * or if the byte read is a new line or line feed, it is logged.
         *
         * @see java.io.InputStream#read()
         */
        @Override
        public int read() throws IOException {
            final int i = is.read();

            if (DATA_LOGGER.isDebugEnabled()) {
                if (i == -1 || i == 10 || i == 13) {
                    if (builder.length() > 0) {
                        DATA_LOGGER.debug("<< {}", builder);
                        builder = new StringBuilder();
                    }
                } else if (i > 0) {
                    builder.append((char) i);
                }
            }

            return i;
        }
    }
}