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

/**
 * Provides API calls for objects with in an environment:
 * <ul>
 * <li>Compute pool
 * <li>Network summary
 * <li>Physical device
 * <li>Retry operation
 * <li>Task
 * <li>Layout
 * <ul>
 * <li>Row
 * <li>Group
 * </ul>
 * </ul>
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public interface EnvironmentHandler {
    /**
     * Method to edit the name for a specified compute pool. If successful, the call returns information regarding the
     * compute pool that was modified.
     * <p/>
     * The {@code name} on {@code ComputePool} is required, may not exceed twenty-five characters, and may be changed.
     * <p/>
     * {@code VirtualMachines} and {@code Purchased} are optional and ignored if present.
     * <p/>
     * {@code CpuBurst} and {@code MemoryBurst} are optional and ignored if present. To enable processor or memory
     * burst, use the calls {@link ComputePoolHandler#enableProcessorBurst(String)} and
     * {@link ComputePoolHandler#enableMemoryBurst(String)} respectively. To disable processor or memory burst, use the
     * calls {@link ComputePoolHandler#disableProcessorBurst(String)} and
     * {@link ComputePoolHandler#disableMemoryBurst(String)} respectively.
     *
     * @param obj Compute pool with name updated.
     * @return Updated compute pool.
     * @throws TerremarkException If an error occurs changing the name of the compute pool.
     */
    ComputePool computePoolEdit(ComputePool obj) throws TerremarkException;

    /**
     * This call returns information regarding compute pools defined in an environment.
     * <p/>
     * {@code ProcessorCount} refers to the number of processors in the virtual machine. Permitted values are: 1, 2, 4,
     * or 8.
     * <p/>
     * {@code Status} of {@code VirtualMachine} refers to the status of the virtual machine. Permitted values are:
     * <ul>
     * <li>NotDeployed - Host has not been defined but not deployed, such as with a physical device.</li>
     * <li>Deployed - Host is defined and deployed, available for service.</li>
     * <li>Orphaned - An attempt was made to create the host but failed.</li>
     * <li>TaskInProgress - The host has been defined and creation is in progress.</li>
     * <li>CopyInProgress - The host is to be a copy of an existing host and the copy is in progress.</li>
     * </ul>
     * Note: A virtual machine with {@code Status} {@code Orphaned} will contain only {@code Status}.
     *
     * @param environmentId The environment for which all compute pools should be retrieved.
     * @return Compute pools in the specified environment.
     * @throws TerremarkException If an error occurs retrieving the compute pools.
     */
    ComputePools getComputePools(String environmentId) throws TerremarkException;

    /**
     * This method returns information regarding a specified compute pool defined in an environment.
     * <p/>
     * {@code ProcessorCount} refers to the number of processors in the virtual machine. Permitted values are: 1, 2, 4,
     * or 8.
     * <p/>
     * {@code Status} of {@code VirtualMachine} refers to the status of the virtual machine. Permitted values are:
     * <ul>
     * <li>NotDeployed - Host has not been defined but not deployed, such as with a physical device.</li>
     * <li>Deployed - Host is defined and deployed, available for service.</li>
     * <li>Orphaned - An attempt was made to create the host but failed.</li>
     * <li>TaskInProgress - The host has been defined and creation is in progress.</li>
     * <li>CopyInProgress - The host is to be a copy of an existing host and the copy is in progress.</li>
     * </ul>
     * Note: A virtual machine with {@code Status} {@code Orphaned} will contain only {@code Status}.
     *
     * @param computePoolId ID of the compute pool to retrieve.
     * @return Compute pool for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the compute pool.
     */
    ComputePool getComputePoolByID(String computePoolId) throws TerremarkException;

    /**
     * Returns information regarding a specified physical high availability (HA) router defined in an environment.
     *
     * @param haRouterId ID of the HA router.
     * @return HA router for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the HA router.
     */
    HighAvailabilityRouter getHighAvailabilityRouterByID(String haRouterId) throws TerremarkException;

    /**
     * Returns information regarding network hosts in a specified group in an environment.
     *
     * @param groupId ID of the layout group.
     * @return Layout group for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the layout group information.
     */
    LayoutGroup getLayoutGroupByID(String groupId) throws TerremarkException;

    /**
     * Returns information regarding the groups and network hosts in a specified row in an environment.
     *
     * @param rowId ID of the layout row.
     * @return Layout row for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the layout row information.
     */
    LayoutRow getLayoutRowByID(String rowId) throws TerremarkException;

    /**
     * Returns information regarding the row and group of network hosts in an environment. Rows and groups allow
     * aggregation of servers along logical boundaries defined by the organization.
     *
     * @param environmentId ID of the environment.
     * @return Device layout information.
     * @throws TerremarkException If an error occurs retrieving the layout information.
     */
    DeviceLayout getLayouts(String environmentId) throws TerremarkException;

    /**
     * Returns information regarding the row and group of network hosts for a specified compute pool in an environment.
     * Rows and groups allow aggregation of servers along logical boundaries defined by the organization.
     *
     * @param computePoolId ID of the compute pool.
     * @return Device layout information.
     * @throws TerremarkException If an error occurs retrieving the layout information.
     */
    DeviceLayout getLayoutsByComputePool(String computePoolId) throws TerremarkException;

    /**
     * Returns summary information regarding networks in an environment.
     *
     * @param environmentId ID of the environment.
     * @return Network summary information for the specified environment.
     * @throws TerremarkException If an error occurs retrieving the network summary.
     */
    EnvironmentNetworkSummary getNetworkSummary(String environmentId) throws TerremarkException;

    /**
     * Returns information regarding installed physical devices. Physical devices are hardware devices, as opposed to
     * virtual devices, provided by the customer and installed in Terremark data centers.
     *
     * @param environmentId ID of the environment in which the physical devices exist.
     * @return Physical devices in the specified environment.
     * @throws TerremarkException If an error occurs retrieving the physical devices.
     */
    PhysicalDevices getPhysicalDevices(String environmentId) throws TerremarkException;

    /**
     * Returns information regarding a specified physical router defined in an environment.
     *
     * @param physicalRouterId ID of the physical router to retrieve.
     * @return Physical router for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the physical router.
     */
    PhysicalRouter getPhysicalRouterByID(String physicalRouterId) throws TerremarkException;

    /**
     * Returns information regarding a specified physical server defined in an environment.
     *
     * @param physicalServerId ID of the physical server.
     * @return Physical server for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the physical server.
     */
    PhysicalServer getPhysicalServerByID(String physicalServerId) throws TerremarkException;

    /**
     * Returns information regarding retrying a failed attach disk operation. The attach disk operation affects two
     * entities: the virtual machine and the detached disk. The Retry Operation may be accessed through either affected
     * entity. See {@link #getRetryOperationAttachDiskByVirtualMachine(String)} for access via the virtual machine.
     *
     * @param detachedDiskId ID of the detached disk.
     * @return Attach disk retry operation information.
     * @throws TerremarkException If an error occurs retrieving the retry operation.
     */
    AttachDiskRetryOperation getRetryOperationAttachDiskByDetachedDisk(String detachedDiskId) throws TerremarkException;

    /**
     * This method returns information regarding retrying a failed attach disk operation. The attach disk operation
     * affects two entities: the virtual machine and the detached disk. The Retry Operation may be accessed through
     * either affected entity. See {@link #getRetryOperationAttachDiskByDetachedDisk(String)} for access via the
     * detached disk.
     *
     * @param virtualMachineId ID of the virtual machine.
     * @return Attach disk retry operation information.
     * @throws TerremarkException If an error occurs retrieving the retry operation.
     */
    AttachDiskRetryOperation getRetryOperationAttachDiskByVirtualMachine(String virtualMachineId)
                    throws TerremarkException;

    /**
     * Returns information regarding retrying a failed detach disk operation. The detach disk operation affects two
     * entities: the virtual machine and the detached disk. The Retry Operation may be accessed through either affected
     * entity. See {@link #getRetryOperationDetachDiskByVirtualMachine(String)} for access via the virtual machine.
     *
     * @param detachedDiskId ID of the detached disk.
     * @return Detach disk retry operation information.
     * @throws TerremarkException If an error occurs retrieving the retry operation.
     */
    DetachDiskRetryOperation getRetryOperationDetachDiskByDetachedDisk(String detachedDiskId) throws TerremarkException;

    /**
     * This method returns information regarding retrying a failed detach disk operation. The detach disk operation
     * affects two entities: the virtual machine and the detached disk. The Retry Operation may be accessed through
     * either affected entity. See {@link #getRetryOperationDetachDiskByDetachedDisk(String)} for access via the
     * detached disk.
     *
     * @param virtualMachineId ID of the virtual machine.
     * @return Detach disk retry operation information.
     * @throws TerremarkException If an error occurs retrieving the retry operation.
     */
    DetachDiskRetryOperation getRetryOperationDetachDiskByVirtualMachine(String virtualMachineId)
                    throws TerremarkException;

    /**
     * Returns information regarding a specified physical storage device defined in an environment.
     *
     * @param storageDeviceId Storage device identifier.
     * @return Storage device for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the storage device.
     */
    StorageDevice getStorageDeviceByID(String storageDeviceId) throws TerremarkException;

    /**
     * Returns information regarding the tasks in an environment. The task list is a history of changes to the
     * environment. Tasks are retained for twelve months.
     * <p/>
     * This call may include optional arguments. Permitted arguments are:
     * <table border="1">
     * <tr>
     * <th>Parameter</th>
     * <th>Usage</th>
     * </tr>
     * <tr>
     * <td>page</td>
     * <td>Use of page chunks the returned data and returns the requested page, default = 1</td>
     * </tr>
     * <tr>
     * <td>pageSize</td>
     * <td>Number of items returned per page between 1 and 1000, default = 20</td>
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
     * <td>All Task elements are permitted as the sort key:
     * <ul>
     * <li>ImpactedItem
     * <li>Operation
     * <li>Notes
     * <li>Status
     * <li>InitiatedBy
     * <li>StartTime
     * <li>CompletedTime
     * </ul>
     * </td>
     * </tr>
     * <tr>
     * <td>startDate</td>
     * <td>Enter in ISO8601 format. Time is always start of day and if entered is ignored, default = earliest record</td>
     * </tr>
     * <tr>
     * <td>endDate</td>
     * <td>Enter in ISO8601 format. Time is always end of day and if entered is ignored, default = latest record</td>
     * </tr>
     * </table>
     *
     * @param environmentId ID of the environment.
     * @param filterArguments Filter arguments. See description of this method. Can be null.
     * @return Tasks in the specified environment after applying the specified filter arguments.
     * @throws TerremarkException If an error occurs retrieving the tasks.
     */
    Tasks getTasks(String environmentId, Map<String, String> filterArguments) throws TerremarkException;

    /**
     * Returns information regarding tasks for a specified detached disk in a compute pool. The task list is a history
     * of changes to the detached disk. Tasks are retained for twelve months.
     *
     * @param detachedDiskId ID of the detached disk for which tasks should be returned.
     * @return Tasks for the specified detached disk.
     * @throws TerremarkException If an error occurs while retrieving the tasks for the specified detached disk.
     */
    Tasks getTasksByDetachedDisk(String detachedDiskId) throws TerremarkException;

    /**
     * Returns information regarding tasks for a specified high availability router in an environment. The task list is
     * a history of changes to the high availability router. Tasks are retained for twelve months.
     *
     * @param haRouterId ID of the high availability router for which tasks should be returned.
     * @return Tasks for the specified high availability router.
     * @throws TerremarkException If an error occurs while retrieving the tasks for the specified high availability
     * router.
     */
    Tasks getTasksByHighAvailabilityRouter(String haRouterId) throws TerremarkException;

    /**
     * Returns information regarding a specified task in an environment. A task is a history of a change to the
     * environment. Tasks are retained for twelve months.
     *
     * @param taskId ID of the task to retrieve.
     * @return Task for the specified identifier.
     * @throws TerremarkException If an error occurs retrieving the task by ID.
     */
    Task getTaskByID(String taskId) throws TerremarkException;

    /**
     * Returns information regarding tasks for a specified physical router in an environment. The task list is a history
     * of changes to the physical router. Tasks are retained for twelve months.
     *
     * @param physicalRouterId ID of the physical router for which tasks should be returned.
     * @return Tasks for the specified physical router.
     * @throws TerremarkException If an error occurs while retrieving the tasks for the specified physical router.
     */
    Tasks getTasksByPhysicalRouter(String physicalRouterId) throws TerremarkException;

    /**
     * Returns information regarding tasks for a specified physical server in an environment. The task list is a history
     * of changes to the physical server. Tasks are retained for twelve months.
     *
     * @param physicalServerId ID of the physical server for which tasks should be returned.
     * @return Tasks for the specified physical server.
     * @throws TerremarkException If an error occurs while retrieving the tasks for the specified physical server.
     */
    Tasks getTasksByPhysicalServer(String physicalServerId) throws TerremarkException;

    /**
     * Returns information regarding tasks for a specified storage device in an environment. The task list is a history
     * of changes to the storage device. Tasks are retained for twelve months.
     *
     * @param storageDeviceId ID of the storage device for which tasks should be returned.
     * @return Tasks for the specified storage device.
     * @throws TerremarkException If an error occurs while retrieving the tasks for the specified storage device.
     */
    Tasks getTasksByStorageDevice(String storageDeviceId) throws TerremarkException;

    /**
     * Returns information regarding tasks for a specified virtual machine in an environment. The task list is a history
     * of changes to the virtual machine. Tasks are retained for twelve months.
     *
     * @param virtualMachineId ID of the virtual machine for which tasks should be returned.
     * @return Tasks for the specified virtual machine.
     * @throws TerremarkException If an error occurs while retrieving the tasks for the specified virtual machine.
     */
    Tasks getTasksByVirtualMachine(String virtualMachineId) throws TerremarkException;

    /**
     * This method can be used to edit the name, description, or tags of a high availability router defined in an
     * environment.
     * <p/>
     * If successful and the name is changed, even if the description or tags are also changed, a task is returned.
     * <p/>
     * If successful and only the description or tags are changed (the name is not changed), {@code null} is returned.
     * <p/>
     * The {@code name} field on {@code HighAvailabilityRouter} is required and may be changed.
     * <p/>
     * Note: The name may not be changed to that of another high availability router. It must begin with a letter. May
     * contain only letters, numbers, or hyphens. And must not exceed fifteen characters.
     * <p/>
     * {@code Description} is optional but if present the description must not exceed one hundred characters.
     * <p/>
     * Note: To remove the description an empty value should be specified.
     * <p/>
     * Both {@code Tags} and {@code Tag} are optional. Including a {@code Tag} not currently on the physical device adds
     * that tag to the physical device.
     * <p/>
     * Note: If the high availability router has tags and {@code Tags} is empty, all tags are removed. Similarly, if any
     * {@code Tag} exists on the high availability router and is not present in the call, that tag is removed from the
     * high availability router. If the high availability router has tags and {@code Tags} is not present in the call,
     * no change is made to the tags.
     *
     * @param obj High availability router to edit.
     * @return Task, if the edit call was successful and name was updated. {@code Null} otherwise.
     * @throws TerremarkException If an error occurs editing the high availablity router.
     */
    Task highAvailabilityRouterEdit(HighAvailabilityRouter obj) throws TerremarkException;

    /**
     * This method moves the high availability router to a different layout group.
     * <p/>
     * Three options are possible:
     * <ul>
     * <li>The high availability router may be moved to a group currently defined in the layout of the environment. The
     * group may be in a different row.
     * <li>The high availability router may be moved to a new layout group created in the specified layout row defined
     * in the layout of the environment.
     * <li>The high availability router may be moved to a new layout group created in a new row created in the layout of
     * the environment.
     * </ul>
     * <p/>
     * {@code LayoutRequest} has three variations. Only one of the three variations is permitted in a call:
     * <ul>
     * <li>Move to an existing group. {@code Group} is required.
     * <li>Move to a newly created group in an existing row. {@code Row} is required. {@code NewGroup} is required to
     * provide the required name, which may not exceed fifty characters.
     * <li>Move to a newly created group in a newly created row. {@code NewRow} is required to provide the required
     * name, which may not exceed fifty characters. {@code NewGroup} is required to provide the required name, which may
     * not exceed fifty characters.
     * </ul>
     *
     * @param haRouterId ID of high availability router to move.
     * @param obj New layout request.
     * @throws TerremarkException If an error occurs moving the high availability router.
     */
    void highAvailabilityRouterMove(String haRouterId, LayoutRequest obj) throws TerremarkException;

    /**
     * Method to create a new group in a specified row or a new row. The new group is placed at the end of the row. If
     * successful, this call returns information regarding the group that was created.
     * <p/>
     * The {@code name} on {@code CreateLayoutGroup} is required and need not be unique.
     * <p/>
     * Note: The name may not exceed fifty characters.
     * <p/>
     * {@code LayoutRequest} has two variations. Only one of the two variations is permitted in a call:
     * <ul>
     * <li>Add to an existing row. {@code Row} is required.
     * <li>Add to a newly created row. {@code NewRow} is required to provide the required name, which may not exceed
     * fifty characters, and to create the row in which the new group will be created.
     * <ul>
     *
     * @param environmentId ID of the environment in which the new group should be created.
     * @param obj Create layout group request.
     * @return The newly created layout group information.
     * @throws TerremarkException If an error occurs trying to create the layout group.
     */
    LayoutGroup layoutGroupCreate(String environmentId, CreateLayoutGroup obj) throws TerremarkException;

    /**
     * Method to edit the name of a specified group in an environment. The {@code name} on {@code LayoutGroup} is
     * required, may be changed, and need not be unique.
     * <p/>
     * Note: The name may not exceed fifty characters.
     *
     * @param obj Layout group to edit.
     * @throws TerremarkException If an error occurs editing the layout group.
     */
    void layoutGroupEdit(LayoutGroup obj) throws TerremarkException;

    /**
     * This method changes the position the user interface of a specified group in an environment. Order higher moves a
     * group to the left and, if necessary, up.
     *
     * @param groupId ID of the group to order higher.
     * @throws TerremarkException If an error occurs moving the group up.
     */
    void layoutGroupOrderHigher(String groupId) throws TerremarkException;

    /**
     * This method changes the position the user interface of a specified group in an environment. Order lower moves a
     * group to the right and, if necessary, down.
     *
     * @param groupId ID of the group to order lower.
     * @throws TerremarkException If an error occurs moving the group down.
     */
    void layoutGroupOrderLower(String groupId) throws TerremarkException;

    /**
     * Removes a specified group from an environment.
     *
     * @param groupId ID of the group to remove.
     * @throws TerremarkException If an error occurs removing the group.
     */
    void layoutGroupRemove(String groupId) throws TerremarkException;

    /**
     * This method creates a new row in an environment. The new row is placed at the bottom of the user interface. If
     * successful, this call returns information regarding the row that was created.
     * <p/>
     * The {@code name} on {@code CreateLayoutRow} is required but need not be unique.
     * <p/>
     * Note: The name may not exceed fifty characters.
     *
     * @param environmentId ID of the environment where the row should be created.
     * @param obj Layout row create request.
     * @return Newly created row information.
     * @throws TerremarkException If an error occurs creating the row.
     */
    LayoutRow layoutRowCreate(String environmentId, CreateLayoutRow obj) throws TerremarkException;

    /**
     * Edits the name of a specified row in an environment.
     * <p/>
     * The {@code name} on {@code LayoutRow} is required, may be changed, and need not be unique.
     * <p/>
     * Note: The name may not exceed fifty characters.
     *
     * @param obj Layout row to edit.
     * @throws TerremarkException If an error occurs editing the row name.
     */
    void layoutRowEdit(LayoutRow obj) throws TerremarkException;

    /**
     * This method changes the position in the user interface of a specified row in an environment. Move down moves a
     * row down.
     * <p/>
     * Note: The index increments by one with this call.
     *
     * @param rowId ID of the row to move down.
     * @throws TerremarkException If an error occurs moving the row down.
     */
    void layoutRowMoveDown(String rowId) throws TerremarkException;

    /**
     * This method changes the position in the user interface of a specified row in an environment. Move up moves a row
     * up.
     * <p/>
     * Note: The index decrements by one with this call.
     *
     * @param rowId ID of the row to move up.
     * @throws TerremarkException If an error occurs moving the row up.
     */
    void layoutRowMoveUp(String rowId) throws TerremarkException;

    /**
     * Removes a specified row from an environment.
     *
     * @param rowId ID of the row to remove.
     * @throws TerremarkException If an error occurs removing the row.
     */
    void layoutRowRemove(String rowId) throws TerremarkException;

    /**
     * This method can be used to edit the name, description, or tags on a physical router defined in an environment. If
     * successful and the name is changed, even if the description or tags are also changed, a task is returned. If
     * successful and only the description or tags are changed (the name is not changed), {@code null} is returned.
     * <p/>
     * The {@code name} on {@code PhysicalRouter} is required and may be changed.
     * <p/>
     * Note: The name may not be changed to that of another physical router. Must begin with a letter. May contain only
     * letters, numbers, or hyphens. And must not exceed fifteen characters.
     * <p/>
     * {@code Description} is optional but if present the description must not exceed one hundred characters.
     * <p/>
     * Note: To remove the description an empty string must be specified.
     * <p/>
     * Both {@code Tags} and {@code Tag} are optional. Including a {@code Tag} not currently on the physical device adds
     * that tag to the physical device.
     * <p/>
     * Note: If the physical router has tags and {@code Tags} is empty, all tags are removed. Similarly, if any
     * {@code Tag} is on the physical router and not present in the call, that tag is removed from the physical router.
     * If the physical router has tags and {@code Tags} is not present in the call, no change is made to the tags.
     *
     * @param obj Physical router with updated name and/or description and/or tags.
     * @return Task, if the physical routers name was modified and the call was successful. {@code Null} otherwise.
     * @throws TerremarkException If an error occurs editing the physical router information.
     */
    Task physicalRouterEdit(PhysicalRouter obj) throws TerremarkException;

    /**
     * This method moves the physical router to a different layout group.
     * <p/>
     * Three options are possible:
     * <ul>
     * <li>The physical router may be moved to a group currently defined in the layout of the environment. The group may
     * be in a different row.
     * <li>The physical router may be moved to a new layout group created in the specified layout row defined in the
     * layout of the environment.
     * <li>The physical router may be moved to a new layout group created in a new row created in the layout of the
     * environment.
     * </ul>
     * <p/>
     * {@code LayoutRequest} has three variations. Only one of the three variations is permitted in a call:
     * <ul>
     * <li>Move to an existing group. {@code Group} is required.
     * <li>Move to a newly created group in an existing row. {@code Row} is required. {@code NewGroup} is required to
     * provide the required name, which may not exceed fifty characters, and to create the group to which the physical
     * router physical device will be moved.
     * <li>Move to a newly created group in a newly created row. {@code NewRow} is required to provide the required
     * name, which may not exceed fifty characters, and to create the row in which the new group will be created.
     * {@code NewGroup} is required to provide the required name, which may not exceed fifty characters, and to create
     * the group to which the physical router physical device will be moved.
     * </ul>
     *
     * @param physicalRouterId ID of the physical router to move.
     * @param obj New layout information for moving the physical router.
     * @throws TerremarkException If an error occurs moving the physical router.
     */
    void physicalRouterMove(String physicalRouterId, LayoutRequest obj) throws TerremarkException;

    /**
     * Method to edit the name, description, or tags on a physical server defined in an environment. If successful and
     * the name is changed, even if the description or tags are also changed, a task that changed the physical server
     * name is returned. If successful and only the description or tags are changed (the name is not changed), null is
     * returned.
     * <p/>
     * The {@code name} on {@code PhysicalServer} is required and may be changed.
     * <p/>
     * Note: The name may not be changed to that of another physical server, must begin with a letter, may contain only
     * letters, numbers, or hyphens, and must not exceed fifteen characters.
     * <p/>
     * {@code Description} is optional but if present the description must not exceed one hundred characters.
     * <p/>
     * Both {@code Tags} and {@code Tag} are optional. Including a {@code Tag} not currently on the physical device adds
     * that tag to the physical device.
     * <p/>
     * Note: If the physical server has tags and {@code Tags} is empty, all tags are removed. Similarly, if any
     * {@code Tag} subordinate elements are valued on the physical server and not present in the call, that tag is
     * removed from the physical server. If the physical server has tags and {@code Tags} is not present in the call, no
     * change is made to the tags.
     * <p/>
     * {@code AssignedIpAddresses} is optional and ignored if present. See
     * {@link #physicalServerEditAssignedIPAddress(String, AssignedIpAddresses)} to modify assigned IP addresses.
     * <p/>
     * {@code Status} refers to the status of the task. Permitted values are:
     * <ul>
     * <li>Queued – the task is queued for execution.
     * <li>Running – the task is running.
     * <li>Complete – the task completed successfully.
     * <li>Error – the task failed with an error.
     * </ul>
     * {@code CompletedTime} is not applicable to {@code Status} {@code Queued} or {@code Status} {@code Running} and is
     * not included in the response.
     *
     * @param obj Physical server object with updated name, description or tags.
     * @return Task, if the name was changed. Null is returned if only description and/or tags are modified.
     * @throws TerremarkException If an error occurs editing the physical server information.
     */
    Task physicalServerEdit(PhysicalServer obj) throws TerremarkException;

    /**
     * This call edits the IP addresses assigned to a physical server defined in an environment. If successful, the call
     * returns the task that modified the physical server.
     * <p/>
     * Note: The network to which a physical server is attached may not be changed.
     * <p/>
     * Both {@code Network} and {@code IpAddress} are optional. Including an {@code IpAddress} not currently on the
     * virtual machine adds that IP address to the physical server.
     * <p/>
     * Note: If an {@code IpAddress} is valued on the physical server and not present in the call, that IP address is
     * removed from the network.
     * <p/>
     * {@code Status} refers to the status of the task. Permitted values are:
     * <ul>
     * <li>Queued – the task is queued for execution.
     * <li>Running – the task is running.
     * <li>Complete – the task completed successfully.
     * <li>Error – the task failed with an error.
     * </ul>
     * {@code CompletedTime} is not applicable to {@code Status} {@code Queued} or {@code Status} {@code Running} and is
     * not included in the response.
     *
     * @param physicalServerId ID of the physical server to update.
     * @param obj New IP address assignment information.
     * @return Task for polling the status of IP address assignment.
     * @throws TerremarkException If an error occurs modifying the IP addresses of the physical server.
     */
    Task physicalServerEditAssignedIPAddress(String physicalServerId, AssignedIpAddresses obj)
                    throws TerremarkException;

    /**
     * This method moves the physical server to a different layout group.
     * <p/>
     * Three options are possible:
     * <ul>
     * <li>The physical server may be moved to a group currently defined in the layout of the environment. The group may
     * be in a different row.
     * <li>The physical server may be moved to a new layout group created in the specified layout row defined in the
     * layout of the environment.
     * <li>The physical server may be moved to a new layout group created in a new row created in the layout of the
     * environment.
     * </ul>
     * <p/>
     * {@code LayoutRequest} has three variations. Only one of the three variations is permitted in a call:
     * <ul>
     * <li>Move to an existing group. {@code Group} is required.
     * <li>Move to a newly created group in an existing row. {@code Row} is required. {@code NewGroup} is required to
     * provide the required name, which may not exceed fifty characters, and to create the group to which the physical
     * server physical device will be moved.
     * <li>Move to a newly created group in a newly created row. {@code NewRow} is required to provide the required
     * name, which may not exceed fifty characters, and to create the row in which the new group will be created.
     * {@code NewGroup} is required to provide the required name, which may not exceed fifty characters, and to create
     * the group to which the physical server physical device will be moved.
     * </ul>
     *
     * @param physicalServerId Id of the physical server to move.
     * @param obj New layout request information for moving the physical server.
     * @throws TerremarkException If an error occurs moving the physical server.
     */
    void physicalServerMove(String physicalServerId, LayoutRequest obj) throws TerremarkException;

    /**
     * This method retries attaching a disk to a virtual machine that previously failed. If successful, the call returns
     * a task regarding the virtual machine to which disk or disks were attached.
     * <p/>
     * The attach disk operation affects two entities: the virtual machine and the detached disk. The Retry Operation
     * may be accessed through either affected entity. See {@link #retryOperationAttachDiskByVirtualMachine(String)} for
     * access via the virtual machine.
     *
     * @param detachedDiskId ID of the detached disk.
     * @return Task for checking the status of the attach action.
     * @throws TerremarkException If an error occurs retrying the attach disk action.
     */
    Task retryOperationAttachDiskByDetachedDisk(String detachedDiskId) throws TerremarkException;

    /**
     * This method retries attaching a disk to a virtual machine that previously failed. If successful, the call returns
     * a task regarding the virtual machine to which disk or disks were attached.
     * <p/>
     * The attach disk operation affects two entities: the virtual machine and the detached disk. The Retry Operation
     * may be accessed through either affected entity. See {@link #retryOperationAttachDiskByDetachedDisk(String)} for
     * access via the detached disk.
     *
     * @param virtualMachineId ID of the virtual machine.
     * @return Task for checking the status of the attach action.
     * @throws TerremarkException If an error occurs retrying the attach disk action.
     */
    Task retryOperationAttachDiskByVirtualMachine(String virtualMachineId) throws TerremarkException;

    /**
     * This method retries detaching a disk from a virtual machine that previously failed. If successful, the call
     * returns a task regarding the disk or disks detached.
     * <p/>
     * The detach disk operation affects two entities: the virtual machine and the detached disk. The Retry Operation
     * may be accessed through either affected entity. See {@link #retryOperationDetachDiskByVirtualMachine(String)} for
     * access via the virtual machine.
     *
     * @param detachedDiskId ID of the detached disk.
     * @return Task for checking the status of detach action.
     * @throws TerremarkException If an error occurs retrying the detach action.
     */
    Task retryOperationDetachDiskByDetachedDisk(String detachedDiskId) throws TerremarkException;

    /**
     * This method retries detaching a disk from a virtual machine that previously failed. If successful, the call
     * returns a task regarding the disk or disks detached.
     * <p/>
     * The detach disk operation affects two entities: the virtual machine and the detached disk. The Retry Operation
     * may be accessed through either affected entity. See {@link #retryOperationDetachDiskByDetachedDisk(String)} for
     * access via the detached disk.
     *
     * @param virtualMachineId ID of the virtual machine.
     * @return Task for checking the status of the detach action.
     * @throws TerremarkException If an error occurs retrying the detach action.
     */
    Task retryOperationDetachDiskByVirtualMachine(String virtualMachineId) throws TerremarkException;

    /**
     * This method edits the name, description, or tags on a storage device defined in an environment. If successful and
     * the name is changed, even if the description or tags are also changed, a task that changed the storage device
     * name is returned. If successful and only the description or tags are changed (the name is not changed),
     * {@code null} returned.
     * <p/>
     * The name attribute on {@code StorageDevice} is required and may be changed.
     * <p/>
     * Note: The name may not be changed to that of another storage device. Must begin with a letter. May contain only
     * letters, numbers, or hyphens. And must not exceed fifteen characters.
     * <p/>
     * {@code Description} is optional but if present the description must not exceed one hundred characters.
     * <p/>
     * Note: To remove the description an empty value must be specified.
     * <p/>
     * Both {@code Tags} and {@code Tag} are optional. Including a {@code Tag} not currently on the physical device adds
     * that tag to the physical device.
     * <p/>
     * Note: If the storage device has tags and {@code Tags} is empty, all tags are removed. Similarly, if any
     * {@code Tag} exists on the storage device and not present in the call, that tag is removed from the storage
     * device. If the storage device has tags and {@code Tags} is not present in the call, no change is made to the
     * tags.
     *
     * @param obj Storage device to edit.
     * @return If successful, a task is returned if the name of the storage device was modified. Otherwise, {@code Null}
     * is returned.
     * @throws TerremarkException If an error occurs editing the storage device information.
     */
    Task storageDeviceEdit(StorageDevice obj) throws TerremarkException;

    /**
     * This method moves the storage device to a different layout group.
     * <p/>
     * Three options are possible:
     * <ul>
     * <li>The storage device may be moved to a group currently defined in the layout of the environment. The group may
     * be in a different row.
     * <li>The storage device may be moved to a new layout group created in the specified layout row defined in the
     * layout of the environment.
     * <li>The storage device may be moved to a new layout group created in a new row created in the layout of the
     * environment.
     * </ul>
     * <p/>
     * {@code LayoutRequest} has three variations. Only one of the three variations is permitted in a call:
     * <ul>
     * <li>Move to an existing group. {@code Group} is required.
     * <li>Move to a newly created group in an existing row. {@code Row} is required. {@code NewGroup} is required to
     * provide the required name, which may not exceed fifty characters, and to create the group to which the storage
     * device physical device will be moved.
     * <li>Move to a newly created group in a newly created row. {@code NewRow} is required to provide the required
     * name, which may not exceed fifty characters, and to create the row in which the new group will be created.
     * {@code NewGroup} is required to provide the required name, which may not exceed fifty characters, and to create
     * the group to which the storage device physical device will be moved.
     * </ul>
     *
     * @param storageDeviceId ID of the storage device to move.
     * @param obj New layout information for moving the storage device.
     * @throws TerremarkException If an error occurs moving the storage device.
     */
    void storageDeviceMove(String storageDeviceId, LayoutRequest obj) throws TerremarkException;
}
