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
 * Java class for HardwareConfiguration complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HardwareConfiguration">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="ProcessorCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Memory" type="{}ResourceCapacity" minOccurs="0"/>
 *         &lt;element name="Disks" type="{}Disks" minOccurs="0"/>
 *         &lt;element name="Nics" type="{}Nics" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HardwareConfiguration", propOrder = {"processorCount", "memory", "disks", "nics"})
@javax.xml.bind.annotation.XmlRootElement(name = "HardwareConfiguration")
public final class HardwareConfiguration extends Resource {

    @XmlElement(name = "ProcessorCount")
    protected Integer processorCount;
    @XmlElement(name = "Memory", nillable = true)
    protected ResourceCapacity memory;
    @XmlElementWrapper(name = "Disks")
    @XmlElement(name = "Disk")
    protected List<VirtualDisk> disks;
    @XmlElementWrapper(name = "Nics")
    @XmlElement(name = "Nic")
    protected List<VirtualNic> nics;

    /**
     * Gets the value of the processorCount property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getProcessorCount() {
        return processorCount;
    }

    /**
     * Sets the value of the processorCount property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setProcessorCount(final Integer value) {
        this.processorCount = value;
    }

    /**
     * Gets the value of the memory property.
     *
     * @return possible object is {@link ResourceCapacity }
     */
    public ResourceCapacity getMemory() {
        return memory;
    }

    /**
     * Sets the value of the memory property.
     *
     * @param value allowed object is {@link ResourceCapacity }
     */
    public void setMemory(final ResourceCapacity value) {
        this.memory = value;
    }

    public List<VirtualDisk> getDisks() {
        if (disks == null) {
            disks = new ArrayList<VirtualDisk>();
        }
        return disks;
    }

    public List<VirtualNic> getNics() {
        if (nics == null) {
            nics = new ArrayList<VirtualNic>();
        }
        return nics;
    }
}
