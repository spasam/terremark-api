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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ResourceCapacity complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ResourceCapacity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceCapacity", propOrder = {"unit", "value"})
@XmlSeeAlso({Threshold.class})
public class ResourceCapacity extends ToStringGenerator {

    @XmlElement(name = "Unit", nillable = true)
    protected String unit;
    @XmlElement(name = "Value")
    protected BigDecimal value;

    /**
     * Gets the value of the unit property.
     *
     * @return possible object is {@link String }
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     *
     * @param value allowed object is {@link String }
     */
    public void setUnit(final String value) {
        this.unit = value;
    }

    /**
     * Gets the value of the value property.
     *
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is {@link BigDecimal }
     */
    public void setValue(final BigDecimal value) {
        this.value = value;
    }
}
