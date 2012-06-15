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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Rnat complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Rnat">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="Default" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PublicIp" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="Networks" type="{}NetworkReferences" minOccurs="0"/>
 *         &lt;element name="Associations" type="{}RnatHostAssociations" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rnat", propOrder = {"_default", "publicIp", "networks", "associations"})
@javax.xml.bind.annotation.XmlRootElement(name = "Rnat")
public final class Rnat extends Resource {

    @XmlElement(name = "Default")
    protected Boolean _default;
    @XmlElement(name = "PublicIp", nillable = true)
    protected Reference publicIp;
    @XmlElementWrapper(name = "Networks")
    @XmlElement(name = "Network")
    protected List<NetworkReference> networks;
    @XmlElementWrapper(name = "Associations")
    @XmlElement(name = "Association")
    protected List<RnatHostAssociation> associations;

    /**
     * Gets the value of the default property.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isDefault() {
        return _default;
    }

    /**
     * Sets the value of the default property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setDefault(final Boolean value) {
        this._default = value;
    }

    /**
     * Gets the value of the publicIp property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getPublicIp() {
        return publicIp;
    }

    /**
     * Sets the value of the publicIp property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setPublicIp(final Reference value) {
        this.publicIp = value;
    }

    public List<NetworkReference> getNetworks() {
        if (networks == null) {
            networks = new ArrayList<NetworkReference>();
        }
        return networks;
    }

    public List<RnatHostAssociation> getAssociations() {
        if (associations == null) {
            associations = new ArrayList<RnatHostAssociation>();
        }
        return associations;
    }

}
