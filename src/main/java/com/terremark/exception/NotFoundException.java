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
 * Exception thrown when Terremark end point returns {@code HTTP 404} error code. Usually this implies that the resource
 * being access is no longer present. For example: Trying to get a VM that was previously deleted etc.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class NotFoundException extends TerremarkException {
    /** Serial version UID */
    private static final long serialVersionUID = 4695694735948580201L;

    /**
     * Default constructor.
     *
     * @param error Terremark error.
     * @param cause Root cause.
     */
    public NotFoundException(final TerremarkError error, final ClientWebException cause) {
        super(error, cause);
    }
}