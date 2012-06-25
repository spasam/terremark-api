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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.terremark.annotations.Order;
import com.terremark.api.AttachDisks;
import com.terremark.api.CreateInternetService;
import com.terremark.api.CreateNodeService;
import com.terremark.api.CreateVirtualMachine;
import com.terremark.api.DetachDisk;
import com.terremark.api.DetachedDisk;
import com.terremark.api.DeviceLayout;
import com.terremark.api.DnsSettings;
import com.terremark.api.HardwareConfiguration;
import com.terremark.api.InternetService;
import com.terremark.api.InternetServicePersistence;
import com.terremark.api.IpAddress;
import com.terremark.api.LayoutGroup;
import com.terremark.api.LayoutRequest;
import com.terremark.api.LayoutRow;
import com.terremark.api.LinuxCustomization;
import com.terremark.api.LoadBalancingMethod;
import com.terremark.api.NetworkAdapterSetting;
import com.terremark.api.NetworkReference;
import com.terremark.api.NetworkSettings;
import com.terremark.api.NetworkTypeEnum;
import com.terremark.api.NodeService;
import com.terremark.api.PersistenceTypeEnum;
import com.terremark.api.ProtocolTypeEnum;
import com.terremark.api.PublicIp;
import com.terremark.api.PublicIpAddressReference;
import com.terremark.api.PublicIpAddresses;
import com.terremark.api.Reference;
import com.terremark.api.ResourceCapacity;
import com.terremark.api.Task;
import com.terremark.api.Template;
import com.terremark.api.TemplateCategory;
import com.terremark.api.TemplateFamily;
import com.terremark.api.TemplateOperatingSystem;
import com.terremark.api.Templates;
import com.terremark.api.VirtualDisk;
import com.terremark.api.VirtualDiskBase;
import com.terremark.api.VirtualMachine;
import com.terremark.exception.RequestFailedException;
import com.terremark.exception.TerremarkException;

