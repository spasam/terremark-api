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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for HttpMonitor complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HttpMonitor">
 *   &lt;complexContent>
 *     &lt;extension base="{}ConfigurableInternetServiceMonitor">
 *       &lt;sequence>
 *         &lt;element name="RequestUri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HttpHeaders" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResponseCodes" type="{}HttpMonitorResponseCodes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HttpMonitor", propOrder = {"requestUri", "httpHeaders", "responseCodes"})
@javax.xml.bind.annotation.XmlRootElement(name = "HttpMonitor")
public final class HttpMonitor extends ConfigurableInternetServiceMonitor {

    @XmlElement(name = "RequestUri", nillable = true)
    protected String requestUri;
    @XmlElement(name = "HttpHeaders", nillable = true)
    protected String httpHeaders;
    @XmlElementWrapper(name = "ResponseCodes")
    @XmlElement(name = "ResponseCode")
    protected List<String> responseCodes;

    /**
     * Gets the value of the requestUri property.
     *
     * @return possible object is {@link String }
     */
    public String getRequestUri() {
        return requestUri;
    }

    /**
     * Sets the value of the requestUri property.
     *
     * @param value allowed object is {@link String }
     */
    public void setRequestUri(final String value) {
        this.requestUri = value;
    }

    /**
     * Gets the value of the httpHeaders property.
     *
     * @return possible object is {@link String }
     */
    public String getHttpHeaders() {
        return httpHeaders;
    }

    /**
     * Sets the value of the httpHeaders property.
     *
     * @param value allowed object is {@link String }
     */
    public void setHttpHeaders(final String value) {
        this.httpHeaders = value;
    }

    public List<String> getResponseCodes() {
        if (responseCodes == null) {
            responseCodes = new ArrayList<String>();
        }
        return responseCodes;
    }
}
