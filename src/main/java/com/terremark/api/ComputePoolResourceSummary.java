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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for ComputePoolResourceSummary complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ComputePoolResourceSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="EndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Cpu" type="{}CpuComputeResourceSummary" minOccurs="0"/>
 *         &lt;element name="Memory" type="{}MemoryComputeResourceSummary" minOccurs="0"/>
 *         &lt;element name="Storage" type="{}StorageResourceSummary" minOccurs="0"/>
 *         &lt;element name="VirtualMachines" type="{}VirtualMachineResourceSummary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComputePoolResourceSummary", propOrder = {"startTime", "endTime", "cpu", "memory", "storage",
                "virtualMachines"})
@javax.xml.bind.annotation.XmlRootElement(name = "ComputePoolResourceSummary")
public final class ComputePoolResourceSummary extends Resource {

    @XmlElement(name = "StartTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlElement(name = "EndTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endTime;
    @XmlElement(name = "Cpu", nillable = true)
    protected CpuComputeResourceSummary cpu;
    @XmlElement(name = "Memory", nillable = true)
    protected MemoryComputeResourceSummary memory;
    @XmlElement(name = "Storage", nillable = true)
    protected StorageResourceSummary storage;
    @XmlElement(name = "VirtualMachines", nillable = true)
    protected VirtualMachineResourceSummary virtualMachines;

    /**
     * Gets the value of the startTime property.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     *
     * @param value allowed object is {@link XMLGregorianCalendar }
     */
    public void setStartTime(final XMLGregorianCalendar value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the endTime property.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     *
     * @param value allowed object is {@link XMLGregorianCalendar }
     */
    public void setEndTime(final XMLGregorianCalendar value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the cpu property.
     *
     * @return possible object is {@link CpuComputeResourceSummary }
     */
    public CpuComputeResourceSummary getCpu() {
        return cpu;
    }

    /**
     * Sets the value of the cpu property.
     *
     * @param value allowed object is {@link CpuComputeResourceSummary }
     */
    public void setCpu(final CpuComputeResourceSummary value) {
        this.cpu = value;
    }

    /**
     * Gets the value of the memory property.
     *
     * @return possible object is {@link MemoryComputeResourceSummary }
     */
    public MemoryComputeResourceSummary getMemory() {
        return memory;
    }

    /**
     * Sets the value of the memory property.
     *
     * @param value allowed object is {@link MemoryComputeResourceSummary }
     */
    public void setMemory(final MemoryComputeResourceSummary value) {
        this.memory = value;
    }

    /**
     * Gets the value of the storage property.
     *
     * @return possible object is {@link StorageResourceSummary }
     */
    public StorageResourceSummary getStorage() {
        return storage;
    }

    /**
     * Sets the value of the storage property.
     *
     * @param value allowed object is {@link StorageResourceSummary }
     */
    public void setStorage(final StorageResourceSummary value) {
        this.storage = value;
    }

    /**
     * Gets the value of the virtualMachines property.
     *
     * @return possible object is {@link VirtualMachineResourceSummary }
     */
    public VirtualMachineResourceSummary getVirtualMachines() {
        return virtualMachines;
    }

    /**
     * Sets the value of the virtualMachines property.
     *
     * @param value allowed object is {@link VirtualMachineResourceSummary }
     */
    public void setVirtualMachines(final VirtualMachineResourceSummary value) {
        this.virtualMachines = value;
    }
}
