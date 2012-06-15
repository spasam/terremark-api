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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Detached disk status refers to the status of the detached disk.
 * <p>
 * Java class for DetachedDiskStatus.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="DetachedDiskStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Available"/>
 *     &lt;enumeration value="AttachInProgress"/>
 *     &lt;enumeration value="DetachInProgress"/>
 *     &lt;enumeration value="DeleteInProgress"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "DetachedDiskStatus")
@XmlEnum
public enum DetachedDiskStatus {
    /** Disk is in storage and available to attach. */
    @XmlEnumValue("Available")
    AVAILABLE("Available"),
    /** Disk is in the process of attaching to a VM and unavailable. */
    @XmlEnumValue("AttachInProgress")
    ATTACH_IN_PROGRESS("AttachInProgress"),
    /** Disk is in the process of detaching from a VM and unavailable. */
    @XmlEnumValue("DetachInProgress")
    DETACH_IN_PROGRESS("DetachInProgress"),
    /** Disk is in the process of being deleted. */
    @XmlEnumValue("DeleteInProgress")
    DELETE_IN_PROGRESS("DeleteInProgress");

    private final String value;

    DetachedDiskStatus(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DetachedDiskStatus fromValue(final String v) {
        for (final DetachedDiskStatus c : DetachedDiskStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
