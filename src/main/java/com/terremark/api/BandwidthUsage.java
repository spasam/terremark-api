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
 * Java class for BandwidthUsage complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BandwidthUsage">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="TotalUsage" type="{}BandwidthTotalUsage" minOccurs="0"/>
 *         &lt;element name="IpStatistics" type="{}BandwidthIpAddressUsages" minOccurs="0"/>
 *         &lt;element name="HistoricalUsages" type="{}ArrayOfHistoricalUsage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BandwidthUsage", propOrder = {"totalUsage", "ipStatistics", "historicalUsages"})
@javax.xml.bind.annotation.XmlRootElement(name = "BandwidthUsage")
public final class BandwidthUsage extends Resource {

    @XmlElement(name = "TotalUsage", nillable = true)
    protected BandwidthTotalUsage totalUsage;
    @XmlElementWrapper(name = "IpStatistics")
    @XmlElement(name = "IpAddress")
    protected List<BandwidthIpAddressUsage> ipStatistics;
    @XmlElementWrapper(name = "HistoricalUsages")
    @XmlElement(name = "HistoricalUsage")
    protected List<HistoricalUsage> historicalUsages;

    /**
     * Gets the value of the totalUsage property.
     *
     * @return possible object is {@link BandwidthTotalUsage }
     */
    public BandwidthTotalUsage getTotalUsage() {
        return totalUsage;
    }

    /**
     * Sets the value of the totalUsage property.
     *
     * @param value allowed object is {@link BandwidthTotalUsage }
     */
    public void setTotalUsage(final BandwidthTotalUsage value) {
        this.totalUsage = value;
    }

    public List<BandwidthIpAddressUsage> getIpStatistics() {
        if (ipStatistics == null) {
            ipStatistics = new ArrayList<BandwidthIpAddressUsage>();
        }
        return ipStatistics;
    }

    public List<HistoricalUsage> getHistoricalUsages() {
        if (historicalUsages == null) {
            historicalUsages = new ArrayList<HistoricalUsage>();
        }
        return historicalUsages;
    }
}
