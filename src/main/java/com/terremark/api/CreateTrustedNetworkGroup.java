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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CreateTrustedNetworkGroup complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CreateTrustedNetworkGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Hosts" type="{}TrustedNetworkGroupHosts" minOccurs="0"/>
 *         &lt;element name="Networks" type="{}TrustedNetworkGroupNetworks" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateTrustedNetworkGroup", propOrder = {"hosts", "networks"})
@javax.xml.bind.annotation.XmlRootElement(name = "CreateTrustedNetworkGroup")
public final class CreateTrustedNetworkGroup extends ToStringGenerator {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlElementWrapper(name = "Hosts")
    @XmlElement(name = "IpAddress")
    protected List<String> hosts;
    @XmlElementWrapper(name = "Networks")
    @XmlElement(name = "Network")
    protected List<ExternalNetwork> networks;

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

    public List<String> getHosts() {
        if (hosts == null) {
            hosts = new ArrayList<String>();
        }
        return hosts;
    }

    public List<ExternalNetwork> getNetworks() {
        if (networks == null) {
            networks = new ArrayList<ExternalNetwork>();
        }
        return networks;
    }
}
