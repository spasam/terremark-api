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
 * Java class for FirewallLog complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FirewallLog">
 *   &lt;complexContent>
 *     &lt;extension base="{}Entity">
 *       &lt;sequence>
 *         &lt;element name="IpAddress" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="ExternalIpAddress" type="{}ExternalHost" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FirewallLog", propOrder = {"ipAddress", "externalIpAddress"})
@javax.xml.bind.annotation.XmlRootElement(name = "FirewallLog")
public final class FirewallLog extends Entity {

    @XmlElement(name = "IpAddress", nillable = true)
    protected Reference ipAddress;
    @XmlElement(name = "ExternalIpAddress", nillable = true)
    protected ExternalHost externalIpAddress;

    /**
     * Gets the value of the ipAddress property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getIpAddress() {
        return ipAddress;
    }

    /**
     * Sets the value of the ipAddress property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setIpAddress(final Reference value) {
        this.ipAddress = value;
    }

    /**
     * Gets the value of the externalIpAddress property.
     *
     * @return possible object is {@link ExternalHost }
     */
    public ExternalHost getExternalIpAddress() {
        return externalIpAddress;
    }

    /**
     * Sets the value of the externalIpAddress property.
     *
     * @param value allowed object is {@link ExternalHost }
     */
    public void setExternalIpAddress(final ExternalHost value) {
        this.externalIpAddress = value;
    }

}
