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
 * Java class for AlertEvent complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AlertEvent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Reading" type="{}ResourceCapacity" minOccurs="0"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="EventType" type="{}AlertEventTypeEnum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlertEvent", propOrder = {"reading", "date", "eventType"})
public class AlertEvent extends ToStringGenerator {

    @XmlElement(name = "Reading", nillable = true)
    protected ResourceCapacity reading;
    @XmlElement(name = "Date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "EventType")
    protected AlertEventTypeEnum eventType;

    /**
     * Gets the value of the reading property.
     *
     * @return possible object is {@link ResourceCapacity }
     */
    public ResourceCapacity getReading() {
        return reading;
    }

    /**
     * Sets the value of the reading property.
     *
     * @param value allowed object is {@link ResourceCapacity }
     */
    public void setReading(final ResourceCapacity value) {
        this.reading = value;
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
     * Gets the value of the eventType property.
     *
     * @return possible object is {@link AlertEventTypeEnum }
     */
    public AlertEventTypeEnum getEventType() {
        return eventType;
    }

    /**
     * Sets the value of the eventType property.
     *
     * @param value allowed object is {@link AlertEventTypeEnum }
     */
    public void setEventType(final AlertEventTypeEnum value) {
        this.eventType = value;
    }
}
