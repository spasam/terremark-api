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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PortRange complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PortRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Start" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="End" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PortRange", propOrder = {"start", "end"})
public class PortRange extends ToStringGenerator {

    @XmlElement(name = "Start")
    @XmlSchemaType(name = "unsignedInt")
    protected Long start;
    @XmlElement(name = "End")
    @XmlSchemaType(name = "unsignedInt")
    protected Long end;

    /**
     * Gets the value of the start property.
     *
     * @return possible object is {@link Long }
     */
    public Long getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     *
     * @param value allowed object is {@link Long }
     */
    public void setStart(final Long value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     *
     * @return possible object is {@link Long }
     */
    public Long getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     *
     * @param value allowed object is {@link Long }
     */
    public void setEnd(final Long value) {
        this.end = value;
    }
}
