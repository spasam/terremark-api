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
package com.terremark;

import com.terremark.api.SupportedVersions;
import com.terremark.api.Time;

/**
 * Terremark client interface. All anonymous API calls ({@link #getSupportedVersions()} and {@link #getTime()}) are
 * defined here. This interface also defines methods to get various types of handlers. A handler providers a collection
 * on API methods calls grouped together by category.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 * @see TerremarkFactory#getClient(com.terremark.config.PropertiesBuilder)
 */
public interface TerremarkClient {
    /**
     * Returns the supported API versions.
     *
     * @return API versions supported by the endpoint.
     */
    SupportedVersions getSupportedVersions();

    /**
     * Returns the current end point server time.
     *
     * @return Current server time.
     */
    Time getTime();

    /**
     * Returns the organization handler.
     *
     * @return Organization handler.
     */
    OrganizationHandler getOrganizationHandler();

    /**
     * Return the environment handler.
     *
     * @return Environment handler.
     */
    EnvironmentHandler getEnvironmentHandler();

    /**
     * Returns the compute pool handler.
     *
     * @return Compute pool handler.
     */
    ComputePoolHandler getComputePoolHandler();

    /**
     * Returns the network handler.
     *
     * @return Network handler.
     */
    NetworkHandler getNetworkHandler();
}
