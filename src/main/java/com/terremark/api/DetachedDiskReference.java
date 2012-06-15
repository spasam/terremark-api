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
 * Java class for DetachedDiskReference complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DetachedDiskReference">
 *   &lt;complexContent>
 *     &lt;extension base="{}Reference">
 *       &lt;sequence>
 *         &lt;element name="Size" type="{}ResourceCapacity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetachedDiskReference", propOrder = {"size"})
public class DetachedDiskReference extends Reference {

    @XmlElement(name = "Size", nillable = true)
    protected ResourceCapacity size;

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
}
