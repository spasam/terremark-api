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

import java.util.Date;

import com.terremark.api.AssignedIpAddresses;
import com.terremark.api.AttachDisks;
import com.terremark.api.CatalogEntry;
import com.terremark.api.ComputePoolCpuUsage;
import com.terremark.api.ComputePoolCpuUsageDetail;
import com.terremark.api.ComputePoolMemoryUsage;
import com.terremark.api.ComputePoolMemoryUsageDetail;
import com.terremark.api.ComputePoolPerformanceStatistics;
import com.terremark.api.ComputePoolResourceSummary;
import com.terremark.api.ComputePoolResourceSummaryList;
import com.terremark.api.ComputePoolStorageUsageDetail;
import com.terremark.api.CopyIdenticalVirtualMachine;
import com.terremark.api.CopyVirtualMachine;
import com.terremark.api.CreateBlankVirtualMachine;
import com.terremark.api.CreateGuestProcess;
import com.terremark.api.CreateVirtualMachine;
import com.terremark.api.DetachDisk;
import com.terremark.api.DetachedDisk;
import com.terremark.api.DetachedDisks;
import com.terremark.api.ExportVirtualMachineRequest;
import com.terremark.api.GuestProcess;
import com.terremark.api.GuestProcesses;
import com.terremark.api.HardwareConfiguration;
import com.terremark.api.ImportVirtualMachine;
import com.terremark.api.LayoutRequest;
import com.terremark.api.MksTicket;
import com.terremark.api.OperatingSystem;
import com.terremark.api.OperatingSystemFamilies;
import com.terremark.api.PerformanceStatistics;
import com.terremark.api.Task;
import com.terremark.api.Template;
import com.terremark.api.Templates;
import com.terremark.api.VirtualMachine;
import com.terremark.api.VirtualMachineConfigurationOptions;
import com.terremark.api.VirtualMachines;
import com.terremark.exception.TerremarkException;

/**
 * Provides API calls for top level objects with in an compute pool:
 * <ul>
 * <li>Resource
 * <li>Template
 * <li>Virtual machine
 * <li>Detached disk
 * <li>Operating system family
 * </ul>
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 * @see TerremarkFactory#getId(com.terremark.api.Reference)
 * @see TerremarkFactory#getId(com.terremark.api.Resource)
 */
public interface ComputePoolHandler {
    // TODO FIXME XXX: void virtualMachinesGuestFile(String virtualMachineId, String filePath, BytesToUpload obj);

    // TODO FIXME XXX: FileContents getVirtualMachinesGuestFile(String virtualMachineId, String filePathAndName);

    /**
     * Detached Disks Edit call edits the name or description on a detached disk defined in a compute pool. If
     * successful, the call returns the task that modified the the detached disk.
     * <p/>
     * The {@code name} is required, may be changed, and need not be unique. The name may not exceed fifteen characters.
     * <p/>
     * Description is optional but if present the description must not exceed one hundred characters. To remove the
     * description it should be set to empty string.
     * <p/>
     * Other fields are optional and ignored if present.
     *
     * @param obj Detached disk to edit
     * @return Task that modified the detached disk.
     * @throws TerremarkException If an error occurs editing the detached disk.
     */
    Task detachedDiskEdit(DetachedDisk obj) throws TerremarkException;

    /**
     * Detached Disks Remove call removes a specified detached disk from the compute pool. If successful, the call
     * returns the task that removed the detached disk.
     * <p/>
     * To remove a detached disk, it should be in {@code Available} {@code Status}.
     *
     * @param detachedDiskId ID of the detached disk to remove.
     * @return Task that removed the detached disk.
     * @throws TerremarkException If an error occurs trying to remove the detached disk.
     */
    Task detachedDiskRemove(String detachedDiskId) throws TerremarkException;

    /**
     * Get Detached Disks call returns information regarding the disks detached in a compute pool.
     * <p/>
     * For each detached disk, {@code LastKnownVirtualMachineConfiguration} contains the configuration, where name is
     * the name, of the virtual machine from which the disk was detached. {@code ProcessorCount} refers to the number of
     * processors in the virtual machine. Permitted values are: 1, 2, 4, or 8.
     * <p/>
     * {@code DiskType} refers to the type of content on the disk when attached to the last virtual machine.
     * <p/>
     * {@code Status} refers to the status of the detached disk.
     *
     * @param computePoolId The compute pool for which all detached disks should be returned.
     * @return Detached disks in the specified compute pool.
     * @throws TerremarkException If an error occurs getting the detached disks.
     */
    DetachedDisks getDetachedDisks(String computePoolId) throws TerremarkException;

    /**
     * Get Detached Disk call returns information regarding a detached disk.
     * <p/>
     * For the detached disk, {@code LastKnownVirtualMachineConfiguration} contains the configuration, where name is the
     * name, of the virtual machine from which the disk was detached. {@code ProcessorCount} refers to the number of
     * processors in the virtual machine. Permitted values are: 1, 2, 4, or 8.
     * <p/>
     * {@code DiskType} refers to the type of content on the disk when attached to the last virtual machine.
     * <p/>
     * {@code Status} refers to the status of the detached disk.
     *
     * @param detachedDiskId ID of the detached disk to retrieve.
     * @return Detached disk for the specified ID.
     * @throws TerremarkException If an error occurs retrieving the detached disk by ID.
     */
    DetachedDisk getDetachedDiskByID(String detachedDiskId) throws TerremarkException;

    /**
     * Get Operating Systems Families call returns information regarding the operating systems available within
     * operating system families defined in a compute pool.
     *
     * @param computePoolId Compute pool for which operating system families should be returned.
     * @return Operating system families for the specified compute pool.
     * @throws TerremarkException If an error occurs retrieving the operating system families.
     */
    OperatingSystemFamilies getOperatingSystemFamilies(String computePoolId) throws TerremarkException;

    /**
     * Get Operating Systems by ID call returns information regarding a specified operating system defined in a compute
     * pool. The {@code StepFactor} for {@code Processor} is inapplicable as the permitted values for processor are: 1,
     * 2, 4, or 8.
     *
     * @param osShortName Operating system short name.
     * @param computePoolId ID of compute pool for which the operating system information should be returned.
     * @return Operating system information.
     * @throws TerremarkException If an error occurs retrieving the operating system by ID.
     * @see TerremarkFactory#getOsShortName(com.terremark.api.OperatingSystem)
     */
    OperatingSystem getOperatingSystemByID(String osShortName, String computePoolId) throws TerremarkException;

    /**
     * This call returns references to obtain the individual performance statistics reports in a compute pool.
     *
     * @param computePoolId Compute pool for which performance statistic information should be returned.
     * @return Performance statistics for the specified compute pool.
     * @throws TerremarkException If an error occurs retrieving the performance statistics.
     */
    ComputePoolPerformanceStatistics getPerformanceStatistics(String computePoolId) throws TerremarkException;

    /**
     * This method returns daily information regarding memory performance for a specified compute pool defined in an
     * environment for the specified time period. The call retrieves information for each full day, <i>00:00:00Z</i> to
     * <i>23:59:59Z</i>, available between requested times.
     * <p/>
     * If {@code startTime} and {@code endTime} are both {@code null}, this call returns statistics for the previous
     * seven days. The default {@code endTime} is midnight the beginning of the current day and the default
     * {@code startTime} is midnight seven days prior to the {@code endTime}. For example, if the call is made at
     * <i>2011-07-12T14:48:00Z</i>, then {@code startTime} is <i>2011-07-05T00:00:00Z</i> and {@code endTime} is
     * <i>2011-07-12T00:00:00Z</i>.
     * <p/>
     * If {@code startTime} and {@code endTime} are not null, this call returns statistics for the complete days between
     * requested dates.
     * <p/>
     * If either time parameters is missing, the default value is used. Only complete days are returned. For example,
     * <i>2011-06-20T00:00:00Z</i> to <i>2011-06-22T00:00:00Z</i> returns information for 2 days: June 20 and June 21.
     * Conversely, <i>2011-06-20T22:00:00Z</i> to <i>2011-06-21T22:30:00Z</i> returns no information as no complete days
     * are in the requested interval.
     *
     * @param computePoolId ID of the compute pool for which the memory performance statistics should be returned.
     * @param startTime Start date/time. Can be null.
     * @param endTime End date/time. Can be null.
     * @return Daily memory performance statistics for the specified compute pool.
     * @throws TerremarkException If an error occurs retrieving the performance statistics.
     */
    PerformanceStatistics getDailyMemoryPerformanceStatistics(String computePoolId, Date startTime, Date endTime)
                    throws TerremarkException;

