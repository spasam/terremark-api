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

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ComputeMatrixEntry complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ComputeMatrixEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcessorCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Memory" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="HourlyCost" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComputeMatrixEntry", propOrder = {"processorCount", "memory", "hourlyCost"})
public class ComputeMatrixEntry extends ToStringGenerator {

    @XmlElement(name = "ProcessorCount")
    protected Integer processorCount;
    @XmlElement(name = "Memory")
    protected Integer memory;
    @XmlElement(name = "HourlyCost")
    protected BigDecimal hourlyCost;

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
     * @return possible object is {@link Integer }
     */
    public Integer getMemory() {
        return memory;
    }

    /**
     * Sets the value of the memory property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setMemory(final Integer value) {
        this.memory = value;
    }

    /**
     * Gets the value of the hourlyCost property.
     *
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getHourlyCost() {
        return hourlyCost;
    }

    /**
     * Sets the value of the hourlyCost property.
     *
     * @param value allowed object is {@link BigDecimal }
     */
    public void setHourlyCost(final BigDecimal value) {
        this.hourlyCost = value;
    }
}
