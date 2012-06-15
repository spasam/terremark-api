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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Reference complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Reference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accessible" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="href" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reference", propOrder = {"accessible"})
@XmlSeeAlso({ComputePoolReference.class, DetachedDiskReference.class, PublicIpAddressReference.class,
                RoleReference.class, TicketReference.class, VirtualMachineMemoryUsageDetail.class,
                IpAddressReference.class, BackupInternetServiceReference.class, NetworkHostIpAddress.class,
                VirtualMachinePerformanceStatistic.class, UserReference.class, NetworkReference.class,
                VirtualMachineReference.class, VirtualMachineCpuUsageDetail.class,
                VirtualMachineStorageUsageDetail.class, SshKeyReference.class})
public class Reference extends ToStringGenerator {

    @XmlElement(nillable = true)
    protected Boolean accessible;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "href", required = true)
    protected String href;
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the accessible property.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isAccessible() {
        return accessible;
    }

    /**
     * Sets the value of the accessible property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setAccessible(final Boolean value) {
        this.accessible = value;
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
     * Gets the value of the href property.
     *
     * @return possible object is {@link String }
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     *
     * @param value allowed object is {@link String }
     */
    public void setHref(final String value) {
        this.href = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is {@link String }
     */
    public void setType(final String value) {
        this.type = value;
    }
}
