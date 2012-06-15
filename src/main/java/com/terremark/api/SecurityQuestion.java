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
 * Java class for SecurityQuestion complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SecurityQuestion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Question" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Answer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IsCustom" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecurityQuestion", propOrder = {"question", "answer", "isCustom"})
public class SecurityQuestion extends ToStringGenerator {

    @XmlElement(name = "Question", required = true, nillable = true)
    protected String question;
    @XmlElement(name = "Answer", required = true, nillable = true)
    protected String answer;
    @XmlElement(name = "IsCustom")
    protected boolean isCustom;

    /**
     * Gets the value of the question property.
     *
     * @return possible object is {@link String }
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the value of the question property.
     *
     * @param value allowed object is {@link String }
     */
    public void setQuestion(final String value) {
        this.question = value;
    }

    /**
     * Gets the value of the answer property.
     *
     * @return possible object is {@link String }
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Sets the value of the answer property.
     *
     * @param value allowed object is {@link String }
     */
    public void setAnswer(final String value) {
        this.answer = value;
    }

    /**
     * Gets the value of the isCustom property.
     */
    public boolean isIsCustom() {
        return isCustom;
    }

    /**
     * Sets the value of the isCustom property.
     */
    public void setIsCustom(final boolean value) {
        this.isCustom = value;
    }
}
