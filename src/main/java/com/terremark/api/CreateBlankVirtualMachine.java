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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CreateBlankVirtualMachine complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CreateBlankVirtualMachine">
 *   &lt;complexContent>
 *     &lt;extension base="{}CreateVirtualMachineRequest">
 *       &lt;sequence>
 *         &lt;element name="OperatingSystem" type="{}Reference"/>
 *         &lt;element name="Disks" type="{}Disks" minOccurs="0"/>
 *         &lt;element name="NetworkAdapterSettings" type="{}NetworkAdapterSettings"/>
 *         &lt;element name="DetachedDisks" type="{}DetachedVirtualDiskReferences" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateBlankVirtualMachine", propOrder = {"operatingSystem", "disks", "networkAdapterSettings",
                "detachedDisks"})
@javax.xml.bind.annotation.XmlRootElement(name = "CreateBlankVirtualMachine")
public final class CreateBlankVirtualMachine extends CreateVirtualMachineRequest {

    @XmlElement(name = "OperatingSystem", required = true, nillable = true)
    protected Reference operatingSystem;
    @XmlElementWrapper(name = "Disks")
    @XmlElement(name = "Disk")
    protected List<VirtualDisk> disks;
    @XmlElementWrapper(name = "NetworkAdapterSettings")
    @XmlElement(name = "NetworkAdapter")
    protected List<NetworkAdapterSetting> networkAdapterSettings;
    @XmlElementWrapper(name = "DetachedDisks")
    @XmlElement(name = "DetachedDisk")
    protected List<Reference> detachedDisks;

    /**
     * Gets the value of the operatingSystem property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * Sets the value of the operatingSystem property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setOperatingSystem(final Reference value) {
        this.operatingSystem = value;
    }

    public List<VirtualDisk> getDisks() {
        if (disks == null) {
            disks = new ArrayList<VirtualDisk>();
        }
        return disks;
    }

    public List<NetworkAdapterSetting> getNetworkAdapterSettings() {
        if (networkAdapterSettings == null) {
            networkAdapterSettings = new ArrayList<NetworkAdapterSetting>();
        }
        return networkAdapterSettings;
    }

    public List<Reference> getDetachedDisks() {
        if (detachedDisks == null) {
            detachedDisks = new ArrayList<Reference>();
        }
        return detachedDisks;
    }
}
