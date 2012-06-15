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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PhysicalDevice complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PhysicalDevice">
 *   &lt;complexContent>
 *     &lt;extension base="{}Device">
 *       &lt;sequence>
 *         &lt;element name="Classification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicalDevice", propOrder = {"classification", "model"})
@XmlSeeAlso({HighAvailabilityRouter.class, PhysicalRouter.class, PhysicalServer.class, StorageDevice.class})
public class PhysicalDevice extends Device {

    @XmlElement(name = "Classification", nillable = true)
    protected String classification;
    @XmlElement(name = "Model", nillable = true)
    protected String model;

    /**
     * Gets the value of the classification property.
     *
     * @return possible object is {@link String }
     */
    public String getClassification() {
        return classification;
    }

    /**
     * Sets the value of the classification property.
     *
     * @param value allowed object is {@link String }
     */
    public void setClassification(final String value) {
        this.classification = value;
    }

    /**
     * Gets the value of the model property.
     *
     * @return possible object is {@link String }
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     *
     * @param value allowed object is {@link String }
     */
    public void setModel(final String value) {
        this.model = value;
    }
}
