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
 * Load balancing method refers to the method used to balance the traffic across the nodes services in an Internet
 * service.
 * <p>
 * Java class for LoadBalancingMethod.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="LoadBalancingMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RoundRobin"/>
 *     &lt;enumeration value="LeastConnection"/>
 *     &lt;enumeration value="LeastResponseTime"/>
 *     &lt;enumeration value="LeastPackets"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "LoadBalancingMethod")
@XmlEnum
public enum LoadBalancingMethod {
    /** Next packet goes to the next node in order. */
    @XmlEnumValue("RoundRobin")
    ROUND_ROBIN("RoundRobin"),
    /** Next packet goes to the node service with the fewest connections. */
    @XmlEnumValue("LeastConnection")
    LEAST_CONNECTION("LeastConnection"),
    /** Next packet goes to the node service with the lowest response time. */
    @XmlEnumValue("LeastResponseTime")
    LEAST_RESPONSE_TIME("LeastResponseTime"),
    /** Next packet goes to the node service with the fewest received packets. */
    @XmlEnumValue("LeastPackets")
    LEAST_PACKETS("LeastPackets");

    private final String value;

    LoadBalancingMethod(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LoadBalancingMethod fromValue(final String v) {
        for (final LoadBalancingMethod c : LoadBalancingMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
