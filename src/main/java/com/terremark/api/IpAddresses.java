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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for IpAddresses complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IpAddresses">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IpAddress" type="{}IpAddress" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IpAddresses", propOrder = {"ipAddresses"})
@javax.xml.bind.annotation.XmlRootElement(name = "IpAddresses")
public final class IpAddresses extends ToStringGenerator {

    @XmlElement(name = "IpAddress", nillable = true)
    protected List<IpAddress> ipAddresses;

    /**
     * Gets the value of the ipAddresses property.
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the ipAddresses property.
     * <p>
     * For example, to add a new item, do as follows:
     *
     * <pre>
     * getIpAddresses().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list {@link IpAddress }
     */
    public List<IpAddress> getIpAddresses() {
        if (ipAddresses == null) {
            ipAddresses = new ArrayList<IpAddress>();
        }
        return this.ipAddresses;
    }
}
