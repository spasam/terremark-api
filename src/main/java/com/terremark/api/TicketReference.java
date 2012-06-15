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
 * Java class for TicketReference complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TicketReference">
 *   &lt;complexContent>
 *     &lt;extension base="{}Reference">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Severity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Device" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TicketReference", propOrder = {"id", "date", "severity", "status", "device", "description"})
public class TicketReference extends Reference {

    @XmlElement(name = "Id")
    protected Integer id;
    @XmlElement(name = "Date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "Severity", nillable = true)
    protected String severity;
    @XmlElement(name = "Status", nillable = true)
    protected String status;
    @XmlElement(name = "Device", nillable = true)
    protected String device;
    @XmlElement(name = "Description", nillable = true)
    protected String description;

    /**
     * Gets the value of the id property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setId(final Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the date property.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value allowed object is {@link XMLGregorianCalendar }
     */
    public void setDate(final XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the severity property.
     *
     * @return possible object is {@link String }
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * Sets the value of the severity property.
     *
     * @param value allowed object is {@link String }
     */
    public void setSeverity(final String value) {
        this.severity = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is {@link String }
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is {@link String }
     */
    public void setStatus(final String value) {
        this.status = value;
    }

    /**
     * Gets the value of the device property.
     *
     * @return possible object is {@link String }
     */
    public String getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     *
     * @param value allowed object is {@link String }
     */
    public void setDevice(final String value) {
        this.device = value;
    }

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
}
