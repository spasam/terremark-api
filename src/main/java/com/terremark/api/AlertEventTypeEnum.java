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
 * Java class for AlertEventTypeEnum.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="AlertEventTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Alarm"/>
 *     &lt;enumeration value="StartIncident"/>
 *     &lt;enumeration value="InIncident"/>
 *     &lt;enumeration value="EndIncident"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "AlertEventTypeEnum")
@XmlEnum
public enum AlertEventTypeEnum {
    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Alarm")
    ALARM("Alarm"),
    @XmlEnumValue("StartIncident")
    START_INCIDENT("StartIncident"),
    @XmlEnumValue("InIncident")
    IN_INCIDENT("InIncident"),
    @XmlEnumValue("EndIncident")
    END_INCIDENT("EndIncident");

    private final String value;

    AlertEventTypeEnum(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AlertEventTypeEnum fromValue(final String v) {
        for (final AlertEventTypeEnum c : AlertEventTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
