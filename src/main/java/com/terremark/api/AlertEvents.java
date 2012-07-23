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
 * Java class for AlertEvents complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AlertEvents">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TotalCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PageCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CurrentPage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="AlertEvent" type="{}AlertEvent" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlertEvents", propOrder = {"totalCount", "pageCount", "currentPage", "alertEvents"})
@javax.xml.bind.annotation.XmlRootElement(name = "AlertEvents")
public final class AlertEvents extends ToStringGenerator {

    @XmlElement(name = "TotalCount")
    protected Integer totalCount;
    @XmlElement(name = "PageCount")
    protected Integer pageCount;
    @XmlElement(name = "CurrentPage")
    protected Integer currentPage;
    @XmlElement(name = "AlertEvent", nillable = true)
    protected List<AlertEvent> alertEvents;

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
     * Gets the value of the pageCount property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * Sets the value of the pageCount property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setPageCount(final Integer value) {
        this.pageCount = value;
    }

    /**
     * Gets the value of the currentPage property.
     *
     * @return possible object is {@link Integer }
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * Sets the value of the currentPage property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setCurrentPage(final Integer value) {
        this.currentPage = value;
    }

    /**
     * Gets the value of the alertEvents property.
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the alertEvents property.
     * <p>
     * For example, to add a new item, do as follows:
     *
     * <pre>
     * getAlertEvents().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list {@link AlertEvent }
     */
    public List<AlertEvent> getAlertEvents() {
        if (alertEvents == null) {
            alertEvents = new ArrayList<AlertEvent>();
        }
        return this.alertEvents;
    }
}
