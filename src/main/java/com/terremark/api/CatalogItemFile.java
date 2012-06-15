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
 * Java class for CatalogItemFile complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CatalogItemFile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UploadUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Size" type="{}ResourceCapacity" minOccurs="0"/>
 *         &lt;element name="BytesTransferred" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Status" type="{}FileUploadStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CatalogItemFile", propOrder = {"uploadUrl", "name", "size", "bytesTransferred", "status"})
public class CatalogItemFile extends ToStringGenerator {

    @XmlElement(name = "UploadUrl", nillable = true)
    protected String uploadUrl;
    @XmlElement(name = "Name", nillable = true)
    protected String name;
    @XmlElement(name = "Size", nillable = true)
    protected ResourceCapacity size;
    @XmlElement(name = "BytesTransferred")
    protected Long bytesTransferred;
    @XmlElement(name = "Status")
    protected FileUploadStatus status;

    /**
     * Gets the value of the uploadUrl property.
     *
     * @return possible object is {@link String }
     */
    public String getUploadUrl() {
        return uploadUrl;
    }

    /**
     * Sets the value of the uploadUrl property.
     *
     * @param value allowed object is {@link String }
     */
    public void setUploadUrl(final String value) {
        this.uploadUrl = value;
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
     * Gets the value of the bytesTransferred property.
     *
     * @return possible object is {@link Long }
     */
    public Long getBytesTransferred() {
        return bytesTransferred;
    }

    /**
     * Sets the value of the bytesTransferred property.
     *
     * @param value allowed object is {@link Long }
     */
    public void setBytesTransferred(final Long value) {
        this.bytesTransferred = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is {@link FileUploadStatus }
     */
    public FileUploadStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is {@link FileUploadStatus }
     */
    public void setStatus(final FileUploadStatus value) {
        this.status = value;
    }
}
