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
 * Java class for LayoutReference complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LayoutReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Row" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="Group" type="{}Reference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LayoutReference", propOrder = {"row", "group"})
public class LayoutReference extends ToStringGenerator {

    @XmlElement(name = "Row", nillable = true)
    protected Reference row;
    @XmlElement(name = "Group", nillable = true)
    protected Reference group;

    /**
     * Gets the value of the row property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getRow() {
        return row;
    }

    /**
     * Sets the value of the row property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setRow(final Reference value) {
        this.row = value;
    }

    /**
     * Gets the value of the group property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setGroup(final Reference value) {
        this.group = value;
    }
}
