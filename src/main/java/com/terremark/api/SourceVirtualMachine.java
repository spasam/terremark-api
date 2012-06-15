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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SourceVirtualMachine complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SourceVirtualMachine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcessorCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Memory" type="{}ResourceCapacity" minOccurs="0"/>
 *         &lt;element name="OperatingSystem" type="{}Reference" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SourceVirtualMachine", propOrder = {"processorCount", "memory", "operatingSystem"})
public class SourceVirtualMachine extends ToStringGenerator {

    @XmlElement(name = "ProcessorCount")
    protected Integer processorCount;
    @XmlElement(name = "Memory", nillable = true)
    protected ResourceCapacity memory;
    @XmlElement(name = "OperatingSystem", nillable = true)
    protected Reference operatingSystem;
    @XmlAttribute(name = "name")
    protected String name;

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
}
