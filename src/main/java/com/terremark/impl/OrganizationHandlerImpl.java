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
package com.terremark.impl;

import static com.terremark.config.Version.VERSION_2_10;
import static com.terremark.config.Version.VERSION_2_11;
import static com.terremark.config.Version.VERSION_2_12;

import java.util.HashMap;
import java.util.Map;

import org.apache.wink.client.RestClient;

import com.terremark.OrganizationHandler;
import com.terremark.TerremarkFactory;
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
import com.terremark.impl.QueryArgument.Type;

/**
 * Implementation for API calls for objects with in an organization.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
@SuppressWarnings({"PMD.AvoidDuplicateLiterals", "PMD.CouplingBetweenObjects"})
final class OrganizationHandlerImpl extends AbstractAPIImpl implements OrganizationHandler {
    /** Query argument metadata for {@link #getAlertLog(String, Map)} */
    private static final Map<String, QueryArgument> ALERT_LOG_ARGS = new HashMap<String, QueryArgument>();
    /** Query argument metadata for {@link #getAlertLogEvents(String, Map)} */
    private static final Map<String, QueryArgument> ALERT_LOG_EVENTS_ARGS = new HashMap<String, QueryArgument>();
    /** Query argument metadata for {@link #getAuditLog(String, Map)} */
    private static final Map<String, QueryArgument> AUDIT_LOG_ARGS = new HashMap<String, QueryArgument>();
    /** Query argument metadata for {@link #getCatalogLog(String, Map)} */
    private static final Map<String, QueryArgument> CATALOG_LOG_ARGS = new HashMap<String, QueryArgument>();

    static {
        ALERT_LOG_ARGS.put("page", new QueryArgument(Type.INTEGER));
        ALERT_LOG_ARGS.put("pageSize", new QueryArgument(1, 1000));
        ALERT_LOG_ARGS.put("direction", new QueryArgument("asc", "ascending", "desc", "descending"));
        ALERT_LOG_ARGS.put("startDate", new QueryArgument(Type.ISO8601_DATE));
        ALERT_LOG_ARGS.put("endDate", new QueryArgument(Type.ISO8601_DATE));
        ALERT_LOG_ARGS.put("sortBy", new QueryArgument("Date"));
        ALERT_LOG_ARGS.put("environmentId", new QueryArgument(Type.INTEGER));
        ALERT_LOG_ARGS.put("entityType", new QueryArgument("computePool", "datacenter"));
        ALERT_LOG_ARGS.put("entityId", new QueryArgument(Type.INTEGER));

        ALERT_LOG_EVENTS_ARGS.put("page", new QueryArgument(Type.INTEGER));
        ALERT_LOG_EVENTS_ARGS.put("pageSize", new QueryArgument(1, 1000));
        ALERT_LOG_EVENTS_ARGS.put("direction", new QueryArgument("asc", "ascending", "desc", "descending"));
        ALERT_LOG_EVENTS_ARGS.put("startDate", new QueryArgument(Type.ISO8601_DATE));
        ALERT_LOG_EVENTS_ARGS.put("endDate", new QueryArgument(Type.ISO8601_DATE));
        ALERT_LOG_EVENTS_ARGS.put("sortBy", new QueryArgument("Date"));

        AUDIT_LOG_ARGS.put("page", new QueryArgument(Type.INTEGER));
        AUDIT_LOG_ARGS.put("pageSize", new QueryArgument(1, 1000));
        AUDIT_LOG_ARGS.put("direction", new QueryArgument("asc", "ascending", "desc", "descending"));
        AUDIT_LOG_ARGS.put("startDate", new QueryArgument(Type.ISO8601_DATE));
        AUDIT_LOG_ARGS.put("endDate", new QueryArgument(Type.ISO8601_DATE));
        AUDIT_LOG_ARGS.put("sortBy", new QueryArgument("Date", "Name", "UserName", "Action", "Details", "Origin",
                        "SourceIP", "Notes"));
        AUDIT_LOG_ARGS.put("action", new QueryArgument("IncorrectAnswer", "LoginFailed", "LoginSucceeded"));
        AUDIT_LOG_ARGS.put("user", new QueryArgument(Type.URI));

        CATALOG_LOG_ARGS.put("page", new QueryArgument(Type.INTEGER));
        CATALOG_LOG_ARGS.put("pageSize", new QueryArgument(1, 1000));
        CATALOG_LOG_ARGS.put("direction", new QueryArgument("asc", "ascending", "desc", "descending"));
        CATALOG_LOG_ARGS.put("startDate", new QueryArgument(Type.ISO8601_DATE));
        CATALOG_LOG_ARGS.put("endDate", new QueryArgument(Type.ISO8601_DATE));
        CATALOG_LOG_ARGS.put("sortBy", new QueryArgument("ImpactedItem", "Operation", "Notes", "Status", "InitiatedBy",
                        "StartTime", "CompletedTime"));
    }

    /**
     * Package visible default constructor for creating compute pool handler.
     *
     * @param client Rest client instance.
     * @param properties Client configuration.
     */
    OrganizationHandlerImpl(final RestClient client, final ClientConfiguration properties) {
        super(client, properties);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void administrativeOrganizationsDisableSupportAccess(final String organizationId) throws TerremarkException {
        post(VERSION_2_10, "/admin/organizations/{organizationId}/action/disableSupportAccess", null, null,
                        organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthenticationLevels administrativeOrganizationEditAuthenticationLevels(final String organizationId,
                    final AuthenticationLevels obj) throws TerremarkException {
        return put(VERSION_2_11, "/admin/organizations/{organizationId}/authenticationLevels",
                        AuthenticationLevels.class, obj, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoginBanner administrativeOrganizationEditLoginBanner(final String organizationId, final LoginBanner obj)
                    throws TerremarkException {
        return put(VERSION_2_10, "/admin/organizations/{organizationId}/loginBanner", LoginBanner.class, obj,
                        organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PasswordComplexityRules administrativeOrganizationEditPasswordComplexityRules(final String organizationId,
                    final PasswordComplexityRules obj) throws TerremarkException {
        return put(VERSION_2_10, "/admin/organizations/{organizationId}/passwordComplexityRules",
                        PasswordComplexityRules.class, obj, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void administrativeOrganizationsEnableSupportAccess(final String organizationId) throws TerremarkException {
        post(VERSION_2_10, "/admin/organizations/{organizationId}/action/enableSupportAccess", null, null,
                        organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AlertRule alertRuleCreate(final String alertRuleTemplateId, final Configuration obj)
                    throws TerremarkException {
        return post(VERSION_2_12, "/admin/alertrules/alertruletemplates/{alertRuleTemplateId}/action/createAlertRule",
                        AlertRule.class, obj, alertRuleTemplateId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AlertRule alertRuleEdit(final AlertRule obj) throws TerremarkException {
        return put(VERSION_2_12, "/admin/alertrules/{alertRuleId}", AlertRule.class, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void alertRuleRemove(final String alertRuleId) throws TerremarkException {
        delete(VERSION_2_12, "/admin/alertrules/{alertRuleId}", alertRuleId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiKey apiKeyActivate(final String apiKeyId) throws TerremarkException {
        return post(VERSION_2_11, "/admin/apiKeys/{apiKeyId}/action/activate", ApiKey.class, null, apiKeyId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiKey apiKeyCreate(final String userId, final CreateApiKey obj) throws TerremarkException {
        return post(VERSION_2_11, "/admin/apiKeys/users/{userId}/action/create", ApiKey.class, obj, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiKey apiKeyDeactivate(final String apiKeyId) throws TerremarkException {
        return post(VERSION_2_11, "/admin/apiKeys/{apiKeyId}/action/deactivate", ApiKey.class, null, apiKeyId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiKey apiKeyEdit(final ApiKey obj) throws TerremarkException {
        return put(VERSION_2_11, "/admin/apiKeys/{apiKeyId}", ApiKey.class, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void apiKeyRemove(final String apiKeyId) throws TerremarkException {
        delete(VERSION_2_11, "/admin/apiKeys/{apiKeyId}", apiKeyId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CatalogEntry catalogCreate(final String organizationId, final CreateCatalogEntry obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/admin/catalog/organizations/{organizationId}/action/createCatalogEntry",
                        CatalogEntry.class, obj, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void catalogRemove(final String catalogId) throws TerremarkException {
        delete(VERSION_2_10, "/admin/catalog/{catalogId}", catalogId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdminOrganizations getAdministrativeOrganizations() throws TerremarkException {
        return get(VERSION_2_10, "/admin/organizations/", AdminOrganizations.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthenticationLevels getAdministrativeOrganizationsAuthenticationLevels(final String organizationId)
                    throws TerremarkException {
        return get(VERSION_2_11, "/admin/organizations/{organizationId}/authenticationLevels",
                        AuthenticationLevels.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdminOrganization getAdministrativeOrganizationByID(final String organizationId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/organizations/{organizationId}", AdminOrganization.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoginBanner getAdministrativeOrganizationsLoginBanner(final String organizationId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/organizations/{organizationId}/loginBanner", LoginBanner.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PasswordComplexityRules getAdministrativeOrganizationsPasswordComplexityRules(final String organizationId)
                    throws TerremarkException {
        return get(VERSION_2_10, "/admin/organizations/{organizationId}/passwordComplexityRules",
                        PasswordComplexityRules.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AlertLog getAlertLog(final String organizationId, final Map<String, String> filterArguments)
                    throws TerremarkException {
        validateQueryArguments(filterArguments, ALERT_LOG_ARGS);

        return get(VERSION_2_12, "/alerts/organizations/{organizationId}", filterArguments, null, AlertLog.class,
                        organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Alert getAlertLogByID(final String alertId) throws TerremarkException {
        return get(VERSION_2_12, "/alerts/{alertId}", Alert.class, alertId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AlertEvents getAlertLogEvents(final String alertId, final Map<String, String> filterArguments)
                    throws TerremarkException {
        validateQueryArguments(filterArguments, ALERT_LOG_EVENTS_ARGS);

        return get(VERSION_2_12, "/alerts/{alertId}/events", filterArguments, null, AlertEvents.class, alertId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AlertNotification getAlertNotifications(final String organizationId) throws TerremarkException {
        return get(VERSION_2_12, "/admin/alertNotifications/organizations/{organizationId}", AlertNotification.class,
                        organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AlertRules getAlertRules(final String organizationId) throws TerremarkException {
        return get(VERSION_2_12, "/admin/alertRules/organizations/{organizationId}", AlertRules.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AlertRule getAlertRuleByID(final String alertRuleId) throws TerremarkException {
        return get(VERSION_2_12, "/admin/alertRules/{alertRuleId}", AlertRule.class, alertRuleId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AlertRuleTemplates getAlertRuleTemplates() throws TerremarkException {
        return get(VERSION_2_12, "/alertRuleTemplates/", AlertRuleTemplates.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AlertRuleTemplate getAlertRuleTemplateByID(final String alertRuleTemplateId) throws TerremarkException {
        return get(VERSION_2_12, "/alertRuleTemplates/{alertRuleTemplateId}", AlertRuleTemplate.class,
                        alertRuleTemplateId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiKeys getAPIKeys(final String userId) throws TerremarkException {
        return get(VERSION_2_11, "/admin/apiKeys/users/{userId}", ApiKeys.class, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiKey getAPIKeyByID(final String apiKeyId) throws TerremarkException {
        return get(VERSION_2_11, "/admin/apiKeys/{apiKeyId}", ApiKey.class, apiKeyId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuditLog getAuditLog(final String organizationId, final Map<String, String> filterArguments)
                    throws TerremarkException {
        validateQueryArguments(filterArguments, AUDIT_LOG_ARGS);

        return get(VERSION_2_10, "/admin/organizations/{organizationId}/auditLog", filterArguments, null,
                        AuditLog.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BandwidthPeriods getBandwidthPeriod(final String organizationId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/bandwidth/organizations/{organizationId}/periods", BandwidthPeriods.class,
                        organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BandwidthUsage getBandwidthUsage(final String organizationId, final String yyyy, final String mm)
                    throws TerremarkException {
        return get(VERSION_2_10, "/admin/bandwidth/organizations/{organizationId}/usage/{yyyy}/{mm}",
                        BandwidthUsage.class, organizationId, yyyy, mm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BusinessOperations getBusinessOperations(final String organizationId) throws TerremarkException {
        return get(VERSION_2_11, "/admin/roles/organizations/{organizationId}/businessOperations",
                        BusinessOperations.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BusinessOperation getBusinessOperationByID(final String businessOperationId) throws TerremarkException {
        return get(VERSION_2_11, "/admin/roles/businessOperations/{businessOperationId}", BusinessOperation.class,
                        businessOperationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog(final String organizationId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/catalog/organizations/{organizationId}", Catalog.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CatalogEntry getCatalogByID(final String catalogId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/catalog/{catalogId}", CatalogEntry.class, catalogId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalogByLocation(final String organizationId, final String locationId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/catalog/organizations/{organizationId}/locations/{locationId}", Catalog.class,
                        organizationId, locationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CatalogEntryConfiguration getCatalogConfiguration(final String catalogId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/catalog/{catalogId}/configuration", CatalogEntryConfiguration.class, catalogId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CatalogLog getCatalogLog(final String organizationId, final Map<String, String> filterArguments)
                    throws TerremarkException {
        validateQueryArguments(filterArguments, CATALOG_LOG_ARGS);

        return get(VERSION_2_10, "/admin/catalog/organizations/{organizationId}/log", filterArguments, null,
                        CatalogLog.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contacts getContacts(final String organizationId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/contacts/organizations/{organizationId}", Contacts.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact getContactByID(final String contactId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/contacts/{contactId}", Contact.class, contactId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Environments getEnvironments(final String organizationId) throws TerremarkException {
        return get(VERSION_2_10, "/environments/organizations/{organizationId}", Environments.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Environment getEnvironmentByID(final String environmentId) throws TerremarkException {
        return get(VERSION_2_10, "/environments/{environmentId}", Environment.class, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Location getLocationByID(final String locationId) throws TerremarkException {
        return get(VERSION_2_10, "/locations/{locationId}", Location.class, locationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organizations getOrganizations() throws TerremarkException {
        return get(VERSION_2_10, "/organizations/", Organizations.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization getOrganizationByID(final String organizationId) throws TerremarkException {
        return get(VERSION_2_10, "/organizations/{organizationId}", Organization.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Roles getRoles(final String organizationId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/roles/organizations/{organizationId}", Roles.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role getRoleByID(final String roleId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/roles/{roleId}", Role.class, roleId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRole getRolesByUser(final String userId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/roles/users/{userId}", UserRole.class, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SshKeys getSSHKeys(final String organizationId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/sshKeys/organizations/{organizationId}", SshKeys.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SshKey getSSHKeyByID(final String sshKeyId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/sshKeys/{sshKeyId}", SshKey.class, sshKeyId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TicketGroups getSupportTickets(final String organizationId) throws TerremarkException {
        return get(VERSION_2_11, "/admin/tickets/organizations/{organizationId}", TicketGroups.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tickets getActiveSupportTickets(final String organizationId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/tickets/organizations/{organizationId}/active", Tickets.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ticket getSupportTicketByID(final String ticketId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/tickets/{ticketId}", Ticket.class, ticketId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tickets getSupportTicketsHistory(final String organizationId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/tickets/organizations/{organizationId}/history", Tickets.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeviceTagList getTags(final String organizationId) throws TerremarkException {
        return get(VERSION_2_10, "/deviceTags/organizations/{organizationId}", DeviceTagList.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Users getUsers(final String organizationId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/users/organizations/{organizationId}", Users.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserByID(final String userId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/users/{userId}", User.class, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserCredentials getUserCredentials(final String userId) throws TerremarkException {
        return get(VERSION_2_10, "/admin/users/{userId}/credentials", UserCredentials.class, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Questions getUserSecurityQuestions() throws TerremarkException {
        return get(VERSION_2_10, "/admin/users/securityQuestions", Questions.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role roleCreate(final String organizationId, final CreateRole obj) throws TerremarkException {
        return post(VERSION_2_11, "/admin/roles/organizations/{organizationId}/action/createRole", Role.class, obj,
                        organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role roleDisable(final String roleId) throws TerremarkException {
        return post(VERSION_2_11, "/admin/roles/{roleId}/action/disable", Role.class, null, roleId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role roleEdit(final Role obj) throws TerremarkException {
        return put(VERSION_2_11, "/admin/roles/{roleId}", Role.class, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRole roleEditUser(final String userId, final UserRole obj) throws TerremarkException {
        return put(VERSION_2_12, "/admin/roles/users/{userId}", UserRole.class, obj, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role roleEnable(final String roleId) throws TerremarkException {
        return post(VERSION_2_11, "/admin/roles/{roleId}/action/enable", Role.class, null, roleId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void roleRemove(final String roleId) throws TerremarkException {
        delete(VERSION_2_11, "/admin/roles/{roleId}", roleId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SshKey sshKeyCreate(final String organizationId, final CreateSshKey obj) throws TerremarkException {
        return post(VERSION_2_10, "/admin/sshKeys/organizations/{organizationId}/action/createSshKey", SshKey.class,
                        obj, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SshKey sshKeyEdit(final SshKey obj) throws TerremarkException {
        return put(VERSION_2_10, "/admin/sshKeys/{sshKeyId}", SshKey.class, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sshKeysRemove(final String sshKeyId) throws TerremarkException {
        delete(VERSION_2_10, "/admin/sshKeys/{sshKeyId}", sshKeyId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void supportTicketCreate(final String organizationId, final CreateTicket obj) throws TerremarkException {
        post(VERSION_2_10, "/admin/tickets/organizations/{organizationId}/action/createTicket", null, obj,
                        organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User userCreate(final String organizationId, final CreateUser obj) throws TerremarkException {
        return post(VERSION_2_10, "/admin/users/organizations/{organizationId}/action/createUser", User.class, obj,
                        organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User userCreateAPIUser(final String organizationId, final CreateApiUser obj) throws TerremarkException {
        return post(VERSION_2_11, "/admin/organizations/{organizationId}/action/createApiUser", User.class, obj,
                        organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User userDisableAccount(final String userId) throws TerremarkException {
        return post(VERSION_2_10, "/admin/users/{userId}/accountStatus/action/disable", User.class, null, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User userDisableAlerts(final String userId) throws TerremarkException {
        return post(VERSION_2_10, "/admin/users/{userId}/alertNotification/action/disable", User.class, null, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User userDisableMultifactor(final String userId) throws TerremarkException {
        return post(VERSION_2_10, "/admin/users/{userId}/multifactor/action/disable", User.class, null, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User userEdit(final User obj) throws TerremarkException {
        return put(VERSION_2_10, "/admin/users/{userId}", User.class, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserCredentials userCredentialsEdit(final String userId, final UserCredentials obj)
                    throws TerremarkException {
        return put(VERSION_2_10, "/admin/users/{userId}/credentials", UserCredentials.class, obj, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User userEnableAccount(final String userId) throws TerremarkException {
        return post(VERSION_2_10, "/admin/users/{userId}/accountStatus/action/enable", User.class, null, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User userEnableAlerts(final String userId) throws TerremarkException {
        return post(VERSION_2_10, "/admin/users/{userId}/alertNotification/action/enable", User.class, null, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User userEnableMultifactor(final String userId, final MultifactorAuthentication obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/admin/users/{userId}/multifactor/action/enable", User.class, obj, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void userInvite(final String organizationId, final InviteUser obj) throws TerremarkException {
        post(VERSION_2_10, "/admin/users/organizations/{organizationId}/action/inviteUser", null, obj, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void userRemove(final String userId) throws TerremarkException {
        delete(VERSION_2_10, "/admin/users/{userId}", userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User userResetAccount(final String userId) throws TerremarkException {
        return post(VERSION_2_10, "/admin/users/{userId}/accountStatus/action/reset", User.class, null, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User userUnlockAccount(final String userId) throws TerremarkException {
        return post(VERSION_2_10, "/admin/users/{userId}/accountStatus/action/unlock", User.class, null, userId);
    }
}