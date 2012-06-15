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
 * Java class for MultifactorSummary complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MultifactorSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Purchased" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Used" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultifactorSummary", propOrder = {"purchased", "used"})
public class MultifactorSummary extends ToStringGenerator {

    @XmlElement(name = "Purchased")
    protected Integer purchased;
    @XmlElement(name = "Used")
    protected Integer used;

    /**
     * Gets the value of the purchased property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getPurchased() {
        return purchased;
    }

    /**
     * Sets the value of the purchased property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setPurchased(final Integer value) {
        this.purchased = value;
    }

    /**
     * Gets the value of the used property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getUsed() {
        return used;
    }

    /**
     * Sets the value of the used property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setUsed(final Integer value) {
        this.used = value;
    }
}
