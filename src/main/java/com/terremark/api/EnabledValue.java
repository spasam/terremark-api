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
 * Java class for EnabledValue complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EnabledValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnabledValue", propOrder = {"enabled", "value", "unit"})
public class EnabledValue extends ToStringGenerator {

    @XmlElement(name = "Enabled")
    protected boolean enabled;
    @XmlElement(name = "Value", nillable = true)
    protected Integer value;
    @XmlElement(name = "Unit", nillable = true)
    protected String unit;

    /**
     * Gets the value of the enabled property.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     */
    public void setEnabled(final boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the value property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setValue(final Integer value) {
        this.value = value;
    }

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
}
