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
 * Java class for SupportedVersions complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SupportedVersions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VersionInfo" type="{}VersionInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupportedVersions", propOrder = {"versionInfos"})
@com.terremark.annotations.AuthenticationNotRequired
@javax.xml.bind.annotation.XmlRootElement(name = "SupportedVersions")
public final class SupportedVersions extends ToStringGenerator {

    @XmlElement(name = "VersionInfo", nillable = true)
    protected List<VersionInfo> versionInfos;

    /**
     * Gets the value of the versionInfos property.
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the versionInfos property.
     * <p>
     * For example, to add a new item, do as follows:
     *
     * <pre>
     * getVersionInfos().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list {@link VersionInfo }
     */
    public List<VersionInfo> getVersionInfos() {
        if (versionInfos == null) {
            versionInfos = new ArrayList<VersionInfo>();
        }
        return this.versionInfos;
    }
}
