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
 * Java class for OperatingSystem complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OperatingSystem">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="FamilyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConfigurationOptions" type="{}VirtualMachineConfigurationOptions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperatingSystem", propOrder = {"familyName", "configurationOptions"})
@javax.xml.bind.annotation.XmlRootElement(name = "OperatingSystem")
public final class OperatingSystem extends Resource {

    @XmlElement(name = "FamilyName", nillable = true)
    protected String familyName;
    @XmlElement(name = "ConfigurationOptions", nillable = true)
    protected VirtualMachineConfigurationOptions configurationOptions;

    /**
     * Gets the value of the familyName property.
     *
     * @return possible object is {@link String }
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Sets the value of the familyName property.
     *
     * @param value allowed object is {@link String }
     */
    public void setFamilyName(final String value) {
        this.familyName = value;
    }

    /**
     * Gets the value of the configurationOptions property.
     *
     * @return possible object is {@link VirtualMachineConfigurationOptions }
     */
    public VirtualMachineConfigurationOptions getConfigurationOptions() {
        return configurationOptions;
    }

    /**
     * Sets the value of the configurationOptions property.
     *
     * @param value allowed object is {@link VirtualMachineConfigurationOptions }
     */
    public void setConfigurationOptions(final VirtualMachineConfigurationOptions value) {
        this.configurationOptions = value;
    }
}
