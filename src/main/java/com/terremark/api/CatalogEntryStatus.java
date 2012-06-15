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
 * Catalog entry status refers to the status of the catalog or of the OVF file for the virtual machine (VM).
 * <p>
 * Java class for CatalogEntryStatus.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="CatalogEntryStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="Validated"/>
 *     &lt;enumeration value="Failed"/>
 *     &lt;enumeration value="Completed"/>
 *     &lt;enumeration value="Validating"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "CatalogEntryStatus")
@XmlEnum
public enum CatalogEntryStatus {
    /** The catalog item is created but no files are uploaded. */
    @XmlEnumValue("Active")
    ACTIVE("Active"),
    /** OVF successfully validated and is waiting for the image file to upload. */
    @XmlEnumValue("Validated")
    VALIDATED("Validated"),
    /** VM upload failed. */
    @XmlEnumValue("Failed")
    FAILED("Failed"),
    /** VM has successfully completed the entire upload process and is available for import. */
    @XmlEnumValue("Completed")
    COMPLETED("Completed"),
    /** OVF validation is in progress. */
    @XmlEnumValue("Validating")
    VALIDATING("Validating"),
    /** Statis is unknown. */
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");

    private final String value;

    CatalogEntryStatus(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CatalogEntryStatus fromValue(final String v) {
        for (final CatalogEntryStatus c : CatalogEntryStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
