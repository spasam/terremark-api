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
 * Detached disk type refers to the type of content on the disk when attached to the last virtual machine.
 * <p>
 * Java class for DetachedDiskTypeEnum.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="DetachedDiskTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="System"/>
 *     &lt;enumeration value="Data"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "DetachedDiskTypeEnum")
@XmlEnum
public enum DetachedDiskTypeEnum {
    /** Disk contains the operating system. */
    @XmlEnumValue("System")
    SYSTEM("System"),
    /** Disk contains no operating system. */
    @XmlEnumValue("Data")
    DATA("Data");

    private final String value;

    DetachedDiskTypeEnum(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DetachedDiskTypeEnum fromValue(final String v) {
        for (final DetachedDiskTypeEnum c : DetachedDiskTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
