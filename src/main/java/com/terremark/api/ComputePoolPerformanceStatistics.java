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
 * Java class for ComputePoolPerformanceStatistics complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ComputePoolPerformanceStatistics">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="Hourly" type="{}ComputePoolPerformanceStatistic" minOccurs="0"/>
 *         &lt;element name="Daily" type="{}ComputePoolPerformanceStatistic" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComputePoolPerformanceStatistics", propOrder = {"hourly", "daily"})
@javax.xml.bind.annotation.XmlRootElement(name = "ComputePoolPerformanceStatistics")
public final class ComputePoolPerformanceStatistics extends Resource {

    @XmlElement(name = "Hourly", nillable = true)
    protected ComputePoolPerformanceStatistic hourly;
    @XmlElement(name = "Daily", nillable = true)
    protected ComputePoolPerformanceStatistic daily;

    /**
     * Gets the value of the hourly property.
     *
     * @return possible object is {@link ComputePoolPerformanceStatistic }
     */
    public ComputePoolPerformanceStatistic getHourly() {
        return hourly;
    }

    /**
     * Sets the value of the hourly property.
     *
     * @param value allowed object is {@link ComputePoolPerformanceStatistic }
     */
    public void setHourly(final ComputePoolPerformanceStatistic value) {
        this.hourly = value;
    }

    /**
     * Gets the value of the daily property.
     *
     * @return possible object is {@link ComputePoolPerformanceStatistic }
     */
    public ComputePoolPerformanceStatistic getDaily() {
        return daily;
    }

    /**
     * Sets the value of the daily property.
     *
     * @param value allowed object is {@link ComputePoolPerformanceStatistic }
     */
    public void setDaily(final ComputePoolPerformanceStatistic value) {
        this.daily = value;
    }

}
