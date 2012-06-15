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

import java.util.HashMap;
import java.util.Map;

import org.apache.wink.client.RestClient;

import com.terremark.NetworkHandler;
import com.terremark.TerremarkFactory;
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
import com.terremark.impl.QueryArgument.Type;

/**
 * Implementation for API calls for objects with in an network.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
@SuppressWarnings("PMD.CouplingBetweenObjects")
final class NetworkHandlerImpl extends AbstractAPIImpl implements NetworkHandler {
    /** Query argument metadata for {@link #getFirewallRules(String, Map)} */
    private static final Map<String, QueryArgument> FIREWALL_RULES_ARGS = new HashMap<String, QueryArgument>();

    static {
        FIREWALL_RULES_ARGS.put("page", new QueryArgument(Type.INTEGER));
        FIREWALL_RULES_ARGS.put("pageSize", new QueryArgument(1, 1000));
        FIREWALL_RULES_ARGS.put("direction", new QueryArgument("asc", "ascending", "desc", "descending"));
        FIREWALL_RULES_ARGS.put("permission", new QueryArgument("allow", "deny"));
        FIREWALL_RULES_ARGS.put("aclType", new QueryArgument("custom", "internetService"));
        FIREWALL_RULES_ARGS.put("fromTo", new QueryArgument("outsideTraffic", "network", "device", "externalNetwork",
                        "externalIp", "externalAny"));
        FIREWALL_RULES_ARGS.put("network", new QueryArgument(Type.SUBNET));
        FIREWALL_RULES_ARGS.put("device", new QueryArgument(Type.HOSTNAME));
        FIREWALL_RULES_ARGS.put("ip", new QueryArgument(Type.IP_ADDRESS));
        FIREWALL_RULES_ARGS.put("externalNetwork", new QueryArgument(Type.SUBNET));
        FIREWALL_RULES_ARGS.put("externalIp", new QueryArgument(Type.IP_ADDRESS));
    }

    /**
     * Package visible default constructor for creating network handler.
     *
     * @param client Rest client instance.
     * @param properties Client configuration.
     */
    NetworkHandlerImpl(final RestClient client, final ClientConfiguration properties) {
        super(client, properties);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RnatHostAssociation associationCreate(final String environmentId, final CreateRnatAssociation obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/rnats/environments/{environmentId}/action/createAssociation",
                        RnatHostAssociation.class, obj, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task associationEdit(final String networkId, final NetworkRnat obj) throws TerremarkException {
        return put(VERSION_2_10, "/rnats/networks/{networkId}", Task.class, obj, networkId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task associationRemove(final String associationId) throws TerremarkException {
        return delete(VERSION_2_10, "/rnats/associations/{associationId}", Task.class, associationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BackupInternetService backupInternetServiceCreate(final String environmentId,
                    final CreateBackupInternetService obj) throws TerremarkException {
        return post(VERSION_2_10,
                        "/backupInternetServices/environments/{environmentId}/action/createBackupInternetService",
                        BackupInternetService.class, obj, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task backupInternetServiceEdit(final BackupInternetService obj) throws TerremarkException {
        return put(VERSION_2_10, "/backupInternetServices/{backupInternetServiceId}", Task.class, obj,
                        TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task backupInternetServiceRemove(final String backupInternetServiceId) throws TerremarkException {
        return delete(VERSION_2_10, "/backupInternetServices/{backupInternetServiceId}", Task.class,
                        backupInternetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FirewallLog firewallLogCreate(final String environmentId, final FirewallLog obj) throws TerremarkException {
        return post(VERSION_2_10, "/firewallLogs/environments/{environmentId}/action/createFirewallLog",
                        FirewallLog.class, obj, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task firewallLogEdit(final String environmentId, final FirewallLog obj) throws TerremarkException {
        return put(VERSION_2_10, "/firewallLogs/environments/{environmentId}", Task.class, obj, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task firewallLogRemove(final String environmentId) throws TerremarkException {
        return delete(VERSION_2_10, "/firewallLogs/environments/{environmentId}", Task.class, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FirewallAcl firewallRuleCreate(final String environmentId, final CreateFirewallAcl obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/firewallAcls/environments/{environmentId}/action/createFirewallAcl",
                        FirewallAcl.class, obj, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task firewallRuleRemove(final String firewallRuleId) throws TerremarkException {
        return delete(VERSION_2_10, "/firewallAcls/custom/{firewallRuleId}", Task.class, firewallRuleId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RnatHostAssociation getAssociationByID(final String associationId) throws TerremarkException {
        return get(VERSION_2_10, "/rnats/associations/{associationId}", RnatHostAssociation.class, associationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BackupInternetServices getBackupInternetServices(final String environmentId) throws TerremarkException {
        return get(VERSION_2_10, "/backupInternetServices/environments/{environmentId}", BackupInternetServices.class,
                        environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BackupInternetService getBackupInternetServiceByID(final String backupInternetServiceId)
                    throws TerremarkException {
        return get(VERSION_2_10, "/backupInternetServices/{backupInternetServiceId}", BackupInternetService.class,
                        backupInternetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FirewallLog getFirewallLogs(final String environmentId) throws TerremarkException {
        return get(VERSION_2_10, "/firewallLogs/environments/{environmentId}", FirewallLog.class, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FirewallAcls getFirewallRules(final String environmentId, final Map<String, String> filterArguments)
                    throws TerremarkException {
        validateQueryArguments(filterArguments, FIREWALL_RULES_ARGS);

        return get(VERSION_2_10, "/firewallAcls/environments/{environmentId}", filterArguments, null,
                        FirewallAcls.class, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FirewallAcl getCustomFirewallRule(final String firewallRuleId) throws TerremarkException {
        return get(VERSION_2_10, "/firewallAcls/custom/{firewallRuleId}", FirewallAcl.class, firewallRuleId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FirewallAcl getNodeServiceFirewallRule(final String nodeServiceId) throws TerremarkException {
        return get(VERSION_2_10, "/firewallAcls/nodeServices/{nodeServiceId}", FirewallAcl.class, nodeServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InternetService getInternetServiceByID(final String internetServiceId) throws TerremarkException {
        return get(VERSION_2_10, "/internetServices/{internetServiceId}", InternetService.class, internetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IpAddress getIPAddressByID(final String networkId, final String hostIPAddress) throws TerremarkException {
        return get(VERSION_2_10, "/ipAddresses/networks/{networkId}/{hostIPAddress}", IpAddress.class, networkId,
                        hostIPAddress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultMonitor getMonitorByInternetService(final String internetServiceId) throws TerremarkException {
        return get(VERSION_2_10, "/internetServices/{internetServiceId}/monitor", DefaultMonitor.class,
                        internetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NetworkHostSummary getNetworkHosts(final String environmentId) throws TerremarkException {
        return get(VERSION_2_10, "/networkHosts/environments/{environmentId}", NetworkHostSummary.class, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NetworkHost getNetworkHostByID(final String networkHostId) throws TerremarkException {
        return get(VERSION_2_10, "/networkHosts/{networkHostId}", NetworkHost.class, networkHostId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Networks getNetworks(final String environmentId) throws TerremarkException {
        return get(VERSION_2_10, "/networks/environments/{environmentId}", Networks.class, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkByID(final String networkId) throws TerremarkException {
        return get(VERSION_2_10, "/networks/{networkId}", Network.class, networkId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeService getNodeServiceByID(final String nodeServiceId) throws TerremarkException {
        return get(VERSION_2_10, "/nodeServices/{nodeServiceId}", NodeService.class, nodeServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PublicIpAddresses getPublicIPs(final String environmentId) throws TerremarkException {
        return get(VERSION_2_10, "/publicIps/environments/{environmentId}", PublicIpAddresses.class, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PublicIp getPublicIPByID(final String publicIPId) throws TerremarkException {
        return get(VERSION_2_10, "/publicIps/{publicIPId}", PublicIp.class, publicIPId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RnatConfiguration getRNATs(final String environmentId) throws TerremarkException {
        return get(VERSION_2_10, "/rnats/environments/{environmentId}", RnatConfiguration.class, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Rnat getRNATByID(final String publicIPId) throws TerremarkException {
        return get(VERSION_2_10, "/rnats/{publicIPId}", Rnat.class, publicIPId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NetworkRnat getNetworkRNAT(final String networkId) throws TerremarkException {
        return get(VERSION_2_10, "/rnats/networks/{networkId}", NetworkRnat.class, networkId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrustedNetworkGroups getTrustedNetworkGroups(final String environmentId) throws TerremarkException {
        return get(VERSION_2_10, "/trustedNetworkGroups/environments/{environmentId}", TrustedNetworkGroups.class,
                        environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrustedNetworkGroup getTrustedNetworkGroupByID(final String trustedNetworkGroupId) throws TerremarkException {
        return get(VERSION_2_10, "/trustedNetworkGroups/{trustedNetworkGroupId}", TrustedNetworkGroup.class,
                        trustedNetworkGroupId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InternetService internetServiceCreate(final String publicIPId, final CreateInternetService obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/internetServices/publicIps/{publicIPId}/action/createInternetService",
                        InternetService.class, obj, publicIPId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Error internetServiceCreateforEnvironment(final String environmentId, final CreateInternetService obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/internetServices/environments/{environmentId}/action/createInternetService",
                        Error.class, obj, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task internetServiceEdit(final InternetService obj) throws TerremarkException {
        return put(VERSION_2_10, "/internetServices/{internetServiceId}", Task.class, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task internetServiceRemove(final String internetServiceId) throws TerremarkException {
        return delete(VERSION_2_10, "/internetServices/{internetServiceId}", Task.class, internetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ipAddressConfigureReservation(final String networkId, final IpAddresses obj) throws TerremarkException {
        post(VERSION_2_11, "/ipAddresses/networks/{networkId}/action/configureIpReservation", null, obj, networkId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ipAddressReserve(final String networkId, final String hostIPAddress) throws TerremarkException {
        post(VERSION_2_11, "/ipAddresses/networks/{networkId}/{hostIPAddress}/action/reserve", null, null, networkId,
                        hostIPAddress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ipAddressSync(final String networkId, final String hostIPAddress) throws TerremarkException {
        post(VERSION_2_10, "/ipAddresses/networks/{networkId}/{hostIPAddress}/action/sync", null, null, networkId,
                        hostIPAddress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ipAddressUnreserve(final String networkId, final String hostIPAddress) throws TerremarkException {
        post(VERSION_2_11, "/ipAddresses/networks/{networkId}/{hostIPAddress}/action/unreserve", null, null, networkId,
                        hostIPAddress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultMonitor monitorCreateDefault(final String internetServiceId) throws TerremarkException {
        return post(VERSION_2_10, "/internetServices/{internetServiceId}/action/createDefaultMonitor",
                        DefaultMonitor.class, null, internetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EcvMonitor monitorCreateECV(final String internetServiceId, final CreateEcvMonitor obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/internetServices/{internetServiceId}/action/createEcvMonitor", EcvMonitor.class,
                        obj, internetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HttpMonitor monitorCreateHTTP(final String internetServiceId, final CreateHttpMonitor obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/internetServices/{internetServiceId}/action/createHttpMonitor", HttpMonitor.class,
                        obj, internetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoopbackMonitor monitorCreateLoopback(final String internetServiceId) throws TerremarkException {
        return post(VERSION_2_10, "/internetServices/{internetServiceId}/action/createLoopbackMonitor",
                        LoopbackMonitor.class, null, internetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PingMonitor monitorCreatePing(final String internetServiceId, final CreatePingMonitor obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/internetServices/{internetServiceId}/action/createPingMonitor", PingMonitor.class,
                        obj, internetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task monitorDisable(final String internetServiceId) throws TerremarkException {
        return post(VERSION_2_10, "/internetServices/{internetServiceId}/action/disableMonitor", Task.class, null,
                        internetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EcvMonitor monitorEditECV(final String internetServiceId, final EcvMonitor obj) throws TerremarkException {
        return put(VERSION_2_10, "/internetServices/{internetServiceId}/monitor?type=ecv", EcvMonitor.class, obj,
                        internetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HttpMonitor monitorEditHTTP(final String internetServiceId, final HttpMonitor obj) throws TerremarkException {
        return put(VERSION_2_10, "/internetServices/{internetServiceId}/monitor?type=http", HttpMonitor.class, obj,
                        internetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PingMonitor monitorEditPing(final String internetServiceId, final PingMonitor obj) throws TerremarkException {
        return put(VERSION_2_10, "/internetServices/{internetServiceId}/monitor?type=ping", PingMonitor.class, obj,
                        internetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task monitorEnable(final String internetServiceId) throws TerremarkException {
        return post(VERSION_2_10, "/internetServices/{internetServiceId}/action/enableMonitor", Task.class, null,
                        internetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeService nodeServiceCreateBackup(final String backupInternetServiceId, final CreateNodeService obj)
                    throws TerremarkException {
        return post(VERSION_2_10,
                        "/nodeServices/backupInternetServices/{backupInternetServiceId}/action/createNodeService",
                        NodeService.class, obj, backupInternetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeService nodeServiceCreate(final String internetServiceId, final CreateNodeService obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/nodeServices/internetServices/{internetServiceId}/action/createNodeService",
                        NodeService.class, obj, internetServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task nodeServiceEdit(final NodeService obj) throws TerremarkException {
        return put(VERSION_2_10, "/nodeServices/{nodeServiceId}", Task.class, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task nodeServiceRemove(final String nodeServiceId) throws TerremarkException {
        return delete(VERSION_2_10, "/nodeServices/{nodeServiceId}", Task.class, nodeServiceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PublicIp publicIPActivate(final String environmentId) throws TerremarkException {
        return post(VERSION_2_10, "/publicIps/environments/{environmentId}/action/activatePublicIp", PublicIp.class,
                        null, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task publicIPRemove(final String publicIPId) throws TerremarkException {
        return delete(VERSION_2_10, "/publicIps/{publicIPId}", Task.class, publicIPId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrustedNetworkGroup trustedNetworkGroupCreate(final String environmentId, final CreateTrustedNetworkGroup obj)
                    throws TerremarkException {
        return post(VERSION_2_10,
                        "/trustedNetworkGroups/environments/{environmentId}/action/createTrustedNetworkGroup",
                        TrustedNetworkGroup.class, obj, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task trustedNetworkGroupEdit(final TrustedNetworkGroup obj) throws TerremarkException {
        return put(VERSION_2_10, "/trustedNetworkGroups/{trustedNetworkGroupId}", Task.class, obj,
                        TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task trustedNetworkGroupRemove(final String trustedNetworkGroupId) throws TerremarkException {
        return delete(VERSION_2_10, "/trustedNetworkGroups/{trustedNetworkGroupId}", Task.class, trustedNetworkGroupId);
    }
}
