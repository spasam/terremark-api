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
 * Java class for PublicIp complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PublicIp">
 *   &lt;complexContent>
 *     &lt;extension base="{}Entity">
 *       &lt;sequence>
 *         &lt;element name="PublicIpType" type="{}PublicIpTypeEnum" minOccurs="0"/>
 *         &lt;element name="InternetServices" type="{}ArrayOfInternetService" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublicIp", propOrder = {"publicIpType", "internetServices"})
@javax.xml.bind.annotation.XmlRootElement(name = "PublicIp")
public final class PublicIp extends Entity {

    @XmlElement(name = "PublicIpType")
    protected PublicIpTypeEnum publicIpType;
    @XmlElementWrapper(name = "InternetServices")
    @XmlElement(name = "InternetService")
    protected List<InternetService> internetServices;

    /**
     * Gets the value of the publicIpType property.
     *
     * @return possible object is {@link PublicIpTypeEnum }
     */
    public PublicIpTypeEnum getPublicIpType() {
        return publicIpType;
    }

    /**
     * Sets the value of the publicIpType property.
     *
     * @param value allowed object is {@link PublicIpTypeEnum }
     */
    public void setPublicIpType(final PublicIpTypeEnum value) {
        this.publicIpType = value;
    }

    public List<InternetService> getInternetServices() {
        if (internetServices == null) {
            internetServices = new ArrayList<InternetService>();
        }
        return internetServices;
    }
}
