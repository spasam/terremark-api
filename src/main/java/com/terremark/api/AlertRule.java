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
 * Java class for AlertRule complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AlertRule">
 *   &lt;complexContent>
 *     &lt;extension base="{}Resource">
 *       &lt;sequence>
 *         &lt;element name="AlertRuleTemplate" type="{}Reference" minOccurs="0"/>
 *         &lt;element name="RuleGroup" type="{}AlertRuleGroup" minOccurs="0"/>
 *         &lt;element name="Threshold" type="{}Threshold" minOccurs="0"/>
 *         &lt;element name="RuleAction" type="{}AlertRuleAction" minOccurs="0"/>
 *         &lt;element name="Configuration" type="{}Configuration" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlertRule", propOrder = {"alertRuleTemplate", "ruleGroup", "threshold", "ruleAction", "configuration"})
@javax.xml.bind.annotation.XmlRootElement(name = "AlertRule")
public final class AlertRule extends Resource {

    @XmlElement(name = "AlertRuleTemplate", nillable = true)
    protected Reference alertRuleTemplate;
    @XmlElement(name = "RuleGroup")
    protected AlertRuleGroup ruleGroup;
    @XmlElement(name = "Threshold", nillable = true)
    protected Threshold threshold;
    @XmlElement(name = "RuleAction")
    protected AlertRuleAction ruleAction;
    @XmlElement(name = "Configuration", nillable = true)
    protected Configuration configuration;

    /**
     * Gets the value of the alertRuleTemplate property.
     *
     * @return possible object is {@link Reference }
     */
    public Reference getAlertRuleTemplate() {
        return alertRuleTemplate;
    }

    /**
     * Sets the value of the alertRuleTemplate property.
     *
     * @param value allowed object is {@link Reference }
     */
    public void setAlertRuleTemplate(final Reference value) {
        this.alertRuleTemplate = value;
    }

    /**
     * Gets the value of the ruleGroup property.
     *
     * @return possible object is {@link AlertRuleGroup }
     */
    public AlertRuleGroup getRuleGroup() {
        return ruleGroup;
    }

    /**
     * Sets the value of the ruleGroup property.
     *
     * @param value allowed object is {@link AlertRuleGroup }
     */
    public void setRuleGroup(final AlertRuleGroup value) {
        this.ruleGroup = value;
    }

    /**
     * Gets the value of the threshold property.
     *
     * @return possible object is {@link Threshold }
     */
    public Threshold getThreshold() {
        return threshold;
    }

    /**
     * Sets the value of the threshold property.
     *
     * @param value allowed object is {@link Threshold }
     */
    public void setThreshold(final Threshold value) {
        this.threshold = value;
    }

    /**
     * Gets the value of the ruleAction property.
     *
     * @return possible object is {@link AlertRuleAction }
     */
    public AlertRuleAction getRuleAction() {
        return ruleAction;
    }

    /**
     * Sets the value of the ruleAction property.
     *
     * @param value allowed object is {@link AlertRuleAction }
     */
    public void setRuleAction(final AlertRuleAction value) {
        this.ruleAction = value;
    }

    /**
     * Gets the value of the configuration property.
     *
     * @return possible object is {@link Configuration }
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Sets the value of the configuration property.
     *
     * @param value allowed object is {@link Configuration }
     */
    public void setConfiguration(final Configuration value) {
        this.configuration = value;
    }

}
