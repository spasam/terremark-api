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
 * Java class for Alert complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Alert">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="AlertRuleTemplate" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="AlertSource" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="DurationInMinutes" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="EndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Status" type="{}AlertResolutionStatusEnum" minOccurs="0"/>
 *         &lt;element name="AlertType" type="{}AlertTypeEnum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Alert", propOrder = {"alertRuleTemplate", "alertSource", "durationInMinutes", "startTime", "endTime",
                "status", "alertType"})
@javax.xml.bind.annotation.XmlRootElement(name = "Alert")
public final class Alert extends Resource {

    @XmlElement(name = "AlertRuleTemplate", nillable = true)
    protected Reference alertRuleTemplate;
    @XmlElement(name = "AlertSource", nillable = true)
    protected Reference alertSource;
    @XmlElement(name = "DurationInMinutes", nillable = true)
    protected Long durationInMinutes;
    @XmlElement(name = "StartTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlElement(name = "EndTime", nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endTime;
    @XmlElement(name = "Status")
    protected AlertResolutionStatusEnum status;
    @XmlElement(name = "AlertType")
    protected AlertTypeEnum alertType;

    /**
     * Gets the value of the alertRuleTemplate property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getAlertRuleTemplate() {
        return alertRuleTemplate;
    }

    /**
     * Sets the value of the alertRuleTemplate property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setAlertRuleTemplate(final Reference value) {
        this.alertRuleTemplate = value;
    }

    /**
     * Gets the value of the alertSource property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getAlertSource() {
        return alertSource;
    }

    /**
     * Sets the value of the alertSource property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setAlertSource(final Reference value) {
        this.alertSource = value;
    }

    /**
     * Gets the value of the durationInMinutes property.
     *
     * @return possible object is {@link Long }
     */
    public Long getDurationInMinutes() {
        return durationInMinutes;
    }

    /**
     * Sets the value of the durationInMinutes property.
     *
     * @param value allowed object is {@link Long }
     */
    public void setDurationInMinutes(final Long value) {
        this.durationInMinutes = value;
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
     * Gets the value of the endTime property.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     *
     * @param value allowed object is {@link XMLGregorianCalendar }
     */
    public void setEndTime(final XMLGregorianCalendar value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is {@link AlertResolutionStatusEnum }
     */
    public AlertResolutionStatusEnum getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is {@link AlertResolutionStatusEnum }
     */
    public void setStatus(final AlertResolutionStatusEnum value) {
        this.status = value;
    }

    /**
     * Gets the value of the alertType property.
     *
     * @return possible object is {@link AlertTypeEnum }
     */
    public AlertTypeEnum getAlertType() {
        return alertType;
    }

    /**
     * Sets the value of the alertType property.
     *
     * @param value allowed object is {@link AlertTypeEnum }
     */
    public void setAlertType(final AlertTypeEnum value) {
        this.alertType = value;
    }
}
