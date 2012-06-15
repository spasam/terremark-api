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

import com.terremark.api.BackupInternetService;
import com.terremark.api.BackupInternetServices;
import com.terremark.api.CreateBackupInternetService;
import com.terremark.api.CreateEcvMonitor;
import com.terremark.api.CreateFirewallAcl;
import com.terremark.api.CreateHttpMonitor;
import com.terremark.api.CreateInternetService;
import com.terremark.api.CreateNodeService;
import com.terremark.api.CreatePingMonitor;
import com.terremark.api.CreateRnatAssociation;
import com.terremark.api.CreateTrustedNetworkGroup;
import com.terremark.api.DefaultMonitor;
import com.terremark.api.EcvMonitor;
import com.terremark.api.FirewallAcl;
import com.terremark.api.FirewallAcls;
import com.terremark.api.FirewallLog;
import com.terremark.api.HttpMonitor;
import com.terremark.api.InternetService;
import com.terremark.api.IpAddress;
import com.terremark.api.IpAddresses;
import com.terremark.api.LoopbackMonitor;
import com.terremark.api.Network;
import com.terremark.api.NetworkHost;
import com.terremark.api.NetworkHostSummary;
import com.terremark.api.NetworkRnat;
import com.terremark.api.Networks;
import com.terremark.api.NodeService;
import com.terremark.api.PingMonitor;
import com.terremark.api.PublicIp;
import com.terremark.api.PublicIpAddresses;
import com.terremark.api.Rnat;
import com.terremark.api.RnatConfiguration;
import com.terremark.api.RnatHostAssociation;
import com.terremark.api.Task;
import com.terremark.api.TrustedNetworkGroup;
import com.terremark.api.TrustedNetworkGroups;
import com.terremark.exception.TerremarkException;

