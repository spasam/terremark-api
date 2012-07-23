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
 * Java class for VirtualMachineConfigurationOptions complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VirtualMachineConfigurationOptions">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="Processor" type="{}ConfigurationOptionRange" minOccurs="0"/>
 *         &lt;element name="Memory" type="{}ResourceCapacityRange" minOccurs="0"/>
 *         &lt;element name="Disk" type="{}DiskConfigurationOption" minOccurs="0"/>
 *         &lt;element name="NetworkAdapter" type="{}ConfigurationOptionRange" minOccurs="0"/>
 *         &lt;element name="Customization" type="{}CustomizationOption" minOccurs="0"/>
 *         &lt;element name="ComputeMatrix" type="{}ComputeMatrix" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineConfigurationOptions", propOrder = {"processor", "memory", "disk", "networkAdapter",
                "customization", "computeMatrix"})
@javax.xml.bind.annotation.XmlRootElement(name = "VirtualMachineConfigurationOptions")
public final class VirtualMachineConfigurationOptions extends Resource {

    @XmlElement(name = "Processor", nillable = true)
    protected ConfigurationOptionRange processor;
    @XmlElement(name = "Memory", nillable = true)
    protected ResourceCapacityRange memory;
    @XmlElement(name = "Disk", nillable = true)
    protected DiskConfigurationOption disk;
    @XmlElement(name = "NetworkAdapter", nillable = true)
    protected ConfigurationOptionRange networkAdapter;
    @XmlElement(name = "Customization", nillable = true)
    protected CustomizationOption customization;
    @XmlElementWrapper(name = "ComputeMatrix")
    @XmlElement(name = "Entry")
    protected List<ComputeMatrixEntry> computeMatrix;

    /**
     * Gets the value of the processor property.
     *
     * @return possible object is {@link ConfigurationOptionRange }
     */
    public ConfigurationOptionRange getProcessor() {
        return processor;
    }

    /**
     * Sets the value of the processor property.
     *
     * @param value allowed object is {@link ConfigurationOptionRange }
     */
    public void setProcessor(final ConfigurationOptionRange value) {
        this.processor = value;
    }

    /**
     * Gets the value of the memory property.
     *
     * @return possible object is {@link ResourceCapacityRange }
     */
    public ResourceCapacityRange getMemory() {
        return memory;
    }

    /**
     * Sets the value of the memory property.
     *
     * @param value allowed object is {@link ResourceCapacityRange }
     */
    public void setMemory(final ResourceCapacityRange value) {
        this.memory = value;
    }

    /**
     * Gets the value of the disk property.
     *
     * @return possible object is {@link DiskConfigurationOption }
     */
    public DiskConfigurationOption getDisk() {
        return disk;
    }

    /**
     * Sets the value of the disk property.
     *
     * @param value allowed object is {@link DiskConfigurationOption }
     */
    public void setDisk(final DiskConfigurationOption value) {
        this.disk = value;
    }

    /**
     * Gets the value of the networkAdapter property.
     *
     * @return possible object is {@link ConfigurationOptionRange }
     */
    public ConfigurationOptionRange getNetworkAdapter() {
        return networkAdapter;
    }

    /**
     * Sets the value of the networkAdapter property.
     *
     * @param value allowed object is {@link ConfigurationOptionRange }
     */
    public void setNetworkAdapter(final ConfigurationOptionRange value) {
        this.networkAdapter = value;
    }

    /**
     * Gets the value of the customization property.
     *
     * @return possible object is {@link CustomizationOption }
     */
    public CustomizationOption getCustomization() {
        return customization;
    }

    /**
     * Sets the value of the customization property.
     *
     * @param value allowed object is {@link CustomizationOption }
     */
    public void setCustomization(final CustomizationOption value) {
        this.customization = value;
    }

    public List<ComputeMatrixEntry> getComputeMatrix() {
        if (computeMatrix == null) {
            computeMatrix = new ArrayList<ComputeMatrixEntry>();
        }
        return computeMatrix;
    }
}
