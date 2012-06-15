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
 * Current status of the user’s access.
 * <p>
 * Java class for UserLoginStatus.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 *
 * <pre>
 * &lt;simpleType name="UserLoginStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="LockedOut"/>
 *     &lt;enumeration value="AccountReset"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "UserLoginStatus")
@XmlEnum
public enum UserLoginStatus {
    /** User is able to log in. */
    @XmlEnumValue("Active")
    ACTIVE("Active"),
    /** User has exceeded the permitted attempts to log in. */
    @XmlEnumValue("LockedOut")
    LOCKED_OUT("LockedOut"),
    /** User’s account has been reset and user has not yet performed the registration steps. */
    @XmlEnumValue("AccountReset")
    ACCOUNT_RESET("AccountReset");

    private final String value;

    UserLoginStatus(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UserLoginStatus fromValue(final String v) {
        for (final UserLoginStatus c : UserLoginStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
