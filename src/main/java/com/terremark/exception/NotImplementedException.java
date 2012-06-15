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

import org.apache.wink.client.ClientWebException;

import com.terremark.api.TerremarkError;

/**
 * Exception thrown when a method is not implemented in the configured API version. For example, if the client is
 * configured to use {@code 2.11} API version and invokes a {@code 2.12} API method, this exception will be thrown.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class NotImplementedException extends TerremarkException {
    /** Serial version UID. */
    private static final long serialVersionUID = 452679321970838837L;

    /**
     * Default constructor. Used when a method not available in configured API version is invoked.
     *
     * @param message Error message.
     */
    public NotImplementedException(final String message) {
        super(message);
    }

    /**
     * Constructor used when Terremark end point returns {@code HTTP 501} error code.
     *
     * @param error Terremark error.
     * @param cause Root cause.
     */
    public NotImplementedException(final TerremarkError error, final ClientWebException cause) {
        super(error, cause);
    }
}