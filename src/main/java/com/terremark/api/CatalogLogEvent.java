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
 * Java class for CatalogLogEvent.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="CatalogLogEvent">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CatalogCreated"/>
 *     &lt;enumeration value="CatalogDeleted"/>
 *     &lt;enumeration value="UploadStarted"/>
 *     &lt;enumeration value="UploadFinished"/>
 *     &lt;enumeration value="CopyServerStarted"/>
 *     &lt;enumeration value="CopyServerFinished"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "CatalogLogEvent")
@XmlEnum
public enum CatalogLogEvent {
    @XmlEnumValue("CatalogCreated")
    CATALOG_CREATED("CatalogCreated"),
    @XmlEnumValue("CatalogDeleted")
    CATALOG_DELETED("CatalogDeleted"),
    @XmlEnumValue("UploadStarted")
    UPLOAD_STARTED("UploadStarted"),
    @XmlEnumValue("UploadFinished")
    UPLOAD_FINISHED("UploadFinished"),
    @XmlEnumValue("CopyServerStarted")
    COPY_SERVER_STARTED("CopyServerStarted"),
    @XmlEnumValue("CopyServerFinished")
    COPY_SERVER_FINISHED("CopyServerFinished");

    private final String value;

    CatalogLogEvent(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CatalogLogEvent fromValue(final String v) {
        for (final CatalogLogEvent c : CatalogLogEvent.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
