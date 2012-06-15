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

/**
 * API versions supported by this implementation and that can be used by callers.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 * @see com.terremark.config.PropertiesBuilder#setAPIVersion(Version)
 */
public enum Version {
    // NOTE: Versions should be in increasing order. Older version first and most recent version last.
    /** Version 2.10 */
    VERSION_2_10("2011-07-01"),
    /** Version 2.11 */
    VERSION_2_11("2011-10-01"),
    /** Version 2.12 */
    VERSION_2_12("2012-03-01");

    /** Version release date */
    private final String versionDate;

    /**
     * Default constructor for the enumeration.
     *
     * @param versionDate Version date.
     */
    Version(final String versionDate) {
        this.versionDate = versionDate;
    }

    /**
     * Returns the version daate.
     *
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return versionDate;
    }
}