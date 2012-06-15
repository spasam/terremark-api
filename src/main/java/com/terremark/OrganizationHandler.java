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
package com.terremark;

import java.util.Map;

import com.terremark.api.AdminOrganization;
import com.terremark.api.AdminOrganizations;
import com.terremark.api.Alert;
import com.terremark.api.AlertEvents;
import com.terremark.api.AlertLog;
import com.terremark.api.AlertNotification;
import com.terremark.api.AlertRule;
import com.terremark.api.AlertRuleTemplate;
import com.terremark.api.AlertRuleTemplates;
import com.terremark.api.AlertRules;
import com.terremark.api.ApiKey;
import com.terremark.api.ApiKeys;
import com.terremark.api.AuditLog;
import com.terremark.api.AuthenticationLevels;
import com.terremark.api.BandwidthPeriods;
import com.terremark.api.BandwidthUsage;
import com.terremark.api.BusinessOperation;
import com.terremark.api.BusinessOperations;
import com.terremark.api.Catalog;
import com.terremark.api.CatalogEntry;
import com.terremark.api.CatalogEntryConfiguration;
import com.terremark.api.CatalogLog;
import com.terremark.api.Configuration;
import com.terremark.api.Contact;
import com.terremark.api.Contacts;
import com.terremark.api.CreateApiKey;
import com.terremark.api.CreateApiUser;
import com.terremark.api.CreateCatalogEntry;
import com.terremark.api.CreateRole;
import com.terremark.api.CreateSshKey;
import com.terremark.api.CreateTicket;
import com.terremark.api.CreateUser;
import com.terremark.api.DeviceTagList;
import com.terremark.api.Environment;
import com.terremark.api.Environments;
import com.terremark.api.InviteUser;
import com.terremark.api.Location;
import com.terremark.api.LoginBanner;
import com.terremark.api.MultifactorAuthentication;
import com.terremark.api.Organization;
import com.terremark.api.Organizations;
import com.terremark.api.PasswordComplexityRules;
import com.terremark.api.Questions;
import com.terremark.api.Role;
import com.terremark.api.Roles;
import com.terremark.api.SshKey;
import com.terremark.api.SshKeys;
import com.terremark.api.Ticket;
import com.terremark.api.TicketGroups;
import com.terremark.api.Tickets;
import com.terremark.api.User;
import com.terremark.api.UserCredentials;
import com.terremark.api.UserRole;
import com.terremark.api.Users;
import com.terremark.exception.TerremarkException;

