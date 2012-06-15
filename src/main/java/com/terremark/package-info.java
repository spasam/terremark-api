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
 * Provides the classes necessary for interfacing with the Terremark API.
 * <p/>
 * {@link com.terremark.TerremarkFactory#getClient(com.terremark.config.PropertiesBuilder)} can be used to build an
 * instance of {@link com.terremark.TerremarkClient}. The client instance provides four different handlers. Each handler
 * provides a subset of the Terremark API calls. {@link com.terremark.OrganizationHandler},
 * {@link com.terremark.EnvironmentHandler}, {@link com.terremark.ComputePoolHandler} and
 * {@link com.terremark.NetworkHandler} together provide all the necessary API calls.
 * <p/>
 * {@link com.terremark.TerremarkFactory} provides factory methods line
 * {@link com.terremark.TerremarkFactory#getId(com.terremark.api.Resource)}. This call along with other calls provide
 * utility methods necessary for invoking some API calls.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 * @since 1.0
 * @see com.terremark.api
 * @see com.terremark.config
 * @see com.terremark.exception
 */
package com.terremark;