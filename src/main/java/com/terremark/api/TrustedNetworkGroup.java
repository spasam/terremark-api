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
 * Java class for TrustedNetworkGroup complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TrustedNetworkGroup">
 *   &lt;complexContent>
 *     &lt;extension base="{}Entity">
 *       &lt;sequence>
 *         &lt;element name="Hosts" type="{}TrustedNetworkGroupHosts" minOccurs="0"/>
 *         &lt;element name="Networks" type="{}TrustedNetworkGroupNetworks" minOccurs="0"/>
 *         &lt;element name="InternetServices" type="{}InternetServiceReferences" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrustedNetworkGroup", propOrder = {"hosts", "networks", "internetServices"})
@javax.xml.bind.annotation.XmlRootElement(name = "TrustedNetworkGroup")
public final class TrustedNetworkGroup extends Entity {

    @XmlElementWrapper(name = "Hosts")
    @XmlElement(name = "IpAddress")
    protected List<String> hosts;
    @XmlElementWrapper(name = "Networks")
    @XmlElement(name = "Network")
    protected List<ExternalNetwork> networks;
    @XmlElementWrapper(name = "InternetServices")
    @XmlElement(name = "InternetService")
    protected List<Reference> internetServices;

    public List<String> getHosts() {
        if (hosts == null) {
            hosts = new ArrayList<String>();
        }
        return hosts;
    }

    public List<ExternalNetwork> getNetworks() {
        if (networks == null) {
            networks = new ArrayList<ExternalNetwork>();
        }
        return networks;
    }

    public List<Reference> getInternetServices() {
        if (internetServices == null) {
            internetServices = new ArrayList<Reference>();
        }
        return internetServices;
    }
}
