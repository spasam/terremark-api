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
 * Java class for VirtualMachine complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VirtualMachine">
 *   &lt;complexContent>
 *     &lt;extension base="{}Device">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{}VirtualMachineStatus" minOccurs="0"/>
 *         &lt;element name="PoweredOn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HardwareConfiguration" type="{}HardwareConfiguration" minOccurs="0"/>
 *         &lt;element name="IpAddresses" type="{}VirtualMachineIpAddresses" minOccurs="0"/>
 *         &lt;element name="OperatingSystem" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="ToolsStatus" type="{}ToolsStatus" minOccurs="0"/>
 *         &lt;element name="MediaStatus" type="{}VirtualMachineMediaStatus" minOccurs="0"/>
 *         &lt;element name="CustomizationPending" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PendingRetryOperation" type="{}Reference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachine", propOrder = {"status", "poweredOn", "hardwareConfiguration", "ipAddresses",
                "operatingSystem", "toolsStatus", "mediaStatus", "customizationPending", "pendingRetryOperation"})
@javax.xml.bind.annotation.XmlRootElement(name = "VirtualMachine")
public final class VirtualMachine extends Device {

    @XmlElement(name = "Status", nillable = true)
    protected VirtualMachineStatus status;
    @XmlElement(name = "PoweredOn", nillable = true)
    protected Boolean poweredOn;
    @XmlElement(name = "HardwareConfiguration", nillable = true)
    protected HardwareConfiguration hardwareConfiguration;
    @XmlElement(name = "IpAddresses", nillable = true)
    protected VirtualMachineIpAddresses ipAddresses;
    @XmlElement(name = "OperatingSystem", nillable = true)
    protected Reference operatingSystem;
    @XmlElement(name = "ToolsStatus", nillable = true)
    protected ToolsStatus toolsStatus;
    @XmlElement(name = "MediaStatus", nillable = true)
    protected VirtualMachineMediaStatus mediaStatus;
    @XmlElement(name = "CustomizationPending", nillable = true)
    protected Boolean customizationPending;
    @XmlElement(name = "PendingRetryOperation", nillable = true)
    protected Reference pendingRetryOperation;

    /**
     * Gets the value of the status property.
     *
     * @return possible object is {@link VirtualMachineStatus }
     */
    public VirtualMachineStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is {@link VirtualMachineStatus }
     */
    public void setStatus(final VirtualMachineStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the poweredOn property.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isPoweredOn() {
        return poweredOn;
    }

    /**
     * Sets the value of the poweredOn property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setPoweredOn(final Boolean value) {
        this.poweredOn = value;
    }

    /**
     * Gets the value of the hardwareConfiguration property.
     *
     * @return possible object is {@link HardwareConfiguration }
     */
    public HardwareConfiguration getHardwareConfiguration() {
        return hardwareConfiguration;
    }

    /**
     * Sets the value of the hardwareConfiguration property.
     *
     * @param value allowed object is {@link HardwareConfiguration }
     */
    public void setHardwareConfiguration(final HardwareConfiguration value) {
        this.hardwareConfiguration = value;
    }

    /**
     * Gets the value of the ipAddresses property.
     *
     * @return possible object is {@link VirtualMachineIpAddresses }
     */
    public VirtualMachineIpAddresses getIpAddresses() {
        return ipAddresses;
    }

    /**
     * Sets the value of the ipAddresses property.
     *
     * @param value allowed object is {@link VirtualMachineIpAddresses }
     */
    public void setIpAddresses(final VirtualMachineIpAddresses value) {
        this.ipAddresses = value;
    }

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

    /**
     * Gets the value of the toolsStatus property.
     *
     * @return possible object is {@link ToolsStatus }
     */
    public ToolsStatus getToolsStatus() {
        return toolsStatus;
    }

    /**
     * Sets the value of the toolsStatus property.
     *
     * @param value allowed object is {@link ToolsStatus }
     */
    public void setToolsStatus(final ToolsStatus value) {
        this.toolsStatus = value;
    }

    /**
     * Gets the value of the mediaStatus property.
     *
     * @return possible object is {@link VirtualMachineMediaStatus }
     */
    public VirtualMachineMediaStatus getMediaStatus() {
        return mediaStatus;
    }

    /**
     * Sets the value of the mediaStatus property.
     *
     * @param value allowed object is {@link VirtualMachineMediaStatus }
     */
    public void setMediaStatus(final VirtualMachineMediaStatus value) {
        this.mediaStatus = value;
    }

    /**
     * Gets the value of the customizationPending property.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isCustomizationPending() {
        return customizationPending;
    }

    /**
     * Sets the value of the customizationPending property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setCustomizationPending(final Boolean value) {
        this.customizationPending = value;
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
