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

/**
 * <p>
 * Java class for NodeService complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NodeService">
 *   &lt;complexContent>
 *     &lt;extension base="{}Entity">
 *       &lt;sequence>
 *         &lt;element name="IpAddress" type="{}IpAddressReference" minOccurs="0"/>
 *         &lt;element name="Protocol" type="{}ProtocolTypeEnum" minOccurs="0"/>
 *         &lt;element name="Port" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NodeService", propOrder = {"ipAddress", "protocol", "port", "enabled", "description"})
@javax.xml.bind.annotation.XmlRootElement(name = "NodeService")
public final class NodeService extends Entity {

    @XmlElement(name = "IpAddress", nillable = true)
    protected IpAddressReference ipAddress;
    @XmlElement(name = "Protocol")
    protected ProtocolTypeEnum protocol;
    @XmlElement(name = "Port")
    @XmlSchemaType(name = "unsignedInt")
    protected Long port;
    @XmlElement(name = "Enabled")
    protected boolean enabled;
    @XmlElement(name = "Description", nillable = true)
    protected String description;

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
     * Gets the value of the protocol property.
     *
     * @return possible object is {@link ProtocolTypeEnum }
     */
    public ProtocolTypeEnum getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     *
     * @param value allowed object is {@link ProtocolTypeEnum }
     */
    public void setProtocol(final ProtocolTypeEnum value) {
        this.protocol = value;
    }

    /**
     * Gets the value of the port property.
     *
     * @return possible object is {@link Long }
     */
    public Long getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     *
     * @param value allowed object is {@link Long }
     */
    public void setPort(final Long value) {
        this.port = value;
    }

    /**
     * Gets the value of the enabled property.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     */
    public void setEnabled(final boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is {@link String }
     */
    public void setDescription(final String value) {
        this.description = value;
    }

}
