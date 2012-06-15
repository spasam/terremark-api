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
 * <p>
 * Java class for CatalogItemLicensedBy.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="CatalogItemLicensedBy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ServiceProvider"/>
 *     &lt;enumeration value="Customer"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "CatalogItemLicensedBy")
@XmlEnum
public enum CatalogItemLicensedBy {
    @XmlEnumValue("ServiceProvider")
    SERVICE_PROVIDER("ServiceProvider"),
    @XmlEnumValue("Customer")
    CUSTOMER("Customer");

    private final String value;

    CatalogItemLicensedBy(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CatalogItemLicensedBy fromValue(final String v) {
        for (final CatalogItemLicensedBy c : CatalogItemLicensedBy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
