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
 * Java class for FirewallAclEndpoint complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FirewallAclEndpoint">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{}FirewallAclEndpointTypeEnum" minOccurs="0"/>
 *         &lt;element name="ExternalIpAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExternalNetwork" type="{}ExternalNetwork" minOccurs="0"/>
 *         &lt;element name="IpAddress" type="{}IpAddressReference" minOccurs="0"/>
 *         &lt;element name="Network" type="{}NetworkReference" minOccurs="0"/>
 *         &lt;element name="TrustedNetworkGroup" type="{}Reference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FirewallAclEndpoint", propOrder = {"type", "externalIpAddress", "externalNetwork", "ipAddress",
                "network", "trustedNetworkGroup"})
public class FirewallAclEndpoint extends ToStringGenerator {

    @XmlElement(name = "Type")
    protected FirewallAclEndpointTypeEnum type;
    @XmlElement(name = "ExternalIpAddress", nillable = true)
    protected String externalIpAddress;
    @XmlElement(name = "ExternalNetwork", nillable = true)
    protected ExternalNetwork externalNetwork;
    @XmlElement(name = "IpAddress", nillable = true)
    protected IpAddressReference ipAddress;
    @XmlElement(name = "Network", nillable = true)
    protected NetworkReference network;
    @XmlElement(name = "TrustedNetworkGroup", nillable = true)
    protected Reference trustedNetworkGroup;

    /**
     * Gets the value of the type property.
     *
     * @return possible object is {@link FirewallAclEndpointTypeEnum }
     */
    public FirewallAclEndpointTypeEnum getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is {@link FirewallAclEndpointTypeEnum }
     */
    public void setType(final FirewallAclEndpointTypeEnum value) {
        this.type = value;
    }

    /**
     * Gets the value of the externalIpAddress property.
     *
     * @return possible object is {@link String }
     */
    public String getExternalIpAddress() {
        return externalIpAddress;
    }

    /**
     * Sets the value of the externalIpAddress property.
     *
     * @param value allowed object is {@link String }
     */
    public void setExternalIpAddress(final String value) {
        this.externalIpAddress = value;
    }

    /**
     * Gets the value of the externalNetwork property.
     *
     * @return possible object is {@link ExternalNetwork }
     */
    public ExternalNetwork getExternalNetwork() {
        return externalNetwork;
    }

    /**
     * Sets the value of the externalNetwork property.
     *
     * @param value allowed object is {@link ExternalNetwork }
     */
    public void setExternalNetwork(final ExternalNetwork value) {
        this.externalNetwork = value;
    }

    /**
     * Gets the value of the ipAddress property.
     *
     * @return possible object is {@link IpAddressReference }
     */
    public IpAddressReference getIpAddress() {
        return ipAddress;
    }

    /**
     * Sets the value of the ipAddress property.
     *
     * @param value allowed object is {@link IpAddressReference }
     */
    public void setIpAddress(final IpAddressReference value) {
        this.ipAddress = value;
    }

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
     * Gets the value of the trustedNetworkGroup property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getTrustedNetworkGroup() {
        return trustedNetworkGroup;
    }

    /**
     * Sets the value of the trustedNetworkGroup property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setTrustedNetworkGroup(final Reference value) {
        this.trustedNetworkGroup = value;
    }
}