    /**
     * This call returns daily information regarding processor performance for a specified compute pool defined in an
     * environment for the specified time period. The call retrieves information for each full day, <i>00:00:00Z</i> to
     * <i>23:59:59Z</i>, available between requested times.
     * <p/>
     * If {@code startTime} and {@code endTime} are both {@code null}, this call returns statistics for the previous
     * seven days. The default {@code endTime} is midnight the beginning of the current day and the default
     * {@code startTime} is midnight seven days prior to the {@code endTime}. For example, if the call is made at
     * <i>2011-07-12T14:48:00Z</i>, then {@code startTime} is <i>2011-07-05T00:00:00Z</i> and {@code endTime} is
     * <i>2011-07-12T00:00:00Z</i>.
     * <p/>
     * If {@code startTime} and {@code endTime} are not null, this call returns statistics for the complete days between
     * requested dates.
     * <p/>
     * If either time parameters is missing, the default value is used. Only complete days are returned. For example,
     * <i>2011-06-20T00:00:00Z</i> to <i>2011-06-22T00:00:00Z</i> returns information for 2 days: June 20 and June 21.
     * Conversely, <i>2011-06-20T22:00:00Z</i> to <i>2011-06-21T22:30:00Z</i> returns no information as no complete days
     * are in the requested interval.
     *
     * @param computePoolId ID of the compute pool for which the processor performance statistics should be returned.
     * @param startTime Start date/time. Can be null.
     * @param endTime End date/time. Can be null.
     * @return Daily processor performance statistics for the specified compute pool.
     * @throws TerremarkException If an error occurs retrieving the performance statistics.
     */
    PerformanceStatistics getDailyProcessorPerformanceStatistics(String computePoolId, Date startTime, Date endTime)
                    throws TerremarkException;

    /**
     * This call returns hourly information regarding memory performance for a specified compute pool defined in an
     * environment for the specified time period. The call retrieves information for each full hour, <i>nn:00:00Z</i> to
     * <i>nn:59:59Z</i>, available between requested times.
     * <p/>
     * If {@code startTime} and {@code endTime} are both {@code null}, this call returns statistics for the previous 24
     * hours. The default {@code endTime} is the end of the hour prior to the current time and the default
     * {@code startTime} is the beginning of the hour 24 hours prior to the {@code endTime}. For example, if the call is
     * made at <i>2011-07-12T14:48:00Z</i>, then {@code startTime} is <i>2011-07-11T13:00:00Z</i> and {@code endTime} is
     * <i>2011-07-12T14:00:00Z</i>.
     * <p/>
     * If {@code startTime} and {@code endTime} are both {@code null}, this call returns statistics for the complete
     * days between requested dates.
     * <p/>
     * If either parameter is missing, the default value is used. Only complete hours are returned. For example,
     * <i>2011-06-22T06:00:00Z</i> to <i>2011-06-22T08:00:00Z</i> returns information for 2 hours: the <i>06:00</i> hour
     * and the <i>07:00</i> hour. Conversely, <i>2011-06-21T14:10:00Z</i> to <i>2011-06-21T15:50:00Z</i> returns no
     * information as no complete hours are in the requested interval.
     *
     * @param computePoolId ID of the compute pool for which the memory performance statistics should be returned.
     * @param startTime Start date/time. Can be null.
     * @param endTime End date/time. Can be null.
     * @return Hourly memory performance statistics for the specified compute pool.
     * @throws TerremarkException If an error occurs retrieving the performance statistics.
     */
    PerformanceStatistics getHourlyMemoryPerformanceStatistics(String computePoolId, Date startTime, Date endTime)
                    throws TerremarkException;

    /**
     * This call returns hourly information regarding processor performance for a specified compute pool defined in an
     * environment for the specified time period. The call retrieves information for each full hour, <i>nn:00:00Z</i> to
     * <i>nn:59:59Z</i>, available between requested times.
     * <p/>
     * If {@code startTime} and {@code endTime} are both {@code null}, this call returns statistics for the previous 24
     * hours. The default {@code endTime} is the end of the hour prior to the current time and the default
     * {@code startTime} is the beginning of the hour 24 hours prior to the {@code endTime}. For example, if the call is
     * made at <i>2011-07-12T14:48:00Z</i>, then {@code startTime} is <i>2011-07-11T13:00:00Z</i> and {@code endTime} is
     * <i>2011-07-12T14:00:00Z</i>.
     * <p/>
     * If {@code startTime} and {@code endTime} are both {@code null}, this call returns statistics for the complete
     * days between requested dates.
     * <p/>
     * If either parameter is missing, the default value is used. Only complete hours are returned. For example,
     * <i>2011-06-22T06:00:00Z</i> to <i>2011-06-22T08:00:00Z</i> returns information for 2 hours: the <i>06:00</i> hour
     * and the <i>07:00</i> hour. Conversely, <i>2011-06-21T14:10:00Z</i> to <i>2011-06-21T15:50:00Z</i> returns no
     * information as no complete hours are in the requested interval.
     *
     * @param computePoolId ID of the compute pool for which the processor performance statistics should be returned.
     * @param startTime Start date/time. Can be null.
     * @param endTime End date/time. Can be null.
     * @return Hourly processor performance statistics for the specified compute pool.
     * @throws TerremarkException If an error occurs retrieving the performance statistics.
     */
    PerformanceStatistics getHourlyProcessorPerformanceStatistics(String computePoolId, Date startTime, Date endTime)
                    throws TerremarkException;

    /**
     * This method returns resource summary information regarding a specified compute pool defined in an environment.
     *
     * @param computePoolId ID of the compute pool for which the resource summary should be returned.
     * @return Resource summary information.
     * @throws TerremarkException If an error occurs retrieving the resource summary.
     */
    ComputePoolResourceSummary getResourceSummary(String computePoolId) throws TerremarkException;

    /**
     * This method returns summary information regarding resource utilization in the compute pools defined in an
     * environment.
     *
     * @param environmentId ID of the environment for which the resource summary list should be returned.
     * @return Resource summary list.
     * @throws TerremarkException If an error occurs retrieving the resource summary list.
     */
    ComputePoolResourceSummaryList getResourceSummaryList(String environmentId) throws TerremarkException;

    /**
     * This call returns information regarding memory usage for a specified compute pool defined in an environment at
     * five minute intervals for the 24 hours ending one hour prior to the current time, rounded later. For example, if
     * current time is <i>11:22</i>, the end time <i>10:25</i>.
     *
     * @param computePoolId ID of the compute pool for which memory usage should be returned.
     * @return Memory usage information.
     * @throws TerremarkException If an error occurs retrieving the compute pool memory usage.
     */
    ComputePoolMemoryUsage getMemoryUsage(String computePoolId) throws TerremarkException;

    /**
     * This method returns information regarding memory usage for a specified compute pool defined in an environment at
     * the time, a specified five minute time interval within the 24 hours ending one hour prior to the current time,
     * rounded later. For example, if current time is <i>11:22</i>, the start time is <i>10:25</i> the previous day and
     * the end time <i>10:25</i> today. The response includes usage of every virtual machine during the interval.
     * <p/>
     * The {@code time} argument is required and must precisely match a time in the preceding 24 hours. Times are on
     * five minute intervals starting on the hour. Available times are in {@code Time} in the response to
     * {@link #getMemoryUsage(String)}.
     * <p/>
     * If the {@code time} argument is within the 24 hour window as described above but not an available time (not a
     * minute divisible by five), the call succeeds but returns no information.
     * <p/>
     * If the {@code time} argument is not within the 24 hour window as described above, the call fails.
     * <p/>
     * {@code Deleted} is applicable and appears only when virtual machine have been removed subsequent to the time of
     * the snapshot.
     *
     * @param computePoolId ID of the compute pool for which memory usage details should be returned.
     * @param time Date/time argument as described above.
     * @return Memory usage details.
     * @throws TerremarkException If an error occurs retrieving the memory usage details.
     */
    ComputePoolMemoryUsageDetail getMemoryUsageDetails(String computePoolId, Date time) throws TerremarkException;

