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
 * Java class for Role complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Role">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="RoleType" type="{}RoleTypeEnum" minOccurs="0"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Category" type="{}RoleCategory" minOccurs="0"/>
 *         &lt;element name="IsAdminRole" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="BusinessOperations" type="{}BusinessOperationReferences" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Role", propOrder = {"roleType", "active", "category", "isAdminRole", "businessOperations"})
@javax.xml.bind.annotation.XmlRootElement(name = "Role")
public final class Role extends Resource {

    @XmlElement(name = "RoleType")
    protected RoleTypeEnum roleType;
    @XmlElement(name = "Active")
    protected Boolean active;
    @XmlElement(name = "Category")
    protected RoleCategory category;
    @XmlElement(name = "IsAdminRole")
    protected Boolean isAdminRole;
    @XmlElementWrapper(name = "BusinessOperations")
    @XmlElement(name = "BusinessOperation")
    protected List<Reference> businessOperations;

    /**
     * Gets the value of the roleType property.
     *
     * @return possible object is {@link RoleTypeEnum }
     */
    public RoleTypeEnum getRoleType() {
        return roleType;
    }

    /**
     * Sets the value of the roleType property.
     *
     * @param value allowed object is {@link RoleTypeEnum }
     */
    public void setRoleType(final RoleTypeEnum value) {
        this.roleType = value;
    }

    /**
     * Gets the value of the active property.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setActive(final Boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the category property.
     *
     * @return possible object is {@link RoleCategory }
     */
    public RoleCategory getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     *
     * @param value allowed object is {@link RoleCategory }
     */
    public void setCategory(final RoleCategory value) {
        this.category = value;
    }

    /**
     * Gets the value of the isAdminRole property.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isIsAdminRole() {
        return isAdminRole;
    }

    /**
     * Sets the value of the isAdminRole property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setIsAdminRole(final Boolean value) {
        this.isAdminRole = value;
    }

    public List<Reference> getBusinessOperations() {
        if (businessOperations == null) {
            businessOperations = new ArrayList<Reference>();
        }
        return businessOperations;
    }
}
