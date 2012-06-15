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
package com.terremark.config;

import java.util.Map;

import com.terremark.exception.TerremarkException;

/**
 * Interface that can be implemented to specify custom retry strategy. It is possible that API calls can fail randomly.
 * When a {@code HTTP GET} call fails with error code greater than 499, the call can be retried. User's can determine if
 * a specific failed call needs to be retried and how many times. Other types of HTTP request (such as POST, PUT,
 * DELETE) cannot be retried. Implementation of this interface will only be invoked for HTTP GET calls that fail with
 * 500 or greater error code.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 * @see com.terremark.config.PropertiesBuilder#setRetryHandler(RetryHandler)
 */
public interface RetryHandler {
    /**
     * Method invoked to determine if the API call should be retried or not.
     *
     * @param failuresSoFar Number of failures so far. Starts with {@code 1} for the first failure.
     * @param exception Terremark exception. This may contain information like HTTP error code, message etc.
     * @param relativePath Relative URL path that was being accessed for the API call.
     * @param queryParams Query arguments being passed to the API end point.
     * @param extraHeaders Additional headers passed to the API end point.
     * @param responseClass Type of response excepted from the API end point.
     * @param arguments Additional arguments being passed to the end point.
     * @return Implementation should return {@code true} to indicate that the call should be retried. If {@code false}
     * is returned, the call is not retried and {@link TerremarkException} will be thrown.
     */
    <T> boolean shouldRetry(int failuresSoFar, TerremarkException exception, final String relativePath,
                    final Map<String, String> queryParams, final Map<String, String> extraHeaders,
                    final Class<T> responseClass, final Object... arguments);
}