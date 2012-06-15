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
 * Java class for BackupInternetServiceReference complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BackupInternetServiceReference">
 *   &lt;complexContent>
 *     &lt;extension base="{}Reference">
 *       &lt;sequence>
 *         &lt;element name="Protocol" type="{}ProtocolTypeEnum" minOccurs="0"/>
 *         &lt;element name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BackupInternetServiceReference", propOrder = {"protocol", "enabled"})
public class BackupInternetServiceReference extends Reference {

    @XmlElement(name = "Protocol")
    protected ProtocolTypeEnum protocol;
    @XmlElement(name = "Enabled")
    protected Boolean enabled;

    /**
     * Gets the value of the protocol property.
     *
     * @return possible object is {@link ProtocolTypeEnum }
     */
    public ProtocolTypeEnum getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     *
     * @param value allowed object is {@link ProtocolTypeEnum }
     */
    public void setProtocol(final ProtocolTypeEnum value) {
        this.protocol = value;
    }

    /**
     * Gets the value of the enabled property.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setEnabled(final Boolean value) {
        this.enabled = value;
    }
}
