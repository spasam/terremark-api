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
 * Java class for SshKeyReference complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SshKeyReference">
 *   &lt;complexContent>
 *     &lt;extension base="{}Reference">
 *       &lt;sequence>
 *         &lt;element name="Default" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FingerPrint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SshKeyReference", propOrder = {"_default", "fingerPrint"})
public class SshKeyReference extends Reference {

    @XmlElement(name = "Default", nillable = true)
    protected Boolean _default;
    @XmlElement(name = "FingerPrint", nillable = true)
    protected String fingerPrint;

    /**
     * Gets the value of the default property.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isDefault() {
        return _default;
    }

    /**
     * Sets the value of the default property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setDefault(final Boolean value) {
        this._default = value;
    }

    /**
     * Gets the value of the fingerPrint property.
     *
     * @return possible object is {@link String }
     */
    public String getFingerPrint() {
        return fingerPrint;
    }

    /**
     * Sets the value of the fingerPrint property.
     *
     * @param value allowed object is {@link String }
     */
    public void setFingerPrint(final String value) {
        this.fingerPrint = value;
    }
}
