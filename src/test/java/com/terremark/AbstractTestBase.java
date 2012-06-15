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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.junit.runner.RunWith;

import com.terremark.api.ComputePools;
import com.terremark.api.CreateSshKey;
import com.terremark.api.Environments;
import com.terremark.api.IpAddress;
import com.terremark.api.Network;
import com.terremark.api.NetworkReference;
import com.terremark.api.NetworkTypeEnum;
import com.terremark.api.Networks;
import com.terremark.api.Organizations;
import com.terremark.api.Reference;
import com.terremark.api.Resource;
import com.terremark.api.SshKey;
import com.terremark.api.Task;
import com.terremark.api.TaskStatus;
import com.terremark.api.VirtualMachine;
import com.terremark.config.ContentType;
import com.terremark.config.Version;
import com.terremark.exception.TerremarkException;
import com.terremark.junit.OrderedTestRunner;

/**
 * TODO
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
@RunWith(OrderedTestRunner.class)
public class AbstractTestBase {
    /** TODO */
    private static final String[] LIVESPEC_CONFIG = new String[] {
                    "https://services.enterprisecloud.terremark.com/cloudapi/spec",
                    "test@terremark.com",
                    "T3rr3m@rk",
                    "33333333333333333333333333333333",
                    "3333333333333333333333333333333333333333333333333333333333333333"};

    /** TODO */
    private static final String[] REAL_ENV_CONFIG = new String[] {
                    "https://services.enterprisecloud.terremark.com/cloudapi/ecloud",
                    "user@email.com",
                    "password",
                    "access key",
                    "private key"};

    /** Whether to use Livespec environment or Beta environment */
    protected static final boolean LIVESPEC = false;

    /** API endpoint URL */
    protected static final String ENDPOINT_URL = LIVESPEC ? LIVESPEC_CONFIG[0] : REAL_ENV_CONFIG[0];

    /** User name for basic authentication */
    protected static final String USER = LIVESPEC ? LIVESPEC_CONFIG[1] : REAL_ENV_CONFIG[1];

    /** Password for basic authentication */
    protected static final String PASSWORD = LIVESPEC ? LIVESPEC_CONFIG[2] : REAL_ENV_CONFIG[2];

    /** Access key for Cloud API authentication */
    protected static final String ACCESS_KEY = LIVESPEC ? LIVESPEC_CONFIG[3] : REAL_ENV_CONFIG[3];

    /** Private key for Cloud API authentication */
    protected static final String PRIVATE_KEY = LIVESPEC ? LIVESPEC_CONFIG[4] : REAL_ENV_CONFIG[4];

    /** API version to use */
    protected static final Version VERSION = Version.VERSION_2_12;

    /** Content type to use */
    protected static final ContentType CONTENT_TYPE = ContentType.XML;

    /** Client handle for making API the calls */
    protected static TerremarkClient client;

    /** TODO */
    protected static final long TEST_ID = System.currentTimeMillis();

    /** TODO */
    protected static String organizationId;
    /** TODO */
    protected static String environmentId;
    /** TODO */
    protected static String computePoolId;
    /** TODO */
    private static String sshKeyName;
    /** TODO */
    private static String sshKeyId;

    /**
     * TODO
     *
     * @param resource
     */
    protected void assertResourceNoName(final Resource resource) {
        assertNotNull(resource);
        assertNotNull("Resource does not have href: " + resource, resource.getHref());
        assertNotNull("Resource does not have type: " + resource, resource.getType());
    }

    /**
     * TODO
     *
     * @param resource
     */
    protected void assertResource(final Resource resource) {
        assertResourceNoName(resource);
        assertNotNull("Resource does not have name: " + resource, resource.getName());
        // Assert.assertNotNull("Resource does not have actions: " + resource, resource.getActions());
        // Assert.assertNotNull("Resource does not have links: " + resource, resource.getLinks());
    }

    /**
     * TODO
     *
     * @param reference
     */
    protected void assertReference(final Reference reference) {
        assertNotNull(reference);
        assertNotNull("Reference does not have name: " + reference, reference.getName());
        assertNotNull("Reference does not have href: " + reference, reference.getHref());
        assertNotNull("Reference does not have type: " + reference, reference.getType());
    }

    /**
     * TODO
     *
     * @return
     * @throws TerremarkException
     */
    protected Organizations getOrganizations() throws TerremarkException {
        assertNotNull("Invalid client", client);

        final Organizations orgs = client.getOrganizationHandler().getOrganizations();
        assertNotNull("Invalid organizations", orgs);
        assertTrue("Should get at least one organization: " + orgs, orgs.getOrganizations().size() > 0);
        organizationId = TerremarkFactory.getId(orgs.getOrganizations().get(0));

        return orgs;
    }

    /**
     * TODO
     *
     * @throws TerremarkException
     */
    protected void getEnvironmentId() throws TerremarkException {
        assertNotNull("Invalid client", client);

        if (organizationId == null) {
            getOrganizations();
        }

        final Environments envs = client.getOrganizationHandler().getEnvironments(organizationId);
        assertResourceNoName(envs);
        assertTrue("Invalid environments: " + envs, envs.getEnvironments().size() > 0);

        environmentId = TerremarkFactory.getId(envs.getEnvironments().get(0));
    }

    /**
     * TODO
     *
     * @throws TerremarkException
     */
    protected void getComputePoolId() throws TerremarkException {
        assertNotNull("Invalid client", client);

        if (environmentId == null) {
            getEnvironmentId();
        }

        final ComputePools pools = client.getEnvironmentHandler().getComputePools(environmentId);
        assertNotNull("Invalid compute pools", pools);
        assertTrue("Was expecting at least one compute pool: " + pools, pools.getComputePools().size() > 0);
        assertReference(pools.getComputePools().get(0));

        computePoolId = TerremarkFactory.getId(pools.getComputePools().get(0));
    }

    /**
     * TODO
     *
     * @param keyName
     * @throws Exception
     */
    protected Reference createSshKey(final String keyName) throws Exception {
        if (organizationId == null) {
            getOrganizations();
        }

        final CreateSshKey createSshKey = new CreateSshKey();
        createSshKey.setDefault(Boolean.FALSE);
        createSshKey.setName(keyName);

        SshKey sshKey = client.getOrganizationHandler().sshKeyCreate(organizationId, createSshKey);
        assertNotNull("SSH key not created");
        assertResource(sshKey);
        assertNotNull("Invalid SSH private key: " + sshKey, sshKey.getPrivateKey());
        assertNotNull("Invalid SSH fingerprint: " + sshKey, sshKey.getFingerPrint());

        OutputStream os = new FileOutputStream(System.getProperty("java.io.tmpdir") + "/" + keyName + ".pem");
        try {
            os.write(sshKey.getPrivateKey().getBytes());
        } finally {
            os.close();
        }

        sshKeyName = keyName;
        sshKeyId = TerremarkFactory.getId(sshKey);

        return TerremarkFactory.getReference(sshKey);
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    protected void deleteSshKey() throws Exception {
        assertNotNull("Invalid SSH key ID", sshKeyId);
        client.getOrganizationHandler().sshKeysRemove(sshKeyId);

        assertNotNull("Invalid SSH key name", sshKeyName);
        Runtime.getRuntime().exec("/bin/rm -rf " + System.getProperty("java.io.tmpdir") + "/" + sshKeyName + ".pem");
    }

    /**
     * TODO
     *
     * @param type
     * @return
     * @throws TerremarkException
     */
    protected NetworkReference getNetwork(NetworkTypeEnum type) throws TerremarkException {
        if (environmentId == null) {
            getEnvironmentId();
        }

        Networks networks = client.getNetworkHandler().getNetworks(environmentId);
        for (NetworkReference nr : networks.getNetworks()) {
            assertReference(nr);
            if (nr.getNetworkType() == type) {
                return nr;
            }
        }

        assertTrue(type.toString() + " network not found in: " + environmentId, false);
        return null;
    }

    /**
     * TODO
     *
     * @param network
     * @return
     * @throws TerremarkException
     */
    protected IpAddress getFreeIpAddress(Reference network) throws TerremarkException {
        Network n = client.getNetworkHandler().getNetworkByID(TerremarkFactory.getId(network));
        assertResource(n);
        assertNotNull("Invalid IP address in network: " + n, n.getIpAddresses());
        assertTrue("Invalid IP address in network: " + n, n.getIpAddresses().getIpAddresses().size() > 0);

        for (IpAddress ipaddr : n.getIpAddresses().getIpAddresses()) {
            assertResource(ipaddr);

            if (ipaddr.getHost() == null && !ipaddr.isReserved().booleanValue()) {
                assertResource(ipaddr);

                return ipaddr;
            }
        }

        assertTrue("No free IP address found in: " + network, false);
        return null;
    }

    /**
     * TODO
     *
     * @param task
     * @throws Exception
     */
    protected void waitForTask(Task task) throws Exception {
        assertNotNull("Invalid task", task);
        String taskId = TerremarkFactory.getId(task);
        Task t = task;

        while (t.getStatus() != TaskStatus.COMPLETE) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException ex) {
                // Ignore
            }

            t = client.getEnvironmentHandler().getTaskByID(taskId);
            assertResourceNoName(t);

            switch (t.getStatus()) {
            case COMPLETE:
                return;
            case ERROR:
                throw new Exception("Task failed with error: " + t);
            case QUEUED:
            case RUNNING:
                // Continue
            }
        }
    }

    /**
     * TODO
     *
     * @param vmId
     * @throws TerremarkException
     */
    protected void waitForVMPowerOn(String vmId) throws TerremarkException {
        assertNotNull("Invalid virtual machine ID", vmId);

        VirtualMachine vm = client.getComputePoolHandler().getVirtualMachineByID(vmId);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException ex) {
                // Ignore
            }

            vm = client.getComputePoolHandler().getVirtualMachineByID(vmId);
            assertResource(vm);

            switch (vm.getToolsStatus()) {
            case CURRENT:
            case OUT_OF_DATE:
                return;
            case NOT_INSTALLED:
            case NOT_RUNNING:
                // Wait and retry
            }
        }
    }

    /**
     * TODO
     *
     * @param vmId
     * @throws TerremarkException
     */
    protected void waitForVMPowerOff(String vmId) throws TerremarkException {
        assertNotNull("Invalid virtual machine ID", vmId);

        VirtualMachine vm = client.getComputePoolHandler().getVirtualMachineByID(vmId);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException ex) {
                // Ignore
            }

            vm = client.getComputePoolHandler().getVirtualMachineByID(vmId);
            assertResource(vm);

            if (!vm.isPoweredOn().booleanValue()) {
                return;
            }
        }
    }
}