    /**
     * This call returns information regarding processor usage for a specified compute pool defined in an environment at
     * five minute intervals for the 24 hours ending one hour prior to the current time, rounded later. For example, if
     * current time is <i>11:22</i>, the end time <i>10:25</i>.
     *
     * @param computePoolId ID of the compute pool for which processor usage should be returned.
     * @return Processor usage information.
     * @throws TerremarkException If an error occurs retrieving the processor usage.
     */
    ComputePoolCpuUsage getProcessorUsage(String computePoolId) throws TerremarkException;

    /**
     * This method returns information regarding processor usage for a specified compute pool defined in an environment
     * at the time, a specified five minute time interval within the 24 hours ending one hour prior to the current time,
     * rounded later. For example, if current time is <i>11:22</i>, the start time is <i>10:25</i> the previous day and
     * the end time <i>10:25</i> today. The response includes usage of every virtual machine during the interval.
     * <p/>
     * The {@code time} argument is required and must precisely match a time in the preceding 24 hours. Times are on
     * five minute intervals starting on the hour. Available times are in {@code Time} in the response to
     * {@link #getProcessorUsage(String)}.
     * <p/>
     * If the {@code time} argument is within the 24 hour window as described above but not an available time (not a
     * minute divisible by five), the call succeeds but returns no information.
     * <p/>
     * If the {@code time} argument is not within the 24 hour window as described above, the call fails.
     * <p/>
     * {@code Deleted} is applicable and appears only when virtual machine have been removed subsequent to the time of
     * the snapshot.
     *
     * @param computePoolId ID of the compute pool for which processor usage details should be returned.
     * @param time Date/time argument as described above.
     * @return Processor usage details.
     * @throws TerremarkException If an error occurs retrieving the processor usage.
     */
    ComputePoolCpuUsageDetail getProcessorUsageDetails(String computePoolId, Date time) throws TerremarkException;

    /**
     * This call returns information regarding current storage usage for a specified compute pool defined in an
     * environment for active virtual machines and detached disks. The response includes usage of every active virtual
     * machine and every detached disk.
     *
     * @param computePoolId ID of the compute pool for which storage usage should be returned.
     * @return Storage usage information.
     * @throws TerremarkException If an error occurs retrieving the storage usage.
     */
    ComputePoolStorageUsageDetail getStorageUsage(String computePoolId) throws TerremarkException;

    /**
     * This method returns information regarding templates defined in a compute pool.
     *
     * @param computePoolId ID of the compute pool for which templates information should be returned.
     * @return Templates for specified compute pool.
     * @throws TerremarkException If an error occurs retrieving the templates.
     */
    Templates getTemplates(String computePoolId) throws TerremarkException;

    /**
     * This method returns information regarding a specified template defined in a compute pool.
     * {@code LicensedSoftware} is not present on templates without licensing costs.
     *
     * @param templateId ID of the template to retrieve.
     * @param computePoolId ID of the compute pool this template belongs to.
     * @return Template for the specified template ID.
     * @throws TerremarkException If an error occurs retrieving the template.
     * @see TerremarkFactory#getTemplateId(com.terremark.api.Reference)
     * @see TerremarkFactory#getTemplateId(com.terremark.api.Resource)
     */
    Template getTemplateByID(String templateId, String computePoolId) throws TerremarkException;

    /**
     * This call returns information regarding virtual machines defined in a compute pool.
     * <p/>
     * {@code Tasks} refers to tasks regarding the virtual machine. Only the most recent tasks, up to twenty, are
     * returned. Use the {@code ID} to retrieve the complete list of tasks.
     * <p/>
     * {@code CompletedTime} is not present on tasks {@code Queued} or {@code Running}.
     * <p/>
     * {@code TotalCount} refers to the total number of tasks regarding this entity.
     * <p/>
     * {@code Status} refers to the status of the virtual machine.
     * <p/>
     * A virtual machine with {@code Status} {@code Orphaned} will contain only {@code Links}, {@code Actions},
     * {@code Tasks}, and {@code Status}.
     * <p/>
     * {@code ProcessorCount} refers to the number of processors in the virtual machine. Permitted values are: 1, 2, 4,
     * or 8.
     * <p/>
     * {@code ToolsStatus} refers to VMware Tools status.
     * <p/>
     * {@code MediaStatus} is the status of the VMware Tools media.
     * <p/>
     * {@code DetectedIpAddresses} are IP addresses detected on the virtual machine but not assigned to the virtual
     * machine in the Enterprise Cloud.
     *
     * @param computePoolId ID of the compute pool for which virtual machines should be returned.
     * @return Virtual machines for the specified compute pool.
     * @throws TerremarkException If an error occurs retrieving the virtual machines.
     */
    VirtualMachines getVirtualMachines(String computePoolId) throws TerremarkException;

    /**
     * This method returns information regarding the IP addresses assigned to a specified virtual machine in a compute
     * pool.
     *
     * @param virtualMachineId ID of the virtual machine for which the IP address information should be returned.
     * @return IP address information for the specified virtual machine.
     * @throws TerremarkException If an error occurs retrieving the virtual machine's IP addresses.
     */
    AssignedIpAddresses getVirtualMachineAssignedIPAddresses(String virtualMachineId) throws TerremarkException;

    /**
     * This call returns information regarding a specified virtual machines defined in an environment.
     * <p/>
     * {@code Tasks} refers to tasks regarding the virtual machine. Only the most recent tasks, up to twenty, are
     * returned. Use the {@code ID} to retrieve the complete list of tasks.
     * <p/>
     * {@code CompletedTime} is not present on tasks {@code Queued} or {@code Running}.
     * <p/>
     * {@code TotalCount} refers to the total number of tasks regarding this entity.
     * <p/>
     * {@code Status} refers to the status of the virtual machine.
     * <p/>
     * A virtual machine with {@code Status} {@code Orphaned} will contain only {@code Links}, {@code Actions},
     * {@code Tasks}, and {@code Status}.
     * <p/>
     * {@code ProcessorCount} refers to the number of processors in the virtual machine. Permitted values are: 1, 2, 4,
     * or 8.
     * <p/>
     * {@code ToolsStatus} refers to VMware Tools status.
     * <p/>
     * {@code MediaStatus} is the status of the VMware Tools media.
     * <p/>
     * {@code DetectedIpAddresses} are IP addresses detected on the virtual machine but not assigned to the virtual
     * machine in the Enterprise Cloud.
     * <p/>
     * {@code PendingRetryOperation} will appear only if an operation is pending a retry after failing.
     *
     * @param virtualMachineId ID of the virtual machine to retrieve.
     * @return Virtual machine information for the specified ID.
     * @throws TerremarkException If an error occurs retrieving the virtual machine.
     */
    VirtualMachine getVirtualMachineByID(String virtualMachineId) throws TerremarkException;

    /**
     * This method returns information regarding the configuration options of a specified virtual machine in a compute
     * pool. {@code ProcessorCount} refers to the number of processors in the virtual machine. Permitted values are: 1,
     * 2, 4, or 8.
     *
     * @param virtualMachineId ID of the virtual machine for which configuration options should be retrieved.
     * @return Virtual machine configuration options.
     * @throws TerremarkException If an error occurs retrieving the virtual machine configuration options.
     */
    VirtualMachineConfigurationOptions getVirtualMachinesConfigurationOptions(String virtualMachineId)
                    throws TerremarkException;

    /**
     * This method returns information regarding processes running on a virtual machine.
     * <p/>
     * This call requires valid credentials for a user with permission to retrieve processes on the virtual machine.
     * <p/>
     * To retrieve processes on a virtual machine requires a {@code PoweredOn} value of true.
     *
     * @param virtualMachineId ID of the virtual machine for which guest process information should be returned.
     * @param osUserName Operating system user name.
     * @param osPassword OS user's password.
     * @return Returns the virtual machine guest process information.
     * @throws TerremarkException If an error occurs retrieving the virtual machine guest processes.
     */
    GuestProcesses getVirtualMachinesGuestProcesses(String virtualMachineId, String osUserName, String osPassword)
                    throws TerremarkException;

