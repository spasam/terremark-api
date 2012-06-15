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
 * Java class for Network complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Network">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NetworkType" type="{}NetworkTypeEnum" minOccurs="0"/>
 *         &lt;element name="BroadcastAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GatewayAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RnatAddress" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="IpAddresses" type="{}IpAddresses" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Network", propOrder = {"address", "networkType", "broadcastAddress", "gatewayAddress", "rnatAddress",
                "ipAddresses"})
@javax.xml.bind.annotation.XmlRootElement(name = "Network")
public final class Network extends Resource {

    @XmlElement(name = "Address", nillable = true)
    protected String address;
    @XmlElement(name = "NetworkType")
    protected NetworkTypeEnum networkType;
    @XmlElement(name = "BroadcastAddress", nillable = true)
    protected String broadcastAddress;
    @XmlElement(name = "GatewayAddress", nillable = true)
    protected String gatewayAddress;
    @XmlElement(name = "RnatAddress", nillable = true)
    protected Reference rnatAddress;
    @XmlElement(name = "IpAddresses", nillable = true)
    protected IpAddresses ipAddresses;

    /**
     * Gets the value of the address property.
     *
     * @return possible object is {@link String }
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value allowed object is {@link String }
     */
    public void setAddress(final String value) {
        this.address = value;
    }

    /**
     * Gets the value of the networkType property.
     *
     * @return possible object is {@link NetworkTypeEnum }
     */
    public NetworkTypeEnum getNetworkType() {
        return networkType;
    }

    /**
     * Sets the value of the networkType property.
     *
     * @param value allowed object is {@link NetworkTypeEnum }
     */
    public void setNetworkType(final NetworkTypeEnum value) {
        this.networkType = value;
    }

    /**
     * Gets the value of the broadcastAddress property.
     *
     * @return possible object is {@link String }
     */
    public String getBroadcastAddress() {
        return broadcastAddress;
    }

    /**
     * Sets the value of the broadcastAddress property.
     *
     * @param value allowed object is {@link String }
     */
    public void setBroadcastAddress(final String value) {
        this.broadcastAddress = value;
    }

    /**
     * Gets the value of the gatewayAddress property.
     *
     * @return possible object is {@link String }
     */
    public String getGatewayAddress() {
        return gatewayAddress;
    }

    /**
     * Sets the value of the gatewayAddress property.
     *
     * @param value allowed object is {@link String }
     */
    public void setGatewayAddress(final String value) {
        this.gatewayAddress = value;
    }

    /**
     * Gets the value of the rnatAddress property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getRnatAddress() {
        return rnatAddress;
    }

    /**
     * Sets the value of the rnatAddress property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setRnatAddress(final Reference value) {
        this.rnatAddress = value;
    }

    /**
     * Gets the value of the ipAddresses property.
     *
     * @return possible object is {@link IpAddresses }
     */
    public IpAddresses getIpAddresses() {
        return ipAddresses;
    }

    /**
     * Sets the value of the ipAddresses property.
     *
     * @param value allowed object is {@link IpAddresses }
     */
    public void setIpAddresses(final IpAddresses value) {
        this.ipAddresses = value;
    }

}
