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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Device complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Device">
 *   &lt;complexContent>
 *     &lt;extension base="{}Entity">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tags" type="{}Tags" minOccurs="0"/>
 *         &lt;element name="Layout" type="{}LayoutReference" minOccurs="0"/>
 *         &lt;element name="NetworkHost" type="{}Reference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Device", propOrder = {"description", "tags", "layout", "networkHost"})
@XmlSeeAlso({VirtualMachine.class, PhysicalDevice.class})
public class Device extends Entity {

    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "Layout", nillable = true)
    protected LayoutReference layout;
    @XmlElement(name = "NetworkHost", nillable = true)
    protected Reference networkHost;
    @XmlElementWrapper(name = "Tags")
    @XmlElement(name = "Tag")
    protected List<String> tags;

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
     * Gets the value of the layout property.
     *
     * @return possible object is {@link LayoutReference }
     */
    public LayoutReference getLayout() {
        return layout;
    }

    /**
     * Sets the value of the layout property.
     *
     * @param value allowed object is {@link LayoutReference }
     */
    public void setLayout(final LayoutReference value) {
        this.layout = value;
    }

    /**
     * Gets the value of the networkHost property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getNetworkHost() {
        return networkHost;
    }

    /**
     * Sets the value of the networkHost property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setNetworkHost(final Reference value) {
        this.networkHost = value;
    }

    public List<String> getTags() {
        if (tags == null) {
            tags = new ArrayList<String>();
        }
        return tags;
    }
}
