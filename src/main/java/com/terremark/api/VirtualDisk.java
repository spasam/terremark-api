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
 * Java class for VirtualDisk complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VirtualDisk">
 *   &lt;complexContent>
 *     &lt;extension base="{}VirtualDiskBase">
 *       &lt;sequence>
 *         &lt;element name="Size" type="{}ResourceCapacity"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDisk", propOrder = {"size", "name"})
public class VirtualDisk extends VirtualDiskBase {

    @XmlElement(name = "Size", required = true, nillable = true)
    protected ResourceCapacity size;
    @XmlElement(name = "Name", nillable = true)
    protected String name;

    /**
     * Gets the value of the size property.
     *
     * @return possible object is {@link ResourceCapacity }
     */
    public ResourceCapacity getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     *
     * @param value allowed object is {@link ResourceCapacity }
     */
    public void setSize(final ResourceCapacity value) {
        this.size = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is {@link String }
     */
    public void setName(final String value) {
        this.name = value;
    }
}
