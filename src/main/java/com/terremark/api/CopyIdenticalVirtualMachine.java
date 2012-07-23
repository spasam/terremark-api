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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CopyIdenticalVirtualMachine complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CopyIdenticalVirtualMachine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Source" type="{}Reference"/>
 *         &lt;element name="Layout" type="{}LayoutRequest" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CopyIdenticalVirtualMachine", propOrder = {"source", "layout", "description"})
@javax.xml.bind.annotation.XmlRootElement(name = "CopyIdenticalVirtualMachine")
public final class CopyIdenticalVirtualMachine extends ToStringGenerator {

    @XmlElement(name = "Source", required = true, nillable = true)
    protected Reference source;
    @XmlElement(name = "Layout", nillable = true)
    protected LayoutRequest layout;
    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the source property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setSource(final Reference value) {
        this.source = value;
    }

    /**
     * Gets the value of the layout property.
     *
     * @return possible object is {@link LayoutRequest }
     */
    public LayoutRequest getLayout() {
        return layout;
    }

    /**
     * Sets the value of the layout property.
     *
     * @param value allowed object is {@link LayoutRequest }
     */
    public void setLayout(final LayoutRequest value) {
        this.layout = value;
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
