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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ChangePassword complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ChangePassword">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OldPassword" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NewPassword" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangePassword", propOrder = {"userName", "oldPassword", "newPassword"})
@com.terremark.annotations.AuthenticationNotRequired
public final class ChangePassword extends ToStringGenerator {

    @XmlElement(name = "UserName", required = true, nillable = true)
    protected String userName;
    @XmlElement(name = "oldPassword", required = true, nillable = true)
    protected String oldPassword;
    @XmlElement(name = "newPassword", required = true, nillable = true)
    protected String newPassword;

    /**
     * Gets the value of the userName property.
     *
     * @return possible object is {@link String }
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     *
     * @param value allowed object is {@link String }
     */
    public void setUserName(final String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the oldPassword property.
     *
     * @return possible object is {@link String }
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * Sets the value of the oldPassword property.
     *
     * @param value allowed object is {@link String }
     */
    public void setOldPassword(final String value) {
        this.oldPassword = value;
    }

    /**
     * Gets the value of the newPassword property.
     *
     * @return possible object is {@link String }
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Sets the value of the newPassword property.
     *
     * @param value allowed object is {@link String }
     */
    public void setNewPassword(final String value) {
        this.newPassword = value;
    }
}
