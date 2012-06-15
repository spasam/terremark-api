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
 * Java class for AuditLogItem complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AuditLogItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="User" type="{}UserReference" minOccurs="0"/>
 *         &lt;element name="Action" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Origin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditLogItem", propOrder = {"date", "user", "action", "details", "origin", "sourceIp", "notes"})
public class AuditLogItem extends ToStringGenerator {

    @XmlElement(name = "Date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "User", nillable = true)
    protected UserReference user;
    @XmlElement(name = "Action", nillable = true)
    protected String action;
    @XmlElement(name = "Details", nillable = true)
    protected String details;
    @XmlElement(name = "Origin", nillable = true)
    protected String origin;
    @XmlElement(name = "SourceIp", nillable = true)
    protected String sourceIp;
    @XmlElement(name = "Notes", nillable = true)
    protected String notes;

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
     * Gets the value of the action property.
     *
     * @return possible object is {@link String }
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     *
     * @param value allowed object is {@link String }
     */
    public void setAction(final String value) {
        this.action = value;
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

    /**
     * Gets the value of the origin property.
     *
     * @return possible object is {@link String }
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     *
     * @param value allowed object is {@link String }
     */
    public void setOrigin(final String value) {
        this.origin = value;
    }

    /**
     * Gets the value of the sourceIp property.
     *
     * @return possible object is {@link String }
     */
    public String getSourceIp() {
        return sourceIp;
    }

    /**
     * Sets the value of the sourceIp property.
     *
     * @param value allowed object is {@link String }
     */
    public void setSourceIp(final String value) {
        this.sourceIp = value;
    }

    /**
     * Gets the value of the notes property.
     *
     * @return possible object is {@link String }
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     *
     * @param value allowed object is {@link String }
     */
    public void setNotes(final String value) {
        this.notes = value;
    }
}
