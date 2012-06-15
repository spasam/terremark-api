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
 * Exception thrown when Terremark end point returns {@code HTTP 503} error code. If a retry handler is configured that
 * if the request is a {@code HTTP GET}, then the API call can be retried.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class ServiceUnavailableException extends TerremarkException {
    /** Serial version UID */
    private static final long serialVersionUID = -4282926447432310075L;

    /**
     * Default constructor.
     *
     * @param error Terremark error.
     * @param cause Root cause.
     */
    public ServiceUnavailableException(final TerremarkError error, final ClientWebException cause) {
        super(error, cause);
    }
}