/**
 * Provides API calls for top level objects with in an network:
 * <ul>
 * <li>Network
 * <li>Trusted network group
 * <li>Public IP
 * <li>Firewall rule
 * <li>Firewall log
 * <li>IP address
 * <li>Network host
 * <li>Internet services
 * <li>Backup Internet services
 * <li>Monitor
 * <li>Node service
 * <li>RNAT
 * </ul>
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public interface NetworkHandler {
    /**
     * This method creates a device RNAT association in an environment. If successful, the call returns information
     * regarding the association for a reverse network address translation that was created.
     *
     * @param environmentId ID of the environment in which the association should be created in.
     * @param obj RNAT association request.
     * @return The RNAT association.
     * @throws TerremarkException If an error occurs creating the RNAT association.
     */
    RnatHostAssociation associationCreate(String environmentId, CreateRnatAssociation obj) throws TerremarkException;

    /**
     * This method edits a network RNAT association in an environment. If successful, the call returns the task that
     * modified the association.
     *
     * @param networkId ID of the network for which the RNAT association should be edited.
     * @param obj The RNAT association that should be updated.
     * @return Task for checking the status of the update action.
     * @throws TerremarkException If an error occurs editing the RNAT association.
     */
    Task associationEdit(String networkId, NetworkRnat obj) throws TerremarkException;

    /**
     * This call removes a device RNAT association from a network host in an environment. If successful, the call
     * returns the task that removed the association.
     *
     * @param associationId ID of the RNAT association to remove.
     * @return Task for checking the status of the association remove call.
     * @throws TerremarkException If an error occurs removing the RNAT association.
     */
    Task associationRemove(String associationId) throws TerremarkException;

    /**
     * This method creates a backup Internet Service in a specified environment. If successful, the call returns
     * information regarding the backup Internet service created.
     * <p/>
     * The name field on {@code CreateBackupInternetService} is required.
     * <p/>
     * Note: The name may not be that of another backup Internet service.
     * <p/>
     * {@code Protocol} is required.
     * <p/>
     * {@code Port} is required and must be in the range of 1 to 65535.
     * <p/>
     * {@code Enabled} is required.
     * <p/>
     * {@code Type} refers to the method for persisting a connection session. Permitted values are:
     * <ul>
     * <li>None - No persistence.
     * <li>SourceIp - Use the IP address of the source device for persistence.
     * </ul>
     * <p/>
     * If {@code Timeout} is absent with {@code Type} {@code SourceIp}, then {@code Timeout} defaults to 2 minutes. Omit
     * {@code Timeout} if {@code Type} {@code none}.
     * <p/>
     * Note: The minimum value for {@code Timeout} is 2 (for two minutes) and the maximum is 5.
     *
     * @param environmentId ID of the environment where the backup Internet service should be created.
     * @param obj Create backup Internet service request.
     * @return The backup Internet service that was created.
     * @throws TerremarkException If an error occurs
     */
    BackupInternetService backupInternetServiceCreate(String environmentId, CreateBackupInternetService obj)
                    throws TerremarkException;

    /**
     * Call that edits a backup Internet Service in a specified environment. If successful, the call returns the task
     * that modified the backup Internet service.
     * <p/>
     * The name field on {@code BackupInternetService} is required and may be changed.
     * <p/>
     * Note: The name may not be changed to that of another backup Internet group.
     * <p/>
     * {@code Protocol} is required but may not be changed.
     * <p/>
     * {@code Enabled} is required.
     * <p/>
     * {@code Type} refers to the method for persisting a connection session. Permitted values are:
     * <ul>
     * <li>None - No persistence.
     * <li>SourceIp - Use the IP address of the source device for persistence.
     * </ul>
     * <p/>
     * If {@code Timeout} is absent with {@code Type} {@code Source}, then {@code Timeout} defaults to 2 minutes. Omit
     * {@code Timeout} if {@code Type} {@code none}.
     * <p/>
     * Note: The minimum value for {@code Timeout} is 2 (for two minutes) and the maximum is 5.
     * <p/>
     * Both {@code InternetServices} and {@code InternetService} are optional and ignored if present.
     *
     * @param obj Backup Internet service to update.
     * @return Task for checking the status of the update action.
     * @throws TerremarkException If an error occurs
     */
    Task backupInternetServiceEdit(BackupInternetService obj) throws TerremarkException;

    /**
     * This method removes a backup Internet service from an environment. If successful, the call returns the task that
     * removed the backup Internet service.
     * <p/>
     * Note: The backup Internet service must have neither node services nor Internet services associated to remove.
     *
     * @param backupInternetServiceId ID of the backup Internet service to retrieve.
     * @return Task for checking the status of the delete action.
     * @throws TerremarkException If an error occurs
     */
    Task backupInternetServiceRemove(String backupInternetServiceId) throws TerremarkException;

    /**
     * This method creates a destination address for the firewall log. This call is used when no addresses are currently
     * assigned for firewall logs. If successful, the call returns the task that created the firewall log.
     * <p/>
     * One of {@code IpAddress} or {@code ExternalAddress} is required. Presence of both is not permitted, presence of
     * neither is not meaningful.
     * <p/>
     * The {@code IpAddress}, if specified is used to identify the IP address to which to send the firewall logs.
     *
     * @param environmentId ID of the environment where the firewall log should be created.
     * @param obj Firewall log to create.
     * @return The firewall log that was created.
     * @throws TerremarkException If an error occurs
     */
    FirewallLog firewallLogCreate(String environmentId, FirewallLog obj) throws TerremarkException;

    /**
     * Method to edit the destination address for the firewall log. This call is used when an address is currently
     * assigned for firewall logs. If successful, the call returns the task that modified the firewall log.
     * <p/>
     * One of {@code IpAddress} or {@code ExternalAddress} is required. Presence of both is not permitted, presence of
     * neither is not meaningful.
     * <p/>
     * The {@code IpAddress}, if specified is used to identify the IP address to which to send the firewall logs.
     *
     * @param environmentId ID of the environment where the firewall log should be updated.
     * @param obj Firewall log to update.
     * @return Task for checking the status of the update action.
     * @throws TerremarkException If an error occurs
     */
    Task firewallLogEdit(String environmentId, FirewallLog obj) throws TerremarkException;

    /**
     * This method removes the destination address for the firewall log. This call is used when an address is currently
     * assigned for firewall logs. If successful, the call returns the task that removed the firewall log.
     *
     * @param environmentId ID of the environment where the firewall log should be deleted.
     * @return Task for checking the status of the delete action.
     * @throws TerremarkException If an error occurs
     */
    Task firewallLogRemove(String environmentId) throws TerremarkException;

    /**
     * This method creates a new firewall rule in an environment. If successful, the call returns information regarding
     * the firewall rule that was created.
     * <p/>
     * Only firewall rules of {@code AclType} {@code custom} may be created through the API. All firewall rules with
     * {@code AclType} {@code internetService} are created or destroyed automatically when node services are assigned to
     * or removed from an Internet service.
     * <p/>
     * The order in which firewall rules are evaluated is important to ensuring only desired traffic is permitted
     * through the firewall. Firewall rules with {@code AclType} {@code internetService} are automatically created and
     * placed appropriately in the evaluation order. For firewall rules with {@code AclType} {@code custom}, all
     * firewall rules with {@code Permission} {@code deny} are evaluated before any firewall rules with
     * {@code Permission} {@code allow}. The final firewall rule evaluated denies all traffic.
     * <p/>
     * {@code Permission} is required and permitted values are:
     * <ul>
     * <li>allow - Internal traffic meeting the requirements of the rule is allowed.
     * <li>deny - External traffic meeting the requirements of the rule is denied.
     * </ul>
     * <p/>
     * {@code Protocol} is required and the only permitted values for a custom rule are:
     * <ul>
     * <li>Any - Any protocol satisfies the rule.
     * <li>TCP - Transmission Control Protocol.
     * <li>UDP - User Datagram Protocol.
     * </ul>
     * <p/>
     * {@code Type} permitted values are:
     * <ul>
     * <li>Any - All hosts or networks included in the requirements for source or destination.
     * <li>IpAddress - A specific internal address included in the requirements for source or destination.
     * <li>Network - A specific internal network included in the requirements for source or destination.
     * <li>ExternalIp - A specific external address included in the requirements for source or destination.
     * <li>ExternalNetwork - A specific external network included in the requirements for source or destination.
     * </ul>
     * <p/>
     * {@code Source} and {@code Destination} are required. For {@code Permission} {@code deny}, {@code Source} must be
     * external and {@code Destination} must be {@code Type} {@code Any}. For {@code Permission} {@code allow},
     * {@code Source} must be internal and {@code Destination} may be either internal or external. Values for
     * {@code Type} for {@code Source} and {@code Destination} for each {@code Permission} is shown in the table.
     * <p/>
     * <table border="1">
     * <tr>
     * <th>{@code Permission} Value</th>
     * <th>Target</th>
     * <th>{@code Type} Value</th>
     * </tr>
     * <tr>
     * <td>{@code Permission} {@code deny}</td>
     * <td>{@code Source}</td>
     * <td>{@code Type} {@code ExternalIp} or {@code Type} {@code ExternalNetwork}</td>
     * </tr>
     * <tr>
     * <td>{@code Permission} {@code deny}</td>
     * <td>{@code Destination}</td>
     * <td>{@code Type} {@code Any}</td>
     * </tr>
     * <tr>
     * <td>{@code Permission} {@code allow}</td>
     * <td>{@code Source}</td>
     * <td>{@code Type} {@code IpAddress} or {@code Type} {@code Network}</td>
     * </tr>
     * <tr>
     * <td>{@code Permission} {@code allow}</td>
     * <td>{@code Destination}</td>
     * <td>{@code Type} {@code IpAddress} or {@code Type} {@code Network} or {@code Type} {@code ExternalIp} or
     * {@code Type} {@code ExternalNetwork}</td>
     * </tr>
     * </table>
     * <p/>
     * Under {@code Source} and {@code Destination}, {@code Type} is required. The required sibling element varies by
     * the value of {@code Type}.
     * <p/>
     * {@code NetworkType} permitted values are:
     * <ul>
     * <li>Dmz (Demilitarized zone) - Network on which servers are behind the firewall but permit access from the public
     * Internet.
     * <li>Internal - Network on which access to the servers for such reasons as administration and backup are performed
     * but isolated from the public Internet.
     * </ul>
     * <p/>
     * {@code PortType} will be populated depending on the {@code PortRange} values. Permitted values are:
     * <ul>
     * <li>Any - All ports included in the requirements
     * <li>Specific - Only specific ports included in the requirements
     * <li>Range - A range of ports included in the requirements
     * </ul>
     * <p/>
     *
     * @param environmentId ID of the environment where the firewall rule should be created.
     * @param obj Firewall rule to create.
     * @return The firewall rule that was created.
     * @throws TerremarkException If an error occurs
     */
    FirewallAcl firewallRuleCreate(String environmentId, CreateFirewallAcl obj) throws TerremarkException;

    /**
     * Method to remove a custom firewall rule from an environment. If successful, the call returns the task that
     * removed the firewall rule from the environment.
     * <p/>
     * Note: Only firewall rules with an {@code AclType} of custom may be removed.
     *
     * @param firewallRuleId ID of the firewall rule to delete.
     * @return Task for checking the status of the delete action.
     * @throws TerremarkException If an error occurs
     */
    Task firewallRuleRemove(String firewallRuleId) throws TerremarkException;

    /**
     * This call returns information regarding a specified association for a reverse network address translation defined
     * in an environment.
     * <p/>
     * {@code NetworkType} permitted values are:
     * <ul>
     * <li>Dmz (Demilitarized zone) - Network on which servers are behind the firewall but permit access from the public
     * Internet.
     * <li>Internal - Network on which access to the servers for such reasons as administration and backup are performed
     * but isolated from the public Internet.
     * </ul>
     *
     * @param associationId ID of the RNAT association to retrieve.
     * @return The RNAT association.
     * @throws TerremarkException If an error occurs
     */
    RnatHostAssociation getAssociationByID(String associationId) throws TerremarkException;

    /**
     * This method returns information regarding backup Internet services defined in an environment.
     * <p/>
     * {@code Protocol} permitted values are:
     * <ul>
     * <li>HTTP - HyperText Transfer Protocol.
     * <li>HTTPS - HyperText Transfer Protocol Secure.
     * <li>TCP - Transmission Control Protocol.
     * <li>UDP - User Datagram Protocol.
     * <li>IPSEC - Internet Protocol security.
     * <li>FTP - File Transfer Protocol
     * </ul>
     * <p/>
     * {@code Type} for {@code Persistence} refers to the method for persisting a connection session. Permitted values
     * are:
     * <ul>
     * <li>None - No persistence.
     * <li>SourceIp - Use the IP address of the source device for persistence.
     * <li>CookieInsert - A custom header field, a cookie, inserted in the request header for persistence.
     * <li>SessionCookie - A CookiInsert with no timeout, persists until the client clears the request header value.
     * <li>SslSession - Use the SSL session identifier for persistence.
     * </ul>
     * <p/>
     * Note: Persistence type values are limited by protocol: {@code CookieInsert} is valid only with {@code HTTP},
     * {@code SslSession} is valid only with {@code HTTPS}, and {@code SourceIp} and {@code None} are valid with any
     * protocol.
     *
     * @param environmentId ID of the environment for which the backup Internet services should be returned.
     * @return The backup Internet service.
     * @throws TerremarkException If an error occurs
     */
    BackupInternetServices getBackupInternetServices(String environmentId) throws TerremarkException;

    /**
     * This call returns information regarding a specified backup Internet service defined in an environment.
     * <p/>
     * {@code Protocol} permitted values are:
     * <ul>
     * <li>HTTP - HyperText Transfer Protocol.
     * <li>HTTPS - HyperText Transfer Protocol Secure.
     * <li>TCP - Transmission Control Protocol.
     * <li>UDP - User Datagram Protocol.
     * <li>IPSEC - Internet Protocol security.
     * <li>FTP - File Transfer Protocol
     * </ul>
     * <p/>
     * {@code Type} for {@code Persistence} refers to the method for persisting a connection session. Permitted values
     * are:
     * <ul>
     * <li>None - No persistence.
     * <li>SourceIp - Use the IP address of the source device for persistence.
     * <li>CookieInsert - A custom header field, a cookie, inserted in the request header for persistence.
     * <li>SessionCookie - A CookiInsert with no timeout, persists until the client clears the request header value.
     * <li>SslSession - Use the SSL session identifier for persistence.
     * </ul>
     * <p/>
     * Note: Persistence type values are limited by protocol: {@code CookieInsert} is valid only with {@code HTTP},
     * {@code SslSession} is valid only with {@code HTTPS}, and {@code SourceIp} and {@code None} are valid with any
     * protocol.
     *
     * @param backupInternetServiceId ID of the backup Internet service to retrieve.
     * @return The backup Internet service.
     * @throws TerremarkException If an error occurs
     */
    BackupInternetService getBackupInternetServiceByID(String backupInternetServiceId) throws TerremarkException;

    /**
     * This method returns information regarding the IP address of the server to which firewall logs are sent for an
     * environment.
     *
     * @param environmentId ID of the environment for which the firewall logs should be returned.
     * @return The firewall logs for the specified environment.
     * @throws TerremarkException If an error occurs
     */
    FirewallLog getFirewallLogs(String environmentId) throws TerremarkException;

    /**
     * This method returns information regarding firewall rules defined in an environment.
     * <p/>
     * When node services are assigned to or removed from an Internet service the firewall rule is created or destroyed
     * automatically.
     * <p/>
     * The order in which firewall rules are evaluated is important to ensuring only desired traffic is permitted
     * through the firewall. Firewall rules with {@code AclType} {@code internetService} are automatically created and
     * placed appropriately in the evaluation order. For firewall rules with {@code AclType} {@code custom}, all
     * firewall rules with {@code Permission} {@code deny} are evaluated before any firewall rules with
     * {@code Permission} {@code allow}. The final firewall rule evaluated denies all traffic.
     * <p/>
     * This call may include optional arguments. Permitted arguments are:
     * <table border="1">
     * <tr>
     * <th>Parameter</th>
     * <th>Usage</th>
     * </tr>
     * <tr>
     * <td>page</td>
     * <td>Use of {@code page} chunks the returned data and returns the requested page. Default is all items. Use empty
     * value</td>
     * </tr>
     * <tr>
     * <td>pageSize</td>
     * <td>Number of items returned per page between 1 and 1000. Default is 20</td>
     * </tr>
     * <tr>
     * <td>direction</td>
     * <td>
     * <ul>
     * <li>{@code asc} - Ascending
     * <li>{@code desc} - Descending
     * <li>Default is {@code desc}
     * </ul>
     * </td>
     * </tr>
     * <tr>
     * <td>sortBy</td>
     * <td>All {@code FirewallAcl} elements are permitted as the sort key:
     * <ul>
     * <li>Permission
     * <li>Type
     * <li>Source
     * <li>Protocol
     * <li>Port
     * <li>Destination
     * </ul>
     * </td>
     * </tr>
     * <tr>
     * <td>permission</td>
     * <td>
     * <ul>
     * <li>{@code allow} - Allow inside traffic
     * <li>{@code deny} - Deny outside traffic
     * </ul>
     * </tr>
     * <tr>
     * <td>aclType</td>
     * <td>
     * <ul>
     * <li>{@code custom} - Custom rule defined by the organization
     * <li>{@code internetService} - Automatic rule for Internet service
     * </ul>
     * </td>
     * </tr>
     * <tr>
     * <td>fromTo</td>
     * <td>
     * <ul>
     * <li>{@code outsideTraffic} - Rules that permit outside traffic
     * <li>{@code network} - See network
     * <li>{@code device} - See device. Optionally permits IP address, see ip
     * <li>{@code externalNetwork} - See externalNetwork
     * <li>{@code externalIp} - See externalIp
     * <li>{@code externalAny} - Either {@code externalNetwork} or {@code externalIp}
     * <li>Default is all traffic
     * </ul>
     * </td>
     * </tr>
     * <tr>
     * <td>network</td>
     * <td>{network address}/{network prefix length}</td>
     * </tr>
     * <tr>
     * <td>device</td>
     * <td>{network host name}</td>
     * </tr>
     * <tr>
     * <td>ip</td>
     * <td>{host IP address} see the Note below</td>
     * </tr>
     * <tr>
     * <td>externalNetwork</td>
     * <td>{external network address}/{external network prefix length}</td>
     * </tr>
     * <tr>
     * <td>externalIp</td>
     * <td>{external host IP address}</td>
     * </tr>
     * </table>
     * <p/>
     * Note: If {@code fromTo} is set to device, then in addition to the required device parameter the {@code ip}
     * parameter may also be valued. If the device parameter is used alone, then rules for all IP addresses for that
     * device are included. If the device parameter is used with the {@code ip} parameter, then rules for only that
     * single IP address are included.
     * <p/>
     * {@code Permission} permitted values are:
     * <ul>
     * <li>allow - Internal traffic meeting the requirements of the rule is allowed.
     * <li>deny - External traffic meeting the requirements of the rule is denied.
     * </ul>
     * <p/>
     * {@code AclType} permitted values are:
     * <ul>
     * <li>internetService - Rule is applied to an Internet service.
     * <li>custom - Rule is custom.
     * </ul>
     * <p/>
     * {@code PortType} permitted values are:
     * <ul>
     * <li>Any - All ports included in the requirements
     * <li>Specific - Only specific ports included in the requirements
     * <li>Range - A range of ports included in the requirements
     * </ul>
     * <p/>
     * {@code Protocol} permitted values are:
     * <ul>
     * <li>Any - Any protocol satisfies the rule.
     * <li>HTTP - HyperText Transfer Protocol.
     * <li>HTTPS - HyperText Transfer Protocol Secure.
     * <li>TCP - Transmission Control Protocol.
     * <li>UDP - User Datagram Protocol.
     * <li>IPSEC - Internet Protocol security.
     * <li>FTP - File Transfer Protocol
     * </ul>
     * <p/>
     * {@code Type} permitted values are:
     * <ul>
     * <li>Any - All sources or destinations included in the requirements.
     * <li>IpAddress - A specific internal address included in the source or destination requirements.
     * <li>Network - A specific internal network included in the source or destination requirements.
     * <li>ExternalIp - A specific external address included in the source or destination requirements.
     * <li>ExternalNetwork - A specific external network included in the source or destination requirements.
     * <li>TrustedNetworkGroup - A trusted network group defined in the environment.
     * </ul>
     * <p/>
     * {@code NetworkType} permitted values are:
     * <ul>
     * <li>Dmz (Demilitarized zone) - Network on which servers are behind the firewall but permit access from the public
     * Internet.
     * <li>Internal - Network on which access to the servers for such reasons as administration and backup are performed
     * but isolated from the public Internet.
     * </ul>
     *
     * @param environmentId ID of the environment for which the firewall ACL's should be returned.
     * @param filterArguments Filter arguments. See description of this method. Can be null.
     * @return The firewall rules for the specified environment.
     * @throws TerremarkException If an error occurs
     */
    FirewallAcls getFirewallRules(String environmentId, Map<String, String> filterArguments) throws TerremarkException;

    /**
     * This method returns information regarding a specified custom firewall rule in an environment.
     * <p/>
     * When node services are assigned to or removed from an Internet service the firewall rule is created or destroyed
     * automatically.
     * <p/>
     * The order in which firewall rules are evaluated is important to ensuring only desired traffic is permitted
     * through the firewall. Firewall rules with {@code AclType} {@code internetService} are automatically created and
     * placed appropriately in the evaluation order. For firewall rules with {@code AclType} {@code custom}, all
     * firewall rules with {@code Permission} {@code deny} are evaluated before any firewall rules with
     * {@code Permission} {@code allow}. The final firewall rule evaluated denies all traffic.
     *
     * @param firewallRuleId ID of the firewall rule to retrieve.
     * @return Returns the custom firewall rule with the specified ID.
     * @throws TerremarkException If an error occurs
     */
    FirewallAcl getCustomFirewallRule(String firewallRuleId) throws TerremarkException;

    /**
     * This call returns information regarding a specified Internet service firewall rule in an environment.
     * <p/>
     * When node services are assigned to or removed from an Internet service the firewall rule is created or destroyed
     * automatically.
     * <p/>
     * The order in which firewall rules are evaluated is important to ensuring only desired traffic is permitted
     * through the firewall. Firewall rules with {@code AclType} {@code internetService} are automatically created and
     * placed appropriately in the evaluation order. For firewall rules with {@code AclType} {@code custom}, all
     * firewall rules with {@code Permission} {@code deny} are evaluated before any firewall rules with
     * {@code Permission} {@code allow}. The final firewall rule evaluated denies all traffic.
     *
     * @param nodeServiceId ID of the node service for which the firewall ACL should be retrieved.
     * @return The firewall rules for the specified node service.
     * @throws TerremarkException If an error occurs
     */
    FirewallAcl getNodeServiceFirewallRule(String nodeServiceId) throws TerremarkException;

    /**
     * This method returns information regarding a specified Internet service defined in an environment.
     * <p/>
     * {@code Type} for {@code Persistence} refers to the method for persisting a connection session.
     * <p/>
     * Note: Persistence type values are limited by protocol: {@code CookieInsert} is valid only with {@code HTTP},
     * {@code SslSession} is valid only with {@code HTTPS}, and {@code SourceIp} and {@code None} are valid with any
     * protocol.
     * <p/>
     * {@code LoadBalancingMethod} refers to the method used to balance the traffic across the nodes services in an
     * Internet service.
     *
     * @param internetServiceId ID of the Internet service to retrieve.
     * @return Returns the Internet service for the specified ID.
     * @throws TerremarkException If an error occurs
     */
    InternetService getInternetServiceByID(String internetServiceId) throws TerremarkException;

    /**
     * This method returns information regarding a specified IP Addresses defined in an environment.
     * <p/>
     * An {@code IpAddress} with no fields populated is not assigned, not configured on a host, and not associated to a
     * reverse network address translation.
     * <p/>
     * An {@code IpAddress} may have more than one field populated, which appear under the following circumstances:
     * <ul>
     * <li>{@code Actions} is populated for IP addresses configured on a host but not assigned to that host.
     * <li>{@code Hosts} is populated for IP addresses assigned to a host.
     * <li>{@code DetectedOn} is populated for IP addresses configured on a host but not assigned.
     * <li>{@code RnatAddress} is populated for IP addresses associated to a reverse network address translation.
     * </ul>
     *
     * @param networkId ID of the network to which the IP address belongs to.
     * @param hostIPAddress IP address to retrieve information about.
     * @return Returns the IP address.
     * @throws TerremarkException If an error occurs
     */
    IpAddress getIPAddressByID(String networkId, String hostIPAddress) throws TerremarkException;

    /**
     * Returns information regarding a specified Internet service defined in an environment.
     *
     * @param internetServiceId ID of the Internet service for which the default monitor should be retrieved.
     * @return Returns the monitor for the specified Internet service.
     * @throws TerremarkException If an error occurs
     */
    DefaultMonitor getMonitorByInternetService(String internetServiceId) throws TerremarkException;

    /**
     * Returns information regarding the network hosts, virtual machines or physical devices, on the networks in an
     * environment.
     * <p/>
     * {@code Status} refers to the status of the host.
     *
     * @param environmentId ID of the environment for which the network hosts should be returned.
     * @return Returns the network hosts for the specified environment.
     * @throws TerremarkException If an error occurs
     */
    NetworkHostSummary getNetworkHosts(String environmentId) throws TerremarkException;

    /**
     * Returns information regarding a specified network host defined in an environment.
     *
     * @param networkHostId ID of the network host to return.
     * @return Returns the network host with the specified ID.
     * @throws TerremarkException If an error occurs
     */
    NetworkHost getNetworkHostByID(String networkHostId) throws TerremarkException;

    /**
     * Returns information regarding networks in an environment.
     *
     * @param environmentId ID of the environment for which the networks should be returned.
     * @return Returns the networks in the specified environment.
     * @throws TerremarkException If an error occurs
     */
    Networks getNetworks(String environmentId) throws TerremarkException;

    /**
     * This method returns information regarding the usage of all IP addresses on a specified network defined in an
     * environment.
     * <p/>
     * An {@code IpAddress} with no field populated is not assigned, not configured on a host, and not associated to a
     * reverse network address translation.
     * <p/>
     * An {@code IpAddress} may have more than one field populated, which appear under the following circumstances:
     * <ul>
     * <li>{@code Actions} is populated for IP addresses configured on a host but not assigned to that host.
     * <li>{@code Hosts} is populated for IP addresses assigned to a host.
     * <li>{@code DetectedOn} is populated for IP addresses configured on a host but not assigned.
     * <li>{@code RnatAddress} is populated for IP addresses associated to a reverse network address translation.
     * </ul>
     *
     * @param networkId ID of the network to retrieve.
     * @return Returns the network with the specified ID.
     * @throws TerremarkException If an error occurs
     */
    Network getNetworkByID(String networkId) throws TerremarkException;

    /**
     * This call returns information regarding a specified node service defined in an environment.
     *
     * @param nodeServiceId ID of the network service to retrieve.
     * @return Returns the node service with the specified ID.
     * @throws TerremarkException If an error occurs
     */
    NodeService getNodeServiceByID(String nodeServiceId) throws TerremarkException;

    /**
     * This method returns information regarding public IP addresses defined in an environment.
     *
     * @param environmentId ID of the environment for which the public IP addresses should be returned.
     * @return Returns the public IP addresses in the specified environment.
     * @throws TerremarkException If an error occurs
     */
    PublicIpAddresses getPublicIPs(String environmentId) throws TerremarkException;

    /**
     * This call returns information regarding a specified public IP address defined in an environment.
     * <p/>
     * {@code Type} for {@code Persistence} refers to the method for persisting a connection session.
     * <p/>
     * Note: Persistence type values are limited by protocol: {@code CookieInsert} is valid only with {@code HTTP},
     * {@code SslSession} is valid only with {@code HTTPS}, and {@code SourceIp} and {@code None} are valid with any
     * protocol.
     *
     * @param publicIPId ID of the public IP address to retrieve.
     * @return Returns the public IP address with the specified ID.
     * @throws TerremarkException If an error occurs
     */
    PublicIp getPublicIPByID(String publicIPId) throws TerremarkException;

    /**
     * This method call returns information regarding the reverse network address translations defined in an
     * environment.
     *
     * @param environmentId ID of the environment for which the RNAT's should be returned.
     * @return Returns the RNAT configuration for the specified environment.
     * @throws TerremarkException If an error occurs
     */
    RnatConfiguration getRNATs(String environmentId) throws TerremarkException;

    /**
     * This call returns information regarding a specified reverse network address translation defined in an
     * environment.
     *
     * @param publicIPId ID of the public IP address for which RNAT configuration should be returned.
     * @return Returns the RNAT configuration that is applicable to the specified IP address.
     * @throws TerremarkException If an error occurs
     */
    Rnat getRNATByID(String publicIPId) throws TerremarkException;

    /**
     * Returns information regarding a network RNAT association in an environment.
     *
     * @param networkId ID of the network RNAT to retrieve.
     * @return Returns the RNAT configuration for the specified network.
     * @throws TerremarkException If an error occurs
     */
    NetworkRnat getNetworkRNAT(String networkId) throws TerremarkException;

    /**
     * Returns information regarding trusted network groups defined in an environment.
     * <p/>
     * A {@code TrustedNetworkGroup} with no {@code InternetServices} indicates that the trusted network group has been
     * defined but not yet bound to an Internet service.
     *
     * @param environmentId ID of the environment where for which the trusted network groups should be returned.
     * @return The trusted network groups in the specified environment.
     * @throws TerremarkException If an error occurs
     */
    TrustedNetworkGroups getTrustedNetworkGroups(String environmentId) throws TerremarkException;

    /**
     * Returns information regarding the specified trusted network group in an environment.
     *
     * @param trustedNetworkGroupId ID of the trusted network group to retrieve.
     * @return The trusted network group with the specified ID.
     * @throws TerremarkException If an error occurs
     */
    TrustedNetworkGroup getTrustedNetworkGroupByID(String trustedNetworkGroupId) throws TerremarkException;

    /**
     * Creates an Internet service on a public IP address in an environment. If successful, the call returns information
     * regarding the Internet service that was created.
     * <p/>
     * The {@code name} on {@code CreateInternetService} is required.
     * <p/>
     * Note: The name may not be that of another Internet service.
     * <p/>
     * {@code Protocol} is required.
     * <p/>
     * {@code Port} is required and must be in the range of 1 to 65535.
     * <p/>
     * {@code Enabled} is required.
     * <p/>
     * {@code LoadBalancingMethod} is optional and refers to the method used to balance the traffic across the nodes
     * services in the Internet service. If not present, defaults to {@code LeastConnection}.
     * <p/>
     * {@code Type} for {@code Persistence} refers to the method for persisting a connection session.
     * <p/>
     * Note: Persistence type values are limited by protocol: {@code CookieInsert} is valid only with {@code HTTP},
     * {@code SslSession} is valid only with {@code HTTPS}, and {@code SourceIp} and {@code None} are valid with any
     * protocol. If {@code Timeout} is absent with {@code Type} {@code SourceIp}, then {@code Timeout} defaults to 2
     * minutes. Omit {@code Timeout} if {@code Type} is {@code none}.
     * <p/>
     * Note: The minimum value for {@code Timeout} is 2 (for two minutes) and the maximum is 5.
     *
     * @param publicIPId ID of the public IP address on which the Internet service should be created.
     * @param obj Create Internet service request.
     * @return The Internet service that was created.
     * @throws TerremarkException If an error occurs
     */
    InternetService internetServiceCreate(String publicIPId, CreateInternetService obj) throws TerremarkException;

    /**
     * This method creates an Internet service in an environment. The call returns information regarding the Internet
     * service created.
     * <p/>
     * Note: This call is applicable to vCloud Express only.
     * <p/>
     * The name field on {@code CreateInternetService} is required.
     * <p/>
     * Note: The name may not be that of another Internet service.
     * <p/>
     * {@code Protocol} is required.
     * <p/>
     * {@code Port} is required and must be in the range of 1 to 65535.
     * <p/>
     * {@code Enabled} is required.
     * <p/>
     * {@code LoadBalancingMethod} is optional and refers to the method used to balance the traffic across the nodes
     * services in the Internet service. If not present, defaults to {@code LeastConnection}.
     * <p/>
     * {@code Type} for {@code Persistence} refers to the method for persisting a connection session.
     * <p/>
     * Note: Persistence type values are limited by protocol: {@code CookieInsert} is valid only with {@code HTTP},
     * {@code SslSession} is valid only with {@code HTTPS}, and {@code SourceIp} and {@code None} are valid with any
     * protocol.
     * <p/>
     * If {@code Timeout} is absent with {@code Type} {@code SourceIp}, then {@code Timeout} defaults to 2 minutes. Omit
     * {@code Timeout} if {@code Type} {@code none}.
     * <p/>
     * Note: The minimum value for {@code Timeout} is 2 (for two minutes) and the maximum is 5.
     *
     * @param environmentId ID of the environment where for which the Internet service should be created.
     * @param obj Create Internet service request.
     * @return The Internet service that was created.
     * @throws TerremarkException If an error occurs
     */
    Error internetServiceCreateforEnvironment(String environmentId, CreateInternetService obj)
                    throws TerremarkException;

    /**
     * This method edits the name, source (any or a specific trusted network group), enablement, description,
     * persistence, redirect URL, trusted network group, backup Internet service, or load balancing algorithm on a
     * specified Internet service in an environment. If successful, the call returns the task that modified the Internet
     * service.
     * <p/>
     * The name field on {@code InternetService} is required and may be changed.
     * <p/>
     * Note: The name may not be changed to that of another Internet service.
     * <p/>
     * {@code Port} is optional and ignored if present.
     * <p/>
     * {@code Enabled} is required.
     * <p/>
     * {@code Type} for {@code Persistence} refers to the method for persisting a connection session.
     * <p/>
     * Note: Persistence type values are limited by protocol: {@code CookieInsert} is valid only with {@code HTTP},
     * {@code SslSession} is valid only with {@code HTTPS}, and {@code SourceIp} and {@code None} are valid with any
     * protocol.
     * <p/>
     * If {@code Timeout} is absent with {@code Type} {@code SourceIp}, then {@code Timeout} defaults to 2 minutes. Omit
     * {@code Timeout} if {@code Type} {@code none}.
     * <p/>
     * Note: The minimum value for {@code Timeout} is 2 (for two minutes) and the maximum is 5. Both
     * {@code TrustedNetworkGroup} and {@code BackupInternetService} are optional. Including a
     * {@code TrustedNetworkGroup} or {@code BackupInternetService} not currently on the Internet service adds that
     * trusted network group or backup Internet service to the Internet service.
     * <p/>
     * Note: If any {@code TrustedNetworkGroup} is valued on the Internet service and not present in the call, that
     * trusted network group is removed from the Internet service. Similarly, if any {@code BackupInternetService} is
     * valued on the Internet service and not present in the call, that backup Internet service is removed from the
     * Internet service.
     * <p/>
     * {@code LoadBalancingMethod} is optional and refers to the method used to balance the traffic across the nodes
     * services in the Internet service. If not present, no change is made.
     *
     * @param obj Internet service to update.
     * @return Task for checking the status of the update action.
     * @throws TerremarkException If an error occurs
     */
    Task internetServiceEdit(InternetService obj) throws TerremarkException;

    /**
     * This method removes an Internet service from an environment. If successful, the call returns the task that
     * removed the Internet service. Note: The Internet service must have no node services associated to remove.
     *
     * @param internetServiceId ID of the Internet service to delete.
     * @return Task for checking the status of the delete action.
     * @throws TerremarkException If an error occurs
     */
    Task internetServiceRemove(String internetServiceId) throws TerremarkException;

    /**
     * This method configures the reserved state, reserved or not reserved, of IP addresses in a specified network.
     * <p/>
     * At least one {@code IpAddress} is required to be meaningful. Note: IP addresses not included in the call are
     * unchanged. {@code Reserved} is required on every {@code IpAddress} and sets the reserved status. {@code Host},
     * {@code DetectedOn}, and {@code RnatAddress} are optional and ignored if present.
     *
     * @param networkId ID of the network to which the IP address belongs to.
     * @param obj IP address to configure reservation for.
     * @throws TerremarkException If an error occurs
     */
    void ipAddressConfigureReservation(String networkId, IpAddresses obj) throws TerremarkException;

    /**
     * This call reserves a specified IP address in a specified network.
     * <p/>
     * Note: To reserve an IP address, the IP address must not be currently reserved, may not be assigned to host, may
     * not be detected on a host, and may not be associated to a device reverse network address translation (RNAT).
     *
     * @param networkId ID of the network to which the IP address belongs to.
     * @param hostIPAddress IP address to reserve.
     * @throws TerremarkException If an error occurs
     */
    void ipAddressReserve(String networkId, String hostIPAddress) throws TerremarkException;

    /**
     * Synchronizes a specified IP address in a specified network as assigned to a host.
     * <p/>
     * Note: To synchronize, the host on which the IP address is detected may not be assigned to another IP address.
     *
     * @param networkId ID of the network to which the IP address belongs to.
     * @param hostIPAddress IP address to sync.
     * @throws TerremarkException If an error occurs
     */
    void ipAddressSync(String networkId, String hostIPAddress) throws TerremarkException;

    /**
     * This method unreserve's a specified IP address in a specified network. Note: To unreserve, the IP address must be
     * reserved.
     *
     * @param networkId OD of the network to which the IP address belongs to.
     * @param hostIPAddress IP address to un-reserve.
     * @throws TerremarkException If an error occurs
     */
    void ipAddressUnreserve(String networkId, String hostIPAddress) throws TerremarkException;

    /**
     * Creates a default monitor or changes the monitor to a default monitor on an Internet service. Monitors probe the
     * servers on an Internet service to ensure availability.
     * <p/>
     * Note: If an Internet service currently has a custom monitor (ping, HTTP, ECV, or loopback monitor) the default
     * monitor must first be created on the Internet service and then the custom monitor created.
     *
     * @param internetServiceId ID of the Internet service to create monitor on.
     * @return The monitor that was created.
     * @throws TerremarkException If an error occurs
     */
    DefaultMonitor monitorCreateDefault(String internetServiceId) throws TerremarkException;

    /**
     * Creates an ECV monitor or changes the monitor to an ECV monitor on an Internet service. Monitors probe the
     * servers on an Internet service to ensure availability.
     * <p/>
     * Note: If an Internet service currently has a custom monitor (ping, HTTP, or loopback monitor) the default monitor
     * must first be created on the Internet service and then the ECV monitor created.
     *
     * @param internetServiceId ID of the Internet service to create monitor on.
     * @param obj ECV monitor to create.
     * @return The monitor that was created.
     * @throws TerremarkException If an error occurs
     */
    EcvMonitor monitorCreateECV(String internetServiceId, CreateEcvMonitor obj) throws TerremarkException;

    /**
     * Creates an HTTP monitor or changes the monitor to an HTTP monitor on an Internet service. Monitors probe the
     * servers on an Internet service to ensure availability.
     * <p/>
     * Note: If an Internet service currently has a custom monitor (ping, ECV, or loopback monitor) the default monitor
     * must first be created on the Internet service and then the HTTP monitor created.
     *
     * @param internetServiceId ID of the Internet service to create monitor on.
     * @param obj HTTP monitor to create.
     * @return The monitor that was created.
     * @throws TerremarkException If an error occurs
     */
    HttpMonitor monitorCreateHTTP(String internetServiceId, CreateHttpMonitor obj) throws TerremarkException;

    /**
     * Creates a loopback monitor or changes the monitor to a loopback monitor on an Internet service. Monitors probe
     * the servers on an Internet service to ensure availability.
     * <p/>
     * Note: The loopback monitor does not probe the actual servers and therefore does not ensure service availability.
     * Use of the loopback monitor is not recommended.
     * <p/>
     * Note: If an Internet service currently has a custom monitor (ping, HTTP, or ECV monitor) the default monitor must
     * first be created on the Internet service and then the loopback monitor created.
     *
     * @param internetServiceId ID of the Internet service to create monitor on.
     * @return The monitor that was created.
     * @throws TerremarkException If an error occurs
     */
    LoopbackMonitor monitorCreateLoopback(String internetServiceId) throws TerremarkException;

    /**
     * Creates a ping monitor or changes the monitor to a ping monitor on an Internet service. Monitors probe the
     * servers on an Internet service to ensure availability.
     * <p/>
     * Note: If an Internet service currently has a custom monitor (HTTP, ECV, or loopback monitor) the default monitor
     * must first be created on the Internet service and then the custom monitor created.
     *
     * @param internetServiceId ID of the Internet service to create monitor on.
     * @param obj Ping monitor to create.
     * @return The monitor that was created.
     * @throws TerremarkException If an error occurs
     */
    PingMonitor monitorCreatePing(String internetServiceId, CreatePingMonitor obj) throws TerremarkException;

    /**
     * Disables a ping, HTTP, or ECV monitor that is enabled.
     *
     * @param internetServiceId ID of the Internet service on which monitor should be disabled.
     * @return Task for checking the status of the disable action.
     * @throws TerremarkException If an error occurs
     */
    Task monitorDisable(String internetServiceId) throws TerremarkException;

    /**
     * Modifies the performance characteristics of an ECV monitor.
     *
     * @param internetServiceId ID of the Internet service whose monitor should be edited.
     * @param obj ECV monitor to update.
     * @return The monitor that was updated.
     * @throws TerremarkException If an error occurs
     */
    EcvMonitor monitorEditECV(String internetServiceId, EcvMonitor obj) throws TerremarkException;

    /**
     * Modifies the performance characteristics of an HTTP monitor.
     *
     * @param internetServiceId ID of the Internet service whose monitor should be edited.
     * @param obj HTTP monitor to update.
     * @return The monitor that was updated.
     * @throws TerremarkException If an error occurs
     */
    HttpMonitor monitorEditHTTP(String internetServiceId, HttpMonitor obj) throws TerremarkException;

    /**
     * Modifies the performance characteristics of an ping monitor.
     *
     * @param internetServiceId ID of the Internet service whose monitor should be edited.
     * @param obj Ping monitor to update.
     * @return The monitor that was updated.
     * @throws TerremarkException If an error occurs
     */
    PingMonitor monitorEditPing(String internetServiceId, PingMonitor obj) throws TerremarkException;

    /**
     * Enables a ping, HTTP, or ECV monitor that is disabled.
     *
     * @param internetServiceId ID of the Internet service whose monitor should be enabled.
     * @return Task for checking the status of the enable action.
     * @throws TerremarkException If an error occurs
     */
    Task monitorEnable(String internetServiceId) throws TerremarkException;

    /**
     * This method creates a node service for a specified backup Internet service in an environment. If successful, the
     * call returns information regarding the node service that was created.
     * <p/>
     * The name field on {@code CreateNodeService} is required.
     * <p/>
     * Note: The name may not be that of another node service and may not exceed fifty characters.
     * <p/>
     * {@code IpAddress} is required to identify the network host with which the node service is associated.
     * <p/>
     * {@code Port} is required and must be in the range of 1 to 65535.
     *
     * @param backupInternetServiceId ID of the backup Internet service for which the node service should be created.
     * @param obj Node service create request.
     * @return The node service that was created.
     * @throws TerremarkException If an error occurs
     */
    NodeService nodeServiceCreateBackup(String backupInternetServiceId, CreateNodeService obj)
                    throws TerremarkException;

    /**
     * This method creates a node service for a specified Internet service. If successful, the call returns information
     * regarding the node service that was created.
     * <p/>
     * The name field on {@code CreateNodeService} is required.
     * <p/>
     * Note: The name may not be that of another node service and may not exceed fifty characters.
     * <p/>
     * {@code IpAddress} is required to identify the network host with which the node service is associated.
     * <p/>
     * {@code Port} is required and must be in the range of 1 to 65535.
     *
     * @param internetServiceId ID of the Internet service for which the node service should be created.
     * @param obj Node service create request.
     * @return The node service that was created.
     * @throws TerremarkException If an error occurs
     */
    NodeService nodeServiceCreate(String internetServiceId, CreateNodeService obj) throws TerremarkException;

    /**
     * This call edits the name, description, or enablement of a node service in an environment. If successful, the call
     * returns the task that modified the node service.
     * <p/>
     * The name field on {@code NodeService} is required and may be changed.
     * <p/>
     * Note: The name may not be changed to that of another node service and may not exceed fifty characters.
     * <p/>
     * {@code Port} and {@code IpAddress} and its subordinate fields, {@code Network} and {@code Hosts}, are all
     * optional and ignored if present.
     * <p/>
     * {@code Protocol} is optional and ignored if present.
     *
     * @param obj Node service to update.
     * @return Task for checking the status of the update action.
     * @throws TerremarkException If an error occurs
     */
    Task nodeServiceEdit(NodeService obj) throws TerremarkException;

    /**
     * This method removes a specified node service from an environment. If successful, the call returns the task that
     * removed the node service.
     * <p/>
     * The name field on {@code NodeService} is required.
     * <p/>
     * {@code Port} and {@code IpAddress} and its subordinate fields, {@code Network} and {@code Hosts}, are all
     * optional and ignored if present.
     * <p/>
     * {@code Protocol} is optional and ignored if present.
     *
     * @param nodeServiceId ID of the node service to delete.
     * @return Task for checking the status of the delete action.
     * @throws TerremarkException If an error occurs
     */
    Task nodeServiceRemove(String nodeServiceId) throws TerremarkException;

    /**
     * Activates an additional public IP address from the pool of purchased public IP addresses in the environment. The
     * call returns information regarding the public IP address activated.
     *
     * @param environmentId ID of the environment in which a public IP address should be activated.
     * @return The public IP address that was activated.
     * @throws TerremarkException If an error occurs
     */
    PublicIp publicIPActivate(String environmentId) throws TerremarkException;

    /**
     * Removes a specified public IP address from an environment. If successful, the call returns the task that removed
     * the public IP address.
     * <p/>
     * Note: This call is applicable to vCloud Express only.
     *
     * @param publicIPId ID of the public IP address to remove.
     * @return Task for checking the status of the delete action.
     * @throws TerremarkException If an error occurs
     */
    Task publicIPRemove(String publicIPId) throws TerremarkException;

    /**
     * Creates a trusted network group. If successful, the call returns information regarding the trusted network group
     * that was created.
     * <p/>
     * The name field on {@code CreateTrustedNetworkGroup} is required.
     * <p/>
     * Note: The name may not be that of another trusted network group and may not exceed fifty characters.
     *
     * @param environmentId ID of the environment in which a trusted network group should be created.
     * @param obj Trusted network group create request.
     * @return The trusted network group that was created.
     * @throws TerremarkException If an error occurs
     */
    TrustedNetworkGroup trustedNetworkGroupCreate(String environmentId, CreateTrustedNetworkGroup obj)
                    throws TerremarkException;

    /**
     * Edits the name of, or the hosts and networks in, a trusted network group. If successful, the call returns the
     * task that modified the trusted network group.
     * <p/>
     * The name field on {@code CreateTrustedNetworkGroup} is required and may be changed.
     * <p/>
     * Note: The name may not be changed to that of another trusted network group and may not exceed fifty characters.
     * <p/>
     * Both {@code Hosts} and {@code Networks} are optional. Including an {@code IpAddress} or {@code Network} not
     * currently on the trusted network group adds that host or network to the trusted network group.
     * <p/>
     * Note: If any {@code IpAddress} is valued on the trusted network group and not present in the call, that host's IP
     * address is removed from the trusted network group. Similarly, if any {@code Network} is valued on the trusted
     * network group and not present in the call, that network is removed from the trusted network group.
     *
     * @param obj Trusted network group to update.
     * @return Task for checking the status of the update action.
     * @throws TerremarkException If an error occurs
     */
    Task trustedNetworkGroupEdit(TrustedNetworkGroup obj) throws TerremarkException;

    /**
     * This method removes a trusted network group from an environment. If successful, the call returns the task that
     * removed the trusted network group.
     * <p/>
     * Note: To remove, the trusted network group may not be associated to an Internet service.
     *
     * @param trustedNetworkGroupId ID of the trusted network group to delete.
     * @return Task for checking the status of the delete action.
     * @throws TerremarkException If an error occurs
     */
    Task trustedNetworkGroupRemove(String trustedNetworkGroupId) throws TerremarkException;
}
