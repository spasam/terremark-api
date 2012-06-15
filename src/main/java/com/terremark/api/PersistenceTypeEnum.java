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
 * Persistence type values are limited by protocol: CookieInsert is valid only with HTTP, SslSession is valid only with
 * HTTPS, and SourceIp and None are valid with any protocol.
 * <p/>
 * <p>
 * Java class for PersistenceTypeEnum.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="PersistenceTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="SourceIp"/>
 *     &lt;enumeration value="SslSession"/>
 *     &lt;enumeration value="CookieInsert"/>
 *     &lt;enumeration value="SessionCookie"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "PersistenceTypeEnum")
@XmlEnum
public enum PersistenceTypeEnum {
    /** No persistence */
    @XmlEnumValue("None")
    NONE("None"),
    /** Use the IP address of the source device for persistence. */
    @XmlEnumValue("SourceIp")
    SOURCE_IP("SourceIp"),
    /** Use the SSL session identifier for persistence. Only valid with HTTPS protocol. */
    @XmlEnumValue("SslSession")
    SSL_SESSION("SslSession"),
    /** A custom header field, a cookie, inserted in the request header for persistence. Only valid with HTTP protocol. */
    @XmlEnumValue("CookieInsert")
    COOKIE_INSERT("CookieInsert"),
    /** A CookieInsert with no timeout, persists until the client clears the request header value. */
    @XmlEnumValue("SessionCookie")
    SESSION_COOKIE("SessionCookie");

    private final String value;

    PersistenceTypeEnum(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PersistenceTypeEnum fromValue(final String v) {
        for (final PersistenceTypeEnum c : PersistenceTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
