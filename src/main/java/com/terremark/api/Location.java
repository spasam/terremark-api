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
 * Java class for Location complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Location">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="FriendlyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Locode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISO3166" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Location", propOrder = {"friendlyName", "locode", "iso3166"})
@javax.xml.bind.annotation.XmlRootElement(name = "Location")
public final class Location extends Resource {

    @XmlElement(name = "FriendlyName", nillable = true)
    protected String friendlyName;
    @XmlElement(name = "Locode", nillable = true)
    protected String locode;
    @XmlElement(name = "ISO3166", nillable = true)
    protected String iso3166;

    /**
     * Gets the value of the friendlyName property.
     *
     * @return possible object is {@link String }
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     * Sets the value of the friendlyName property.
     *
     * @param value allowed object is {@link String }
     */
    public void setFriendlyName(final String value) {
        this.friendlyName = value;
    }

    /**
     * Gets the value of the locode property.
     *
     * @return possible object is {@link String }
     */
    public String getLocode() {
        return locode;
    }

    /**
     * Sets the value of the locode property.
     *
     * @param value allowed object is {@link String }
     */
    public void setLocode(final String value) {
        this.locode = value;
    }

    /**
     * Gets the value of the iso3166 property.
     *
     * @return possible object is {@link String }
     */
    public String getISO3166() {
        return iso3166;
    }

    /**
     * Sets the value of the iso3166 property.
     *
     * @param value allowed object is {@link String }
     */
    public void setISO3166(final String value) {
        this.iso3166 = value;
    }

}
