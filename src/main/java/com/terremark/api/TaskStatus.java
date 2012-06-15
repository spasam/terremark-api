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
 * Status of a task.
 * <p>
 * Java class for TaskStatus.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="TaskStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Queued"/>
 *     &lt;enumeration value="Running"/>
 *     &lt;enumeration value="Error"/>
 *     &lt;enumeration value="Complete"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "TaskStatus")
@XmlEnum
public enum TaskStatus {
    /** The task is queued for execution. */
    @XmlEnumValue("Queued")
    QUEUED("Queued"),
    /** The task is running. */
    @XmlEnumValue("Running")
    RUNNING("Running"),
    /** The task failed with an error. */
    @XmlEnumValue("Error")
    ERROR("Error"),
    /** The task completed successfully. */
    @XmlEnumValue("Complete")
    COMPLETE("Complete");

    private final String value;

    TaskStatus(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaskStatus fromValue(final String v) {
        for (final TaskStatus c : TaskStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
