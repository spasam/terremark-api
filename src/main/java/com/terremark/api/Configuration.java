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
 * Java class for Configuration complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Configuration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EmailConfiguration" type="{}NotifyByEmailConfiguration" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Configuration", propOrder = {"emailConfiguration"})
@javax.xml.bind.annotation.XmlRootElement(name = "Configuration")
public final class Configuration extends ToStringGenerator {

    @XmlElement(name = "EmailConfiguration", nillable = true)
    protected NotifyByEmailConfiguration emailConfiguration;

    /**
     * Gets the value of the emailConfiguration property.
     *
     * @return possible object is {@link NotifyByEmailConfiguration }
     */
    public NotifyByEmailConfiguration getEmailConfiguration() {
        return emailConfiguration;
    }

    /**
     * Sets the value of the emailConfiguration property.
     *
     * @param value allowed object is {@link NotifyByEmailConfiguration }
     */
    public void setEmailConfiguration(final NotifyByEmailConfiguration value) {
        this.emailConfiguration = value;
    }

}
