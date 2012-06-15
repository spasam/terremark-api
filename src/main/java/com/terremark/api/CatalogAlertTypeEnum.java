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
 * Catalog alert type created while uploading or exporting a virtual machine.
 * <p>
 * Java class for CatalogAlertTypeEnum.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="CatalogAlertTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Info"/>
 *     &lt;enumeration value="Warning"/>
 *     &lt;enumeration value="Error"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "CatalogAlertTypeEnum")
@XmlEnum
public enum CatalogAlertTypeEnum {
    /** The virtual machine has an informational note. */
    @XmlEnumValue("Info")
    INFO("Info"),
    /**
     * The VM has a non-fatal potential issue. For example, processor count exceeds operating system limits, an issue
     * which can be corrected when importing.
     */
    @XmlEnumValue("Warning")
    WARNING("Warning"),
    /** VM has a fatal issue; for example, disk count exceeds limits. */
    @XmlEnumValue("Error")
    ERROR("Error");

    private final String value;

    CatalogAlertTypeEnum(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CatalogAlertTypeEnum fromValue(final String v) {
        for (final CatalogAlertTypeEnum c : CatalogAlertTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
