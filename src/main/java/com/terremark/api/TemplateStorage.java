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
 * Java class for TemplateStorage complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TemplateStorage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Size" type="{}ResourceCapacity" minOccurs="0"/>
 *         &lt;element name="HourlyCost" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemplateStorage", propOrder = {"size", "hourlyCost"})
public class TemplateStorage extends ToStringGenerator {

    @XmlElement(name = "Size", nillable = true)
    protected ResourceCapacity size;
    @XmlElement(name = "HourlyCost", nillable = true)
    protected BigDecimal hourlyCost;

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
