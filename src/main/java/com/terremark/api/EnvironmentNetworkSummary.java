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
 * Java class for EnvironmentNetworkSummary complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EnvironmentNetworkSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="Networks" type="{}NetworkHostSummary" minOccurs="0"/>
 *         &lt;element name="PublicIpAddresses" type="{}PublicIpAddresses" minOccurs="0"/>
 *         &lt;element name="InternetServices" type="{}InternetServiceReferences" minOccurs="0"/>
 *         &lt;element name="NodeServices" type="{}NodeServiceReferences" minOccurs="0"/>
 *         &lt;element name="FirewallAcls" type="{}FirewallAclReferences" minOccurs="0"/>
 *         &lt;element name="TrustedNetworkGroups" type="{}TrustedNetworkGroupReferences" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnvironmentNetworkSummary", propOrder = {"networks", "publicIpAddresses", "internetServices",
                "nodeServices", "firewallAcls", "trustedNetworkGroups"})
@javax.xml.bind.annotation.XmlRootElement(name = "EnvironmentNetworkSummary")
public final class EnvironmentNetworkSummary extends Resource {

    @XmlElement(name = "Networks", nillable = true)
    protected NetworkHostSummary networks;
    @XmlElement(name = "PublicIpAddresses", nillable = true)
    protected PublicIpAddresses publicIpAddresses;
    @XmlElementWrapper(name = "InternetServices")
    @XmlElement(name = "InternetService")
    protected List<Reference> internetServices;
    @XmlElementWrapper(name = "NodeServices")
    @XmlElement(name = "NodeService")
    protected List<Reference> nodeServices;
    @XmlElementWrapper(name = "FirewallAcls")
    @XmlElement(name = "FirewallAcl")
    protected List<Reference> firewallAcls;
    @XmlElementWrapper(name = "TrustedNetworkGroups")
    @XmlElement(name = "TrustedNetworkGroup")
    protected List<Reference> trustedNetworkGroups;

    /**
     * Gets the value of the networks property.
     *
     * @return possible object is {@link NetworkHostSummary }
     */
    public NetworkHostSummary getNetworks() {
        return networks;
    }

    /**
     * Sets the value of the networks property.
     *
     * @param value allowed object is {@link NetworkHostSummary }
     */
    public void setNetworks(final NetworkHostSummary value) {
        this.networks = value;
    }

    /**
     * Gets the value of the publicIpAddresses property.
     *
     * @return possible object is {@link PublicIpAddresses }
     */
    public PublicIpAddresses getPublicIpAddresses() {
        return publicIpAddresses;
    }

    /**
     * Sets the value of the publicIpAddresses property.
     *
     * @param value allowed object is {@link PublicIpAddresses }
     */
    public void setPublicIpAddresses(final PublicIpAddresses value) {
        this.publicIpAddresses = value;
    }

    public List<Reference> getInternetServices() {
        if (internetServices == null) {
            internetServices = new ArrayList<Reference>();
        }
        return internetServices;
    }

    public List<Reference> getNodeServices() {
        if (nodeServices == null) {
            nodeServices = new ArrayList<Reference>();
        }
        return nodeServices;
    }

    public List<Reference> getFirewallAcls() {
        if (firewallAcls == null) {
            firewallAcls = new ArrayList<Reference>();
        }
        return firewallAcls;
    }

    public List<Reference> getTrustedNetworkGroups() {
        if (trustedNetworkGroups == null) {
            trustedNetworkGroups = new ArrayList<Reference>();
        }
        return trustedNetworkGroups;
    }

}
