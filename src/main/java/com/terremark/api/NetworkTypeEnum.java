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
 * Network types.
 * <p>
 * Java class for NetworkTypeEnum.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="NetworkTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Dmz"/>
 *     &lt;enumeration value="Internal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "NetworkTypeEnum")
@XmlEnum
public enum NetworkTypeEnum {
    /**
     * (Demilitarized zone) - Network on which servers are behind the firewall but permit access from the public
     * Internet
     */
    @XmlEnumValue("Dmz")
    DMZ("Dmz"),

    /**
     * Internal - Network on which access to the servers for such reasons as administration and backup are performed but
     * isolated from the public Internet.
     */
    @XmlEnumValue("Internal")
    INTERNAL("Internal");

    private final String value;

    NetworkTypeEnum(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NetworkTypeEnum fromValue(final String v) {
        for (final NetworkTypeEnum c : NetworkTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
