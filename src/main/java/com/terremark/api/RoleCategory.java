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
 * Role category refers to the definitional control of the role.
 * <p>
 * Java class for RoleCategory.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="RoleCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="System"/>
 *     &lt;enumeration value="Custom"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "RoleCategory")
@XmlEnum
public enum RoleCategory {
    /** Role is defined by the Enterprise Cloud and may not be modified. */
    @XmlEnumValue("System")
    SYSTEM("System"),
    /** Role is defined by the organization and may be modified. */
    @XmlEnumValue("Custom")
    CUSTOM("Custom");

    private final String value;

    RoleCategory(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoleCategory fromValue(final String v) {
        for (final RoleCategory c : RoleCategory.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
