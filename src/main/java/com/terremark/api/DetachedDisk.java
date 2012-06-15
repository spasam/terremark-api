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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DetachedDisk complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DetachedDisk">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="Tasks" type="{}Tasks" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastKnownVirtualMachineConfiguration" type="{}SourceVirtualMachine" minOccurs="0"/>
 *         &lt;element name="DiskType" type="{}DetachedDiskTypeEnum" minOccurs="0"/>
 *         &lt;element name="Size" type="{}ResourceCapacity" minOccurs="0"/>
 *         &lt;element name="Status" type="{}DetachedDiskStatus" minOccurs="0"/>
 *         &lt;element name="PendingRetryOperation" type="{}Reference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetachedDisk", propOrder = {"tasks", "description", "lastKnownVirtualMachineConfiguration",
                "diskType", "size", "status", "pendingRetryOperation"})
@javax.xml.bind.annotation.XmlRootElement(name = "DetachedDisk")
public final class DetachedDisk extends Resource {

    @XmlElement(name = "Tasks", nillable = true)
    protected Tasks tasks;
    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "LastKnownVirtualMachineConfiguration", nillable = true)
    protected SourceVirtualMachine lastKnownVirtualMachineConfiguration;
    @XmlElement(name = "DiskType")
    protected DetachedDiskTypeEnum diskType;
    @XmlElement(name = "Size", nillable = true)
    protected ResourceCapacity size;
    @XmlElement(name = "Status")
    protected DetachedDiskStatus status;
    @XmlElement(name = "PendingRetryOperation", nillable = true)
    protected Reference pendingRetryOperation;

    /**
     * Gets the value of the tasks property.
     *
     * @return possible object is {@link Tasks }
     */
    public Tasks getTasks() {
        return tasks;
    }

    /**
     * Sets the value of the tasks property.
     *
     * @param value allowed object is {@link Tasks }
     */
    public void setTasks(final Tasks value) {
        this.tasks = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is {@link String }
     */
    public void setDescription(final String value) {
        this.description = value;
    }

    /**
     * Gets the value of the lastKnownVirtualMachineConfiguration property.
     *
     * @return possible object is {@link SourceVirtualMachine }
     */
    public SourceVirtualMachine getLastKnownVirtualMachineConfiguration() {
        return lastKnownVirtualMachineConfiguration;
    }

    /**
     * Sets the value of the lastKnownVirtualMachineConfiguration property.
     *
     * @param value allowed object is {@link SourceVirtualMachine }
     */
    public void setLastKnownVirtualMachineConfiguration(final SourceVirtualMachine value) {
        this.lastKnownVirtualMachineConfiguration = value;
    }

    /**
     * Gets the value of the diskType property.
     *
     * @return possible object is {@link DetachedDiskTypeEnum }
     */
    public DetachedDiskTypeEnum getDiskType() {
        return diskType;
    }

    /**
     * Sets the value of the diskType property.
     *
     * @param value allowed object is {@link DetachedDiskTypeEnum }
     */
    public void setDiskType(final DetachedDiskTypeEnum value) {
        this.diskType = value;
    }

    /**
     * Gets the value of the size property.
     *
     * @return possible object is {@link ResourceCapacity }
     */
    public ResourceCapacity getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     *
     * @param value allowed object is {@link ResourceCapacity }
     */
    public void setSize(final ResourceCapacity value) {
        this.size = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is {@link DetachedDiskStatus }
     */
    public DetachedDiskStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is {@link DetachedDiskStatus }
     */
    public void setStatus(final DetachedDiskStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the pendingRetryOperation property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getPendingRetryOperation() {
        return pendingRetryOperation;
    }

    /**
     * Sets the value of the pendingRetryOperation property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setPendingRetryOperation(final Reference value) {
        this.pendingRetryOperation = value;
    }

}
