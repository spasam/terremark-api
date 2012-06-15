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
 * Java class for NetworkAdapterSetting complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NetworkAdapterSetting">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Network" type="{}NetworkReference"/>
 *         &lt;element name="IpAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkAdapterSetting", propOrder = {"network", "ipAddress"})
public class NetworkAdapterSetting extends ToStringGenerator {

    @XmlElement(name = "Network", required = true, nillable = true)
    protected NetworkReference network;
    @XmlElement(name = "IpAddress", nillable = true)
    protected String ipAddress;

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
     * Gets the value of the ipAddress property.
     *
     * @return possible object is {@link String }
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Sets the value of the ipAddress property.
     *
     * @param value allowed object is {@link String }
     */
    public void setIpAddress(final String value) {
        this.ipAddress = value;
    }
}
