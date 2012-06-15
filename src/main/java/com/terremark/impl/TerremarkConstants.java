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
package com.terremark.impl;

import java.util.TimeZone;

/**
 * Constants used internally.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class TerremarkConstants {
    /** Terremark content sub-type prefix */
    public static final String TERREMARK_SUB_TYPE_PREFIX = "vnd.tmrk.";
    /** Wild-card application content type */
    public static final String TERREMARK_MEDIA_TYPE_WILDCARD = "application/*";
    /** GMT time zone */
    public static final TimeZone GMT_TIME_ZONE = TimeZone.getTimeZone("GMT");
    /** ISO 8601 date format */
    public static final String ISO_8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:'00Z'";
}