    /**
     * This method returns information regarding the hardware configuration of a specified virtual machine in a compute
     * pool. {@code ProcessorCount} refers to the number of processors in the virtual machine. Permitted values are: 1,
     * 2, 4, or 8.
     *
     * @param virtualMachineId ID of the virtual machine for which the hardware configuration should be returned.
     * @return Hardware configuration for the specified virtual machine.
     * @throws TerremarkException If an error occurs retrieving the virtual machine's hardware configuration.
     */
    HardwareConfiguration getVirtualMachinesHardwareConfiguration(String virtualMachineId) throws TerremarkException;

    /**
     * Returns a MKS ticket for the original console connect feature. Without a client application, the MKS ticket is
     * not useful.
     *
     * @param virtualMachineId ID of the virtual machine for which MKS ticket should retrieved.
     * @return MKS ticket for specified virtual machine.
     * @throws TerremarkException If an error occurs retrieving a MKS ticket for the virtual machines.
     */
    MksTicket getVirtualMachinesMKSTicket(String virtualMachineId) throws TerremarkException;

    /**
     * Burst mode permits a compute pool to temporarily exceed its subscribed memory level. Enabling burst mode does
     * not, itself, incur additional expense. However, use of the additional capacity does. Therefore, memory burst mode
     * is often disabled when business conditions do not warrant its use.
     *
     * @param computePoolId ID of the compute pool for which memory bursting should be disabled.
     * @return Task for polling the status of this call.
     * @throws TerremarkException If an error occurs disabling the memory bursting.
     */
    Task disableMemoryBurst(String computePoolId) throws TerremarkException;

    /**
     * Burst mode permits a compute pool to temporarily exceed its subscribed processor level. Enabling burst mode does
     * not, itself, incur additional expense. However, use of the additional capacity does. Therefore, processor burst
     * mode is often disabled when business conditions do not warrant its use.
     *
     * @param computePoolId ID of the compute pool for which CPU bursting should be disabled.
     * @return Task for polling the status of this call.
     * @throws TerremarkException If an error occurs disabling the processor bursting.
     */
    Task disableProcessorBurst(String computePoolId) throws TerremarkException;

    /**
     * Burst mode permits a compute pool to temporarily exceed its subscribed memory level. Enabling burst mode does
     * not, itself, incur additional expense. However, use of the additional capacity does. Therefore, memory burst mode
     * is often only enabled when business conditions warrant its use.
     *
     * @param computePoolId ID of the compute pool for which memory bursting should be enabled.
     * @return Task for polling the status of this call.
     * @throws TerremarkException If an error occurs enabling the memory bursting.
     */
    Task enableMemoryBurst(String computePoolId) throws TerremarkException;

    /**
     * Burst mode permits a compute pool to temporarily exceed its subscribed processor level. Enabling burst mode does
     * not, itself, incur additional expense. However, use of the additional capacity does. Therefore, processor burst
     * mode is often only enabled when business conditions warrant its use.
     *
     * @param computePoolId ID of the compute pool for which CPU bursting should be enabled.
     * @return Task for polling the status of this call.
     * @throws TerremarkException If an error occurs enabling the processor bursting.
     */
    Task enableProcessorBurst(String computePoolId) throws TerremarkException;

    /**
     * This method attaches a previously detached disk to a virtual machine. If successful, the call returns a task
     * regarding the virtual machine to which the disk or disks were attached.
     * <p/>
     * At least one {@code DetachedDisk} is required to identify the detached disk desired to attach. With version API
     * version 2012-03-01 (2.12), only one disk may be attached in a call.
     *
     * @param virtualMachineId ID of the virtual machine to whicht the disk must be attached.
     * @param obj Attach disk request.
     * @return The task for polling the status of the disk attach call.
     * @throws TerremarkException If an error occurs attaching disk to the virtual machine.
     */
    Task virtualMachineAttachDisk(String virtualMachineId, AttachDisks obj) throws TerremarkException;

    /**
     * This method creates a new, blank virtual machine in the compute pool. If successful, the call returns information
     * regarding the blank virtual machine that was created. The {@code name} on {@code CreateBlankVirtualMachine} is
     * required.
     * <p/>
     * The name may not be that of another virtual machine. Must begin with a letter, may contain only letters, numbers,
     * or hyphens, and must not exceed fifteen characters. {@code ProcessorCount} is required and refers to the number
     * of processors in the virtual machine. Permitted values are: 1, 2, 4, or 8.
     * <p/>
     * {@code Memory} is required. Permitted values are in megabytes and must be evenly divisible by 4.
     * <p/>
     * {@code Layout} is required. Only one of three variations is permitted in a call:
     * <ul>
     * <li>Add to an existing group. {@code Group} is required.
     * <li>Add to a newly created group in an existing row. {@code Row} is required. {@code NewGroup} is required to
     * provide the required name, which may not exceed fifty characters.
     * <li>Add to a newly created group in a newly created row. {@code NewRow} is required to provide the required name,
     * which may not exceed fifty characters. {@code NewGroup} is required to provide the required name, which may not
     * exceed fifty characters.
     * </ul>
     * {@code Description} is optional but if present the description must not exceed one hundred characters.
     * <p/>
     * {@code Tags} is optional but is permitted to be empty if no tags are desired on the virtual machine.
     * <p/>
     * {@code OperatingSystem} is required to identify the operating system to be installed on the virtual machine. This
     * ensures the virtual machine is correctly configured for the expected operating system.
     * <p/>
     * NOTE: A virtual machine must have a system disk. Therefore, one disk is required: either one {@code Disk} under
     * {@code Disks} or one {@code DetachedDisk} under {@code DetachedDisks}. Both may not be used.
     * <p/>
     * {@code Disks} is required. {@code Disk} is optional but only one disk may be defined when creating a blank
     * virtual machine. Within a disk, {@code Index} is required as an integer with the first disk set to zero and
     * incremented for each additional disk. {@code Size} is required. {@code Unit} is required and will be "GB" for
     * disks. {@code Value} is required and must be greater than zero and less than 512. {@code Name} is optional and
     * ignored if present.
     * <p/>
     * {@code DetachedDisks} is required. {@code DetachedDisk} is optional but if used will identify the detached disk
     * to be attached. Only one detached disk may be attached when creating a blank virtual machine.
     * <p/>
     * {@code NetworkAdapterSettings} is required.
     * <p/>
     * At least one {@code NetworkAdapter} is required. Up to four {@code NetworkAdapters} may be included.
     * <p/>
     * {@code Network} is required to identify the network to which the network adapter will be bound.
     * <p/>
     * {@code NetworkType} is optional and ignored if present.
     * <p/>
     * {@code IpAddress} is optional and ignored if present.
     * <p/>
     * {@code NetworkHosts} provides a fast path to the utilization of the virtual machine.
     * <p/>
     * {@code Status} refers to the status of the virtual machine.
     * <p/>
     * {@code ProcessorCount} refers to the number of processors in the virtual machine. Permitted values are: 1, 2, 4,
     * or 8.
     * <p/>
     * {@code ToolsStatus} refers to VMware Tools status.
     * <p/>
     * {@code MediaStatus} is the status of the VMware Tools media.
     * <p/>
     * {@code DetectedIpAddresses} are IP addresses detected on the virtual machine but not assigned to the virtual
     * machine in the Enterprise Cloud.
     * <p/>
     * {@code HardwareConfiguration}, which is defined in the body and therefore exists on the created blank virtual
     * machine, will not appear in the response if the task is not complete, which is the normal situation.
     * <p/>
     * {@code PendingRetryOperation} will appear only if an operation is pending a retry after failing.
     *
     * @param computePoolId ID of the compute pool in which the blank virtual machine will be created.
     * @param obj Create blank virtual machine request.
     * @return The blank virtual machine that is created.
     * @throws TerremarkException If an error occurs creating a blank virtual machine.
     */
    VirtualMachine virtualMachineCreateBlank(String computePoolId, CreateBlankVirtualMachine obj)
                    throws TerremarkException;

