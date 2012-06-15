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
 * Exception thrown when Terremark end point returns {@code HTTP 401} error code. Or if there is a proxy and the proxy
 * returns {@code HTTP 407}. When 401 is returned, it implies that authentication failed and the credentials are
 * incorrect. When 407 is returned from a proxy, it implies that proxy authentication failed.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class AuthenticationDeniedException extends TerremarkException {
    /** Serial version UID */
    private static final long serialVersionUID = -839450698706850774L;

    /**
     * Default constructor.
     *
     * @param error Terremark error.
     * @param cause Root cause.
     */
    public AuthenticationDeniedException(final TerremarkError error, final ClientWebException cause) {
        super(error, cause);
    }
}