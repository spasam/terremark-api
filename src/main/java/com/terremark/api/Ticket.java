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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for Ticket complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Ticket">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DetectedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Severity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Device" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Classification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Owner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Information" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Solution" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="History" type="{}ArrayOfTicketHistoryItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ticket", propOrder = {"id", "date", "status", "category", "detectedBy", "severity", "device",
                "classification", "owner", "description", "information", "solution", "history"})
@javax.xml.bind.annotation.XmlRootElement(name = "Ticket")
public final class Ticket extends Resource {

    @XmlElement(name = "Id")
    protected Integer id;
    @XmlElement(name = "Date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "Status", nillable = true)
    protected String status;
    @XmlElement(name = "Category", nillable = true)
    protected String category;
    @XmlElement(name = "DetectedBy", nillable = true)
    protected String detectedBy;
    @XmlElement(name = "Severity", nillable = true)
    protected String severity;
    @XmlElement(name = "Device", nillable = true)
    protected String device;
    @XmlElement(name = "Classification", nillable = true)
    protected String classification;
    @XmlElement(name = "Owner", nillable = true)
    protected String owner;
    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "Information", nillable = true)
    protected String information;
    @XmlElement(name = "Solution", nillable = true)
    protected String solution;
    @XmlElementWrapper(name = "History")
    @XmlElement(name = "TicketHistoryItem")
    protected List<TicketHistoryItem> history;

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
     * Gets the value of the category property.
     *
     * @return possible object is {@link String }
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     *
     * @param value allowed object is {@link String }
     */
    public void setCategory(final String value) {
        this.category = value;
    }

    /**
     * Gets the value of the detectedBy property.
     *
     * @return possible object is {@link String }
     */
    public String getDetectedBy() {
        return detectedBy;
    }

    /**
     * Sets the value of the detectedBy property.
     *
     * @param value allowed object is {@link String }
     */
    public void setDetectedBy(final String value) {
        this.detectedBy = value;
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
     * Gets the value of the classification property.
     *
     * @return possible object is {@link String }
     */
    public String getClassification() {
        return classification;
    }

    /**
     * Sets the value of the classification property.
     *
     * @param value allowed object is {@link String }
     */
    public void setClassification(final String value) {
        this.classification = value;
    }

    /**
     * Gets the value of the owner property.
     *
     * @return possible object is {@link String }
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     *
     * @param value allowed object is {@link String }
     */
    public void setOwner(final String value) {
        this.owner = value;
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

    /**
     * Gets the value of the information property.
     *
     * @return possible object is {@link String }
     */
    public String getInformation() {
        return information;
    }

    /**
     * Sets the value of the information property.
     *
     * @param value allowed object is {@link String }
     */
    public void setInformation(final String value) {
        this.information = value;
    }

    /**
     * Gets the value of the solution property.
     *
     * @return possible object is {@link String }
     */
    public String getSolution() {
        return solution;
    }

    /**
     * Sets the value of the solution property.
     *
     * @param value allowed object is {@link String }
     */
    public void setSolution(final String value) {
        this.solution = value;
    }

    public List<TicketHistoryItem> getHistory() {
        if (history == null) {
            history = new ArrayList<TicketHistoryItem>();
        }
        return history;
    }

}
