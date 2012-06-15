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
 * Java class for HistoricalUsage complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HistoricalUsage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Month" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Billable" type="{}ResourceCapacity" minOccurs="0"/>
 *         &lt;element name="Burst" type="{}ResourceCapacity" minOccurs="0"/>
 *         &lt;element name="Total" type="{}ResourceCapacity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HistoricalUsage", propOrder = {"month", "year", "billable", "burst", "total"})
public class HistoricalUsage extends ToStringGenerator {

    @XmlElement(name = "Month")
    protected Integer month;
    @XmlElement(name = "Year")
    protected Integer year;
    @XmlElement(name = "Billable", nillable = true)
    protected ResourceCapacity billable;
    @XmlElement(name = "Burst", nillable = true)
    protected ResourceCapacity burst;
    @XmlElement(name = "Total", nillable = true)
    protected ResourceCapacity total;

    /**
     * Gets the value of the month property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setMonth(final Integer value) {
        this.month = value;
    }

    /**
     * Gets the value of the year property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setYear(final Integer value) {
        this.year = value;
    }

    /**
     * Gets the value of the billable property.
     *
     * @return possible object is {@link ResourceCapacity }
     */
    public ResourceCapacity getBillable() {
        return billable;
    }

    /**
     * Sets the value of the billable property.
     *
     * @param value allowed object is {@link ResourceCapacity }
     */
    public void setBillable(final ResourceCapacity value) {
        this.billable = value;
    }

    /**
     * Gets the value of the burst property.
     *
     * @return possible object is {@link ResourceCapacity }
     */
    public ResourceCapacity getBurst() {
        return burst;
    }

    /**
     * Sets the value of the burst property.
     *
     * @param value allowed object is {@link ResourceCapacity }
     */
    public void setBurst(final ResourceCapacity value) {
        this.burst = value;
    }

    /**
     * Gets the value of the total property.
     *
     * @return possible object is {@link ResourceCapacity }
     */
    public ResourceCapacity getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     *
     * @param value allowed object is {@link ResourceCapacity }
     */
    public void setTotal(final ResourceCapacity value) {
        this.total = value;
    }
}
