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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CatalogEntryConfiguration complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CatalogEntryConfiguration">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="ProcessorCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Memory" type="{}ResourceCapacity" minOccurs="0"/>
 *         &lt;element name="OperatingSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Disks" type="{}Disks" minOccurs="0"/>
 *         &lt;element name="NetworkAdapters" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NetworkMappings" type="{}CatalogNetworkMappings" minOccurs="0"/>
 *         &lt;element name="LicensedBy" type="{}CatalogItemLicensedBy" minOccurs="0"/>
 *         &lt;element name="LicenseType" type="{}CatalogItemLicenseTypeEnum" minOccurs="0"/>
 *         &lt;element name="LicenseCost" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CatalogEntryConfiguration", propOrder = {"processorCount", "memory", "operatingSystem", "disks",
                "networkAdapters", "networkMappings", "licensedBy", "licenseType", "licenseCost"})
@javax.xml.bind.annotation.XmlRootElement(name = "CatalogEntryConfiguration")
public final class CatalogEntryConfiguration extends Resource {

    @XmlElement(name = "ProcessorCount")
    protected Integer processorCount;
    @XmlElement(name = "Memory", nillable = true)
    protected ResourceCapacity memory;
    @XmlElement(name = "OperatingSystem", nillable = true)
    protected String operatingSystem;
    @XmlElement(name = "NetworkAdapters")
    protected Integer networkAdapters;
    @XmlElement(name = "LicensedBy")
    protected CatalogItemLicensedBy licensedBy;
    @XmlElement(name = "LicenseType")
    protected CatalogItemLicenseTypeEnum licenseType;
    @XmlElement(name = "LicenseCost")
    protected BigDecimal licenseCost;
    @XmlElementWrapper(name = "Disks")
    @XmlElement(name = "Disk")
    protected List<VirtualDisk> disks;
    @XmlElementWrapper(name = "NetworkMappings")
    @XmlElement(name = "NetworkMapping")
    protected List<CatalogNetworkMapping> networkMappings;

    /**
     * Gets the value of the processorCount property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getProcessorCount() {
        return processorCount;
    }

    /**
     * Sets the value of the processorCount property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setProcessorCount(final Integer value) {
        this.processorCount = value;
    }

    /**
     * Gets the value of the memory property.
     *
     * @return possible object is {@link ResourceCapacity }
     */
    public ResourceCapacity getMemory() {
        return memory;
    }

    /**
     * Sets the value of the memory property.
     *
     * @param value allowed object is {@link ResourceCapacity }
     */
    public void setMemory(final ResourceCapacity value) {
        this.memory = value;
    }

    /**
     * Gets the value of the operatingSystem property.
     *
     * @return possible object is {@link String }
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * Sets the value of the operatingSystem property.
     *
     * @param value allowed object is {@link String }
     */
    public void setOperatingSystem(final String value) {
        this.operatingSystem = value;
    }

    /**
     * Gets the value of the networkAdapters property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getNetworkAdapters() {
        return networkAdapters;
    }

    /**
     * Sets the value of the networkAdapters property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setNetworkAdapters(final Integer value) {
        this.networkAdapters = value;
    }

    /**
     * Gets the value of the licensedBy property.
     *
     * @return possible object is {@link CatalogItemLicensedBy }
     */
    public CatalogItemLicensedBy getLicensedBy() {
        return licensedBy;
    }

    /**
     * Sets the value of the licensedBy property.
     *
     * @param value allowed object is {@link CatalogItemLicensedBy }
     */
    public void setLicensedBy(final CatalogItemLicensedBy value) {
        this.licensedBy = value;
    }

    /**
     * Gets the value of the licenseType property.
     *
     * @return possible object is {@link CatalogItemLicenseTypeEnum }
     */
    public CatalogItemLicenseTypeEnum getLicenseType() {
        return licenseType;
    }

    /**
     * Sets the value of the licenseType property.
     *
     * @param value allowed object is {@link CatalogItemLicenseTypeEnum }
     */
    public void setLicenseType(final CatalogItemLicenseTypeEnum value) {
        this.licenseType = value;
    }

    /**
     * Gets the value of the licenseCost property.
     *
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getLicenseCost() {
        return licenseCost;
    }

    /**
     * Sets the value of the licenseCost property.
     *
     * @param value allowed object is {@link BigDecimal }
     */
    public void setLicenseCost(final BigDecimal value) {
        this.licenseCost = value;
    }

    public List<VirtualDisk> getDisks() {
        if (disks == null) {
            disks = new ArrayList<VirtualDisk>();
        }
        return disks;
    }

    public List<CatalogNetworkMapping> getNetworkMappings() {
        if (networkMappings == null) {
            networkMappings = new ArrayList<CatalogNetworkMapping>();
        }
        return networkMappings;
    }

}
