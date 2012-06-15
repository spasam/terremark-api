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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for AuditLog complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AuditLog">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TotalCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="AuditLogItem" type="{}AuditLogItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditLog", propOrder = {"totalCount", "auditLogItems"})
@javax.xml.bind.annotation.XmlRootElement(name = "AuditLog")
public final class AuditLog extends ToStringGenerator {

    @XmlElement(name = "TotalCount")
    protected Integer totalCount;
    @XmlElement(name = "AuditLogItem", nillable = true)
    protected List<AuditLogItem> auditLogItems;

    /**
     * Gets the value of the totalCount property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * Sets the value of the totalCount property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setTotalCount(final Integer value) {
        this.totalCount = value;
    }

    /**
     * Gets the value of the auditLogItems property.
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the auditLogItems property.
     * <p>
     * For example, to add a new item, do as follows:
     *
     * <pre>
     * getAuditLogItems().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list {@link AuditLogItem }
     */
    public List<AuditLogItem> getAuditLogItems() {
        if (auditLogItems == null) {
            auditLogItems = new ArrayList<AuditLogItem>();
        }
        return this.auditLogItems;
    }

}
