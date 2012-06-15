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
 * Java class for EnvironmentRole complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EnvironmentRole">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Environment" type="{}Reference"/>
 *         &lt;element name="Role" type="{}Reference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnvironmentRole", propOrder = {"environment", "role"})
public class EnvironmentRole extends ToStringGenerator {

    @XmlElement(name = "Environment", required = true, nillable = true)
    protected Reference environment;
    @XmlElement(name = "Role", nillable = true)
    protected Reference role;

    /**
     * Gets the value of the environment property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getEnvironment() {
        return environment;
    }

    /**
     * Sets the value of the environment property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setEnvironment(final Reference value) {
        this.environment = value;
    }

    /**
     * Gets the value of the role property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setRole(final Reference value) {
        this.role = value;
    }
}
