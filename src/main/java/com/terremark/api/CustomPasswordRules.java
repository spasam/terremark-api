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
 * Java class for CustomPasswordRules complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CustomPasswordRules">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MinimumCharacters" type="{}EnabledValue"/>
 *         &lt;element name="MinimumUpperCaseCharacters" type="{}EnabledValue"/>
 *         &lt;element name="MinimumLowerCaseCharacters" type="{}EnabledValue"/>
 *         &lt;element name="MinimumNumericCharacters" type="{}EnabledValue"/>
 *         &lt;element name="MinimumSpecialCharacters" type="{}EnabledValue"/>
 *         &lt;element name="MaximumConsecutiveCharactersFromPriorPassword" type="{}EnabledValue"/>
 *         &lt;element name="MinimumLifetimeRestriction" type="{}EnabledValue"/>
 *         &lt;element name="MinimumGenerationsBeforeReuse" type="{}EnabledValue"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomPasswordRules", propOrder = {"minimumCharacters", "minimumUpperCaseCharacters",
                "minimumLowerCaseCharacters", "minimumNumericCharacters", "minimumSpecialCharacters",
                "maximumConsecutiveCharactersFromPriorPassword", "minimumLifetimeRestriction",
                "minimumGenerationsBeforeReuse"})
public class CustomPasswordRules extends ToStringGenerator {

    @XmlElement(name = "MinimumCharacters", required = true, nillable = true)
    protected EnabledValue minimumCharacters;
    @XmlElement(name = "MinimumUpperCaseCharacters", required = true, nillable = true)
    protected EnabledValue minimumUpperCaseCharacters;
    @XmlElement(name = "MinimumLowerCaseCharacters", required = true, nillable = true)
    protected EnabledValue minimumLowerCaseCharacters;
    @XmlElement(name = "MinimumNumericCharacters", required = true, nillable = true)
    protected EnabledValue minimumNumericCharacters;
    @XmlElement(name = "MinimumSpecialCharacters", required = true, nillable = true)
    protected EnabledValue minimumSpecialCharacters;
    @XmlElement(name = "MaximumConsecutiveCharactersFromPriorPassword", required = true, nillable = true)
    protected EnabledValue maximumConsecutiveCharactersFromPriorPassword;
    @XmlElement(name = "MinimumLifetimeRestriction", required = true, nillable = true)
    protected EnabledValue minimumLifetimeRestriction;
    @XmlElement(name = "MinimumGenerationsBeforeReuse", required = true, nillable = true)
    protected EnabledValue minimumGenerationsBeforeReuse;

    /**
     * Gets the value of the minimumCharacters property.
     *
     * @return possible object is {@link EnabledValue }
     */
    public EnabledValue getMinimumCharacters() {
        return minimumCharacters;
    }

    /**
     * Sets the value of the minimumCharacters property.
     *
     * @param value allowed object is {@link EnabledValue }
     */
    public void setMinimumCharacters(final EnabledValue value) {
        this.minimumCharacters = value;
    }

    /**
     * Gets the value of the minimumUpperCaseCharacters property.
     *
     * @return possible object is {@link EnabledValue }
     */
    public EnabledValue getMinimumUpperCaseCharacters() {
        return minimumUpperCaseCharacters;
    }

    /**
     * Sets the value of the minimumUpperCaseCharacters property.
     *
     * @param value allowed object is {@link EnabledValue }
     */
    public void setMinimumUpperCaseCharacters(final EnabledValue value) {
        this.minimumUpperCaseCharacters = value;
    }

    /**
     * Gets the value of the minimumLowerCaseCharacters property.
     *
     * @return possible object is {@link EnabledValue }
     */
    public EnabledValue getMinimumLowerCaseCharacters() {
        return minimumLowerCaseCharacters;
    }

    /**
     * Sets the value of the minimumLowerCaseCharacters property.
     *
     * @param value allowed object is {@link EnabledValue }
     */
    public void setMinimumLowerCaseCharacters(final EnabledValue value) {
        this.minimumLowerCaseCharacters = value;
    }

    /**
     * Gets the value of the minimumNumericCharacters property.
     *
     * @return possible object is {@link EnabledValue }
     */
    public EnabledValue getMinimumNumericCharacters() {
        return minimumNumericCharacters;
    }

    /**
     * Sets the value of the minimumNumericCharacters property.
     *
     * @param value allowed object is {@link EnabledValue }
     */
    public void setMinimumNumericCharacters(final EnabledValue value) {
        this.minimumNumericCharacters = value;
    }

    /**
     * Gets the value of the minimumSpecialCharacters property.
     *
     * @return possible object is {@link EnabledValue }
     */
    public EnabledValue getMinimumSpecialCharacters() {
        return minimumSpecialCharacters;
    }

    /**
     * Sets the value of the minimumSpecialCharacters property.
     *
     * @param value allowed object is {@link EnabledValue }
     */
    public void setMinimumSpecialCharacters(final EnabledValue value) {
        this.minimumSpecialCharacters = value;
    }

    /**
     * Gets the value of the maximumConsecutiveCharactersFromPriorPassword property.
     *
     * @return possible object is {@link EnabledValue }
     */
    public EnabledValue getMaximumConsecutiveCharactersFromPriorPassword() {
        return maximumConsecutiveCharactersFromPriorPassword;
    }

    /**
     * Sets the value of the maximumConsecutiveCharactersFromPriorPassword property.
     *
     * @param value allowed object is {@link EnabledValue }
     */
    public void setMaximumConsecutiveCharactersFromPriorPassword(final EnabledValue value) {
        this.maximumConsecutiveCharactersFromPriorPassword = value;
    }

    /**
     * Gets the value of the minimumLifetimeRestriction property.
     *
     * @return possible object is {@link EnabledValue }
     */
    public EnabledValue getMinimumLifetimeRestriction() {
        return minimumLifetimeRestriction;
    }

    /**
     * Sets the value of the minimumLifetimeRestriction property.
     *
     * @param value allowed object is {@link EnabledValue }
     */
    public void setMinimumLifetimeRestriction(final EnabledValue value) {
        this.minimumLifetimeRestriction = value;
    }

    /**
     * Gets the value of the minimumGenerationsBeforeReuse property.
     *
     * @return possible object is {@link EnabledValue }
     */
    public EnabledValue getMinimumGenerationsBeforeReuse() {
        return minimumGenerationsBeforeReuse;
    }

    /**
     * Sets the value of the minimumGenerationsBeforeReuse property.
     *
     * @param value allowed object is {@link EnabledValue }
     */
    public void setMinimumGenerationsBeforeReuse(final EnabledValue value) {
        this.minimumGenerationsBeforeReuse = value;
    }
}
