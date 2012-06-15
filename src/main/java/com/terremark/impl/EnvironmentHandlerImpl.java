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
import static com.terremark.config.Version.VERSION_2_12;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.wink.client.RestClient;

import com.terremark.EnvironmentHandler;
import com.terremark.TerremarkFactory;
import com.terremark.api.AssignedIpAddresses;
import com.terremark.api.AttachDiskRetryOperation;
import com.terremark.api.ComputePool;
import com.terremark.api.ComputePools;
import com.terremark.api.CreateLayoutGroup;
import com.terremark.api.CreateLayoutRow;
import com.terremark.api.DetachDiskRetryOperation;
import com.terremark.api.DeviceLayout;
import com.terremark.api.EnvironmentNetworkSummary;
import com.terremark.api.HighAvailabilityRouter;
import com.terremark.api.LayoutGroup;
import com.terremark.api.LayoutRequest;
import com.terremark.api.LayoutRow;
import com.terremark.api.PhysicalDevices;
import com.terremark.api.PhysicalRouter;
import com.terremark.api.PhysicalServer;
import com.terremark.api.StorageDevice;
import com.terremark.api.Task;
import com.terremark.api.Tasks;
import com.terremark.exception.TerremarkException;
import com.terremark.impl.QueryArgument.Type;

