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
 * Java class for DetachDiskRetryOperation complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DetachDiskRetryOperation">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="DetachedDisk" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="VirtualMachine" type="{}Reference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetachDiskRetryOperation", propOrder = {"detachedDisk", "virtualMachine"})
@javax.xml.bind.annotation.XmlRootElement(name = "DetachDiskRetryOperation")
public final class DetachDiskRetryOperation extends Resource {

    @XmlElement(name = "DetachedDisk", nillable = true)
    protected Reference detachedDisk;
    @XmlElement(name = "VirtualMachine", nillable = true)
    protected Reference virtualMachine;

    /**
     * Gets the value of the detachedDisk property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getDetachedDisk() {
        return detachedDisk;
    }

    /**
     * Sets the value of the detachedDisk property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setDetachedDisk(final Reference value) {
        this.detachedDisk = value;
    }

    /**
     * Gets the value of the virtualMachine property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getVirtualMachine() {
        return virtualMachine;
    }

    /**
     * Sets the value of the virtualMachine property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setVirtualMachine(final Reference value) {
        this.virtualMachine = value;
    }
}
