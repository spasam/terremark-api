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
 * Exception thrown when Terremark end point returns {@code HTTP 409, 420, 421} error codes. Usually this implies that a
 * bad API request was made. This is a generic error code returned in many cases when either the API call is not
 * appropriate or incorrect arguments are passed. Examples: Detaching disk when virtual machine is not in stable state,
 * assigning IP address that is already in use etc.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class RequestFailedException extends TerremarkException {
    /** Serial version UID */
    private static final long serialVersionUID = -8381258940044056768L;

    /**
     * Default constructor.
     *
     * @param error Terremark error.
     * @param cause Root cause.
     */
    public RequestFailedException(final TerremarkError error, final ClientWebException cause) {
        super(error, cause);
    }
}