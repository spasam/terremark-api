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
 * Java class for CreateRnatAssociation complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CreateRnatAssociation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PublicIp" type="{}Reference"/>
 *         &lt;element name="IpAddress" type="{}Reference"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateRnatAssociation", propOrder = {"publicIp", "ipAddress"})
@javax.xml.bind.annotation.XmlRootElement(name = "CreateRnatAssociation")
public final class CreateRnatAssociation extends ToStringGenerator {

    @XmlElement(name = "PublicIp", required = true, nillable = true)
    protected Reference publicIp;
    @XmlElement(name = "IpAddress", required = true, nillable = true)
    protected Reference ipAddress;

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

}
