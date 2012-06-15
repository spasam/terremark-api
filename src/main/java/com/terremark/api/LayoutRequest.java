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
 * Java class for LayoutRequest complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LayoutRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Row" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="Group" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="NewRow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NewGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LayoutRequest", propOrder = {"row", "group", "newRow", "newGroup"})
@javax.xml.bind.annotation.XmlRootElement(name = "LayoutRequest")
public final class LayoutRequest extends ToStringGenerator {

    @XmlElement(name = "Row", nillable = true)
    protected Reference row;
    @XmlElement(name = "Group", nillable = true)
    protected Reference group;
    @XmlElement(name = "NewRow", nillable = true)
    protected String newRow;
    @XmlElement(name = "NewGroup", nillable = true)
    protected String newGroup;

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

    /**
     * Gets the value of the newRow property.
     *
     * @return possible object is {@link String }
     */
    public String getNewRow() {
        return newRow;
    }

    /**
     * Sets the value of the newRow property.
     *
     * @param value allowed object is {@link String }
     */
    public void setNewRow(final String value) {
        this.newRow = value;
    }

    /**
     * Gets the value of the newGroup property.
     *
     * @return possible object is {@link String }
     */
    public String getNewGroup() {
        return newGroup;
    }

    /**
     * Sets the value of the newGroup property.
     *
     * @param value allowed object is {@link String }
     */
    public void setNewGroup(final String value) {
        this.newGroup = value;
    }

}
