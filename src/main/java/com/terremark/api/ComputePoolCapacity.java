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
 * Java class for ComputePoolCapacity complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ComputePoolCapacity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cpu" type="{}ResourceCapacity" minOccurs="0"/>
 *         &lt;element name="Memory" type="{}ResourceCapacity" minOccurs="0"/>
 *         &lt;element name="Storage" type="{}ResourceCapacity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComputePoolCapacity", propOrder = {"cpu", "memory", "storage"})
public class ComputePoolCapacity extends ToStringGenerator {

    @XmlElement(name = "Cpu", nillable = true)
    protected ResourceCapacity cpu;
    @XmlElement(name = "Memory", nillable = true)
    protected ResourceCapacity memory;
    @XmlElement(name = "Storage", nillable = true)
    protected ResourceCapacity storage;

    /**
     * Gets the value of the cpu property.
     *
     * @return possible object is {@link ResourceCapacity }
     */
    public ResourceCapacity getCpu() {
        return cpu;
    }

    /**
     * Sets the value of the cpu property.
     *
     * @param value allowed object is {@link ResourceCapacity }
     */
    public void setCpu(final ResourceCapacity value) {
        this.cpu = value;
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
     * Gets the value of the storage property.
     *
     * @return possible object is {@link ResourceCapacity }
     */
    public ResourceCapacity getStorage() {
        return storage;
    }

    /**
     * Sets the value of the storage property.
     *
     * @param value allowed object is {@link ResourceCapacity }
     */
    public void setStorage(final ResourceCapacity value) {
        this.storage = value;
    }
}