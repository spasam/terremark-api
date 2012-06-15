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
 * Java class for ApiKey complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ApiKey">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="AccessKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{}ApiKeyStatus" minOccurs="0"/>
 *         &lt;element name="PrivateKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApiKey", propOrder = {"accessKey", "status", "privateKey"})
@javax.xml.bind.annotation.XmlRootElement(name = "ApiKey")
public final class ApiKey extends Resource {

    @XmlElement(name = "AccessKey", nillable = true)
    protected String accessKey;
    @XmlElement(name = "Status")
    protected ApiKeyStatus status;
    @XmlElement(name = "PrivateKey", nillable = true)
    protected String privateKey;

    /**
     * Gets the value of the accessKey property.
     *
     * @return possible object is {@link String }
     */
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * Sets the value of the accessKey property.
     *
     * @param value allowed object is {@link String }
     */
    public void setAccessKey(final String value) {
        this.accessKey = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is {@link ApiKeyStatus }
     */
    public ApiKeyStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is {@link ApiKeyStatus }
     */
    public void setStatus(final ApiKeyStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the privateKey property.
     *
     * @return possible object is {@link String }
     */
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * Sets the value of the privateKey property.
     *
     * @param value allowed object is {@link String }
     */
    public void setPrivateKey(final String value) {
        this.privateKey = value;
    }

}
