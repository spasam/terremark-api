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
 * Java class for ResourceBurst complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ResourceBurst">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Actions" type="{}ArrayOfAction" minOccurs="0"/>
 *         &lt;element name="Status" type="{}ResourceBurstStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceBurst", propOrder = {"actions", "status"})
public class ResourceBurst extends ToStringGenerator {

    @XmlElement(name = "Status")
    protected ResourceBurstStatus status;
    @XmlElementWrapper(name = "Actions")
    @XmlElement(name = "Action")
    protected List<Action> actions;

    /**
     * Gets the value of the status property.
     *
     * @return possible object is {@link ResourceBurstStatus }
     */
    public ResourceBurstStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is {@link ResourceBurstStatus }
     */
    public void setStatus(final ResourceBurstStatus value) {
        this.status = value;
    }

    public List<Action> getActions() {
        if (actions == null) {
            actions = new ArrayList<Action>();
        }
        return actions;
    }
}
