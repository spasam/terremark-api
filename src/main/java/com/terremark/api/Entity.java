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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Entity complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Entity">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="Tasks" type="{}Tasks" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Entity", propOrder = {"tasks"})
@XmlSeeAlso({User.class, ComputePool.class, AdminOrganization.class, CatalogEntry.class, InternetService.class,
                TrustedNetworkGroup.class, DeviceTag.class, BackupInternetService.class, Environment.class,
                SshKey.class, FirewallLog.class, CatalogLocation.class, FirewallAcl.class, Organization.class,
                NodeService.class, Device.class, PublicIp.class, Contact.class})
public class Entity extends Resource {

    @XmlElement(name = "Tasks", nillable = true)
    protected Tasks tasks;

    /**
     * Gets the value of the tasks property.
     *
     * @return possible object is {@link Tasks }
     */
    public Tasks getTasks() {
        return tasks;
    }

    /**
     * Sets the value of the tasks property.
     *
     * @param value allowed object is {@link Tasks }
     */
    public void setTasks(final Tasks value) {
        this.tasks = value;
    }
}
