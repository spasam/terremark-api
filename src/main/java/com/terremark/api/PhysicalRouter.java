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
 * Java class for PhysicalRouter complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PhysicalRouter">
 *   &lt;complexContent>
 *     &lt;extension base="{}PhysicalDevice">
 *       &lt;sequence>
 *         &lt;element name="SerialNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OutsideIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InsideIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicalRouter", propOrder = {"serialNumber", "outsideIp", "insideIp"})
@javax.xml.bind.annotation.XmlRootElement(name = "PhysicalRouter")
public final class PhysicalRouter extends PhysicalDevice {

    @XmlElement(name = "SerialNumber", nillable = true)
    protected String serialNumber;
    @XmlElement(name = "OutsideIp", nillable = true)
    protected String outsideIp;
    @XmlElement(name = "InsideIp", nillable = true)
    protected String insideIp;

    /**
     * Gets the value of the serialNumber property.
     *
     * @return possible object is {@link String }
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     *
     * @param value allowed object is {@link String }
     */
    public void setSerialNumber(final String value) {
        this.serialNumber = value;
    }

    /**
     * Gets the value of the outsideIp property.
     *
     * @return possible object is {@link String }
     */
    public String getOutsideIp() {
        return outsideIp;
    }

    /**
     * Sets the value of the outsideIp property.
     *
     * @param value allowed object is {@link String }
     */
    public void setOutsideIp(final String value) {
        this.outsideIp = value;
    }

    /**
     * Gets the value of the insideIp property.
     *
     * @return possible object is {@link String }
     */
    public String getInsideIp() {
        return insideIp;
    }

    /**
     * Sets the value of the insideIp property.
     *
     * @param value allowed object is {@link String }
     */
    public void setInsideIp(final String value) {
        this.insideIp = value;
    }

}
