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
 * Java class for SshKeys complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SshKeys">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="SshKey" type="{}SshKey" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SshKeys", propOrder = {"sshKeys"})
@javax.xml.bind.annotation.XmlRootElement(name = "SshKeys")
public final class SshKeys extends Resource {

    @XmlElement(name = "SshKey", nillable = true)
    protected List<SshKey> sshKeys;

    /**
     * Gets the value of the sshKeys property.
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the sshKeys property.
     * <p>
     * For example, to add a new item, do as follows:
     *
     * <pre>
     * getSshKeys().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list {@link SshKey }
     */
    public List<SshKey> getSshKeys() {
        if (sshKeys == null) {
            sshKeys = new ArrayList<SshKey>();
        }
        return this.sshKeys;
    }

}
