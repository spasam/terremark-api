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
 * Java class for ComputePoolStorageUsageDetail complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ComputePoolStorageUsageDetail">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="Allocated" type="{}ResourceCapacity" minOccurs="0"/>
 *         &lt;element name="VirtualMachines" type="{}StorageDetails_VirtualMachines" minOccurs="0"/>
 *         &lt;element name="DetachedDisks" type="{}DetachedDiskReferenceList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComputePoolStorageUsageDetail", propOrder = {"allocated", "virtualMachines", "detachedDisks"})
@javax.xml.bind.annotation.XmlRootElement(name = "ComputePoolStorageUsageDetail")
public final class ComputePoolStorageUsageDetail extends Resource {

    @XmlElement(name = "Allocated", nillable = true)
    protected ResourceCapacity allocated;
    @XmlElement(name = "DetachedDisks", nillable = true)
    protected DetachedDiskReferenceList detachedDisks;
    @XmlElementWrapper(name = "VirtualMachines")
    @XmlElement(name = "VirtualMachine")
    protected List<VirtualMachineStorageUsageDetail> virtualMachines;

    /**
     * Gets the value of the allocated property.
     *
     * @return possible object is {@link ResourceCapacity }
     */
    public ResourceCapacity getAllocated() {
        return allocated;
    }

    /**
     * Sets the value of the allocated property.
     *
     * @param value allowed object is {@link ResourceCapacity }
     */
    public void setAllocated(final ResourceCapacity value) {
        this.allocated = value;
    }

    /**
     * Gets the value of the detachedDisks property.
     *
     * @return possible object is {@link DetachedDiskReferenceList }
     */
    public DetachedDiskReferenceList getDetachedDisks() {
        return detachedDisks;
    }

    /**
     * Sets the value of the detachedDisks property.
     *
     * @param value allowed object is {@link DetachedDiskReferenceList }
     */
    public void setDetachedDisks(final DetachedDiskReferenceList value) {
        this.detachedDisks = value;
    }

    public List<VirtualMachineStorageUsageDetail> getVirtualMachines() {
        if (virtualMachines == null) {
            virtualMachines = new ArrayList<VirtualMachineStorageUsageDetail>();
        }
        return virtualMachines;
    }

}
