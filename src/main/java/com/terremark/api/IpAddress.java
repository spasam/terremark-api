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
 * Java class for IpAddress complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IpAddress">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="Host" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="DetectedOn" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="RnatAddress" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="Reserved" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IpAddress", propOrder = {"host", "detectedOn", "rnatAddress", "reserved"})
@javax.xml.bind.annotation.XmlRootElement(name = "IpAddress")
public final class IpAddress extends Resource {

    @XmlElement(name = "Host", nillable = true)
    protected Reference host;
    @XmlElement(name = "DetectedOn", nillable = true)
    protected Reference detectedOn;
    @XmlElement(name = "RnatAddress", nillable = true)
    protected Reference rnatAddress;
    @XmlElement(name = "Reserved")
    protected Boolean reserved;

    /**
     * Gets the value of the host property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setHost(final Reference value) {
        this.host = value;
    }

    /**
     * Gets the value of the detectedOn property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getDetectedOn() {
        return detectedOn;
    }

    /**
     * Sets the value of the detectedOn property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setDetectedOn(final Reference value) {
        this.detectedOn = value;
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
     * Gets the value of the reserved property.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isReserved() {
        return reserved;
    }

    /**
     * Sets the value of the reserved property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setReserved(final Boolean value) {
        this.reserved = value;
    }

}