    /**
     * This call creates a new virtual machine from an existing virtual machine in the compute pool. Customization of
     * the configuration is permitted during a customizable copy. If successful, the call returns information regarding
     * the virtual machine that was created.
     * <p/>
     * The {@code name} on {@code CopyVirtualMachine} is required.
     * <p/>
     * Note:
     * <ul>
     * <li>The name may not be that of another virtual machine, must begin with a letter, may contain only letters,
     * numbers, or hyphens, and must not exceed fifteen characters.
     * <li>The source virtual machine must have a {@code PoweredOn} value of false.
     * <li>The source virtual machine must have a {@code Status} value of Deployed.
     * <li>The source virtual machine must have a {@code ToolsStatus} value of Current.
     * </ul>
     * <p/>
     * {@code Source}, is required, to identify the existing virtual machine to copy when creating the virtual machine.
     * <p/>
     * {@code ProcessorCount} is required and refers to the number of processors in the virtual machine. Permitted
     * values are: 1, 2, 4, or 8.
     * <p/>
     * {@code Memory} is required. Permitted values are in megabytes and must be evenly divisible by 4.
     * <p/>
     * {@code Layout} is optional. If present, only one of three variations is permitted in a call:
     * <ul>
     * <li>Add to an existing group. {@code Group} is required.
     * <li>Add to a newly created group in an existing row. {@code Row} is required. {@code NewGroup} is required to
     * provide the required name, which may not exceed fifty characters.
     * <li>Add to a newly created group in a newly created row. {@code NewRow} is required to provide the required name,
     * which may not exceed fifty characters. {@code NewGroup} is required to provide the required name, which may not
     * exceed fifty characters.
     * </ul>
     * <p/>
     * Note: If not used, the new virtual machine is assigned to the same row and group as the source virtual machine.
     * <p/>
     * If {@code DisableCustomization} is true, an exact copy of the source virtual machine is made and neither
     * {@code WindowsCustomization} nor {@code LinuxCustomization} may be present.
     * <p/>
     * One of either {@code WindowsCustomization} or {@code LinuxCustomization} is required, unless
     * {@code DisableCustomization} is true, depending on the operating system family of the virtual machine from which
     * to copy.
     * <p/>
     * Requirements common to all operating system families:
     * <ul>
     * <li>{@code NetworkSettings} and {@code NetworkAdapterSettings} are required.
     * <li>At least one {@code NetworkAdapter} is required. Up to four {@code NetworkAdapters} may be included.
     * <li>{@code Network} is optional. If included will be used to identify the network to which the network adapter
     * will be bound. If not included, defaults to the first available subnet.
     * <li>{@code NetworkType} is optional and ignored if present.
     * <li>{@code IpAddress} is optional. If not included, defaults to the first available IP address on the subnet.
     * <li>{@code DnsSettings} is optional. If not included, defaults to DNS for the data center.
     * <li>{@code PrimaryDns} is required if {@code DnsSettings} is included.
     * <li>{@code PoweredOn} is optional. If not included, defaults to false.
     * </ul>
     * <p/>
     * Windows operating system family:
     * <ul>
     * <li>{@code Password} is required.
     * </ul>
     * <p/>
     * Linux operating system family:
     * <ul>
     * <li>{@code SshKey} is optional and ignored if present.
     * <li>{@code Description} is optional but if present the description must not exceed one hundred characters.
     * <li>{@code Tags} is optional and ignored if present. The tags on the source virtual machine are copied to the
     * newly created virtual machine. To assign different tags, {@link #virtualMachineEdit(VirtualMachine)} to change
     * the tags after the copy creates the new virtual machine.
     * </ul>
     * <p/>
     * Note: If {@code PoweredOn} true will start the new virtual machine after copying. Because the copy is identical
     * to the source, subsequently starting the source causes an IP conflict on the network.
     * <p/>
     * {@code NetworkHosts} provides a fast path to the utilization of the virtual machine.
     * <p/>
     * {@code Status} refers to the status of the virtual machine.
     * <p/>
     * {@code ProcessorCount} refers to the number of processors in the virtual machine. Permitted values are: 1, 2, 4,
     * or 8.
     * <p/>
     * {@code ToolsStatus} refers to VMware Tools status.
     * <p/>
     * {@code MediaStatus} is the status of the VMware Tools media. Permitted values are:
     * <ul>
     * <li>Unmounted - No media is mounted on the virtual machine.
     * <li>IsoMounted - Media is with an ISO image is mounted on the virtual machine.
     * <li>VMwareToolsMounted - VMware Tools media is mounted on the virtual machine.
     * </ul>
     * <p/>
     * {@code DetectedIpAddresses} are IP addresses detected on the virtual machine but not assigned to the virtual
     * machine in the Enterprise Cloud.
     * <p/>
     * {@code HardwareConfiguration}, which exists on the source virtual machine and therefore exists on the copied
     * virtual machine, will not appear in the response if the task is not complete, which is the normal situation.
     * <p/>
     * {@code PendingRetryOperation} will appear only if an operation is pending a retry after failing.
     *
     * @param computePoolId ID of the compute pool where the virtual machine should be copied/created.
     * @param obj Copy virtual machine request.
     * @return Virtual machine that is created for the copy request.
     * @throws TerremarkException If an error occurs creating a copy of a virtual machine.
     */
    VirtualMachine virtualMachineCreateCopy(String computePoolId, CopyVirtualMachine obj) throws TerremarkException;

    /**
     * This method creates a new virtual machine from an existing virtual machine in the compute pool. No customization
     * of the configuration is permitted during an identical copy. If successful, the call returns information regarding
     * the virtual machine that was created.
     * <p/>
     * Note: The newly created virtual machine has the same network address as the source virtual machine. If both are
     * powered on an IP address conflict will result on the network. The IP address of one of the virtual machines must
     * be changed before powering on both virtual machines.
     * <p/>
     * The {@code name} on {@code CopyIdenticalVirtualMachine} is required.
     * <p/>
     * Note:
     * <ul>
     * <li>The name may not be that of another virtual machine, must begin with a letter, may contain only letters,
     * numbers, or hyphens, and must not exceed fifteen characters.
     * <li>The source virtual machine must have a {@code PoweredOn} value of false.
     * <li>The source virtual machine must have a {@code Status} value of Deployed.
     * <li>The source virtual machine must have a {@code ToolsStatus} value of Current.
     * </ul>
     * <p/>
     * The {@code Source} is required, to identify the existing virtual machine to copy identically when creating the
     * virtual machine.
     * <p/>
     * {@code Layout} is optional. If present, only one of three variations is permitted in a call:
     * <ul>
     * <li>Add to an existing group. {@code Group} is required.
     * <li>Add to a newly created group in an existing row. {@code Row} is required. {@code NewGroup} is required to
     * provide the required name, which may not exceed fifty characters.
     * <li>Add to a newly created group in a newly created row. {@code NewRow} is required to provide the required name,
     * which may not exceed fifty characters. {@code NewGroup} is required to provide the required name, which may not
     * exceed fifty characters.
     * </ul>
     * <p/>
     * Note: If {@code Layout} is not used, the new virtual machine is assigned to the same row and group as the source
     * virtual machine.
     * <p/>
     * {@code Description} is optional but if present the description must not exceed one hundred characters.
     * <p/>
     * {@code NetworkHosts} provides a fast path to the utilization of the virtual machine.
     * <p/>
     * {@code Status} refers to the status of the virtual machine.
     * <p/>
     * {@code ProcessorCount} refers to the number of processors in the virtual machine. Permitted values are: 1, 2, 4,
     * or 8.
     * <p/>
     * {@code ToolsStatus} refers to VMware Tools status.
     * <p/>
     * {@code MediaStatus} is the status of the VMware Tools media.
     * <p/>
     * {@code DetectedIpAddresses} are IP addresses detected on the virtual machine but not assigned to the virtual
     * machine in the Enterprise Cloud.
     * <p/>
     * {@code HardwareConfiguration}, which exists on the source virtual machine and therefore exists on the copied
     * virtual machine, will not appear in the response if the task is not complete, which is the normal situation.
     * <p/>
     * {@code Tags} is optional and ignored if present. The tags on the source virtual machine are copied to the newly
     * created virtual machine. To assign different tags, use Action Virtual Machines Edit to change the tags after the
     * copy creates the new virtual machine.
     * <p/>
     * {@code PendingRetryOperation} will appear only if an operation is pending a retry after failing.
     *
     * @param computePoolId ID of the compute pool where the virtual machine should be copied/created.
     * @param obj Copy virtual machine request.
     * @return Virtual machine that is created for the copy request.
     * @throws TerremarkException If an error occurs creating an identical copy of a virtual machine.
     */
    VirtualMachine virtualMachineCreateCopyIdentical(String computePoolId, CopyIdenticalVirtualMachine obj)
                    throws TerremarkException;

