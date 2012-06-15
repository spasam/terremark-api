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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CreateBackupInternetService complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CreateBackupInternetService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Protocol" type="{}ProtocolTypeEnum"/>
 *         &lt;element name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Persistence" type="{}InternetServicePersistence" minOccurs="0"/>
 *         &lt;element name="RedirectUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LoadBalancingMethod" type="{}LoadBalancingMethod" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateBackupInternetService", propOrder = {"protocol", "enabled", "description", "persistence",
                "redirectUrl", "loadBalancingMethod"})
@javax.xml.bind.annotation.XmlRootElement(name = "CreateBackupInternetService")
public final class CreateBackupInternetService extends ToStringGenerator {

    @XmlElement(name = "Protocol", required = true)
    protected ProtocolTypeEnum protocol;
    @XmlElement(name = "Enabled")
    protected boolean enabled;
    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "Persistence", nillable = true)
    protected InternetServicePersistence persistence;
    @XmlElement(name = "RedirectUrl", nillable = true)
    protected String redirectUrl;
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