/**
 * TODO
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class VirtualMachineTest extends AbstractCloudApiAuthTestBase {
    /** TODO */
    private static final String LINUX_64_TEMPLATE_NAME = LIVESPEC ? "RHEL 64 bit" : "CentOS 5.5 x64";
    /** TODO */
    private static final String TAG_NAME = "Terremark Java API Tag";
    /** TODO */
    private static final String ROW = "Terremark Java API Row";
    /** TODO */
    private static final String GROUP = "Terremark Java API Group";
    /** TODO */
    private static final String DESCRIPTION = "Terremark Java API Test";
    /** TODO */
    private static Reference linuxTemplate;
    /** TODO */
    private static String virtualMachineId;
    /** TODO */
    private static String detachedDiskId1;
    /** TODO */
    private static String detachedDiskId2;
    /** TODO */
    private static IpAddress vmIPAddress;

    /**
     * TODO
     *
     * @throws TerremarkException If there is a problem retrieving templates.
     */
    @Order(1)
    @Test
    public void testTemplates() throws TerremarkException {
        getComputePoolId();

        final Templates templates = client.getComputePoolHandler().getTemplates(computePoolId);
        assertResourceNoName(templates);
        assertTrue("Invalid template families: " + templates, templates.getFamilies().size() > 0);

        final TemplateFamily family = templates.getFamilies().get(0);
        assertNotNull("Invalid template family: " + templates, family);
        assertNotNull("Invalid template family name: " + family, family.getName());
        assertTrue("Invalid template family categories: " + family, family.getCategories().size() > 0);

        final TemplateCategory category = family.getCategories().get(0);
        assertNotNull("Invalid template category: " + family, category);
        assertNotNull("Invalid template category name: " + category, category.getName());
        assertTrue("Invalid template category operating systems: " + category,
                        category.getOperatingSystems().size() > 0);

        for (final TemplateOperatingSystem os : category.getOperatingSystems()) {
            assertNotNull("Invalid template operating system: " + category, os);
            assertNotNull("Invalid template operating system name: " + os, os.getName());
            assertTrue("Invalid template operating system templates: " + os, os.getTemplates().size() > 0);

            for (final Reference template : os.getTemplates()) {
                assertReference(template);
                assertNotNull("Invalid template id: " + template, TerremarkFactory.getTemplateId(template));

                if (LINUX_64_TEMPLATE_NAME.equals(template.getName())) {
                    linuxTemplate = template;
                }
            }
        }

        assertNotNull(LINUX_64_TEMPLATE_NAME + " template not found", linuxTemplate);
    }

    /**
     * TODO
     *
     * @throws TerremarkException If there is a problem retrieving a template.
     */
    @Order(2)
    @Test
    public void testTemplate() throws TerremarkException {
        final Template template = client.getComputePoolHandler().getTemplateByID(
                        TerremarkFactory.getTemplateId(linuxTemplate), computePoolId);
        assertResource(template);
        assertNotNull("Invalid template id: " + template, TerremarkFactory.getTemplateId(template));
    }

    /**
     * TODO
     *
     * @throws Exception If there is a problem creating a VM.
     */
    @Order(3)
    @Test
    public void testVMCreate() throws Exception {
        final String sshKeyName = "Terremark_Java_API_" + TEST_ID;
        final Reference sshKey = createSshKey(sshKeyName);

        final NetworkReference network = getNetwork(NetworkTypeEnum.DMZ);
        vmIPAddress = getFreeIpAddress(network);

        final NetworkAdapterSetting adapterSetting = new NetworkAdapterSetting();
        adapterSetting.setIpAddress(vmIPAddress.getName());
        adapterSetting.setNetwork(network);

        final DnsSettings dnsSettings = new DnsSettings();
        dnsSettings.setPrimaryDns("8.8.8.8");
        dnsSettings.setPrimaryDns("8.8.4.4");

        final NetworkSettings networkSettings = new NetworkSettings();
        networkSettings.setDnsSettings(dnsSettings);
        networkSettings.getNetworkAdapterSettings().add(adapterSetting);

        final LayoutRequest layoutRequest = new LayoutRequest();
        layoutRequest.setNewRow(ROW);
        layoutRequest.setNewGroup(GROUP);

        final LinuxCustomization customization = new LinuxCustomization();
        customization.setNetworkSettings(networkSettings);
        customization.setSshKey(sshKey);

        final ResourceCapacity memory = new ResourceCapacity();
        memory.setUnit("MB");
        memory.setValue(new BigDecimal(1024));

        final CreateVirtualMachine createVM = new CreateVirtualMachine();
        createVM.setDescription(DESCRIPTION);
        createVM.setLayout(layoutRequest);
        createVM.setLinuxCustomization(customization);
        createVM.setMemory(memory);
        createVM.setName("JS" + TEST_ID);
        createVM.setProcessorCount(1);
        createVM.getTags().add(TAG_NAME);
        createVM.setTemplate(linuxTemplate);
        createVM.setPoweredOn(Boolean.FALSE);

        VirtualMachine vm = client.getComputePoolHandler().virtualMachineCreateFromTemplate(computePoolId, createVM);
        assertResource(vm);
        assertTrue("Invalid VM actions: " + vm, vm.getActions().size() > 0);
        assertEquals("Invalid VM description: " + vm, DESCRIPTION, vm.getDescription());
        assertNotNull("Invalid VM layout: " + vm, vm.getLayout());
        assertEquals("Invalid VM layout row: " + vm, ROW, vm.getLayout().getRow().getName());
        assertEquals("Invalid VM layout group: " + vm, GROUP, vm.getLayout().getGroup().getName());
        assertTrue("Invalid VM links: " + vm, vm.getLinks().size() > 0);
        assertNotNull("Invalid VM media status: " + vm, vm.getMediaStatus());
        assertEquals("Invalid VM name: " + vm, "JS" + TEST_ID, vm.getName());
        assertNotNull("Invalid VM network host: " + vm, vm.getNetworkHost());
        assertNotNull("Invalid VM status: " + vm, vm.getStatus());
        assertNotNull("Invalid VM tags: " + vm, vm.getTags());
        assertTrue("Invalid VM tag: " + vm, vm.getTags().contains(TAG_NAME));
        assertNotNull("Invalid VM tasks: " + vm, vm.getTasks());

        virtualMachineId = TerremarkFactory.getId(vm);
        waitForTask(vm.getTasks().getTasks().get(0));
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(4)
    @Test
    public void testPowerOn() throws Exception {
        if (LIVESPEC) {
            virtualMachineId = "4";
        }

        Task task = client.getComputePoolHandler().virtualMachinePowerOn(virtualMachineId);
        waitForTask(task);

        // The VM is not really started. Wait for it it start. We can either look for detected IP address(es) or the
        // status of VMware tools
        waitForVMPowerOn(virtualMachineId);
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(5)
    @Test
    public void testAddDisk() throws Exception {
        if (LIVESPEC) {
            virtualMachineId = "1";
        }

        VirtualMachine vm = client.getComputePoolHandler().getVirtualMachineByID(virtualMachineId);
        assertResource(vm);

        HardwareConfiguration hc = vm.getHardwareConfiguration();
        assertResourceNoName(hc);

        // Get the last disk's index and add one
        int index = hc.getDisks().get(hc.getDisks().size() - 1).getIndex().intValue();

        ResourceCapacity capacity = new ResourceCapacity();
        capacity.setUnit("GB"); // Must be GB
        capacity.setValue(new BigDecimal(LIVESPEC ? 25 : 1));

        VirtualDisk disk1 = new VirtualDisk();
        disk1.setName("Disk 1 " + TEST_ID); // Ignored
        disk1.setIndex(Integer.valueOf(index + 1)); // Ignored
        disk1.setSize(capacity);

        VirtualDisk disk2 = new VirtualDisk();
        disk2.setName("Disk 2 " + TEST_ID); // Ignored
        disk2.setIndex(Integer.valueOf(index + 2)); // Ignored
        disk2.setSize(capacity);

        hc.getDisks().add(disk1);
        hc.getDisks().add(disk2);

        Task task = client.getComputePoolHandler().virtualMachineEditHardwareConfiguration(virtualMachineId, hc);
        waitForTask(task);
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(6)
    @Test
    public void testShutdown() throws Exception {
        if (LIVESPEC) {
            virtualMachineId = "1";
        }

        Task task = client.getComputePoolHandler().virtualMachineShutdown(virtualMachineId);
        waitForTask(task);

        // The VM is not really shutdown. Wait for it it shutdown
        waitForVMPowerOff(virtualMachineId);
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(7)
    @Test
    public void testDetachDisks() throws Exception {
        VirtualMachine vm = client.getComputePoolHandler().getVirtualMachineByID(virtualMachineId);
        assertResource(vm);

        // Get the disks, we want to detach the last two
        List<VirtualDisk> disks = vm.getHardwareConfiguration().getDisks();

        // Detach the last one
        VirtualDiskBase disk = new VirtualDiskBase();
        disk.setIndex(disks.get(disks.size() - 1).getIndex());

        DetachDisk detachDisk = new DetachDisk();
        detachDisk.setName("D1" + TEST_ID);
        detachDisk.setDescription("New detached disk " + TEST_ID);
        detachDisk.setDisk(disk);

        DetachedDisk detachedDisk = client.getComputePoolHandler().virtualMachineDetachDisk(virtualMachineId,
                        detachDisk);
        assertResource(detachedDisk);
        assertNotNull("Invalid detached disk tasks: " + detachedDisk, detachedDisk.getTasks());
        assertTrue("Invalid detached disk tasks: " + detachedDisk, detachedDisk.getTasks().getTasks().size() == 1);
        detachedDiskId1 = TerremarkFactory.getId(detachedDisk);

        // Wait for the detach disk task to finish
        waitForTask(detachedDisk.getTasks().getTasks().get(0));

        if (!LIVESPEC) {
            // Detach the last but one
            disk.setIndex(disks.get(disks.size() - 2).getIndex());

            detachDisk.setName("D2" + TEST_ID);
            detachDisk.setDisk(disk);

            detachedDisk = client.getComputePoolHandler().virtualMachineDetachDisk(virtualMachineId, detachDisk);
            assertResource(detachedDisk);
            assertNotNull("Invalid detached disk tasks: " + detachedDisk, detachedDisk.getTasks());
            assertTrue("Invalid detached disk tasks: " + detachedDisk, detachedDisk.getTasks().getTasks().size() == 1);
            detachedDiskId2 = TerremarkFactory.getId(detachedDisk);

            // Wait for the detach disk task to finish
            waitForTask(detachedDisk.getTasks().getTasks().get(0));
        }
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(8)
    @Test
    public void testReattachDisk() throws Exception {
        DetachedDisk disk = client.getComputePoolHandler().getDetachedDiskByID(detachedDiskId1);
        assertResource(disk);
        assertNotNull("Invalid detached disk description: " + disk, disk.getDescription());
        assertNotNull("Invalid detached disk size: " + disk, disk.getSize());

        AttachDisks attachDisks = new AttachDisks();
        attachDisks.getDetachedDisks().add(TerremarkFactory.getReference(disk));

        Task task = client.getComputePoolHandler().virtualMachineAttachDisk(virtualMachineId, attachDisks);
        waitForTask(task);
    }

    /**
     * TODO
     *
     * @throws Exception
     */
    @Order(9)
    @Test
    public void testNetwork() throws Exception {
        PublicIpAddresses addrs = client.getNetworkHandler().getPublicIPs(environmentId);
        PublicIp address = null;

        // Find free public IP
        for (PublicIpAddressReference addr : addrs.getPublicIps()) {
            PublicIp ipAddr = client.getNetworkHandler().getPublicIPByID(TerremarkFactory.getId(addr));
            boolean found = false;

            for (InternetService is : ipAddr.getInternetServices()) {
                if (is.getPort().longValue() == 22) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                address = ipAddr;
                break;
            }
        }

        if (address == null) {
            throw new Exception("Unable to find a free public IP address");
        }

        List<String> internetServices = new ArrayList<String>();
        List<String> nodeServices = new ArrayList<String>();

        for (ProtocolTypeEnum protocol : new ProtocolTypeEnum[] {ProtocolTypeEnum.TCP, ProtocolTypeEnum.UDP}) {
            // Create Internet service
            InternetServicePersistence isPersistence = new InternetServicePersistence();
            isPersistence.setType(PersistenceTypeEnum.NONE);

            CreateInternetService createInternetService = new CreateInternetService();
            createInternetService.setDescription("Internet service description");
            createInternetService.setEnabled(true);
            createInternetService.setLoadBalancingMethod(LoadBalancingMethod.LEAST_CONNECTION);
            createInternetService.setName("IS-" + TEST_ID + "-" + protocol.value() + ":22");
            createInternetService.setPersistence(isPersistence);
            createInternetService.setPort(22);
            createInternetService.setProtocol(protocol);

            InternetService is = client.getNetworkHandler().internetServiceCreate(TerremarkFactory.getId(address),
                            createInternetService);
            assertResource(is);
            internetServices.add(TerremarkFactory.getId(is));

            // Disable monitoring on Internet service
            client.getNetworkHandler().monitorCreateLoopback(TerremarkFactory.getId(is));

            // HACK: Terremark Enterprise (as of 2.12) does not allow creating multiple Internet/node services on same
            // port but different protocols (TCP/UDP). This can only be done if the the Internet services have default
            // monitors. So create a default monitor on all Internet services that are on the same port. Add the node
            // service and add back the loopback monitors
            for (String serviceId : internetServices) {
                try {
                    client.getNetworkHandler().monitorCreateDefault(serviceId);
                } catch (RequestFailedException ex) {
                    // Livespec env says: "Intenet service monitor already exists"
                }
            }

            // Create node service
            CreateNodeService createNodeService = new CreateNodeService();
            createNodeService.setDescription("Node service description");
            createNodeService.setEnabled(true);
            createNodeService.setIpAddress(TerremarkFactory.getReference(vmIPAddress));
            createNodeService.setName("NS-" + TEST_ID + "-" + protocol.value() + ":22");
            createNodeService.setPort(22);

            NodeService ns = client.getNetworkHandler().nodeServiceCreate(TerremarkFactory.getId(is), createNodeService);
            assertResource(ns);
            nodeServices.add(TerremarkFactory.getId(ns));

            for (String serviceId : internetServices) {
                client.getNetworkHandler().monitorCreateLoopback(serviceId);
            }
        }

        // Edit a Internet service
        InternetService is = client.getNetworkHandler().getInternetServiceByID(internetServices.get(0));
        is.setName("New IS-" + TEST_ID);
        Task task = client.getNetworkHandler().internetServiceEdit(is);
        waitForTask(task);

        // Edit a node service
        NodeService ns = client.getNetworkHandler().getNodeServiceByID(nodeServices.get(0));
        ns.setName("New NS-" + TEST_ID);
        task = client.getNetworkHandler().nodeServiceEdit(ns);
        waitForTask(task);

        // Delete node services
        for (String serviceId : nodeServices) {
            task = client.getNetworkHandler().nodeServiceRemove(serviceId);
            waitForTask(task);
        }

        // Delete Internet services
        if (!LIVESPEC) {
            for (String serviceId : internetServices) {
                task = client.getNetworkHandler().internetServiceRemove(serviceId);
                waitForTask(task);
            }
        }
    }

    /**
     * TODO
     *
     * @throws Exception If there is a problem deleting the VM, detached disk or SSH key.
     */
    @Order(10)
    @Test
    public void testDelete() throws Exception {
        if (LIVESPEC) {
            detachedDiskId2 = "1";
            virtualMachineId = "2";
        }

        Task task = client.getComputePoolHandler().detachedDiskRemove(detachedDiskId2);
        waitForTask(task);

        task = client.getComputePoolHandler().virtualMachineRemove(virtualMachineId);
        waitForTask(task);

        deleteSshKey();

        DeviceLayout layouts = client.getEnvironmentHandler().getLayouts(environmentId);
        assertResourceNoName(layouts);
        assertNotNull("Invalid layout rows: " + layouts, layouts.getRows());
        for (LayoutRow row : layouts.getRows()) {
            assertNotNull("Invalid layout row: " + row, row.getGroups());

            for (LayoutGroup group : row.getGroups()) {
                if (GROUP.equals(group.getName())) {
                    client.getEnvironmentHandler().layoutGroupRemove(TerremarkFactory.getId(group));
                    break;
                }
            }

            if (ROW.equals(row.getName())) {
                client.getEnvironmentHandler().layoutRowRemove(TerremarkFactory.getId(row));
            }
        }
    }
}
