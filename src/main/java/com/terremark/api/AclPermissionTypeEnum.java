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
 * ACL permission type.
 * <p>
 * Java class for AclPermissionTypeEnum.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="AclPermissionTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="allow"/>
 *     &lt;enumeration value="deny"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "AclPermissionTypeEnum")
@XmlEnum
public enum AclPermissionTypeEnum {
    /** Internal traffic meeting the requirements of the rule is allowed. */
    @XmlEnumValue("allow")
    ALLOW("allow"),
    /** External traffic meeting the requirements of the rule is denied. */
    @XmlEnumValue("deny")
    DENY("deny");

    private final String value;

    AclPermissionTypeEnum(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AclPermissionTypeEnum fromValue(final String v) {
        for (final AclPermissionTypeEnum c : AclPermissionTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}