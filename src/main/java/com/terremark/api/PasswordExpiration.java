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
 * Java class for PasswordExpiration complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PasswordExpiration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PasswordExpirationEnforced" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ExpirationInDays" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ExpirationNoticeInDays" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DoNotExpireBeforeDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PasswordExpiration", propOrder = {"passwordExpirationEnforced", "expirationInDays", "expirationNoticeInDays", "doNotExpireBeforeDate"})
public final class PasswordExpiration extends ToStringGenerator {

    @XmlElement(name = "PasswordExpirationEnforced", nillable = true)
    protected Boolean passwordExpirationEnforced;
    @XmlElement(name = "ExpirationInDays", nillable = true)
    protected Integer expirationInDays;
    @XmlElement(name = "ExpirationNoticeInDays", nillable = true)
    protected Integer expirationNoticeInDays;
    @XmlElement(name = "DoNotExpireBeforeDate", nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar doNotExpireBeforeDate;

    /**
     * Gets the value of the passwordExpirationEnforced property.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean getPasswordExpirationEnforced() {
        return passwordExpirationEnforced;
    }

    /**
     * Sets the value of the passwordExpirationEnforced property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setPasswordExpirationEnforced(final Boolean value) {
        this.passwordExpirationEnforced = value;
    }

    /**
     * Gets the value of the expirationInDays property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getExpirationInDays() {
        return expirationInDays;
    }

    /**
     * Sets the value of the expirationInDays property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setExpirationInDays(final Integer value) {
        this.expirationInDays = value;
    }

    /**
     * Gets the value of the expirationNoticeInDays property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getExpirationNoticeInDays() {
        return expirationNoticeInDays;
    }

    /**
     * Sets the value of the expirationNoticeInDays property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setExpirationNoticeInDays(final Integer value) {
        this.expirationNoticeInDays = value;
    }

    /**
     * Gets the value of the doNotExpireBeforeDate property.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getdoNotExpireBeforeDate() {
        return doNotExpireBeforeDate;
    }

    /**
     * Sets the value of the doNotExpireBeforeDate property.
     *
     * @param value allowed object is {@link XMLGregorianCalendar }
     */
    public void setDoNotExpireBeforeDate(final XMLGregorianCalendar value) {
        this.doNotExpireBeforeDate = value;
    }
}