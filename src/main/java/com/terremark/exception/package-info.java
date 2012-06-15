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
/**
 * Package that contains all the exceptions thrown by the API calls. {@link com.terremark.exception.TerremarkException}
 * is the base exception class that is extended by all other exceptions. If the Terremark end point returns an error
 * message, the callers can retrieve the relevant error information by calling
 * {@link com.terremark.exception.TerremarkException#getMajorErrorCode()},
 * {@link com.terremark.exception.TerremarkException#getMinorErrorCode()},
 * {@link com.terremark.exception.TerremarkException#getErrorMessage()} methods.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 * @since 1.0
 * @see com.terremark
 * @see com.terremark.api
 * @see com.terremark.config
 */
package com.terremark.exception;