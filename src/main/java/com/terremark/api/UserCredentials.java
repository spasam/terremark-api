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
 * Java class for UserCredentials complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="UserCredentials">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserSecurityQuestions" type="{}SecurityQuestions" minOccurs="0"/>
 *         &lt;element name="PasswordExpirationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserCredentials", propOrder = {"firstName", "lastName", "password", "userSecurityQuestions", "passwordExpirationDate"})
@javax.xml.bind.annotation.XmlRootElement(name = "UserCredentials")
public final class UserCredentials extends Resource {

    @XmlElement(name = "FirstName", nillable = true)
    protected String firstName;
    @XmlElement(name = "LastName", nillable = true)
    protected String lastName;
    @XmlElement(name = "Password", nillable = true)
    protected String password;
    @XmlElementWrapper(name = "UserSecurityQuestions")
    @XmlElement(name = "SecurityQuestion")
    protected List<SecurityQuestion> userSecurityQuestions;
    @XmlElement(name = "PasswordExpirationDate", nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar passwordExpirationDate;

    /**
     * Gets the value of the firstName property.
     *
     * @return possible object is {@link String }
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     *
     * @param value allowed object is {@link String }
     */
    public void setFirstName(final String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     *
     * @return possible object is {@link String }
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     *
     * @param value allowed object is {@link String }
     */
    public void setLastName(final String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return possible object is {@link String }
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value allowed object is {@link String }
     */
    public void setPassword(final String value) {
        this.password = value;
    }

    public List<SecurityQuestion> getUserSecurityQuestions() {
        if (userSecurityQuestions == null) {
            userSecurityQuestions = new ArrayList<SecurityQuestion>();
        }
        return userSecurityQuestions;
    }

    /**
     * Gets the value of the passwordExpirationDate property.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getPasswordExpirationDate() {
        return passwordExpirationDate;
    }

    /**
     * Sets the value of the passwordExpirationDate property.
     *
     * @param value allowed object is {@link XMLGregorianCalendar }
     */
    public void setPasswordExpirationDate(final XMLGregorianCalendar value) {
        this.passwordExpirationDate = value;
    }
}