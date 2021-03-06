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
 * Java class for DeviceLicensedSoftware complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DeviceLicensedSoftware">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HourlyLicensedSoftware" type="{}Software" minOccurs="0"/>
 *         &lt;element name="MonthlyLicensedSoftware" type="{}Software" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceLicensedSoftware", propOrder = {"hourlyLicensedSoftware", "monthlyLicensedSoftware"})
public class DeviceLicensedSoftware extends ToStringGenerator {

    @XmlElementWrapper(name = "HourlyLicensedSoftware")
    @XmlElement(name = "Software")
    protected List<SoftwareEntry> hourlyLicensedSoftware;
    @XmlElementWrapper(name = "MonthlyLicensedSoftware")
    @XmlElement(name = "Software")
    protected List<SoftwareEntry> monthlyLicensedSoftware;

    public List<SoftwareEntry> getHourlyLicensedSoftware() {
        if (hourlyLicensedSoftware == null) {
            hourlyLicensedSoftware = new ArrayList<SoftwareEntry>();
        }
        return hourlyLicensedSoftware;
    }

    public List<SoftwareEntry> getMonthlyLicensedSoftware() {
        if (monthlyLicensedSoftware == null) {
            monthlyLicensedSoftware = new ArrayList<SoftwareEntry>();
        }
        return monthlyLicensedSoftware;
    }
}
