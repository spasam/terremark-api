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
 * Java class for ComputePoolPerformanceStatistic complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ComputePoolPerformanceStatistic">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cpu" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="Memory" type="{}Reference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComputePoolPerformanceStatistic", propOrder = {"cpu", "memory"})
public class ComputePoolPerformanceStatistic extends ToStringGenerator {

    @XmlElement(name = "Cpu", nillable = true)
    protected Reference cpu;
    @XmlElement(name = "Memory", nillable = true)
    protected Reference memory;

    /**
     * Gets the value of the cpu property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getCpu() {
        return cpu;
    }

    /**
     * Sets the value of the cpu property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setCpu(final Reference value) {
        this.cpu = value;
    }

    /**
     * Gets the value of the memory property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getMemory() {
        return memory;
    }

    /**
     * Sets the value of the memory property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setMemory(final Reference value) {
        this.memory = value;
    }
}