    /**
     * This method creates a new virtual machine from a template in the compute pool. If successful, the call returns
     * information regarding the virtual machine that was created.
     * <p/>
     * The {@code name} on {@code CreateVirtualMachine} is required.
     * <p/>
     * Note: The name may not be that of another virtual machine, must begin with a letter, may contain only letters,
     * numbers, or hyphens, and must not exceed fifteen characters.
     * <p/>
     * {@code ProcessorCount} is required and refers to the number of processors in the virtual machine. Permitted
     * values are: 1, 2, 4, or 8.
     * <p/>
     * {@code Memory} is required. Permitted values are in megabytes and must be evenly divisible by 4.
     * <p/>
     * {@code Layout} is required. Only one of three variations is permitted in a call:
     * <ul>
     * <li>Add to an existing group. {@code Group} is required.
     * <li>Add to a newly created group in an existing row. {@code Row} is required. {@code NewGroup} is required to
     * provide the required name, which may not exceed fifty characters.
     * <li>Add to a newly created group in a newly created row. {@code NewRow} is required to provide the required name,
     * which may not exceed fifty characters. {@code NewGroup} is required to provide the required name, which may not
     * exceed fifty characters.
     * </ul>
     * <p/>
     * {@code Description} is optional but if present the description must not exceed one hundred characters.
     * <p/>
     * {@code Tags} is optional but is permitted to be empty if no tags are desired on the virtual machine.
     * <p/>
     * One of either {@code WindowsCustomization} or {@code LinuxCustomization} is required depending on the operating
     * system family of the template selected.
     * <p/>
     * Requirements common to all operating system families:
     * <ul>
     * <li>{@code NetworkSettings} and {@code NetworkAdapterSettings} are required.
     * <li>At least one {@code NetworkAdapter} is required. Up to four {@code NetworkAdapters} may be included.
     * <li>{@code Network} is required.
     * <li>{@code NetworkType} is optional and ignored if present.
     * <li>{@code IpAddress} is required.
     * <li>{@code DnsSettings} is optional. If not included, defaults to DNS for the data center.
     * <li>{@code PrimaryDns} is required if {@code DnsSettings} is included.
     * <li>{@code PoweredOn} is optional. If not included, defaults to false.
     * </ul>
     * <p/>
     * Windows operating system family:
     * <ul>
     * <li>{@code Password} is required.
     * </ul>
     * <p/>
     * Linux operating system family:
     * <ul>
     * <li>{@code SshKey} is required.
     * </ul>
     * <p/>
     * {@code Template} is required, to identify the template from which to create the virtual machine.
     * <p/>
     * {@code NetworkHosts} provides a fast path to the utilization of the virtual machine.
     * <p/>
     * {@code Status} refers to the status of the virtual machine.
     * <p/>
     * {@code ProcessorCount} refers to the number of processors in the virtual machine. Permitted values are: 1, 2, 4,
     * or 8.
     * <p/>
     * {@code ToolsStatus} refers to VMware Tools status.
     * <p/>
     * {@code MediaStatus} is the status of the VMware Tools media
     * <p/>
     * {@code DetectedIpAddresses} are IP addresses detected on the virtual machine but not assigned to the virtual
     * machine in the Enterprise Cloud.
     * <p/>
     * {@code HardwareConfiguration}, which exists on the template and therefore exists on the created virtual machine,
     * will not appear in the response if the task is not complete, which is the normal situation.
     * <p/>
     * {@code PendingRetryOperation} will appear only if an operation is pending a retry after failing.
     *
     * @param computePoolId ID of the compute pool where the virtual machine should be created.
     * @param obj Create virtual machine request.
     * @return Virtual machine that is created for the request.
     * @throws TerremarkException If an error occurs creating a virtual machine from a template.
     */
    VirtualMachine virtualMachineCreateFromTemplate(String computePoolId, CreateVirtualMachine obj)
                    throws TerremarkException;

    /**
     * This method detaches a disk from a virtual machine. If successful, the call returns information regarding the
     * disk detached. The {@code name} on {@code DetachedDisk} is required.
     * <p/>
     * Note: The name may not be that of another detached disk and must not exceed fifteen characters.
     * <p/>
     * {@code Disk} and the subordinate {@code Index} are required.The subordinate {@code Size} and {@code Name} are
     * optional and ignored if present.
     * <p/>
     * Note: The system disk, the disk with {@code index} zero, may not be detached.
     *
     * @param virtualMachineId ID of the virtual machine from which a disk should be detached.
     * @param obj Detach disk request.
     * @return The detached disk information.
     * @throws TerremarkException If an error occurs detaching disk from a virtual machine.
     */
    DetachedDisk virtualMachineDetachDisk(String virtualMachineId, DetachDisk obj) throws TerremarkException;

    /**
     * Method edits the name, description, and/or tags on a virtual machine defined in an environment. If successful a
     * task is returned. If successful and only the description or tags are changed (the name is not changed), the
     * returned task will be null. The {@code name} on {@code VirtualMachine} is required.
     * <p/>
     * Note: The name is case insensitive. The name may not be that of another virtual machine, must begin with a
     * letter, may contain only letters, numbers, or hyphens and must not exceed fifteen characters.
     * <p/>
     * {@code Description} is optional but if present the description must not exceed one hundred characters.
     * <p/>
     * Note: The description is case insensitive. To remove the description an empty {@code Description}, must be
     * specified.
     * <p/>
     * Both {@code Tags} and {@code Tag} are optional. Including a {@code Tag} not currently on the virtual machine adds
     * that tag to the virtual machine.
     * <p/>
     * Note: If the virtual machine has tags and {@code Tags} is empty, all tags are removed. Similarly, if any
     * {@code Tag} is on the virtual machine and not present in the call, that tag is removed from the virtual machine.
     * If the virtual machine has tags and {@code Tags} is not present in the call, no change is made to the tags.
     * <p/>
     * {@code Status} refers to the status of the task.
     * <p/>
     * {@code CompletedTime} is not applicable to {@code Queued} or {@code Running} {@code Status} and is not included
     * in the response.
     *
     * @param obj The virtual machine object with the edits.
     * @return Task (if name is changed) or {@code null}.
     * @throws TerremarkException If an error occurs editing the specified virtual machine.
     */
    Task virtualMachineEdit(VirtualMachine obj) throws TerremarkException;

    /**
     * This method edits the IP addresses assigned to a virtual machine defined in an environment. If successful, the
     * call returns the task that modified the virtual machine.
     * <p/>
     * Note: To change networks or assigned IP addresses on a virtual machine requires a {@code Status} of
     * {@code Deployed}.
     * <p/>
     * {@code Network} can be used to identify which network the assigned IP address belongs to.
     * <p/>
     * Both {@code Network} and {@code IpAddress} are optional. Including a {@code Network} or {@code IpAddress} not
     * currently on the virtual machine adds that network or IP address to the virtual machine.
     * <p/>
     * Note: If a {@code Network} is on the virtual machine and is not present in the call, that network and all
     * assigned IP addresses for that network are removed. Similarly, if an {@code IpAddress} is on the virtual machine
     * and not present in the call, that IP address is removed from the network.
     * <p/>
     * {@code Status} refers to the status of the task.
     * <p/>
     * {@code CompletedTime} is not applicable to {@code Queued} or {@code Running} {@code Status} and is not included
     * in the response.
     *
     * @param virtualMachineId ID of the virtual machine for which IP addresses should be edited.
     * @param obj IP addresses information to be updated on the virtual machine.
     * @return Task for the specified changes.
     * @throws TerremarkException If an error occurs editing the assigned IP addresses of the virtual machine.
     */
    Task virtualMachineEditAssignedIPAddress(String virtualMachineId, AssignedIpAddresses obj)
                    throws TerremarkException;

