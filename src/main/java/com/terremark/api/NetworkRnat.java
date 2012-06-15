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
 * Java class for NetworkRnat complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NetworkRnat">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="Network" type="{}NetworkReference" minOccurs="0"/>
 *         &lt;element name="Rnat" type="{}Reference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkRnat", propOrder = {"network", "rnat"})
@javax.xml.bind.annotation.XmlRootElement(name = "NetworkRnat")
public final class NetworkRnat extends Resource {

    @XmlElement(name = "Network", nillable = true)
    protected NetworkReference network;
    @XmlElement(name = "Rnat", nillable = true)
    protected Reference rnat;

    /**
     * Gets the value of the network property.
     *
     * @return possible object is {@link NetworkReference }
     */
    public NetworkReference getNetwork() {
        return network;
    }

    /**
     * Sets the value of the network property.
     *
     * @param value allowed object is {@link NetworkReference }
     */
    public void setNetwork(final NetworkReference value) {
        this.network = value;
    }

    /**
     * Gets the value of the rnat property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getRnat() {
        return rnat;
    }

    /**
     * Sets the value of the rnat property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setRnat(final Reference value) {
        this.rnat = value;
    }

}
