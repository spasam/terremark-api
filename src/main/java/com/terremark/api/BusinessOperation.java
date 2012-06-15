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
 * Java class for BusinessOperation complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BusinessOperation">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="BusinessOperationType" type="{}BusinessOperationTypeEnum" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsAssignable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessOperation", propOrder = {"businessOperationType", "description", "isAssignable"})
@javax.xml.bind.annotation.XmlRootElement(name = "BusinessOperation")
public final class BusinessOperation extends Resource {

    @XmlElement(name = "BusinessOperationType")
    protected BusinessOperationTypeEnum businessOperationType;
    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "IsAssignable")
    protected Boolean isAssignable;

    /**
     * Gets the value of the businessOperationType property.
     *
     * @return possible object is {@link BusinessOperationTypeEnum }
     */
    public BusinessOperationTypeEnum getBusinessOperationType() {
        return businessOperationType;
    }

    /**
     * Sets the value of the businessOperationType property.
     *
     * @param value allowed object is {@link BusinessOperationTypeEnum }
     */
    public void setBusinessOperationType(final BusinessOperationTypeEnum value) {
        this.businessOperationType = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is {@link String }
     */
    public void setDescription(final String value) {
        this.description = value;
    }

    /**
     * Gets the value of the isAssignable property.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isIsAssignable() {
        return isAssignable;
    }

    /**
     * Sets the value of the isAssignable property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setIsAssignable(final Boolean value) {
        this.isAssignable = value;
    }

}
