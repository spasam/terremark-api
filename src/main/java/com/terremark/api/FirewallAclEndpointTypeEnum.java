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
 * Java class for FirewallAclEndpointTypeEnum.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="FirewallAclEndpointTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Any"/>
 *     &lt;enumeration value="IpAddress"/>
 *     &lt;enumeration value="Network"/>
 *     &lt;enumeration value="ExternalIp"/>
 *     &lt;enumeration value="ExternalNetwork"/>
 *     &lt;enumeration value="TrustedNetworkGroup"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "FirewallAclEndpointTypeEnum")
@XmlEnum
public enum FirewallAclEndpointTypeEnum {
    /** All sources or destinations. */
    @XmlEnumValue("Any")
    ANY("Any"),
    /** A specific internal address included in the source or destination. */
    @XmlEnumValue("IpAddress")
    IP_ADDRESS("IpAddress"),
    /** A specific internal network included in the source or destination. */
    @XmlEnumValue("Network")
    NETWORK("Network"),
    /** A specific external address included in the source or destination. */
    @XmlEnumValue("ExternalIp")
    EXTERNAL_IP("ExternalIp"),
    /** A specific external network included in the source or destination. */
    @XmlEnumValue("ExternalNetwork")
    EXTERNAL_NETWORK("ExternalNetwork"),
    /** A trusted network group defined in the environment. */
    @XmlEnumValue("TrustedNetworkGroup")
    TRUSTED_NETWORK_GROUP("TrustedNetworkGroup");

    private final String value;

    FirewallAclEndpointTypeEnum(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FirewallAclEndpointTypeEnum fromValue(final String v) {
        for (final FirewallAclEndpointTypeEnum c : FirewallAclEndpointTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
