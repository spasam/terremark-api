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
 * Java class for Environment complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Environment">
 *   &lt;complexContent>
 *     &lt;extension base="{}Entity">
 *       &lt;sequence>
 *         &lt;element name="ComputePools" type="{}ComputePoolReferences" minOccurs="0"/>
 *         &lt;element name="Networks" type="{}NetworkReferences" minOccurs="0"/>
 *         &lt;element name="PhysicalDevices" type="{}PhysicalDeviceReferences" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Environment", propOrder = {"computePools", "networks", "physicalDevices"})
@javax.xml.bind.annotation.XmlRootElement(name = "Environment")
public final class Environment extends Entity {

    @XmlElementWrapper(name = "ComputePools")
    @XmlElement(name = "ComputePool")
    protected List<ComputePoolReference> computePools;
    @XmlElementWrapper(name = "Networks")
    @XmlElement(name = "Network")
    protected List<NetworkReference> networks;
    @XmlElementWrapper(name = "PhysicalDevices")
    @XmlElement(name = "PhysicalDevice")
    protected List<Reference> physicalDevices;

    public List<ComputePoolReference> getComputePools() {
        if (computePools == null) {
            computePools = new ArrayList<ComputePoolReference>();
        }
        return computePools;
    }

    public List<NetworkReference> getNetworks() {
        if (networks == null) {
            networks = new ArrayList<NetworkReference>();
        }
        return networks;
    }

    public List<Reference> getPhysicalDevices() {
        if (physicalDevices == null) {
            physicalDevices = new ArrayList<Reference>();
        }
        return physicalDevices;
    }

}
