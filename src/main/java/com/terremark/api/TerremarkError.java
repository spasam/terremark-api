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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Terremark error information that contains error codes and message.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Error")
@XmlType(name = "Error")
public final class TerremarkError {
    /** Error message */
    @XmlAttribute(required = true)
    protected String message;
    /** Major error code */
    @XmlAttribute(required = true)
    protected int majorErrorCode;
    /** Minor error code */
    @XmlAttribute(required = true)
    protected String minorErrorCode;

    /**
     * Return error message.
     *
     * @return Error message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns major (HTTP) error code.
     *
     * @return HTTP error code.
     */
    public int getMajorErrorCode() {
        return majorErrorCode;
    }

    /**
     * Returns minor error code.
     *
     * @return Error code string.
     */
    public String getMinorErrorCode() {
        return minorErrorCode;
    }
}