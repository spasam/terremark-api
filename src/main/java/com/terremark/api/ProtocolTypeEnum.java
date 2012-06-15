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
 * Protocol types.
 * <p>
 * Java class for ProtocolTypeEnum.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="ProtocolTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HTTP"/>
 *     &lt;enumeration value="HTTPS"/>
 *     &lt;enumeration value="TCP"/>
 *     &lt;enumeration value="UDP"/>
 *     &lt;enumeration value="IPSEC"/>
 *     &lt;enumeration value="FTP"/>
 *     &lt;enumeration value="Any"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "ProtocolTypeEnum")
@XmlEnum
public enum ProtocolTypeEnum {
    /** Hypertext transfer protocol. */
    HTTP("HTTP"),
    /** Secure hypertext transfer protocol. */
    HTTPS("HTTPS"),
    /** Transmission control protocol. */
    TCP("TCP"),
    /** * User datagram protocol. */
    UDP("UDP"),
    /** Internet protocol security. */
    IPSEC("IPSEC"),
    /** File transfer protocol. */
    FTP("FTP"),

    /**
     * Any protocol.
     */
    @XmlEnumValue("Any")
    ANY("Any");

    private final String value;

    ProtocolTypeEnum(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProtocolTypeEnum fromValue(final String v) {
        for (final ProtocolTypeEnum c : ProtocolTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
