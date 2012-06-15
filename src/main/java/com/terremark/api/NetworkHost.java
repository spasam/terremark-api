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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for NetworkHost complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NetworkHost">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="Device" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="Networks" type="{}NetworkHostNetworks" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkHost", propOrder = {"device", "networks"})
@javax.xml.bind.annotation.XmlRootElement(name = "NetworkHost")
public final class NetworkHost extends Resource {

    @XmlElement(name = "Device", nillable = true)
    protected Reference device;
    @XmlElementWrapper(name = "Networks")
    @XmlElement(name = "Network")
    protected List<NetworkHostNetwork> networks;

    /**
     * Gets the value of the device property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setDevice(final Reference value) {
        this.device = value;
    }

    public List<NetworkHostNetwork> getNetworks() {
        if (networks == null) {
            networks = new ArrayList<NetworkHostNetwork>();
        }
        return networks;
    }

}