/**
 * Implementation for API calls for objects with in an environment.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
@SuppressWarnings("PMD.CouplingBetweenObjects")
final class EnvironmentHandlerImpl extends AbstractAPIImpl implements EnvironmentHandler {
    /** Query argument metadata for {@link #getTasks(String, Map)} */
    private static final Map<String, QueryArgument> TASKS_ARGS = new HashMap<String, QueryArgument>();

    static {
        TASKS_ARGS.put("page", new QueryArgument(Type.INTEGER));
        TASKS_ARGS.put("pageSize", new QueryArgument(1, 1000));
        TASKS_ARGS.put("direction", new QueryArgument("asc", "ascending", "desc", "descending"));
        TASKS_ARGS.put("startDate", new QueryArgument(Type.ISO8601_DATE));
        TASKS_ARGS.put("endDate", new QueryArgument(Type.ISO8601_DATE));
        TASKS_ARGS.put("sortBy", new QueryArgument("ImpactedItem", "Operation", "Notes", "Status", "InitiatedBy",
                        "StartTime", "CompletedTime"));
    }

    /**
     * Package visible default constructor for creating environment handler.
     *
     * @param client Rest client instance.
     * @param properties Client configuration.
     */
    EnvironmentHandlerImpl(final RestClient client, final ClientConfiguration properties) {
        super(client, properties);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputePool computePoolEdit(final ComputePool obj) throws TerremarkException {
        if (obj == null) {
            throw new IllegalArgumentException("Invalid compute pool");
        }
        if (StringUtils.isEmpty(obj.getName())) {
            throw new IllegalArgumentException("Compute pool name cannot be null/empty");
        }
        if (obj.getName().length() > 25) {
            throw new IllegalArgumentException("Compute pool name cannot exceed 25 characters");
        }

        return put(VERSION_2_10, "/computePools/{computePoolId}", ComputePool.class, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputePools getComputePools(final String environmentId) throws TerremarkException {
        return get(VERSION_2_10, "/computePools/environments/{environmentId}", ComputePools.class, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputePool getComputePoolByID(final String computePoolId) throws TerremarkException {
        return get(VERSION_2_10, "/computePools/{computePoolId}", ComputePool.class, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HighAvailabilityRouter getHighAvailabilityRouterByID(final String haRouterId) throws TerremarkException {
        return get(VERSION_2_10, "/haRouters/{haRouterId}", HighAvailabilityRouter.class, haRouterId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LayoutGroup getLayoutGroupByID(final String groupId) throws TerremarkException {
        return get(VERSION_2_10, "/layoutGroups/{groupId}", LayoutGroup.class, groupId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LayoutRow getLayoutRowByID(final String rowId) throws TerremarkException {
        return get(VERSION_2_10, "/layoutRows/{rowId}", LayoutRow.class, rowId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeviceLayout getLayouts(final String environmentId) throws TerremarkException {
        return get(VERSION_2_10, "/layout/environments/{environmentId}", DeviceLayout.class, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeviceLayout getLayoutsByComputePool(final String computePoolId) throws TerremarkException {
        return get(VERSION_2_10, "/layout/computePools/{computePoolId}", DeviceLayout.class, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnvironmentNetworkSummary getNetworkSummary(final String environmentId) throws TerremarkException {
        return get(VERSION_2_10, "/networkSummary/environments/{environmentId}", EnvironmentNetworkSummary.class,
                        environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PhysicalDevices getPhysicalDevices(final String environmentId) throws TerremarkException {
        return get(VERSION_2_10, "/physicalDevices/environments/{environmentId}", PhysicalDevices.class, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PhysicalRouter getPhysicalRouterByID(final String physicalRouterId) throws TerremarkException {
        return get(VERSION_2_10, "/physicalRouters/{physicalRouterId}", PhysicalRouter.class, physicalRouterId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PhysicalServer getPhysicalServerByID(final String physicalServerId) throws TerremarkException {
        return get(VERSION_2_10, "/physicalServers/{physicalServerId}", PhysicalServer.class, physicalServerId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AttachDiskRetryOperation getRetryOperationAttachDiskByDetachedDisk(final String detachedDiskId)
                    throws TerremarkException {
        return get(VERSION_2_12, "/attachDiskRetryOperations/detachedDisks/{detachedDiskId}",
                        AttachDiskRetryOperation.class, detachedDiskId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AttachDiskRetryOperation getRetryOperationAttachDiskByVirtualMachine(final String virtualMachineId)
                    throws TerremarkException {
        return get(VERSION_2_12, "/attachDiskRetryOperations/virtualMachines/{virtualMachineId}",
                        AttachDiskRetryOperation.class, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetachDiskRetryOperation getRetryOperationDetachDiskByDetachedDisk(final String detachedDiskId)
                    throws TerremarkException {
        return get(VERSION_2_12, "/detachDiskRetryOperations/detachedDisks/{detachedDiskId}",
                        DetachDiskRetryOperation.class, detachedDiskId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetachDiskRetryOperation getRetryOperationDetachDiskByVirtualMachine(final String virtualMachineId)
                    throws TerremarkException {
        return get(VERSION_2_12, "/detachDiskRetryOperations/virtualMachines/{virtualMachineId}",
                        DetachDiskRetryOperation.class, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StorageDevice getStorageDeviceByID(final String storageDeviceId) throws TerremarkException {
        return get(VERSION_2_10, "/storageDevices/{storageDeviceId}", StorageDevice.class, storageDeviceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tasks getTasks(final String environmentId, final Map<String, String> filterArguments) throws TerremarkException {
        validateQueryArguments(filterArguments, TASKS_ARGS);

        return get(VERSION_2_10, "/tasks/environments/{environmentId}", filterArguments, null, Tasks.class,
                        environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tasks getTasksByDetachedDisk(final String detachedDiskId) throws TerremarkException {
        return get(VERSION_2_12, "/tasks/detachedDisks/{detachedDiskId}", Tasks.class, detachedDiskId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tasks getTasksByHighAvailabilityRouter(final String haRouterId) throws TerremarkException {
        return get(VERSION_2_10, "/tasks/haRouters/{haRouterId}", Tasks.class, haRouterId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task getTaskByID(final String taskId) throws TerremarkException {
        return get(VERSION_2_10, "/tasks/{taskId}", Task.class, taskId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tasks getTasksByPhysicalRouter(final String physicalRouterId) throws TerremarkException {
        return get(VERSION_2_10, "/tasks/physicalRouters/{physicalRouterId}", Tasks.class, physicalRouterId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tasks getTasksByPhysicalServer(final String physicalServerId) throws TerremarkException {
        return get(VERSION_2_10, "/tasks/physicalServers/{physicalServerId}", Tasks.class, physicalServerId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tasks getTasksByStorageDevice(final String storageDeviceId) throws TerremarkException {
        return get(VERSION_2_10, "/tasks/storageDevices/{storageDeviceId}", Tasks.class, storageDeviceId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tasks getTasksByVirtualMachine(final String virtualMachineId) throws TerremarkException {
        return get(VERSION_2_10, "/tasks/virtualMachines/{virtualMachineId}", Tasks.class, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task highAvailabilityRouterEdit(final HighAvailabilityRouter obj) throws TerremarkException {
        return put(VERSION_2_10, "/haRouters/{haRouterId}", Task.class, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void highAvailabilityRouterMove(final String haRouterId, final LayoutRequest obj) throws TerremarkException {
        post(VERSION_2_10, "/haRouters/{haRouterId}/action/move", null, obj, haRouterId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LayoutGroup layoutGroupCreate(final String environmentId, final CreateLayoutGroup obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/layoutGroups/environments/{environmentId}/action/createLayoutGroup",
                        LayoutGroup.class, obj, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void layoutGroupEdit(final LayoutGroup obj) throws TerremarkException {
        put(VERSION_2_10, "/layoutGroups/{groupId}", null, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void layoutGroupOrderHigher(final String groupId) throws TerremarkException {
        post(VERSION_2_10, "/layoutGroups/{groupId}/action/orderHigher", null, null, groupId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void layoutGroupOrderLower(final String groupId) throws TerremarkException {
        post(VERSION_2_10, "/layoutGroups/{groupId}/action/orderLower", null, null, groupId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void layoutGroupRemove(final String groupId) throws TerremarkException {
        delete(VERSION_2_10, "/layoutGroups/{groupId}", groupId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LayoutRow layoutRowCreate(final String environmentId, final CreateLayoutRow obj) throws TerremarkException {
        return post(VERSION_2_10, "/layoutRows/environments/{environmentId}/action/createLayoutRow", LayoutRow.class,
                        obj, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void layoutRowEdit(final LayoutRow obj) throws TerremarkException {
        put(VERSION_2_10, "/layoutRows/{rowId}", null, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void layoutRowMoveDown(final String rowId) throws TerremarkException {
        post(VERSION_2_10, "/layoutRows/{rowId}/action/moveDown", null, null, rowId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void layoutRowMoveUp(final String rowId) throws TerremarkException {
        post(VERSION_2_10, "/layoutRows/{rowId}/action/moveUp", null, null, rowId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void layoutRowRemove(final String rowId) throws TerremarkException {
        delete(VERSION_2_10, "/layoutRows/{rowId}", rowId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task physicalRouterEdit(final PhysicalRouter obj) throws TerremarkException {
        return put(VERSION_2_10, "/physicalRouters/{physicalRouterId}", Task.class, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void physicalRouterMove(final String physicalRouterId, final LayoutRequest obj) throws TerremarkException {
        post(VERSION_2_10, "/physicalRouters/{physicalRouterId}/action/move", null, obj, physicalRouterId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task physicalServerEdit(final PhysicalServer obj) throws TerremarkException {
        return put(VERSION_2_10, "/physicalServers/{physicalServerId}", Task.class, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task physicalServerEditAssignedIPAddress(final String physicalServerId, final AssignedIpAddresses obj)
                    throws TerremarkException {
        return put(VERSION_2_10, "/physicalServers/{physicalServerId}/assignedIps", Task.class, obj, physicalServerId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void physicalServerMove(final String physicalServerId, final LayoutRequest obj) throws TerremarkException {
        post(VERSION_2_10, "/physicalServers/{physicalServerId}/action/move", null, obj, physicalServerId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task retryOperationAttachDiskByDetachedDisk(final String detachedDiskId) throws TerremarkException {
        return post(VERSION_2_12, "/attachDiskRetryOperations/detachedDisks/{detachedDiskId}/action/retry", Task.class,
                        null, detachedDiskId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task retryOperationAttachDiskByVirtualMachine(final String virtualMachineId) throws TerremarkException {
        return post(VERSION_2_12, "/attachDiskRetryOperations/virtualMachines/{virtualMachineId}/action/retry",
                        Task.class, null, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task retryOperationDetachDiskByDetachedDisk(final String detachedDiskId) throws TerremarkException {
        return post(VERSION_2_12, "/detachDiskRetryOperations/detachedDisks/{detachedDiskId}/action/retry", Task.class,
                        null, detachedDiskId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task retryOperationDetachDiskByVirtualMachine(final String virtualMachineId) throws TerremarkException {
        return post(VERSION_2_12, "/detachDiskRetryOperations/virtualMachines/{virtualMachineId}/action/retry",
                        Task.class, null, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task storageDeviceEdit(final StorageDevice obj) throws TerremarkException {
        return put(VERSION_2_10, "/storageDevices/{storageDeviceId}", Task.class, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void storageDeviceMove(final String storageDeviceId, final LayoutRequest obj) throws TerremarkException {
        post(VERSION_2_10, "/storageDevices/{storageDeviceId}/action/move", null, obj, storageDeviceId);
    }
}