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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for ComputePoolMemoryUsageDetailSummaryEntry complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ComputePoolMemoryUsageDetailSummaryEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Value" type="{}ResourceCapacity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComputePoolMemoryUsageDetailSummaryEntry", propOrder = {"time", "value"})
public class ComputePoolMemoryUsageDetailSummaryEntry extends ToStringGenerator {

    @XmlElement(name = "Time")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar time;
    @XmlElement(name = "Value", nillable = true)
    protected ResourceCapacity value;

    /**
     * Gets the value of the time property.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     *
     * @param value allowed object is {@link XMLGregorianCalendar }
     */
    public void setTime(final XMLGregorianCalendar value) {
        this.time = value;
    }

    /**
     * Gets the value of the value property.
     *
     * @return possible object is {@link ResourceCapacity }
     */
    public ResourceCapacity getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is {@link ResourceCapacity }
     */
    public void setValue(final ResourceCapacity value) {
        this.value = value;
    }
}
