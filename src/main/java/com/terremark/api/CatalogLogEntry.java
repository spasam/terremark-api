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
 * Java class for CatalogLogEntry complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CatalogLogEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="User" type="{}UserReference" minOccurs="0"/>
 *         &lt;element name="Location" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="CatalogEntryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Event" type="{}CatalogLogEvent" minOccurs="0"/>
 *         &lt;element name="File" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CatalogLogEntry", propOrder = {"date", "user", "location", "catalogEntryName", "event", "file"})
public class CatalogLogEntry extends ToStringGenerator {

    @XmlElement(name = "Date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "User", nillable = true)
    protected UserReference user;
    @XmlElement(name = "Location", nillable = true)
    protected Reference location;
    @XmlElement(name = "CatalogEntryName", nillable = true)
    protected String catalogEntryName;
    @XmlElement(name = "Event")
    protected CatalogLogEvent event;
    @XmlElement(name = "File", nillable = true)
    protected String file;

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
     * Gets the value of the user property.
     *
     * @return possible object is {@link UserReference }
     */
    public UserReference getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     *
     * @param value allowed object is {@link UserReference }
     */
    public void setUser(final UserReference value) {
        this.user = value;
    }

    /**
     * Gets the value of the location property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setLocation(final Reference value) {
        this.location = value;
    }

    /**
     * Gets the value of the catalogEntryName property.
     *
     * @return possible object is {@link String }
     */
    public String getCatalogEntryName() {
        return catalogEntryName;
    }

    /**
     * Sets the value of the catalogEntryName property.
     *
     * @param value allowed object is {@link String }
     */
    public void setCatalogEntryName(final String value) {
        this.catalogEntryName = value;
    }

    /**
     * Gets the value of the event property.
     *
     * @return possible object is {@link CatalogLogEvent }
     */
    public CatalogLogEvent getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     *
     * @param value allowed object is {@link CatalogLogEvent }
     */
    public void setEvent(final CatalogLogEvent value) {
        this.event = value;
    }

    /**
     * Gets the value of the file property.
     *
     * @return possible object is {@link String }
     */
    public String getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     *
     * @param value allowed object is {@link String }
     */
    public void setFile(final String value) {
        this.file = value;
    }
}