/**
 * Provides API calls for top level objects with in an organization:
 * <ul>
 * <li>Organization
 * <li>Environment
 * <li>Tag
 * <li>Location
 * <li>Catalog
 * <li>Bandwidth
 * <li>Alert
 * <li>SSH key
 * <li>Support ticket
 * <li>Administrative organization
 * <li>User
 * <ul>
 * <li>Contact
 * <li>API key
 * <li>Audit log
 * </ul>
 * <li>Role
 * <ul>
 * <li>Business operation
 * </ul>
 * </ul>
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public interface OrganizationHandler {
    // TODO FIXME XXX: void catalogFile(BytesToUpload obj);

    /**
     * Disables access to the support module for a specified organization.
     *
     * @param organizationId ID of the organization.
     * @throws TerremarkException If an error occurs disabling support access.
     */
    void administrativeOrganizationsDisableSupportAccess(String organizationId) throws TerremarkException;

    /**
     * Edits the authentication levels permitted for accessing the API in an organization. If successful, the call
     * returns information regarding the authentication levels that were modified. Authentication levels define the
     * methods permitted for accessing the API. See {@link com.terremark.api.AuthenticationLevels AuthenticationLevels}.
     *
     * @param organizationId ID of the organization.
     * @param obj New authentication levels to use for organization.
     * @return New authentication levels applicable for the specified organization.
     * @throws TerremarkException If an error occurs updating the authentication levels.
     */
    AuthenticationLevels administrativeOrganizationEditAuthenticationLevels(String organizationId,
                    AuthenticationLevels obj) throws TerremarkException;

    /**
     * Changes the state for the display of the login banner. If successful, the call returns information regarding the
     * login banner that was modified.
     * <p/>
     * {@code Display} is a required element.
     * <p/>
     * {@code Text} is optional. If {@code Text} is not present, no change is made to the text. If {@code Text} is empty
     * string, the text field is cleared.
     * <p/>
     * Note: If {@code Display} is {@code true} and {@code Text} has no value, the login banner will appear when users
     * login to the user interface but with no text displayed.
     * <p/>
     * Note: To remove the login banner text an empty value should be specified.
     *
     * @param organizationId ID of the organization.
     * @param obj New login banner information.
     * @return Updated login banner information.
     * @throws TerremarkException If an error occurs updating the login banner for the specified organization.
     */
    LoginBanner administrativeOrganizationEditLoginBanner(String organizationId, LoginBanner obj)
                    throws TerremarkException;

    /**
     * Edits the rules regarding password complexity. If successful, the call returns information regarding the password
     * complexity rules that were modified.
     * <p/>
     * {@code CustomRules} should not be present if {@code RuleType} is {@code Default}. The element {@code CustomRules}
     * must be present and if {@code RuleType} is {@code Custom}. If {@code CustomRules} is present, all of its
     * attributes must be present. Set {@code Enabled} to {@code true} to enable a rule and {@code Enabled} to
     * {@code false} to disable a rule. For each rule enabled, {@code Value} must be present and have a value between 1
     * and 99 for all but {@code MinimumLifetimeRestriction}, which must have a value between 1 and 999. For each rule
     * disabled, {@code Value} is optional and ignored if present.
     * <p/>
     * Note: If a rule is disabled and {@code Value} is present but empty (no value), an error is returned.
     *
     * @param organizationId ID of the organization.
     * @param obj New password complexity rules to apply to the specified organization.
     * @return Updated password complexity rules for the specified organization.
     * @throws TerremarkException If an error occurs updating the password complexity rules.
     */
    PasswordComplexityRules administrativeOrganizationEditPasswordComplexityRules(String organizationId,
                    PasswordComplexityRules obj) throws TerremarkException;

    /**
     * Enables access to the support module for a specified organization.
     *
     * @param organizationId ID of the organization.
     * @throws TerremarkException If an error occurs enabling support access to the specified organization.
     */
    void administrativeOrganizationsEnableSupportAccess(String organizationId) throws TerremarkException;

    /**
     * Creates an alert rule from the specified alert rule template in an organization. If successful, the call returns
     * information regarding the alert rule that was created.</p> At least one {@code Recipient} is required.
     * <p/>
     * Recipient {@code Email} must be unique. If duplicate email addresses exist, the first recipient with that email
     * address is retained and subsequent recipients with that email address are silently dropped.
     *
     * @param alertRuleTemplateId ID of the alert rule template from which to create the rule.
     * @param obj Alert rule configuration.
     * @return The newly created alert rule.
     * @throws TerremarkException If an error occurs creating the alert rule.
     */
    AlertRule alertRuleCreate(String alertRuleTemplateId, Configuration obj) throws TerremarkException;

    /**
     * Edits an alert rule. If successful, the call returns information regarding the alert rule that was modified.
     * <p/>
     * {@code AlertRuleTemplate}, {@code RuleGroup}, {@code Threshold}, and {@code RuleAction} are optional and ignored
     * if present.
     * <p/>
     * At least one {@code Recipient} is required.
     * <p/>
     * Recipient {@code Email} must be unique. If duplicate email addresses exist, the first recipient with that email
     * address is retained and subsequent recipients with that email address are silently dropped.
     * <p/>
     * Note: If any {@code Recipient} exists on the alert rule and is not present in the call, that recipient is removed
     * from the alert rule.
     *
     * @param obj Alert rule with with updates.
     * @return Updated alert rule.
     * @throws TerremarkException If an error occurs updating the alert rule.
     */
    AlertRule alertRuleEdit(AlertRule obj) throws TerremarkException;

    /**
     * Removes alert rule wit the specified identifier.
     *
     * @param alertRuleId ID of the alert rule to remove.
     * @throws TerremarkException If an error occurs removing the alert rule.
     */
    void alertRuleRemove(String alertRuleId) throws TerremarkException;

    /**
     * This call activates an API key. If successful, the call returns information regarding the API key that was
     * activated.
     *
     * @param apiKeyId ID of the API key to activate.
     * @return API key that was activated.
     * @throws TerremarkException If an error occurs activating the API key.
     */
    ApiKey apiKeyActivate(String apiKeyId) throws TerremarkException;

    /**
     * This method creates an API key for an API user in an organization. If successful, the call returns information
     * regarding the API key that was created.
     * <p/>
     * {@code Name} is required.
     * <p/>
     * Note: The name must not exceed 30 characters, must begin with an alphabetic character, and may include
     * alphanumeric, space, hyphen, or underscore characters.
     * <p/>
     * To retrieve the private key, use {@link #getAPIKeyByID(String)}.
     *
     * @param userId ID of the user for whom API key should be created.
     * @param obj API key create request.
     * @return The new API key.
     * @throws TerremarkException If an error occurs creating API key.
     */
    ApiKey apiKeyCreate(String userId, CreateApiKey obj) throws TerremarkException;

    /**
     * This call deactivates an API key. If successful, the call returns information regarding the API key that was
     * deactivated.
     *
     * @param apiKeyId ID of the API key to deactivate.
     * @return API key that was deactivated.
     * @throws TerremarkException If an error occurs deactivating the API key.
     */
    ApiKey apiKeyDeactivate(String apiKeyId) throws TerremarkException;

    /**
     * This method edits the name of an API key. If successful, the call returns information regarding the API key that
     * was modified.
     * <p/>
     * The {@code name} on {@code ApiKey} is required and may be changed.
     * <p/>
     * Note: The name must not exceed 30 characters, must begin with an alphabetic character, and may include
     * alphanumeric, space, hyphen, or underscore characters.
     * <p/>
     * {@code AccessKey} and {@code PrivateKey} are optional and ignored if present.
     * <p/>
     * {@code Status} is optional and ignored if present. {@code Status} may be changed only using
     * {@link #apiKeyActivate(String)} and {@link #apiKeyDeactivate(String)}.
     *
     * @param obj API key with new name.
     * @return API key with updated name.
     * @throws TerremarkException If an error occurs updating the API key.
     */
    ApiKey apiKeyEdit(ApiKey obj) throws TerremarkException;

    /**
     * This call removes an API key.
     *
     * @param apiKeyId ID of the API key to remove.
     * @throws TerremarkException If an error occurs removing the API key.
     */
    void apiKeyRemove(String apiKeyId) throws TerremarkException;

    /**
     * This call creates a catalog item for an organization at a specified location into which a virtual machine may be
     * uploaded. If successful, the call returns information regarding the catalog item that was created.
     * <p/>
     * The name attribute on {@code CreateCatalogEntry} is required.
     * <p/>
     * Note: The name may not be that of another catalog item and must not exceed fifty characters.
     * <p/>
     * The {@code href} attribute on {@code Location} is required to identify the location in which to create the
     * catalog item.
     * <p/>
     * {@code Status} for {@code CatalogEntry} refers to the status of the catalog item or of the OVF file for the
     * virtual machine (VM). Permitted values are:
     * <ul>
     * <li>Active - The catalog item is created but no files are uploaded.
     * <li>Validated - OVF successfully validated and is waiting for the image file to upload.
     * <li>Failed - VM upload failed.
     * <li>Completed - VM has successfully completed the entire upload process and is available for import.
     * <li>Validating - OVF validation is in progress.
     * </ul>
     * <p/>
     * {@code Type} refers to {@code Alerts} created while uploading or exporting a virtual machine. Permitted values
     * are:
     * <ul>
     * <li>Info - the virtual machine has an informational note.
     * <li>Warning - the VM has a non-fatal potential issue, for example, processor count exceeds operating system
     * limits, an issue which can be corrected when importing.
     * <li>Error - VM has a fatal issue, for example, disk count exceeds limits.
     * </ul>
     * <p/>
     * {@code Name} for {@code File} refers to the filename of the OVF file and the VM images, the VMDK files. The name
     * for the OVF file is always upload.ovf. The name for any VMDK file is as entered in the OVF file.
     * <p/>
     * {@code Status} for {@code File} refers to the status of the upload for the OVF file and the VM images, the VMDK
     * files. Permitted values are:
     * <ul>
     * <li>Ready - File transfer has not yet begun.
     * <li>InProgress - File transfer is in progress.
     * <li>Failed - File transfer failed.
     * <li>Verified - File is verified.
     * <li>Completed - File transfer completed.
     * <li>Stopped - File transfer stopped by the user for later restart.
     * </ul>
     * <p/>
     * {@code CatalogType} refers to the source operation for the catalog item. Permitted values are:
     * <ul>
     * <li>Upload - Catalog item was uploaded to the catalog from the organization.
     * <li>Export - Catalog item was exported to the catalog from a virtual machine in the environment.
     * </ul>
     *
     * @param organizationId ID of the organization.
     * @param obj Create catalog entry request.
     * @return Catalog entry created by this call.
     * @throws TerremarkException If an error occurs creating the catalog entry.
     */
    CatalogEntry catalogCreate(String organizationId, CreateCatalogEntry obj) throws TerremarkException;

    /**
     * This call removes a catalog item from a location.
     * <p/>
     * Note: To remove requires a catalog item to have {@code Status} with a value other than {@code Validating}.
     *
     * @param catalogId ID of the catalog item to remove..
     * @throws TerremarkException If an error occurs removing the catalog item.
     */
    void catalogRemove(String catalogId) throws TerremarkException;

    /**
     * Returns administrative information regarding an organization.
     *
     * @return Administrative information regarding an organization.
     * @throws TerremarkException If an error occurs retrieving administrative information.
     */
    AdminOrganizations getAdministrativeOrganizations() throws TerremarkException;

    /**
     * Returns information regarding the authentication levels permitted for accessing the API in an organization.
     * <p/>
     * Authentication levels define the methods permitted for accessing the API. See
     * {@link com.terremark.api.AuthenticationLevels AuthenticationLevels}.
     *
     * @param organizationId ID of the organization.
     * @return Authentication levels for the specified organization.
     * @throws TerremarkException If an error occurs retrieving the authentication levels.
     */
    AuthenticationLevels getAdministrativeOrganizationsAuthenticationLevels(String organizationId)
                    throws TerremarkException;

    /**
     * Returns administrative information regarding a specified organization.
     *
     * @param organizationId ID of the organization.
     * @return Administrative information for the specified organization.
     * @throws TerremarkException If an error occurs retrieving the administrative information.
     */
    AdminOrganization getAdministrativeOrganizationByID(String organizationId) throws TerremarkException;

    /**
     * Returns administrative information regarding the login banner for a specified organization.
     *
     * @param organizationId ID of the organization.
     * @return Login banner information for the specified organization.
     * @throws TerremarkException If an error occurs retrieving the login banner information.
     */
    LoginBanner getAdministrativeOrganizationsLoginBanner(String organizationId) throws TerremarkException;

    /**
     * Return administrative information regarding the password complexity rules for a specified organization.
     * <p/>
     * {@code CustomRules} occurs only when {@code RuleType} is {@code Custom}.
     *
     * @param organizationId ID of the organization.
     * @return Password complexity rules for the specified organization.
     * @throws TerremarkException If an error occurs retrieving the password complexity rules.
     */
    PasswordComplexityRules getAdministrativeOrganizationsPasswordComplexityRules(String organizationId)
                    throws TerremarkException;

    /**
     * Returns information regarding the alert issues and alarms for an organization. Alert issues pass a threshold and
     * may persist for a period of time, resulting in multiple readings. Alert alarms are single occurrences.
     * <p/>
     * {@code PageCount} is the {@code TotalCount} divided by the {@code pageSize} parameter, or 20 if pageSize is not
     * specified, lifted to the higher whole number if not evenly divisible.
     * <p/>
     * This call may include optional arguments. Permitted arguments are:
     * <table border="1">
     * <tr>
     * <th>Parameter</th>
     * <th>Usage</th>
     * </tr>
     * <tr>
     * <td>page</td>
     * <td>Use of page chunks the returned data and returns the requested page. Default = page 1</td>
     * </tr>
     * <tr>
     * <td>pageSize</td>
     * <td>Number of items returned per page between 1 and 1000. Default = 20</td>
     * </tr>
     * <tr>
     * <td>direction</td>
     * <td>
     * <ul>
     * <li>{@code asc} or {@code ascending} - Ascending
     * <li>{@code desc} or {@code descending} - Descending
     * <li>Default is {@code descending}
     * </ul>
     * </td>
     * </tr>
     * <tr>
     * <td>sortBy</td>
     * <td>The permitted sort key is {@code Date} and uses the value of {@code StartTime}</td>
     * </tr>
     * <tr>
     * <td>startDate</td>
     * <td>Enter in ISO8601 format; time is always start of day and if entered is ignored. Default = earliest record</td>
     * </tr>
     * <tr>
     * <td>endDate</td>
     * <td>Enter in ISO8601 format; time is always end of day and if entered is ignored. Default = latest record</td>
     * </tr>
     * <tr>
     * <td>environmentId</td>
     * <td>Environment identifier for the desired environment. Default = all environments</td>
     * </tr>
     * <tr>
     * <td>entityType</td>
     * <td>Entity on which to filter. {@code computePool} or {@code datacenter}</td>
     * </tr>
     * <tr>
     * <td>entityId</td>
     * <td>Identifier of the desired entity in {@code entityType}</td>
     * </tr>
     * </table>
     *
     * @param organizationId ID of the organization.
     * @param filterArguments Filter arguments. See description of this method. Can be null.
     * @return Alert log information.
     * @throws TerremarkException If an error occurs retrieving the alert log information.
     */
    AlertLog getAlertLog(String organizationId, Map<String, String> filterArguments) throws TerremarkException;

    /**
     * Returns information regarding the specified alert issue or alarm. Alert issues pass a threshold and may persist
     * for a period of time, resulting in multiple readings. Alert alarms are single occurrences.
     *
     * @param alertId ID of the alert log entry.
     * @return Alert for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the alert log entry.
     */
    Alert getAlertLogByID(String alertId) throws TerremarkException;

    /**
     * Returns information regarding the alert readings for a specified alert issue or alert alarm. Alert issues,
     * because they have a duration, will typically have multiple readings. Alert alarms, because they are a single
     * occurrence, will have only the reading that triggered the alarm.
     * <p/>
     * {@code PageCount} is the {@code TotalCount} divided by the {@code pageSize} parameter, or 20 if pageSize is not
     * specified, lifted to the higher whole number if not evenly divisible.
     * <p/>
     * This call may include optional arguments. Permitted arguments are:
     * <table border="1">
     * <tr>
     * <th>Parameter</th>
     * <th>Usage</th>
     * </tr>
     * <tr>
     * <td>page</td>
     * <td>Use of page chunks the returned data and returns the requested page. Default = page 1</td>
     * </tr>
     * <tr>
     * <td>pageSize</td>
     * <td>Number of items returned per page between 1 and 1000. Default = 20</td>
     * </tr>
     * <tr>
     * <td>direction</td>
     * <td>
     * <ul>
     * <li>{@code asc} or {@code ascending} - Ascending
     * <li>{@code desc} or {@code descending} - Descending
     * <li>Default is {@code descending}
     * </ul>
     * </td>
     * </tr>
     * <tr>
     * <td>sortBy</td>
     * <td>The permitted sort key is {@code Date}</td>
     * </tr>
     * <tr>
     * <td>startDate</td>
     * <td>Enter in ISO8601 format; time is always start of day and if entered is ignored. Default = earliest record</td>
     * </tr>
     * <tr>
     * <td>endDate</td>
     * <td>Enter in ISO8601 format; time is always end of day and if entered is ignored. Default = latest record</td>
     * </tr>
     * </table>
     *
     * @param alertId ID of the alert for which events should be returned.
     * @param filterArguments Filter arguments. See description of this method. Can be null.
     * @return Alert events for the specified alert identifier.
     * @throws TerremarkException If an error occurs retrieving the alert events.
     */
    AlertEvents getAlertLogEvents(String alertId, Map<String, String> filterArguments) throws TerremarkException;

    /**
     * Returns information regarding the alert notifications for a specified organization.
     *
     * @param organizationId ID of the organization.
     * @return Alert notifications for the specified organization.
     * @throws TerremarkException If an error occurs retrieving the alert notifications.
     */
    AlertNotification getAlertNotifications(String organizationId) throws TerremarkException;

    /**
     * Returns information regarding the alert rule in an organization.
     *
     * @param organizationId ID of the organization.
     * @return Alert rules in the specified organization.
     * @throws TerremarkException If an error occurs retrieving the alert rules.
     */
    AlertRules getAlertRules(String organizationId) throws TerremarkException;

    /**
     * Returns information regarding the specified alert rule.
     *
     * @param alertRuleId ID of the alert rule to retrieve.
     * @return Alert rule for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the alert rule.
     */
    AlertRule getAlertRuleByID(String alertRuleId) throws TerremarkException;

    /**
     * Returns information regarding the alert rule templates.
     *
     * @return Alert rule templates.
     * @throws TerremarkException If an error occurs retrieving alert rule templates.
     */
    AlertRuleTemplates getAlertRuleTemplates() throws TerremarkException;

    /**
     * This method returns information regarding the specified alert rule template.
     *
     * @param alertRuleTemplateId ID of the alert rule template to retrieve.
     * @return Alert rule template for the specified ID.
     * @throws TerremarkException If an error occurs retrieving the alert rule template.
     */
    AlertRuleTemplate getAlertRuleTemplateByID(String alertRuleTemplateId) throws TerremarkException;

    /**
     * Returns information regarding API keys for a specified API user in an organization.
     *
     * @param userId ID of the user for whom API keys should be returned.
     * @return API keys for the specified user.
     * @throws TerremarkException If an error occurs retrieving API keys.
     */
    ApiKeys getAPIKeys(String userId) throws TerremarkException;

    /**
     * This method returns information regarding a specified API key in an organization.
     * <p/>
     * Note: This is the only call in which the private key is presented.
     *
     * @param apiKeyId ID of the API key to retrieve.
     * @return API key with the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the API key.
     */
    ApiKey getAPIKeyByID(String apiKeyId) throws TerremarkException;

    /**
     * Returns information regarding the audit log. The audit log is a history of changes to the users in an
     * organization. Audit log entries are retained for twelve months.
     * <p/>
     * This call may include optional arguments. Permitted arguments are:
     * <table border="1">
     * <tr>
     * <th>Parameter</th>
     * <th>Usage</th>
     * </tr>
     * <tr>
     * <td>page</td>
     * <td>Use of page chunks the returned data and returns the requested page. Default = page 1</td>
     * </tr>
     * <tr>
     * <td>pageSize</td>
     * <td>Number of items returned per page between 1 and 1000. Default = 20</td>
     * </tr>
     * <tr>
     * <td>user</td>
     * <td>The {@code href} from the {@code User} by which to filter log entries selected</td>
     * </tr>
     * <tr>
     * <td>direction</td>
     * <td>
     * <ul>
     * <li>{@code asc} or {@code ascending} - Ascending
     * <li>{@code desc} or {@code descending} - Descending
     * <li>Default is {@code descending}
     * </ul>
     * </td>
     * </tr>
     * <tr>
     * <td>sortBy</td>
     * <td>All AuditLogItem elements are permitted as the sort key:
     * <ul>
     * <li>Date
     * <li>Name
     * <li>UserName
     * <li>Action
     * <li>Details
     * <li>Origin
     * <li>SourceIP
     * <li>Notes
     * </ul>
     * </td>
     * </tr>
     * <tr>
     * <td>startDate</td>
     * <td>Enter in ISO8601 format; time is always start of day and if entered is ignored. Default = earliest record</td>
     * </tr>
     * <tr>
     * <td>endDate</td>
     * <td>Enter in ISO8601 format; time is always end of day and if entered is ignored. Default = latest record</td>
     * </tr>
     * <tr>
     * <td>action</td>
     * <td>Action by which to filter log entries selected. Actions must be specified as:
     * <ul>
     * <li>IncorrectAnswer
     * <li>LoginFailed
     * <li>LoginSucceeded
     * </ul>
     * </td>
     * </tr>
     * </table>
     *
     * @param organizationId ID of the organization.
     * @param filterArguments Filter arguments. See description of this method. Can be null.
     * @return Audit log information.
     * @throws TerremarkException If an error occurs retrieving the audit log information.
     */
    AuditLog getAuditLog(String organizationId, Map<String, String> filterArguments) throws TerremarkException;

    /**
     * This call returns the periods for which bandwidth utilization is available. The available periods are the
     * previous twelve months or the beginning of service, whichever is less.
     *
     * @param organizationId ID of the organization.
     * @return Bandwidth periods.
     * @throws TerremarkException If an error occurs retrieving bandwidth periods.
     */
    BandwidthPeriods getBandwidthPeriod(String organizationId) throws TerremarkException;

    /**
     * This call returns bandwidth usage in the requested period. The historical usage contains monthly usage for the
     * previous twelve months or the beginning of service, whichever is less.
     *
     * @param organizationId ID of the organization.
     * @param yyyy Four digit year.
     * @param mm One or two digit period month
     * @return Bandwidth usage for the specified period.
     * @throws TerremarkException If an error occurs retrieving the bandwidth usage.
     */
    BandwidthUsage getBandwidthUsage(String organizationId, String yyyy, String mm) throws TerremarkException;

    /**
     * This call returns information regarding business operations defined in the Enterprise Cloud.
     * <p/>
     * {@code BusinessOperationType} refers to the level to which the business operation applies. Permitted values are:
     * <ul>
     * <li>Organization - Business operation applies to organizational operations
     * <li>Environment - Business operation applies to environmental operations
     * </ul>
     *
     * @param organizationId ID of the organization.
     * @return Business operations defined in Enterprise Cloud.
     * @throws TerremarkException If an error occurs business operations.
     */
    BusinessOperations getBusinessOperations(String organizationId) throws TerremarkException;

    /**
     * This method returns information regarding a specified business operation defined in the Enterprise Cloud.
     * <p/>
     * {@code BusinessOperationType} refers to the level to which the business operation applies. Permitted values are:
     * <ul>
     * <li>Organization - Business operation applies to organizational operations
     * <li>Environment - Business operation applies to environmental operations
     * </ul>
     *
     * @param businessOperationId ID of the business operation to retrieve.
     * @return Business operation for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the business operation.
     */
    BusinessOperation getBusinessOperationByID(String businessOperationId) throws TerremarkException;

    /**
     * This call returns information regarding the catalog for an organization at all locations.
     * <p/>
     * {@code Status} for {@code CatalogEntry} refers to the status of the catalog item or of the OVF file for the
     * virtual machine (VM). Permitted values are:
     * <ul>
     * <li>Active - The catalog item is created but no files are uploaded.
     * <li>Validated - OVF successfully validated and is waiting for the image file to upload.
     * <li>Failed - VM upload failed.
     * <li>Completed - VM has successfully completed the entire upload process and is available for import.
     * <li>Validating - OVF validation is in progress.
     * </ul>
     * <p/>
     * {@code Type} refers to {@code Alerts} created while uploading or exporting a virtual machine. Permitted values
     * are:
     * <ul>
     * <li>Info - the virtual machine has an informational note.
     * <li>Warning - the VM has a non-fatal potential issue, for example, processor count exceeds operating system
     * limits, an issue which can be corrected when importing.
     * <li>Error - VM has a fatal issue, for example, disk count exceeds limits.
     * </ul>
     * <p/>
     * {@code Name} for {@code File} refers to the filename of the OVF file and the VM images, the VMDK files. The name
     * for the OVF file is always upload.ovf. The name for any VMDK file is as entered in the OVF file.
     * <p/>
     * {@code Status} for {@code File} refers to the status of the upload for the OVF file and the VM images, the VMDK
     * files. Permitted values are:
     * <ul>
     * <li>Ready - File transfer has not yet begun.
     * <li>InProgress - File transfer is in progress.
     * <li>Failed - File transfer failed.
     * <li>Verified - File is verified.
     * <li>Completed - File transfer completed.
     * <li>Stopped - File transfer stopped by the user for later restart.
     * </ul>
     * <p/>
     * {@code ProcessorCount} refers to the number of processors in the virtual machine. Permitted values are: 1, 2, 4,
     * or 8.
     * <p/>
     * Note: A catalog item for which the OVF file is validating may not be removed.
     * <p/>
     * {@code CatalogType} refers to the source operation for the catalog item. Permitted values are:
     * <ul>
     * <li>Upload - Catalog item was uploaded to the catalog from the organization.
     * <li>Export - Catalog item was exported to the catalog from a virtual machine in the environment.
     * </ul>
     *
     * @param organizationId ID of the organization.
     * @return Catalog for the specified organization at all locations.
     * @throws TerremarkException If an error occurs retrieving the catalog.
     */
    Catalog getCatalog(String organizationId) throws TerremarkException;

    /**
     * This call returns information regarding a specified catalog item for an organization.
     * <p/>
     * {@code Status} for {@code CatalogEntry} refers to the status of the catalog item or of the OVF file for the
     * virtual machine (VM). Permitted values are:
     * <ul>
     * <li>Active - The catalog item is created but no files are uploaded.
     * <li>Validated - OVF successfully validated and is waiting for the image file to upload.
     * <li>Failed - VM upload failed.
     * <li>Completed - VM has successfully completed the entire upload process and is available for import.
     * <li>Validating - OVF validation is in progress.
     * </ul>
     * <p/>
     * {@code Type} refers to {@code Alerts} created while uploading or exporting a virtual machine. Permitted values
     * are:
     * <ul>
     * <li>Info - the virtual machine has an informational note.
     * <li>Warning - the VM has a non-fatal potential issue, for example, processor count exceeds operating system
     * limits, an issue which can be corrected when importing.
     * <li>Error - VM has a fatal issue, for example, disk count exceeds limits.
     * </ul>
     * <p/>
     * {@code Name} for {@code File} refers to the filename of the OVF file and the VM images, the VMDK files. The name
     * for the OVF file is always upload.ovf. The name for any VMDK file is as entered in the OVF file.
     * <p/>
     * {@code Status} for {@code File} refers to the status of the upload for the OVF file and the VM images, the VMDK
     * files. Permitted values are:
     * <ul>
     * <li>Ready - File transfer has not yet begun.
     * <li>InProgress - File transfer is in progress.
     * <li>Failed - File transfer failed.
     * <li>Verified - File is verified.
     * <li>Completed - File transfer completed.
     * <li>Stopped - File transfer stopped by the user for later restart.
     * </ul>
     * <p/>
     * {@code ProcessorCount} refers to the number of processors in the virtual machine. Permitted values are: 1, 2, 4,
     * or 8.
     * <p/>
     * Note: A catalog item for which the OVF file is validating may not be removed.
     * <p/>
     * {@code CatalogType} refers to the source operation for the catalog item. Permitted values are:
     * <ul>
     * <li>Upload - Catalog item was uploaded to the catalog from the organization.
     * <li>Export - Catalog item was exported to the catalog from a virtual machine in the environment.
     * </ul>
     *
     * @param catalogId ID of the catalog entry to retrieve.
     * @return Catalog entry for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the catalog entry.
     */
    CatalogEntry getCatalogByID(String catalogId) throws TerremarkException;

    /**
     * This method returns information regarding the catalog for an organization at a specified location.
     * <p/>
     * {@code Status} for {@code CatalogEntry} refers to the status of the catalog item or of the OVF file for the
     * virtual machine (VM). Permitted values are:
     * <ul>
     * <li>Active - The catalog item is created but no files are uploaded.
     * <li>Validated - OVF successfully validated and is waiting for the image file to upload.
     * <li>Failed - VM upload failed.
     * <li>Completed - VM has successfully completed the entire upload process and is available for import.
     * <li>Validating - OVF validation is in progress.
     * </ul>
     * <p/>
     * {@code Type} refers to {@code Alerts} created while uploading or exporting a virtual machine. Permitted values
     * are:
     * <ul>
     * <li>Info - the virtual machine has an informational note.
     * <li>Warning - the VM has a non-fatal potential issue, for example, processor count exceeds operating system
     * limits, an issue which can be corrected when importing.
     * <li>Error - VM has a fatal issue, for example, disk count exceeds limits.
     * </ul>
     * <p/>
     * {@code Name} for {@code File} refers to the filename of the OVF file and the VM images, the VMDK files. The name
     * for the OVF file is always upload.ovf. The name for any VMDK file is as entered in the OVF file.
     * <p/>
     * {@code Status} for {@code File} refers to the status of the upload for the OVF file and the VM images, the VMDK
     * files. Permitted values are:
     * <ul>
     * <li>Ready - File transfer has not yet begun.
     * <li>InProgress - File transfer is in progress.
     * <li>Failed - File transfer failed.
     * <li>Verified - File is verified.
     * <li>Completed - File transfer completed.
     * <li>Stopped - File transfer stopped by the user for later restart.
     * </ul>
     * <p/>
     * {@code ProcessorCount} refers to the number of processors in the virtual machine. Permitted values are: 1, 2, 4,
     * or 8.
     * <p/>
     * Note: A catalog item for which the OVF file is validating may not be removed.
     * <p/>
     * {@code CatalogType} refers to the source operation for the catalog item. Permitted values are:
     * <ul>
     * <li>Upload - Catalog item was uploaded to the catalog from the organization.
     * <li>Export - Catalog item was exported to the catalog from a virtual machine in the environment.
     * </ul>
     *
     * @param organizationId ID of the organization.
     * @param locationId ID of the location.
     * @return Catalog for the specified organization and location.
     * @throws TerremarkException If an error occurs retrieving the catalog.
     */
    Catalog getCatalogByLocation(String organizationId, String locationId) throws TerremarkException;

    /**
     * This call returns information regarding the configuration of a specified catalog item.
     * <p/>
     * Note: To retrieve the catalog configuration requires a catalog item to have {@code Status} with a value
     * {@code Validated} or {@code Completed}.
     *
     * @param catalogId ID of the catalog.
     * @return Catalog entry configuration of the specified catalog identifier.
     * @throws TerremarkException If an error occurs retrieving catalog configuration.
     */
    CatalogEntryConfiguration getCatalogConfiguration(String catalogId) throws TerremarkException;

    /**
     * This method returns information regarding the catalog log. The catalog log is a history of changes to the
     * catalog. Catalog log entries are retained for twelve months.
     * <p/>
     * This call may include optional arguments. Permitted arguments are:
     * <table border="1">
     * <tr>
     * <th>Parameter</th>
     * <th>Usage</th>
     * </tr>
     * <tr>
     * <td>page</td>
     * <td>Use of page chunks the returned data and returns the requested page. Default = 1</td>
     * </tr>
     * <tr>
     * <td>pageSize</td>
     * <td>Number of items returned per page between 1 and 1000. Default = 20</td>
     * </tr>
     * <tr>
     * <td>direction</td>
     * <td>
     * <ul>
     * <li>{@code asc} or {@code ascending} - Ascending
     * <li>{@code desc} or {@code descending} - Descending
     * <li>Default is {@code descending}
     * </ul>
     * </td>
     * </tr>
     * <tr>
     * <td>sortBy</td>
     * <td>All CatalogLogEntry elements are permitted as the sort key:
     * <ul>
     * <li>Date
     * <li>User
     * <li>Location
     * <li>CatalogEntry
     * <li>Event
     * <li>File
     * </ul>
     * </td>
     * </tr>
     * <tr>
     * <td>startDate</td>
     * <td>Enter in ISO8601 format. Time is always start of day and if entered is ignored. Default = earliest record</td>
     * </tr>
     * <tr>
     * <td>endDate</td>
     * <td>Enter in ISO8601 format. Time is always end of day and if entered is ignored. Default = latest record</td>
     * </tr>
     * </table>
     *
     * @param organizationId ID of the organization.
     * @param filterArguments Filter arguments. See description of this method. Can be null.
     * @return Catalog log information.
     * @throws TerremarkException If an error occurs retrieving the catalog log information.
     */
    CatalogLog getCatalogLog(String organizationId, Map<String, String> filterArguments) throws TerremarkException;

    /**
     * This method returns information regarding the contacts for an organization.
     *
     * @param organizationId ID of the organization.
     * @return Contacts for the specified organization.
     * @throws TerremarkException If an error occurs retrieving the contacts.
     */
    Contacts getContacts(String organizationId) throws TerremarkException;

    /**
     * This call returns information regarding a specified contact for an organization.
     *
     * @param contactId ID of the contact to retrieve.
     * @return Contact for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the contact.
     */
    Contact getContactByID(String contactId) throws TerremarkException;

    /**
     * This method returns information regarding environments in a specified organization. The returned environments
     * contain the twenty most recent tasks for the environment.
     *
     * @param organizationId ID of the organization.
     * @return Environments in the specified organization.
     * @throws TerremarkException If an error occurs retrieving the environments.
     */
    Environments getEnvironments(String organizationId) throws TerremarkException;

    /**
     * This call returns information regarding a single environment. The returned environment contains the twenty most
     * recent tasks in the environment.
     *
     * @param environmentId ID of the environment.
     * @return The environment for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the environment.
     */
    Environment getEnvironmentByID(String environmentId) throws TerremarkException;

    /**
     * Returns information regarding a single data center location.
     *
     * @param locationId ID of the location.
     * @return Location for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the location information.
     */
    Location getLocationByID(String locationId) throws TerremarkException;

    /**
     * Returns all organizations the caller has access to.
     *
     * @return All organizations the caller has access to.
     * @throws TerremarkException If an error occurs retrieving organizations.
     */
    Organizations getOrganizations() throws TerremarkException;

    /**
     * This call returns information regarding a single organization. The response to this call is similar to that of
     * the Get Organizations call but limited to the requested organization. This call differs in response from
     * {@link #getOrganizations()} only for reseller organizations.
     *
     * @param organizationId ID of the organization.
     * @return Organization for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the organization.
     */
    Organization getOrganizationByID(String organizationId) throws TerremarkException;

    /**
     * This returns information regarding the roles for an organization.
     * <p/>
     * {@code Status} refers to the status of the role. Permitted values are:
     * <ul>
     * <li>{@code Active} - Role is available for use
     * <li>{@code Inactive} - Role is not available for use
     * </ul>
     * <p/>
     * {@code RoleType} refers to the level to which the role applies. Permitted values are:
     * <ul>
     * <li>{@code Organization} - Role applies to organizational business operations
     * <li>{@code Environment} - Role applies to environmental business operations
     * </ul>
     * <p/>
     * {@code Category} refers to the definitional control of the role. Permitted values are:
     * <ul>
     * <li>{@code System} - Role is defined by the Enterprise Cloud and may not be modified
     * <li>{@code Custom} - Role is defined by the organization and may be modified
     * </ul>
     *
     * @param organizationId ID of the organization.
     * @return Roles for the specified organization.
     * @throws TerremarkException If an error occurs retrieving the roles.
     */
    Roles getRoles(String organizationId) throws TerremarkException;

    /**
     * This method returns information regarding a specified role in an organization.
     * <p/>
     * {@code RoleType} refers to the level to which the role applies. Permitted values are:
     * <ul>
     * <li>{@code Organization} - Role applies to organizational business operations
     * <li>{@code Environment} - Role applies to environmental business operations
     * </ul>
     * <p/>
     * {@code Category} refers to the definitional control of the role. Permitted values are:
     * <ul>
     * <li>{@code System} - Role is defined by the Enterprise Cloud and may not be modified
     * <li>{@code Custom} - Role is defined by the organization and may be modified
     * </ul>
     *
     * @param roleId ID of the role to retrieve.
     * @return Role for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the role.
     */
    Role getRoleByID(String roleId) throws TerremarkException;

    /**
     * This call returns information regarding the roles assigned to a specified user in an organization. Every
     * {@code Environment} for an organization is listed under {@code UserRole}, including environments which are
     * inactive or STARed or otherwise inaccessible to normal use. However, billing information remains available for
     * some time after an environment becomes inaccessible. Inaccessible environments may have roles assigned to view
     * billing.
     * <p/>
     * Note: Absence of {@code OrganizationRole} or of a {@code Role} in an {@code EnvironmentRole} indicates no access
     * permitted to the organization level or to that environment, respectively.
     *
     * @param userId ID of the user for whom roles should be returned.
     * @return User role information.
     * @throws TerremarkException If an error occurs retrieving roles for the specified user.
     */
    UserRole getRolesByUser(String userId) throws TerremarkException;

    /**
     * This method returns information regarding the SSH keys for an organization.
     *
     * @param organizationId ID of the organization.
     * @return SSH keys in the specified organization.
     * @throws TerremarkException If an error occurs retrieving the SSH keys in the specified organization.
     */
    SshKeys getSSHKeys(String organizationId) throws TerremarkException;

    /**
     * This method returns information regarding a specified SSH key for an organization.
     *
     * @param sshKeyId ID of the SSH key.
     * @return SSH key for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the SSH key.
     */
    SshKey getSSHKeyByID(String sshKeyId) throws TerremarkException;

    /**
     * This call returns references to obtain the open and closed support tickets for a specified organization.
     *
     * @param organizationId ID of the organization.
     * @return Support tickets for the specified organization.
     * @throws TerremarkException If an error occurs retrieving the support tickets.
     */
    TicketGroups getSupportTickets(String organizationId) throws TerremarkException;

    /**
     * This method returns active support tickets for a specified organization.
     *
     * @param organizationId ID of the organization.
     * @return Active support tickets for the specified organization.
     * @throws TerremarkException If an error occurs retrieving the support tickets.
     */
    Tickets getActiveSupportTickets(String organizationId) throws TerremarkException;

    /**
     * This method returns a specified support ticket.
     *
     * @param ticketId ID of the support ticket to retrieve.
     * @return Ticket for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the support ticket.
     */
    Ticket getSupportTicketByID(String ticketId) throws TerremarkException;

    /**
     * This call returns support tickets closed within the preceding 90 days for a specified organization.
     *
     * @param organizationId ID of the organization.
     * @return Support tickets closed in the past 90 days.
     * @throws TerremarkException If an error occurs retrieving the support tickets.
     */
    Tickets getSupportTicketsHistory(String organizationId) throws TerremarkException;

    /**
     * This method returns information regarding tags in a specified organization.
     *
     * @param organizationId ID of the organization.
     * @return Tags in the specified organization.
     * @throws TerremarkException If an error occurs retrieving the tags.
     */
    DeviceTagList getTags(String organizationId) throws TerremarkException;

    /**
     * Method returns information regarding all users in an organization.
     * <p/>
     * {@code Status} reflects whether the user or API key is active. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is active and permitted access.
     * <li>{@code Inactive} - user is inactive and no longer permitted access.
     * </ul>
     * <p/>
     * {@code LoginStatus} reflects the current status of the user’s access. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is able to log in.
     * <li>{@code LockedOut} - user has exceeded the permitted attempts to log in.
     * <li>{@code AccountReset} - user’s account has been reset and user has not yet performed the registration steps.
     * </ul>
     * <p/>
     * Every {@code Environment} for an organization is listed under {@code UserRole}, including environments which are
     * inactive or STARed or otherwise inaccessible to normal use. However, billing information remains available for
     * some time after an environment becomes inaccessible. Inaccessible environments may have roles assigned to view
     * billing.
     *
     * @param organizationId ID of the organization.
     * @return Users in the specified organization.
     * @throws TerremarkException If an error occurs retrieving the users.
     */
    Users getUsers(String organizationId) throws TerremarkException;

    /**
     * This call returns information regarding a specified user in an organization.
     * <p/>
     * {@code Status} reflects whether the user or API key is active. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is active and permitted access.
     * <li>{@code Inactive} - user is inactive and no longer permitted access.
     * </ul>
     * <p/>
     * {@code LoginStatus} reflects the current status of the user’s access. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is able to log in.
     * <li>{@code LockedOut} - user has exceeded the permitted attempts to log in.
     * <li>{@code AccountReset} - user’s account has been reset and user has not yet performed the registration steps.
     * </ul>
     * <p/>
     * Every {@code Environment} for an organization is listed under {@code UserRole}, including environments which are
     * inactive or STARed or otherwise inaccessible to normal use. However, billing information remains available for
     * some time after an environment becomes inaccessible. Inaccessible environments may have roles assigned to view
     * billing.
     * <p/>
     * Note: Absence of {@code OrganizationRole} or of a {@code Role} in an {@code EnvironmentRole} indicates no access
     * permitted to the organization level or to that environment, respectively.
     *
     * @param userId ID of the user to retrieve.
     * @return User for the specified identifier..
     * @throws TerremarkException If an error occurs retrieving the user.
     */
    User getUserByID(String userId) throws TerremarkException;

    /**
     * This method returns information regarding the credentials for a specified user in an organization. As part of the
     * user credentials, the user must provide answers to six security questions: three defined by the Enterprise Cloud,
     * where {@code IsCustom} is {@code false}, and three defined by the user, where {@code IsCustom} is {@code true}.
     * <p/>
     * Note: When used, the three questions where {@code IsCustom} is {@code false} must be submitted exactly as
     * presented in the response to {@link #getUserSecurityQuestions()}. If any of the questions in the response to that
     * call is altered or presented with {@code IsCustom} is {@code true}, an error is returned.
     *
     * @param userId ID of the user..
     * @return User credentials.
     * @throws TerremarkException If the error occurs retrieving user credentials.
     */
    UserCredentials getUserCredentials(String userId) throws TerremarkException;

    /**
     * This call returns information regarding the security questions defined by the Enterprise Cloud that are available
     * to the user in an organization. As part of the user credentials, the user must provide answers to six security
     * questions: three defined by the Enterprise Cloud and three defined by the user.
     * <p/>
     * Note: When used in {@link #userCredentialsEdit(String, UserCredentials)} the system-defined question must be
     * entered exactly as returned in the response of this call. If the question is altered or presented as a
     * user-defined secret question, an error is returned.
     *
     * @return User security questions.
     * @throws TerremarkException If an error occurs retrieving security questions.
     */
    Questions getUserSecurityQuestions() throws TerremarkException;

    /**
     * This call creates a custom role in an organization. If successful, the call returns information regarding the
     * role that was created.
     * <p/>
     * {@code Name} is required and may not exceed thirty characters.
     * <p/>
     * {@code Status} is optional. If not present, status is set to {@code Inactive}.
     * <p/>
     * {@code BusinessOperations} and at least one {@code BusinessOperation} is required.
     *
     * @param organizationId ID of the organization.
     * @param obj Create role request.
     * @return The newly created role.
     * @throws TerremarkException If an error occurs creating the role.
     */
    Role roleCreate(String organizationId, CreateRole obj) throws TerremarkException;

    /**
     * Disables a role in an organization. If successful, the call returns information regarding the role that was
     * disabled.
     * <p/>
     * Note: To enable a role, the role must have {@code Active} is {@code true}.
     * <p/>
     * Note: The role must have no users assigned to disable.
     *
     * @param roleId ID of the role to disable.
     * @return Disabled role.
     * @throws TerremarkException If an error occurs disabling the role.
     */
    Role roleDisable(String roleId) throws TerremarkException;

    /**
     * This method edits a custom role in an organization. If successful, the call returns information regarding the
     * role that was modified.
     * <p/>
     * The {@code name} on {@code Role} is required and may be changed.
     * <p/>
     * Note: The name may not be changed to that of another role and may not exceed thirty characters.
     * <p/>
     * {@code RoleType}, {@code Active}, {@code Category}, and {@code IsAdmin} are optional and ignored if present.
     * <p/>
     * Note: To change the value of {@code Active}, use {@link #roleEnable(String)} or {@link #roleDisable(String)}.
     * <p/>
     * {@code BusinessOperations} and at least one {@code BusinessOperation} is required. Including a
     * {@code BusinessOperation} not currently on the role adds that business operation to the role.
     * <p/>
     * Note: If a {@code BusinessOperation} exists on the role and is not present in the call, that business operation
     * is removed from the role.
     *
     * @param obj Role with updated information.
     * @return Updated role.
     * @throws TerremarkException If an error occurs updating the role.
     */
    Role roleEdit(Role obj) throws TerremarkException;

    /**
     * This call edits the roles assigned to a specified user in an organization. If successful, the call returns
     * information regarding the user that was modified.
     * <p/>
     * Note: Absence of {@code OrganizationRole} or of a {@code Role} in an {@code EnvironmentRole} indicates no access
     * permitted to the organization level or to that environment, respectively.
     * <p/>
     * {@code OrganizationRole} is optional. Including an {@code OrganizationRole} not currently on the user adds that
     * organization role to the user.
     * <p/>
     * Note: If a user has an organization role and the {@code OrganizationRole} is not present in the call, the
     * organization role is removed from the user.
     * <p/>
     * Both {@code EnvironmentRoles} and {@code EnvironmentRole} are optional. Including a {@code Role} with an
     * {@code Environment} (under an {@code EnvironmentRole}) not currently on the user adds that environment role in
     * that environment to the user. If an {@code EnvironmentRole} (with an {@code Environment} and a {@code Role}) is
     * not present in the call but present on the user, that environment role is unchanged. If an
     * {@code EnvironmentRole} has an {@code Environment} but the {@code Role} is absent and the environment role is
     * present on the user, that environment role is removed in that environment from the user.
     *
     * @param userId ID of the user.
     * @param obj New user role information.
     * @return Updated user role information.
     * @throws TerremarkException If an error occurs modifying the user roles.
     */
    UserRole roleEditUser(String userId, UserRole obj) throws TerremarkException;

    /**
     * Method enables a role in an organization. If successful, the call returns information regarding the role that was
     * enabled.
     * <p/>
     * Note: To enable a role, the role must have {@code Active} set to {@code false}.
     *
     * @param roleId ID of the role to enable.
     * @return Role that is enabled.
     * @throws TerremarkException If an error occurs enabling the role.
     */
    Role roleEnable(String roleId) throws TerremarkException;

    /**
     * Removes a custom role from an organization.
     * <p/>
     * Note: The role must have no users assigned to remove.
     *
     * @param roleId ID of the role to remove.
     * @throws TerremarkException If an error occurs removing the role.
     */
    void roleRemove(String roleId) throws TerremarkException;

    /**
     * Creates a new SSH key. If successful, the call returns information regarding the SSH key that was created.
     * {@code name} on {@code CreateSshKey} is required.
     * <p/>
     * Note: The name may not be that of another SSH key and may not exceed fifty characters.
     * <p/>
     * {@code Default} is optional. If absent and this is the first key being created for an organization, it defaults
     * to true, otherwise false.
     * <p/>
     * {@code FingerPrint} is the SSH key finger print, which is a 16 byte hash of the private key.
     * <p/>
     * {@code PrivateKey} is the actual private key, which has been encoded by bas64.
     *
     * @param organizationId ID of the organization.
     * @param obj Create SSH key request.
     * @return SSH key that was created.
     * @throws TerremarkException If an error occurs creating the SSH key.
     */
    SshKey sshKeyCreate(String organizationId, CreateSshKey obj) throws TerremarkException;

    /**
     * Edits the name of the SSH key. If successful, the call returns information regarding the SSH key that was
     * modified.
     * <p/>
     * {@code name} on {@code SshKey} may be changed.
     * <p/>
     * Note: The name may not be changed to that of another SSH key and may not exceed fifty characters.
     * <p/>
     * {@code FingerPrint} is optional and ignored if present.
     * <p/>
     * Note: The default SSH key may not be modified to {@code Default} set to {@code false}. Instead, modify the SSH
     * key desired as the default and set {@code Default} to {@code true}. And the existing default SSH key will be
     * automatically modified.
     *
     * @param obj SSH key to edit.
     * @return Updated SSH key.
     * @throws TerremarkException If an error occurs updating the SSH key.
     */
    SshKey sshKeyEdit(SshKey obj) throws TerremarkException;

    /**
     * Removes a specified SSH key from an organization.
     * <p/>
     * Note: The default SSH key may not be removed. To remove it, make a different key the default, then remove it.
     *
     * @param sshKeyId ID of the SSH key to remove.
     * @throws TerremarkException If an error occurs removing the SSH key.
     */
    void sshKeysRemove(String sshKeyId) throws TerremarkException;

    /**
     * Creates a new support ticket for a specified organization. The information in the call is submitted
     * asynchronously to the support system.
     * <p/>
     * {@code Email} is required and must match an email contact method for a contact in the organization.
     * <p/>
     * Both {@code Subject} and {@code Details} are required.
     *
     * @param organizationId ID of the organization.
     * @param obj Create ticket request.
     * @throws TerremarkException If an error occurs creating the support ticket.
     */
    void supportTicketCreate(String organizationId, CreateTicket obj) throws TerremarkException;

    /**
     * Creates a user in an organization. If successful, the call returns information regarding the user that was
     * created.
     * <p/>
     * Note: The call will return an error if the user has already been created.
     * <p/>
     * {@code CreateUser} has two variations. Only one of the two variations is permitted in a call:
     * <p/>
     * <ul>
     * <li>Create from a company contact. Contacts may be retrieved with {@link #getContacts(String)} or
     * {@link #getContactByID(String)}.
     * <p/>
     * The name on {@code CreateUser} is not used.
     * <p/>
     * {@code Contact} is required.
     * <p/>
     * <li>Create a new user.
     * <p/>
     * The {@code name} on {@code CreateUser} is required and is the email address of the user.
     * <p/>
     * Note: The name may not be that of another user.
     * <p/>
     * {@code FirstName} and {@code LastName} are required.
     * <p/>
     * </ul>
     * <p/>
     * {@code Password} is required and must meet password complexity rules, if enabled. Use
     * {@link #getAdministrativeOrganizationByID(String)} to retrieve password complexity rules, if required.
     * <p/>
     * Users must have at least one role, either an organization role or an environment role, to access the system.
     * Users may have one organization role. Users need not have a role in every environment but may have only one role
     * in any environment and may be different for each environment. Use {@link #getRoles(String)} or
     * {@link #getRoleByID(String)} to retrieve available roles.
     * <p/>
     * {@code OrganizationRole} is optional.
     * <p/>
     * {@code EnvironmentRoles} is optional but if present must have at least one {@code EnvironmentRole} subordinate
     * element.
     * <p/>
     * {@code EnvironmentRole} is optional but if present must have all subordinate elements present and valued.
     * <p/>
     * Note: Only one {@code Role} may be assigned to each environment and may be different for each environment.
     * <p/>
     * {@code UserSecurityQuestions} is required with exactly six {@code SecurityQuestion} subordinate elements. The
     * first three security questions must be selected from the available system-defined security questions. Use
     * {@link #getUserSecurityQuestions()} to retrieve available security questions. The last three must be user-defined
     * security questions. No security questions may be repeated. No user-defined security question may be a
     * system-defined security question.
     * <p/>
     * {@code MultifactorAuthentication} is optional. If present, {@code CountryCode}, {@code PrimaryPhone}, and
     * {@code Pin} are required. Other fields are optional. If {@code BackupPhone} is present then
     * {@code BackupCountryCode} is required. If {@code BackupExtension} is present then {@code BackupCountryCode} and
     * {@code BackupPhone} are required. If present, multifactor authentication will be enabled on the user.
     * <p/>
     * Note: If {@code MultifactorAuthentication} is used, a multifactor authentication license must be available. Use
     * {@link #getAdministrativeOrganizationByID(String)} to retrieve available multifactor authentication licenses.
     * <p/>
     * {@code Status} reflects whether the user is active. Permitted values are:
     * <p/>
     * <ul>
     * <li>{@code Active} - user is active and permitted access.
     * <li>{@code Inactive} - user is inactive and no longer permitted access.
     * </ul>
     * <p/>
     * {@code LoginStatus} reflects the current status of the user’s access. Permitted values are:
     * <p/>
     * <ul>
     * <li>{@code Active} - user is able to log in.
     * <li>{@code LockedOut} - user has exceeded the permitted attempts to log in.
     * <li>{@code AccountReset} - user’s account has been reset and user has not yet performed the registration steps.
     * </ul>
     *
     * @param organizationId ID of the organization.
     * @param obj Create user request.
     * @return The newly created user.
     * @throws TerremarkException If an error occurs creating the user.
     */
    User userCreate(String organizationId, CreateUser obj) throws TerremarkException;

    /**
     * Creates an API user in an organization. If successful, the call returns information regarding the user that was
     * created.
     * <p/>
     * Note: The call will return an error if the user has already been created.
     * <p/>
     * {@code FirstName} is required and need not be unique.
     * <p/>
     * Note: {@code LastName} is not available for API users as the family name is designated as "API User" for all API
     * users.
     * <p/>
     * Users must have at least one role, either an organization role or an environment role, to access the system.
     * Users may have one organization role. Users need not have a role in every environment but may have only one role
     * in any environment and may be different for each environment. Use {@link #getRoles(String)} and
     * {@link #getRolesByUser(String)} to retrieve available roles.
     * <p/>
     * {@code OrganizationRole} is optional.
     * <p/>
     * {@code EnvironmentRoles} is optional but if present must have at least one {@code EnvironmentRole} subordinate
     * element.
     * <p/>
     * {@code EnvironmentRole} is optional but if present must have all subordinate elements present and valued.
     * <p/>
     * Note: Only one {@code Role} may be assigned to each environment and may be different for each environment.
     * <p/>
     * {@code Status} reflects whether the user or API key is active. Permitted values are:
     * <p/>
     * <ul>
     * <li>Active - user is active and permitted access.
     * <li>Inactive - user is inactive and no longer permitted access.
     * </ul>
     * <p/>
     * {@code LoginStatus} reflects the current status of the user’s access. Permitted values are:
     * <p/>
     * <ul>
     * <li>Active - user is able to log in.
     * <li>LockedOut - user has exceeded the permitted attempts to log in.
     * <li>AccountReset - user’s account has been reset and user has not yet performed the registration steps.
     * </ul>
     *
     * @param organizationId ID of the organization.
     * @param obj Create API user request.
     * @return The newly created API user.
     * @throws TerremarkException If an error occurs creating API user.
     */
    User userCreateAPIUser(String organizationId, CreateApiUser obj) throws TerremarkException;

    /**
     * Disables a user in an organization. If successful, the call returns information regarding the user that was
     * disabled.
     * <p/>
     * Note: To disable requires {@code Status} to have a value of {@code Active}.
     * <p/>
     * {@code Status} reflects whether the user is active. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is active and permitted access.
     * <li>{@code Inactive} - user is inactive and no longer permitted access.
     * </ul>
     * <p/>
     * Note: This call sets {@code Status} to {@code Inactive}. {@code LoginStatus} reflects the current status of the
     * user’s access. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is able to log in.
     * <li>{@code LockedOut} - user has exceeded the permitted attempts to log in.
     * <li>{@code AccountReset} - user’s account has been reset and user has not yet performed the registration steps.
     * </ul>
     *
     * @param userId ID of the user to disable.
     * @return Disabled user.
     * @throws TerremarkException If an error occurs disabling the user.
     */
    User userDisableAccount(String userId) throws TerremarkException;

    /**
     * Disables email notification of events for a user in an organization. If successful, the call returns information
     * regarding the user for whom alerts were disabled.
     * <p/>
     * Note: Only the user may change their email notification.
     * <p/>
     * Note: To disable alerts the user must have {@code IsAlertNotificationEnabled} set to {@code true}.
     *
     * @param userId ID of the user to disable alerts for.
     * @return Modified user.
     * @throws TerremarkException If an error occurs disabling the alerts.
     */
    User userDisableAlerts(String userId) throws TerremarkException;

    /**
     * Disables multifactor authentication for a user in an organization. If successful, the call returns information
     * regarding the user with multifactor authentication that was disabled.
     * <p/>
     * Note: To disable multifactor authentication the user must have multifactor authentication enabled.
     * <p/>
     * Note: Disabling multifactor authentication for a user will return one multifactor authentication license to the
     * organization.
     * <p/>
     * {@code Status} reflects whether the user is active. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is active and permitted access.
     * <li>{@code Inactive} - user is inactive and no longer permitted access.
     * </ul>
     * <p/>
     * Note: This call sets {@code Status} to {@code Inactive}. {@code LoginStatus} reflects the current status of the
     * user’s access. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is able to log in.
     * <li>{@code LockedOut} - user has exceeded the permitted attempts to log in.
     * <li>{@code AccountReset} - user’s account has been reset and user has not yet performed the registration steps.
     * </ul>
     *
     * @param userId ID of the user for whom multifactor authentication should be disabled.
     * @return Modified user.
     * @throws TerremarkException If an error occurs disabling the multifactor authentication for the user.
     */
    User userDisableMultifactor(String userId) throws TerremarkException;

    /**
     * Edits the first name (given name), last name (family name), assigned roles, and multifactor authentication
     * parameters of a user in an organization. If successful, the call returns information regarding the user that was
     * modified.
     * <p/>
     * The {@code name} on {@code User} is required, is the email address of the user for a regular user and is the
     * family name and given name separated by a comma plus space for an API user, and may not be changed.
     * <p/>
     * Note: {@code FirstName} may be changed. When {@code IsApiUser} is {@code true}, the {@code name} on {@code User}
     * will also change.
     * <p/>
     * Note: {@code LastName} may not be changed when {@code IsApiUser} is {@code true}.
     * <p/>
     * {@code Status} is optional and ignored if present. This may be changed only using
     * {@link #userEnableAccount(String)} and {@link #userDisableAccount(String)}.
     * <p/>
     * {@code LoginStatus} is optional and ignored if present. This element may be changed only to {@code AccountReset}
     * using {@link #userResetAccount(String)}.
     * <p/>
     * This call modifies the roles assigned to a user in the same manner as {@link #roleEditUser(String, UserRole)}.
     * <p/>
     * Users must have at least one role, either an organization role or an environment role, to access the system.
     * Users may have one organization role. Users need not have a role in every environment but may have only one role
     * in any environment and may be different for each environment. Use {@link #getRoles(String)} and
     * {@link #getRoleByID(String)} to retrieve available roles.
     * <p/>
     * Note: Absence of {@code OrganizationRole} or of a {@code Role} in an {@code EnvironmentRole} indicates no access
     * permitted to the organization level or to that environment, respectively.
     * <p/>
     * {@code OrganizationRole} is optional. Including an {@code OrganizationRole} not currently on the user adds that
     * organization role to the user.
     * <p/>
     * Note: If a user has an organization role and the {@code OrganizationRole} is not present in the call, the
     * organization role is removed from the user.
     * <p/>
     * Both {@code EnvironmentRoles} and {@code EnvironmentRole} are optional. Including a {@code Role} with an
     * {@code Environment} (under an {@code EnvironmentRole}) not currently on the user adds that environment role in
     * that environment to the user. If an {@code EnvironmentRole} (with an {@code Environment} and a {@code Role}) is
     * not present in the call but present on the user, that environment role is unchanged. If an
     * {@code EnvironmentRole} has an {@code Environment} but the {@code Role} is absent and the environment role is
     * present on the user, that environment role is removed in that environment from the user.
     * <p/>
     * This call can modify the multifactor authentication parameters, if multifactor authentication is enabled and
     * {@code MultifactorAuthentication} is present, in the same manner as
     * {@link #userEnableMultifactor(String, MultifactorAuthentication)}.
     * <p/>
     * {@code MultifactorAuthentication} is optional. If present and multifactor authentication is enabled for the user,
     * the country code and primary phone are required. Other subordinate elements are optional. If {@code BackupPhone}
     * is present then {@code BackupCountryCode} is required. If {@code BackupExtension} is present then
     * {@code BackupCountryCode} and {@code BackupPhone} are required. If present and multifactor authentication is
     * disabled for the user, multifactor authentication information is ignored.
     * <p/>
     * Note: If the user has multifactor authentication enabled and any optional subordinate elements are present in the
     * call and not on the user account, that element is added to the user account. Similarly, if the user has
     * multifactor authentication enabled and any optional subordinate elements are absent in the call and present on
     * the user account, that element is removed from the user account.
     * <p/>
     * {@code Status} reflects whether the user is active. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is active and permitted access.
     * <li>{@code Inactive} - user is inactive and no longer permitted access.
     * </ul>
     * <p/>
     * Note: This call sets {@code Status} to {@code Inactive}. {@code LoginStatus} reflects the current status of the
     * user’s access. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is able to log in.
     * <li>{@code LockedOut} - user has exceeded the permitted attempts to log in.
     * <li>{@code AccountReset} - user’s account has been reset and user has not yet performed the registration steps.
     * </ul>
     *
     * @param obj User with updated information.
     * @return Modified user object.
     * @throws TerremarkException If an error occurs updating the user account.
     */
    User userEdit(User obj) throws TerremarkException;

    /**
     * Edits the first (given) name, last (family) name, password, and security questions of the credentials for a
     * specified user in an organization. If successful, the call returns information regarding the user that was
     * modified.
     * <p/>
     * Note: Only the user may change their credentials.
     * <p/>
     * {@code FirstName} and {@code LastName} are required.
     * <p/>
     * {@code Password} is optional.
     * <p/>
     * {@code UserSecurityQuestions} is required and must have all subordinate elements present. Three questions must be
     * from the predefined list and three must be created by the user. No security question may be repeated and no
     * answer may be repeated. Questions may not exceed one hundred characters and answers may not exceed twenty-five
     * characters. Use {@link #getUserSecurityQuestions()} to retrieve the predefined secret questions available to the
     * user. The security questions with {@code IsCustom} set to {@code false} must exactly match the predefined
     * question as presented in the response to {@link #getUserSecurityQuestions()} if the question is altered an error
     * is returned. The security questions with {@code IsCustom} set to {@code true} must not use any question presented
     * in the response to {@link #getUserSecurityQuestions()}. If used an error is returned.
     *
     * @param userId ID of the user to edit credentials for.
     * @param obj User credentials.
     * @return Updated user credentials.
     * @throws TerremarkException If an error occurs updating the users credentials.
     */
    UserCredentials userCredentialsEdit(String userId, UserCredentials obj) throws TerremarkException;

    /**
     * Enables a user in an organization. If successful, the call returns information regarding the user that was
     * enabled.
     * <p/>
     * Note: To enable requires {@code Status} to have a value of {@code Inactive}.
     * <p/>
     * {@code Status} reflects whether the user is active. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is active and permitted access.
     * <li>{@code Inactive} - user is inactive and no longer permitted access.
     * </ul>
     * <p/>
     * Note: This call sets {@code Status} to {@code Inactive}. {@code LoginStatus} reflects the current status of the
     * user’s access. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is able to log in.
     * <li>{@code LockedOut} - user has exceeded the permitted attempts to log in.
     * <li>{@code AccountReset} - user’s account has been reset and user has not yet performed the registration steps.
     * </ul>
     *
     * @param userId ID of the user to enable.
     * @return Enabled user object.
     * @throws TerremarkException If an error occurs enabling the user account.
     */
    User userEnableAccount(String userId) throws TerremarkException;

    /**
     * Enables email notification of events for a user in an organization. If successful, the call returns information
     * regarding the user for whom alerts were enabled.
     * <p/>
     * Note: Only the user may change their email notification.
     * <p/>
     * Note: To enable alerts the user must have {@code IsAlertNotificationEnabled} set to {@code false}.
     *
     * @param userId ID of the user to enable alerts for.
     * @return Modified user object.
     * @throws TerremarkException If an error occurs enabling alerts for the user.
     */
    User userEnableAlerts(String userId) throws TerremarkException;

    /**
     * Enables multifactor authentication for a user in an organization. If successful, the call returns information
     * regarding the user with multifactor authentication that was enabled.
     * <p/>
     * Note: To enable multifactor authentication the user must have multifactor authentication disabled.
     * <p/>
     * Note: Enabling multifactor authentication for a user will consume one multifactor authentication license in the
     * organization.
     * <p/>
     * {@code CountryCode} and {@code PrimaryPhone} are required. Other subordinate elements are optional. If
     * {@code BackupPhone} is present then {@code BackupCountryCode} is required. If {@code BackupExtension} is present
     * then {@code BackupCountryCode} and {@code BackupPhone} are required.
     * <p/>
     * Note: To enable, a multifactor authentication license must be available. Use
     * {@link #getAdministrativeOrganizationByID(String)} to retrieve available multifactor authentication licenses.
     * <p/>
     * Note: If any optional subordinate elements are present in the call and not present on the user account, that
     * element is added to the user account. Similarly, if any optional subordinate elements are absent in the call and
     * present on the user account, that element is removed from the user account.
     * <p/>
     * {@code Status} reflects whether the user is active. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is active and permitted access.
     * <li>{@code Inactive} - user is inactive and no longer permitted access.
     * </ul>
     * <p/>
     * Note: This call sets {@code Status} to {@code Inactive}. {@code LoginStatus} reflects the current status of the
     * user’s access. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is able to log in.
     * <li>{@code LockedOut} - user has exceeded the permitted attempts to log in.
     * <li>{@code AccountReset} - user’s account has been reset and user has not yet performed the registration steps.
     * </ul>
     *
     * @param userId ID of the user to enable multifactor authentication for.
     * @param obj Multifactor authentication information.
     * @return Updated user object.
     * @throws TerremarkException If an error occurs enabling the user account for multifactor authentication.
     */
    User userEnableMultifactor(String userId, MultifactorAuthentication obj) throws TerremarkException;

    /**
     * Invites a user to an organization.
     * <p/>
     * {@code InviteUser} has two variations. Only one of the two variations is permitted in a call:
     * <ul>
     * <li>Invite from a company contact. Contacts may be retrieved with {@link #getContacts(String)} or
     * {@link #getContactByID(String)}.
     * <p/>
     * The {@code name} on {@code InviteUser} is not used.
     * <p/>
     * {@code Contact} is required.
     * <p/>
     * <li>Invite a new user. The {@code name} on {@code InviteUser} is required and is the email address of the user.
     * <p/>
     * Note: The name may not be that of another user.
     * <p/>
     * {@code FirstName} and {@code LastName} are required.
     * </ul>
     * <p/>
     * Users must have at least one role, either an organization role or an environment role, to access the system.
     * Users may have one organization role. Users need not have a role in every environment but may have only one role
     * in any environment and may be different for each environment. Use {@link #getRoles(String)} and
     * {@link #getRoleByID(String)} to retrieve available roles.
     * <p/>
     * {@code OrganizationRole} is optional.
     * <p/>
     * {@code EnvironmentRoles} is optional but if present must have at least one {@code EnvironmentRole} subordinate
     * element.
     * <p/>
     * {@code EnvironmentRole} is optional but if present must have all subordinate elements present.
     * <p/>
     * Note: Only one {@code Role} may be assigned to each environment and may be different for each environment.
     * <p/>
     * Multifactor authentication is optional. If present, the country code and primary phone are required, other
     * subordinate elements are optional.
     * <p/>
     * {@code Status} reflects whether the user is active. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is active and permitted access.
     * <li>{@code Inactive} - user is inactive and no longer permitted access.
     * </ul>
     * <p/>
     * Note: This call sets {@code Status} to {@code Inactive}. {@code LoginStatus} reflects the current status of the
     * user’s access. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is able to log in.
     * <li>{@code LockedOut} - user has exceeded the permitted attempts to log in.
     * <li>{@code AccountReset} - user’s account has been reset and user has not yet performed the registration steps.
     * </ul>
     *
     * @param organizationId ID of the organization.
     * @param obj Invitation request.
     * @throws TerremarkException If an error occurs inviting the user.
     */
    void userInvite(String organizationId, InviteUser obj) throws TerremarkException;

    /**
     * Removes a user from an organization.
     *
     * @param userId ID of the user to remove.
     * @throws TerremarkException If an error occurs removing the user.
     */
    void userRemove(String userId) throws TerremarkException;

    /**
     * Resets a user in an organization. If successful, the call returns information regarding the user that was reset.
     * <p/>
     * Note: Resetting a user sets the user account back to the initial state and sends a new invitation email. The user
     * must then perform the registration process to establish their account again. A user may be reset only if
     * {@code Status} is {@code Active}.
     * <p/>
     * {@code Status} reflects whether the user is active. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is active and permitted access.
     * <li>{@code Inactive} - user is inactive and no longer permitted access.
     * </ul>
     * <p/>
     * Note: This call sets {@code Status} to {@code Inactive}. {@code LoginStatus} reflects the current status of the
     * user’s access. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is able to log in.
     * <li>{@code LockedOut} - user has exceeded the permitted attempts to log in.
     * <li>{@code AccountReset} - user’s account has been reset and user has not yet performed the registration steps.
     * </ul>
     *
     * @param userId ID of the user whose account should be reset.
     * @return Updated user account.
     * @throws TerremarkException If an error occurs resetting the user account.
     */
    User userResetAccount(String userId) throws TerremarkException;

    /**
     * Unlocks a user in an organization after too many failed login attempts. If successful, the call returns
     * information regarding the user that was unlocked.
     * <p/>
     * <p/>
     * {@code Status} reflects whether the user is active. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is active and permitted access.
     * <li>{@code Inactive} - user is inactive and no longer permitted access.
     * </ul>
     * <p/>
     * Note: This call sets {@code Status} to {@code Inactive}. {@code LoginStatus} reflects the current status of the
     * user’s access. Permitted values are:
     * <ul>
     * <li>{@code Active} - user is able to log in.
     * <li>{@code LockedOut} - user has exceeded the permitted attempts to log in.
     * <li>{@code AccountReset} - user’s account has been reset and user has not yet performed the registration steps.
     * </ul>
     *
     * @param userId ID of the user to unlock.
     * @return Updated user account.
     * @throws TerremarkException If an error occurs unlocking the specified user.
     */
    User userUnlockAccount(String userId) throws TerremarkException;
}