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
 * Java class for PhysicalServerSoftwareEntry complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PhysicalServerSoftwareEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LicenseCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CostPerUnit" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicalServerSoftwareEntry", propOrder = {"description", "licenseCount", "costPerUnit"})
public class PhysicalServerSoftwareEntry extends ToStringGenerator {

    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "LicenseCount")
    protected Integer licenseCount;
    @XmlElement(name = "CostPerUnit")
    protected BigDecimal costPerUnit;

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
     * Gets the value of the licenseCount property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getLicenseCount() {
        return licenseCount;
    }

    /**
     * Sets the value of the licenseCount property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setLicenseCount(final Integer value) {
        this.licenseCount = value;
    }

    /**
     * Gets the value of the costPerUnit property.
     *
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getCostPerUnit() {
        return costPerUnit;
    }

    /**
     * Sets the value of the costPerUnit property.
     *
     * @param value allowed object is {@link BigDecimal }
     */
    public void setCostPerUnit(final BigDecimal value) {
        this.costPerUnit = value;
    }
}
