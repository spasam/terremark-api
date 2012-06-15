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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CreateInternetService complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CreateInternetService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Protocol" type="{}ProtocolTypeEnum"/>
 *         &lt;element name="Port" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Persistence" type="{}InternetServicePersistence" minOccurs="0"/>
 *         &lt;element name="RedirectUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrustedNetworkGroup" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="BackupInternetService" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="LoadBalancingMethod" type="{}LoadBalancingMethod" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateInternetService", propOrder = {"protocol", "port", "enabled", "description", "persistence",
                "redirectUrl", "trustedNetworkGroup", "backupInternetService", "loadBalancingMethod"})
@javax.xml.bind.annotation.XmlRootElement(name = "CreateInternetService")
public final class CreateInternetService extends ToStringGenerator {

    @XmlElement(name = "Protocol", required = true)
    protected ProtocolTypeEnum protocol;
    @XmlElement(name = "Port")
    @XmlSchemaType(name = "unsignedInt")
    protected long port;
    @XmlElement(name = "Enabled")
    protected boolean enabled;
    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "Persistence", nillable = true)
    protected InternetServicePersistence persistence;
    @XmlElement(name = "RedirectUrl", nillable = true)
    protected String redirectUrl;
    @XmlElement(name = "TrustedNetworkGroup", nillable = true)
    protected Reference trustedNetworkGroup;
    @XmlElement(name = "BackupInternetService", nillable = true)
    protected Reference backupInternetService;
    @XmlElement(name = "LoadBalancingMethod", nillable = true)
    protected LoadBalancingMethod loadBalancingMethod;
    @XmlAttribute(name = "name", required = true)
    protected String name;

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
     */
    public long getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     */
    public void setPort(final long value) {
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

    /**
     * Gets the value of the persistence property.
     *
     * @return possible object is {@link InternetServicePersistence }
     */
    public InternetServicePersistence getPersistence() {
        return persistence;
    }

    /**
     * Sets the value of the persistence property.
     *
     * @param value allowed object is {@link InternetServicePersistence }
     */
    public void setPersistence(final InternetServicePersistence value) {
        this.persistence = value;
    }

    /**
     * Gets the value of the redirectUrl property.
     *
     * @return possible object is {@link String }
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * Sets the value of the redirectUrl property.
     *
     * @param value allowed object is {@link String }
     */
    public void setRedirectUrl(final String value) {
        this.redirectUrl = value;
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

    /**
     * Gets the value of the backupInternetService property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getBackupInternetService() {
        return backupInternetService;
    }

    /**
     * Sets the value of the backupInternetService property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setBackupInternetService(final Reference value) {
        this.backupInternetService = value;
    }

    /**
     * Gets the value of the loadBalancingMethod property.
     *
     * @return possible object is {@link LoadBalancingMethod }
     */
    public LoadBalancingMethod getLoadBalancingMethod() {
        return loadBalancingMethod;
    }

    /**
     * Sets the value of the loadBalancingMethod property.
     *
     * @param value allowed object is {@link LoadBalancingMethod }
     */
    public void setLoadBalancingMethod(final LoadBalancingMethod value) {
        this.loadBalancingMethod = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is {@link String }
     */
    public void setName(final String value) {
        this.name = value;
    }

}
