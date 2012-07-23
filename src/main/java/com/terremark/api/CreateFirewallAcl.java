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
 * Java class for CreateFirewallAcl complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CreateFirewallAcl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Permission" type="{}AclPermissionTypeEnum"/>
 *         &lt;element name="Protocol" type="{}ProtocolTypeEnum"/>
 *         &lt;element name="Source" type="{}FirewallAclEndpoint"/>
 *         &lt;element name="Destination" type="{}FirewallAclEndpoint" minOccurs="0"/>
 *         &lt;element name="PortRange" type="{}PortRange" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateFirewallAcl", propOrder = {"permission", "protocol", "source", "destination", "portRange"})
@javax.xml.bind.annotation.XmlRootElement(name = "CreateFirewallAcl")
public final class CreateFirewallAcl extends ToStringGenerator {

    @XmlElement(name = "Permission", required = true)
    protected AclPermissionTypeEnum permission;
    @XmlElement(name = "Protocol", required = true)
    protected ProtocolTypeEnum protocol;
    @XmlElement(name = "Source", required = true, nillable = true)
    protected FirewallAclEndpoint source;
    @XmlElement(name = "Destination", nillable = true)
    protected FirewallAclEndpoint destination;
    @XmlElement(name = "PortRange", nillable = true)
    protected PortRange portRange;

    /**
     * Gets the value of the permission property.
     *
     * @return possible object is {@link AclPermissionTypeEnum }
     */
    public AclPermissionTypeEnum getPermission() {
        return permission;
    }

    /**
     * Sets the value of the permission property.
     *
     * @param value allowed object is {@link AclPermissionTypeEnum }
     */
    public void setPermission(final AclPermissionTypeEnum value) {
        this.permission = value;
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
     * Gets the value of the source property.
     *
     * @return possible object is {@link FirewallAclEndpoint }
     */
    public FirewallAclEndpoint getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     *
     * @param value allowed object is {@link FirewallAclEndpoint }
     */
    public void setSource(final FirewallAclEndpoint value) {
        this.source = value;
    }

    /**
     * Gets the value of the destination property.
     *
     * @return possible object is {@link FirewallAclEndpoint }
     */
    public FirewallAclEndpoint getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     *
     * @param value allowed object is {@link FirewallAclEndpoint }
     */
    public void setDestination(final FirewallAclEndpoint value) {
        this.destination = value;
    }

    /**
     * Gets the value of the portRange property.
     *
     * @return possible object is {@link PortRange }
     */
    public PortRange getPortRange() {
        return portRange;
    }

    /**
     * Sets the value of the portRange property.
     *
     * @param value allowed object is {@link PortRange }
     */
    public void setPortRange(final PortRange value) {
        this.portRange = value;
    }
}
