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
 * Status of the VMware Tools.
 * <p>
 * Java class for VirtualMachineMediaStatus.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="VirtualMachineMediaStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unmounted"/>
 *     &lt;enumeration value="Mounted"/>
 *     &lt;enumeration value="IsoMounted"/>
 *     &lt;enumeration value="VmwareToolsMounted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "VirtualMachineMediaStatus")
@XmlEnum
public enum VirtualMachineMediaStatus {
    /** No media is mounted on the virtual machine. */
    @XmlEnumValue("Unmounted")
    UNMOUNTED("Unmounted"),
    /** VMware Tools media is mounted on the virtual machine. */
    @XmlEnumValue("Mounted")
    MOUNTED("Mounted"),
    /** Media is with an ISO image is mounted on the virtual machine. */
    @XmlEnumValue("IsoMounted")
    ISO_MOUNTED("IsoMounted"),
    /** VMware Tools media is mounted on the virtual machine. */
    @XmlEnumValue("VmwareToolsMounted")
    VMWARE_TOOLS_MOUNTED("VmwareToolsMounted");

    private final String value;

    VirtualMachineMediaStatus(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineMediaStatus fromValue(final String v) {
        for (final VirtualMachineMediaStatus c : VirtualMachineMediaStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