    /**
     * This call edits the processor count, memory, storage, and network adapters of a virtual machine defined in an
     * environment. If successful, the call returns the task that modified the virtual machine.
     * <p/>
     * Note: To configure a virtual machine requires a {@code Status} value of {@code Deployed}.
     * <p/>
     * The virtual machine must be powered off to change the processor count, memory, and network adapters. The virtual
     * machine must be powered off to remove a disk from a virtual machine. The storage capacity may be changed with the
     * virtual machine powered on or powered off.
     * <p/>
     * Note: The storage capacity of a disk drive may only be increased on a virtual machine.
     * <p/>
     * The first {@code Disk} is the system disk and is required. Subsequent {@code Disk} elements are optional. No more
     * than fifteen disks may be defined. Within a disk, {@code Index} is optional and ignored if present. It is an
     * integer with the first disk set to zero and incremented for each additional disk. {@code Size} is required.
     * {@code Unit} is required and will be "GB" for disks. {@code Value} is required and must be greater than zero and
     * less than 512. {@code Name} is optional and ignored if present.
     * <p/>
     * Note: The first hard disk on a virtual machine is the system disk and may not be removed. If a {@code Disk} is
     * currently set on a virtual machine and is not present in the call, that disk is removed from the virtual machine.
     * <p/>
     * {@code Network} can be used to identify which network the network adapter is attached.
     * <p/>
     * {@code Name} under both {@code Disk} and {@code Nic} is optional and ignored if present. Names for disks and
     * network adapters are internally assigned and may not be changed.
     * <p/>
     * {@code Nic} is optional. Including a {@code Nic} not currently on the virtual machine, based on the subordinate
     * {@code UnitNumber}, adds that network adapter to the virtual machine.
     * <p/>
     * Note: If a network adapter is currently set on a virtual machine and the {@code Nic} for that network adapter is
     * not present in the call, that network adapter and all assigned IP addresses for that network adapter are removed.
     * <p/>
     * {@code NetworkType} is optional and ignored if present.
     * <p/>
     * {@code Status} refers to the status of the task.
     * <p/>
     * {@code CompletedTime} is not applicable to {@code Queued} or {@code Running} {@code Status} and is not included
     * in the response.
     *
     * @param virtualMachineId ID of the virtual machine to edit.
     * @param obj New hardware configuration changes for the virtual machine.
     * @return Task for the specified changes.
     * @throws TerremarkException If an error occurs editing the hardware configuration of the virtual machine.
     */
    Task virtualMachineEditHardwareConfiguration(String virtualMachineId, HardwareConfiguration obj)
                    throws TerremarkException;

    /**
     * This method upgrades a virtual machine to the new version of ESX in an environment. If successful, the call
     * returns the task that modified the virtual machine.
     *
     * @param virtualMachineId ID of the virtual machine to upgrade the hardware version.
     * @return Task for polling the status of the hardware version upgrade.
     * @throws TerremarkException If an error occurs upgrading the hardware version of the virtual machine.
     */
    Task virtualMachineEditUpgradeHardwareVersion(String virtualMachineId) throws TerremarkException;

    /**
     * This call creates a catalog item in the catalog from a virtual machine. If successful, the call returns
     * information regarding the catalog item that was created.
     * <p/>
     * This call also creates a task regarding the source virtual machine that was exported. To view or monitor the task
     * on the virtual machine that was exported, use {@link EnvironmentHandler#getTasksByVirtualMachine(String)} for the
     * source virtual machine. The source virtual machine task will have {@code Operation} set to {@code Export Server}.
     * <p/>
     * Note: The source virtual machine must have a {@code PoweredOn} value of false and must not have a {@code Status}
     * value of {@code TaskInProgress} or {@code CopyInProgress}.
     * <p/>
     * Both {@code ExportVirtualMachine} and {@code CatalogName} are required.
     * <p/>
     * Note: {@code CatalogName} may not be that of another catalog item and must not exceed fifty characters.
     * <p/>
     * {@code CatalogType} refers to the source operation for the catalog item.
     *
     * @param virtualMachineId ID of the virtual machine to export.
     * @param obj Export virtual machine request.
     * @return The catalog entry that was created from the export action.
     * @throws TerremarkException If an error occurs exporting the virtual machine.
     */
    CatalogEntry virtualMachineExport(String virtualMachineId, ExportVirtualMachineRequest obj)
                    throws TerremarkException;

    /**
     * This method logs in to the guest operating system and creates a process on a specified virtual machine. To view
     * any output from the process, send all output to a file and retrieve the file contents from the guest operating
     * system. If successful, the call returns information regarding the process that was created.
     * <p/>
     * To run a program, specify the path and program in {@code ProgramPath} and any arguments in {@code Arguments}.
     * Omit {@code Script} and {@code Interpreter}.
     * <p/>
     * To run a script, enter the contents of the script in {@code Script}. The system will take whatever text is in
     * {@code Script}, write it to a temporary file, and invoke the interpreter specified in {@code Interpreter} passing
     * the file as an argument. To use cmd.exe as the desired interpreter on Windows, pass an empty {@code Interpreter}.
     * Omit {@code ProgramPath} and {@code Arguments}.
     * <p/>
     * Use the returned process information to find the process in the response of
     * {@link #getVirtualMachinesGuestProcesses(String, String, String)}.
     * <p/>
     * Note:
     * <ul>
     * <li>This call requires valid credentials for a user with permission to create the process on the virtual machine.
     * <li>If both a script and program are specified, then the program will take precedence and the script information
     * will be ignored.
     * <li>To run a process on a virtual machine requires a {@code PoweredOn} value of {@code true}.
     * </ul>
     *
     * @param virtualMachineId ID of the virtual machine where the guest process should be run.
     * @param obj Guest process information.
     * @return Information regarding the process.
     * @throws TerremarkException If an error occurs running guest process on the virtual machine.
     */
    GuestProcess virtualMachineGuestProcess(String virtualMachineId, CreateGuestProcess obj) throws TerremarkException;

