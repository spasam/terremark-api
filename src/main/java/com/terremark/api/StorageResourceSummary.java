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
 * Java class for StorageResourceSummary complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StorageResourceSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Purchased" type="{}ResourceCapacity" minOccurs="0"/>
 *         &lt;element name="Used" type="{}ResourceCapacity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageResourceSummary", propOrder = {"purchased", "used"})
public class StorageResourceSummary extends ToStringGenerator {

    @XmlElement(name = "Purchased", nillable = true)
    protected ResourceCapacity purchased;
    @XmlElement(name = "Used", nillable = true)
    protected ResourceCapacity used;

    /**
     * Gets the value of the purchased property.
     *
     * @return possible object is {@link ResourceCapacity }
     */
    public ResourceCapacity getPurchased() {
        return purchased;
    }

    /**
     * Sets the value of the purchased property.
     *
     * @param value allowed object is {@link ResourceCapacity }
     */
    public void setPurchased(final ResourceCapacity value) {
        this.purchased = value;
    }

    /**
     * Gets the value of the used property.
     *
     * @return possible object is {@link ResourceCapacity }
     */
    public ResourceCapacity getUsed() {
        return used;
    }

    /**
     * Sets the value of the used property.
     *
     * @param value allowed object is {@link ResourceCapacity }
     */
    public void setUsed(final ResourceCapacity value) {
        this.used = value;
    }
}
