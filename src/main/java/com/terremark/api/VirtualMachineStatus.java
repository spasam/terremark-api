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
 * Status of a virtual machine.
 * <p>
 * Java class for VirtualMachineStatus.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="VirtualMachineStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotDeployed"/>
 *     &lt;enumeration value="Deployed"/>
 *     &lt;enumeration value="Orphaned"/>
 *     &lt;enumeration value="TaskInProgress"/>
 *     &lt;enumeration value="CopyInProgress"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "VirtualMachineStatus")
@XmlEnum
public enum VirtualMachineStatus {
    /** Host has not been defined but not deployed, such as with a physical device. */
    @XmlEnumValue("NotDeployed")
    NOT_DEPLOYED("NotDeployed"),
    /** Host is defined and deployed; available for service. */
    @XmlEnumValue("Deployed")
    DEPLOYED("Deployed"),
    /** An attempt was made to create the host but failed. */
    @XmlEnumValue("Orphaned")
    ORPHANED("Orphaned"),
    /** The host has been defined and creation is in progress. */
    @XmlEnumValue("TaskInProgress")
    TASK_IN_PROGRESS("TaskInProgress"),
    /** The host is to be a copy of an existing host and the copy is in progress. */
    @XmlEnumValue("CopyInProgress")
    COPY_IN_PROGRESS("CopyInProgress");

    private final String value;

    VirtualMachineStatus(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineStatus fromValue(final String v) {
        for (final VirtualMachineStatus c : VirtualMachineStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
