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
 * Java class for InternetServicePersistence complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InternetServicePersistence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{}PersistenceTypeEnum" minOccurs="0"/>
 *         &lt;element name="Timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InternetServicePersistence", propOrder = {"type", "timeout"})
public class InternetServicePersistence extends ToStringGenerator {

    @XmlElement(name = "Type")
    protected PersistenceTypeEnum type;
    @XmlElement(name = "Timeout", nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long timeout;

    /**
     * Gets the value of the type property.
     *
     * @return possible object is {@link PersistenceTypeEnum }
     */
    public PersistenceTypeEnum getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is {@link PersistenceTypeEnum }
     */
    public void setType(final PersistenceTypeEnum value) {
        this.type = value;
    }

    /**
     * Gets the value of the timeout property.
     *
     * @return possible object is {@link Long }
     */
    public Long getTimeout() {
        return timeout;
    }

    /**
     * Sets the value of the timeout property.
     *
     * @param value allowed object is {@link Long }
     */
    public void setTimeout(final Long value) {
        this.timeout = value;
    }
}
