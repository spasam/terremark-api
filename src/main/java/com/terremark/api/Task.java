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
 * Java class for Task complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Task">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="Operation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{}TaskStatus" minOccurs="0"/>
 *         &lt;element name="ImpactedItem" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="CompletedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InitiatedBy" type="{}Reference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Task", propOrder = {"operation", "status", "impactedItem", "startTime", "completedTime", "notes",
                "errorMessage", "initiatedBy"})
@javax.xml.bind.annotation.XmlRootElement(name = "Task")
public final class Task extends Resource {

    @XmlElement(name = "Operation", nillable = true)
    protected String operation;
    @XmlElement(name = "Status", nillable = true)
    protected TaskStatus status;
    @XmlElement(name = "ImpactedItem", nillable = true)
    protected Reference impactedItem;
    @XmlElement(name = "StartTime", nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlElement(name = "CompletedTime", nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar completedTime;
    @XmlElement(name = "Notes", nillable = true)
    protected String notes;
    @XmlElement(name = "ErrorMessage", nillable = true)
    protected String errorMessage;
    @XmlElement(name = "InitiatedBy", nillable = true)
    protected Reference initiatedBy;

    /**
     * Gets the value of the operation property.
     *
     * @return possible object is {@link String }
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     *
     * @param value allowed object is {@link String }
     */
    public void setOperation(final String value) {
        this.operation = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is {@link TaskStatus }
     */
    public TaskStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is {@link TaskStatus }
     */
    public void setStatus(final TaskStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the impactedItem property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getImpactedItem() {
        return impactedItem;
    }

    /**
     * Sets the value of the impactedItem property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setImpactedItem(final Reference value) {
        this.impactedItem = value;
    }

    /**
     * Gets the value of the startTime property.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     *
     * @param value allowed object is {@link XMLGregorianCalendar }
     */
    public void setStartTime(final XMLGregorianCalendar value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the completedTime property.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCompletedTime() {
        return completedTime;
    }

    /**
     * Sets the value of the completedTime property.
     *
     * @param value allowed object is {@link XMLGregorianCalendar }
     */
    public void setCompletedTime(final XMLGregorianCalendar value) {
        this.completedTime = value;
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

    /**
     * Gets the value of the errorMessage property.
     *
     * @return possible object is {@link String }
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     *
     * @param value allowed object is {@link String }
     */
    public void setErrorMessage(final String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the initiatedBy property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getInitiatedBy() {
        return initiatedBy;
    }

    /**
     * Sets the value of the initiatedBy property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setInitiatedBy(final Reference value) {
        this.initiatedBy = value;
    }
}
