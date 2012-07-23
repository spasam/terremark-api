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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CopyVirtualMachine complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CopyVirtualMachine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Source" type="{}Reference"/>
 *         &lt;element name="ProcessorCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Memory" type="{}ResourceCapacity" minOccurs="0"/>
 *         &lt;element name="Layout" type="{}LayoutRequest" minOccurs="0"/>
 *         &lt;element name="DisableCustomization" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LinuxCustomization" type="{}LinuxCustomization" minOccurs="0"/>
 *         &lt;element name="WindowsCustomization" type="{}WindowsCustomization" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tags" type="{}Tags" minOccurs="0"/>
 *         &lt;element name="PoweredOn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CopyVirtualMachine", propOrder = {"source", "processorCount", "memory", "layout",
                "disableCustomization", "linuxCustomization", "windowsCustomization", "description", "tags",
                "poweredOn"})
@javax.xml.bind.annotation.XmlRootElement(name = "CopyVirtualMachine")
public final class CopyVirtualMachine extends ToStringGenerator {

    @XmlElement(name = "Source", required = true, nillable = true)
    protected Reference source;
    @XmlElement(name = "ProcessorCount")
    protected Integer processorCount;
    @XmlElement(name = "Memory", nillable = true)
    protected ResourceCapacity memory;
    @XmlElement(name = "Layout", nillable = true)
    protected LayoutRequest layout;
    @XmlElement(name = "DisableCustomization", nillable = true)
    protected Boolean disableCustomization;
    @XmlElement(name = "LinuxCustomization", nillable = true)
    protected LinuxCustomization linuxCustomization;
    @XmlElement(name = "WindowsCustomization", nillable = true)
    protected WindowsCustomization windowsCustomization;
    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "PoweredOn", nillable = true)
    protected Boolean poweredOn;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlElementWrapper(name = "Tags")
    @XmlElement(name = "Tag")
    protected List<String> tags;

    /**
     * Gets the value of the source property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setSource(final Reference value) {
        this.source = value;
    }

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

    /**
     * Gets the value of the layout property.
     *
     * @return possible object is {@link LayoutRequest }
     */
    public LayoutRequest getLayout() {
        return layout;
    }

    /**
     * Sets the value of the layout property.
     *
     * @param value allowed object is {@link LayoutRequest }
     */
    public void setLayout(final LayoutRequest value) {
        this.layout = value;
    }

    /**
     * Gets the value of the disableCustomization property.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isDisableCustomization() {
        return disableCustomization;
    }

    /**
     * Sets the value of the disableCustomization property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setDisableCustomization(final Boolean value) {
        this.disableCustomization = value;
    }

    /**
     * Gets the value of the linuxCustomization property.
     *
     * @return possible object is {@link LinuxCustomization }
     */
    public LinuxCustomization getLinuxCustomization() {
        return linuxCustomization;
    }

    /**
     * Sets the value of the linuxCustomization property.
     *
     * @param value allowed object is {@link LinuxCustomization }
     */
    public void setLinuxCustomization(final LinuxCustomization value) {
        this.linuxCustomization = value;
    }

    /**
     * Gets the value of the windowsCustomization property.
     *
     * @return possible object is {@link WindowsCustomization }
     */
    public WindowsCustomization getWindowsCustomization() {
        return windowsCustomization;
    }

    /**
     * Sets the value of the windowsCustomization property.
     *
     * @param value allowed object is {@link WindowsCustomization }
     */
    public void setWindowsCustomization(final WindowsCustomization value) {
        this.windowsCustomization = value;
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
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is {@link String }
     */
    public void setName(final String value) {
        this.name = value;
    }

    public List<String> getTags() {
        if (tags == null) {
            tags = new ArrayList<String>();
        }
        return tags;
    }
}
