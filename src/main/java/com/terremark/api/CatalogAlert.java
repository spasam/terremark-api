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
 * Java class for CatalogAlert complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CatalogAlert">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{}CatalogAlertTypeEnum" minOccurs="0"/>
 *         &lt;element name="Details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CatalogAlert", propOrder = {"type", "details"})
public class CatalogAlert extends ToStringGenerator {

    @XmlElement(name = "Type")
    protected CatalogAlertTypeEnum type;
    @XmlElement(name = "Details", nillable = true)
    protected String details;

    /**
     * Gets the value of the type property.
     *
     * @return possible object is {@link CatalogAlertTypeEnum }
     */
    public CatalogAlertTypeEnum getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is {@link CatalogAlertTypeEnum }
     */
    public void setType(final CatalogAlertTypeEnum value) {
        this.type = value;
    }

    /**
     * Gets the value of the details property.
     *
     * @return possible object is {@link String }
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     *
     * @param value allowed object is {@link String }
     */
    public void setDetails(final String value) {
        this.details = value;
    }
}
