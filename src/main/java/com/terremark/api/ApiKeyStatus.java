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
package com.terremark.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * API key status.
 * <p>
 * Java class for ApiKeyStatus.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="ApiKeyStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="Inactive"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "ApiKeyStatus")
@XmlEnum
public enum ApiKeyStatus {
    /** API key is active and permitted access. */
    @XmlEnumValue("Active")
    ACTIVE("Active"),
    /** API key is inactive and no longer permitted access. */
    @XmlEnumValue("Inactive")
    INACTIVE("Inactive");

    private final String value;

    ApiKeyStatus(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ApiKeyStatus fromValue(final String v) {
        for (final ApiKeyStatus c : ApiKeyStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
