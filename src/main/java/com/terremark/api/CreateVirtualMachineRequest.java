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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CreateVirtualMachineRequest complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CreateVirtualMachineRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcessorCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Memory" type="{}ResourceCapacity"/>
 *         &lt;element name="Layout" type="{}LayoutRequest"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tags" type="{}Tags" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateVirtualMachineRequest", propOrder = {"processorCount", "memory", "layout", "description", "tags"})
@XmlSeeAlso({CreateOsTemplateVirtualMachineRequest.class, ImportVirtualMachine.class, CreateBlankVirtualMachine.class})
public class CreateVirtualMachineRequest extends ToStringGenerator {

    @XmlElement(name = "ProcessorCount")
    protected int processorCount;
    @XmlElement(name = "Memory", required = true, nillable = true)
    protected ResourceCapacity memory;
    @XmlElement(name = "Layout", required = true, nillable = true)
    protected LayoutRequest layout;
    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlElementWrapper(name = "Tags")
    @XmlElement(name = "Tag")
    protected List<String> tags;

    /**
     * Gets the value of the processorCount property.
     */
    public int getProcessorCount() {
        return processorCount;
    }

    /**
     * Sets the value of the processorCount property.
     */
    public void setProcessorCount(final int value) {
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
