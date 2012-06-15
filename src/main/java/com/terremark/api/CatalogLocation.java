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
 * Java class for CatalogLocation complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CatalogLocation">
 *   &lt;complexContent>
 *     &lt;extension base="{}Entity">
 *       &lt;sequence>
 *         &lt;element name="Storage" type="{}CatalogStorage" minOccurs="0"/>
 *         &lt;element name="Catalog" type="{}CatalogEntries" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CatalogLocation", propOrder = {"storage", "catalog"})
public class CatalogLocation extends Entity {

    @XmlElement(name = "Storage", nillable = true)
    protected CatalogStorage storage;
    @XmlElementWrapper(name = "Catalog")
    @XmlElement(name = "CatalogEntry")
    protected List<CatalogEntry> catalog;

    /**
     * Gets the value of the storage property.
     *
     * @return possible object is {@link CatalogStorage }
     */
    public CatalogStorage getStorage() {
        return storage;
    }

    /**
     * Sets the value of the storage property.
     *
     * @param value allowed object is {@link CatalogStorage }
     */
    public void setStorage(final CatalogStorage value) {
        this.storage = value;
    }

    public List<CatalogEntry> getCatalog() {
        if (catalog == null) {
            catalog = new ArrayList<CatalogEntry>();
        }
        return catalog;
    }
}
