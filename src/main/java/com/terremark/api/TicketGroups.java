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
 * Java class for TicketGroups complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TicketGroups">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="Active" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="History" type="{}Reference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TicketGroups", propOrder = {"active", "history"})
@javax.xml.bind.annotation.XmlRootElement(name = "TicketGroups")
public final class TicketGroups extends Resource {

    @XmlElement(name = "Active", nillable = true)
    protected Reference active;
    @XmlElement(name = "History", nillable = true)
    protected Reference history;

    /**
     * Gets the value of the active property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setActive(final Reference value) {
        this.active = value;
    }

    /**
     * Gets the value of the history property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getHistory() {
        return history;
    }

    /**
     * Sets the value of the history property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setHistory(final Reference value) {
        this.history = value;
    }
}