    /**
     * This call creates a virtual machine from a catalog item in the compute pool. If successful, the call returns
     * information regarding the virtual machine that was created.
     * <p/>
     * The {@code name} on {@code ImportVirtualMachine} is required. Note: The name may not be that of another virtual
     * machine, must begin with a letter, may contain only letters, numbers, or hyphens, and must not exceed fifteen
     * characters.
     * <p/>
     * {@code ProcessorCount} is required and refers to the number of processors in the virtual machine. Permitted
     * values are: 1, 2, 4, or 8.
     * <p/>
     * {@code Memory} is required. Permitted values are in megabytes and must be evenly divisible by 4.
     * <p/>
     * {@code Layout} is required. Only one of three variations is permitted in a call:
     * <ul>
     * <li>Add to an existing group. {@code Group} is required.
     * <li>Add to a newly created group in an existing row. {@code Row} is required. {@code NewGroup} is required to
     * provide the required name, which may not exceed fifty characters, and to create the group to which the virtual
     * machine will be added.
     * <li>Add to a newly created group in a newly created row. {@code NewRow} is required to provide the required name,
     * which may not exceed fifty characters, and to create the row in which the new group will be created.
     * {@code NewGroup} is required to provide the required name, which may not exceed fifty characters, and to create
     * the group to which the virtual machine will be added.
     * </ul>
     * <p/>
     * {@code Description} is optional but if present the description must not exceed one hundred characters.
     * <p/>
     * {@code Tags} is optional but is permitted to be empty if no tags are desired on the virtual machine.
     * <p/>
     * {@code CatalogEntry}, is required, to identify the catalog item to import when creating the virtual machine.
     * <p/>
     * {@code NetworkMappings}, {@code NetworkMapping}, and {@code Network} are required. The {@code name} is required
     * on {@code NetworkMapping} and must match the {@code Name} of one {@code NetworkMapping} in the
     * {@code NetworkAdapters} of the catalog configuration in the response to
     * {@link OrganizationHandler#getCatalogConfiguration(String)}. {@code Network} will be used identify the network to
     * which to assign the virtual machine when created.
     * <p/>
     * {@code OperatingSystem} is optional and provides an override for a catalog item with an operating system
     * unsupported in the target location.
     * <p/>
     * If a catalog item has an operating system unsupported by the compute pool location into which the catalog item is
     * imported, the operating system identified in {@code OperatingSystem} will be substituted. If
     * {@code OperatingSystem} is not provided or neither is supported, the import will fail.
     * <p/>
     * Note: {@code OperatingSystem} is ignored if the operating system for the catalog item is supported in the target
     * location.
     * <p/>
     * {@code NetworkHosts} provides a fast path to the utilization of the virtual machine.
     * <p/>
     * {@code Status} refers to the status of the virtual machine.
     * <p/>
     * {@code ProcessorCount} refers to the number of processors in the virtual machine. Permitted values are: 1, 2, 4,
     * or 8.
     * <p/>
     * {@code ToolsStatus} refers to VMware Tools status.
     * <p/>
     * {@code MediaStatus} is the status of the VMware Tools media.
     * <p/>
     * {@code DetectedIpAddresses} are IP addresses detected on the virtual machine but not assigned to the virtual
     * machine in the Enterprise Cloud.
     * <p/>
     * {@code HardwareConfiguration}, which is defined in the catalog item and therefore exists on the imported virtual
     * machine, will not appear in the response if the task is not complete, which is the normal situation.
     * <p/>
     * {@code PendingRetryOperation} will appear only if an operation is pending a retry after failing.
     *
     * @param computePoolId ID of the compute pool where the virtual machine should be imported to.
     * @param obj Import action request.
     * @return Virtual machine that was created as a result of the import action.
     * @throws TerremarkException If an error occurs importing the virtual machine.
     */
    VirtualMachine virtualMachineImport(String computePoolId, ImportVirtualMachine obj) throws TerremarkException;

    /**
     * This method moves the virtual machine to a different layout group.
     * <p/>
     * Three options are possible:
     * <ul>
     * <li>The virtual machine may be moved to a group currently defined in the layout of the environment. The group may
     * be in a different row.
     * <li>The virtual machine may be moved to a new layout group created in the specified layout row defined in the
     * layout of the environment.
     * <li>The virtual machine may be moved to a new layout group created in a new row created in the layout of the
     * environment.
     * </ul>
     * <p/>
     * {@code LayoutRequest} has three variations. Only one of the three variations is permitted in a call:
     * <ul>
     * <li>Move to an existing group. {@code Group} is required.
     * <li>Move to a newly created group in an existing row. {@code Row} is required. {@code NewGroup} is required to
     * provide the required name, which may not exceed fifty characters, and to create the group to which the virtual
     * machine will be moved.
     * <li>Move to a newly created group in a newly created row. {@code NewRow} is required to provide the required
     * name, which may not exceed fifty characters, and to create the row in which the new group will be created.
     * {@code NewGroup} is required to provide the required name, which may not exceed fifty characters, and to create
     * the group to which the virtual machine will be moved.
     * </ul>
     *
     * @param virtualMachineId ID of the virtual machine to move.
     * @param obj The layout request.
     * @throws TerremarkException If an error occurs moving the virtual machine.
     */
    void virtualMachineMove(String virtualMachineId, LayoutRequest obj) throws TerremarkException;

    /**
     * This call powers off a specified virtual machine. Power off simply terminates the virtual machine whereas
     * shutdown requests the virtual machine to end all processes and turn itself off when all processes complete. If
     * successful, the call returns the task that powered off the virtual machine.
     * <p/>
     * Note: To power off requires a {@code PoweredOn} value of {@code true}.
     *
     * @param virtualMachineId ID of the virtual machine to power off.
     * @return Task for checking the status of the power off action.
     * @throws TerremarkException If an error occurs powering off the virtual machine.
     */
    Task virtualMachinePowerOff(String virtualMachineId) throws TerremarkException;

    /**
     * Method that powers on a specified virtual machine. If successful, the call returns the task that powered on the
     * virtual machine.
     * <p/>
     * Note: To power on requires a {@code PoweredOn} value of {@code false}.
     *
     * @param virtualMachineId ID of the virtual machine to power on.
     * @return Task for checking the status of the power on action.
     * @throws TerremarkException If an error occurs powering on the virtual machine.
     */
    Task virtualMachinePowerOn(String virtualMachineId) throws TerremarkException;

    /**
     * This call reboots a specified virtual machine. Reboot is equivalent to pressing the reset button on a computer.
     * If successful, the call returns the task that rebooted the virtual machine.
     * <p/>
     * Note: To reboot requires a {@code PoweredOn} value of {@code true}.
     *
     * @param virtualMachineId ID of the virtual machine to reboot.
     * @return Task for checking the status of the reboot action.
     * @throws TerremarkException If an error occurs rebooting the virtual machine.
     */
    Task virtualMachineReboot(String virtualMachineId) throws TerremarkException;

    /**
     * This method shuts down a specified virtual machine. Shutdown requests the virtual machine to end all processes
     * and turn itself off when all processes complete whereas power off simply terminates the virtual machine. If
     * successful, the call returns the task that shut down the virtual machine.
     * <p/>
     * Note: To shutdown requires a {@code ToolsStatus} value of {@code Current} or {@code OutOfDate} and a
     * {@code PoweredOn} value of {@code true}.
     *
     * @param virtualMachineId ID of the virtual machine to shutdown.
     * @return Task for checking the status of shut down action.
     * @throws TerremarkException If an error occurs shutting down the virtual machine.
     */
    Task virtualMachineShutdown(String virtualMachineId) throws TerremarkException;

    /**
     * Method to remove a specified virtual machine from the compute pool. If successful, the call returns the task that
     * removed the virtual machine.
     * <p/>
     * Note: To remove a virtual machine requires a {@code Status} value of {@code Deployed} and a {@code PoweredOn}
     * value of {@code false}.
     *
     * @param virtualMachineId ID of the virtual machine to remove.
     * @return Task for checking the status of delete action.
     * @throws TerremarkException If an error occurs removing the virtual machine.
     */
    Task virtualMachineRemove(String virtualMachineId) throws TerremarkException;

    /**
     * This method installs VMware Tools on a specified virtual machine. If successful, the call returns the task that
     * installed the tools.
     *
     * @param virtualMachineId ID of the virtual machine on which VMware tools should be installed.
     * @return Task for checking the status of the tools installation.
     * @throws TerremarkException If an error occurs installing the VMware tools on the virtual machine.
     */
    Task virtualMachineToolsInstall(String virtualMachineId) throws TerremarkException;

    /**
     * This method mounts the virtual volume for VMware Tools on a specified virtual machine. If successful, the call
     * returns the task that mounted the tools.
     * <p/>
     * Note: To mount VMware Tools requires a {@code PoweredOn} value of {@code true}.
     *
     * @param virtualMachineId ID of the virtual machine for which the VMware tools should be mounted.
     * @return Task for polling the status of the mount action.
     * @throws TerremarkException If an error occurs mounting the VMware tools location on the virtual machine.
     */
    Task virtualMachineToolsMount(String virtualMachineId) throws TerremarkException;

    /**
     * Method to unmount the virtual volume for VMware Tools on a specified virtual machine. If successful, the call
     * returns the task that unmounted the tools. Note: To unmount VMware Tools requires a {@code PoweredOn} value of
     * {@code true}.
     *
     * @param virtualMachineId ID of the virtual machine for which the tools should be unmounted.
     * @return Task for checking the status of the tools unmount action.
     * @throws TerremarkException If an error occurs unmounting the VMware tools location on the virtual machine.
     */
    Task virtualMachineToolsUnmount(String virtualMachineId) throws TerremarkException;
}
