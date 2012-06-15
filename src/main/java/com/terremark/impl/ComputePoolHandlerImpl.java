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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.wink.client.RestClient;

import com.terremark.ComputePoolHandler;
import com.terremark.TerremarkFactory;
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
 * Implementation for API calls for objects with in an compute pool.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
@SuppressWarnings("PMD.CouplingBetweenObjects")
final class ComputePoolHandlerImpl extends AbstractAPIImpl implements ComputePoolHandler {
    /** Invalid date/time argument */
    private static final String INVALID_DATE = "Invalid date/time argument";
    /** Milliseconds in a 25 hours */
    private static final long MAX_RESOURCE_DURATION = 25 * 60 * 60 * 1000L;
    /** Seconds in 5 minutes */
    private static final long SECONDS_IN_FIVE_MINS = 5 * 60;

    /**
     * Package visible default constructor for creating compute pool handler.
     *
     * @param client Rest client instance.
     * @param properties Client configuration.
     */
    ComputePoolHandlerImpl(final RestClient client, final ClientConfiguration properties) {
        super(client, properties);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task detachedDiskEdit(final DetachedDisk obj) throws TerremarkException {
        if (StringUtils.isEmpty(obj.getName())) {
            throw new IllegalArgumentException("Invalid detached disk name");
        }
        if (obj.getName().length() > 15) {
            throw new IllegalArgumentException("Detached disk name cannot exceed 15 characters");
        }
        if (!StringUtils.isEmpty(obj.getDescription()) && obj.getDescription().length() > 100) {
            throw new IllegalArgumentException("Detached disk description cannot exceed 100 characters");
        }

        return put(VERSION_2_12, "/detachedDisks/{detachedDiskId}", Task.class, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task detachedDiskRemove(final String detachedDiskId) throws TerremarkException {
        return delete(VERSION_2_12, "/detachedDisks/{detachedDiskId}", Task.class, detachedDiskId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetachedDisks getDetachedDisks(final String computePoolId) throws TerremarkException {
        return get(VERSION_2_12, "/detachedDisks/computePools/{computePoolId}", DetachedDisks.class, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetachedDisk getDetachedDiskByID(final String detachedDiskId) throws TerremarkException {
        return get(VERSION_2_12, "/detachedDisks/{detachedDiskId}", DetachedDisk.class, detachedDiskId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperatingSystemFamilies getOperatingSystemFamilies(final String computePoolId) throws TerremarkException {
        return get(VERSION_2_10, "/operatingSystemFamilies/computePools/{computePoolId}",
                        OperatingSystemFamilies.class, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperatingSystem getOperatingSystemByID(final String osShortName, final String computePoolId)
                    throws TerremarkException {
        return get(VERSION_2_10, "/operatingSystems/{osShortName}/computePools/{computePoolId}", OperatingSystem.class,
                        osShortName, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputePoolPerformanceStatistics getPerformanceStatistics(final String computePoolId)
                    throws TerremarkException {
        return get(VERSION_2_10, "/computePools/{computePoolId}/performanceStatistics",
                        ComputePoolPerformanceStatistics.class, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PerformanceStatistics getDailyMemoryPerformanceStatistics(final String computePoolId, final Date startTime,
                    final Date endTime) throws TerremarkException {
        final Map<String, String> queryParams = getQueryParams(startTime, endTime);
        return get(VERSION_2_10, "/computePools/{computePoolId}/usage/memory/performanceStatistics/daily", queryParams,
                        null, PerformanceStatistics.class, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PerformanceStatistics getHourlyMemoryPerformanceStatistics(final String computePoolId, final Date startTime,
                    final Date endTime) throws TerremarkException {
        final Map<String, String> queryParams = getQueryParams(startTime, endTime);
        return get(VERSION_2_10, "/computePools/{computePoolId}/usage/memory/performanceStatistics/hourly",
                        queryParams, null, PerformanceStatistics.class, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PerformanceStatistics getDailyProcessorPerformanceStatistics(final String computePoolId,
                    final Date startTime, final Date endTime) throws TerremarkException {
        final Map<String, String> queryParams = getQueryParams(startTime, endTime);
        return get(VERSION_2_10, "/computePools/{computePoolId}/usage/cpu/performanceStatistics/daily", queryParams,
                        null, PerformanceStatistics.class, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PerformanceStatistics getHourlyProcessorPerformanceStatistics(final String computePoolId,
                    final Date startTime, final Date endTime) throws TerremarkException {
        final Map<String, String> queryParams = getQueryParams(startTime, endTime);
        return get(VERSION_2_10, "/computePools/{computePoolId}/usage/cpu/performanceStatistics/hourly", queryParams,
                        null, PerformanceStatistics.class, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputePoolResourceSummary getResourceSummary(final String computePoolId) throws TerremarkException {
        return get(VERSION_2_10, "/resourceSummary/computePools/{computePoolId}", ComputePoolResourceSummary.class,
                        computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputePoolResourceSummaryList getResourceSummaryList(final String environmentId) throws TerremarkException {
        return get(VERSION_2_10, "/resourceSummary/computePools/environments/{environmentId}",
                        ComputePoolResourceSummaryList.class, environmentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputePoolMemoryUsage getMemoryUsage(final String computePoolId) throws TerremarkException {
        return get(VERSION_2_10, "/computePools/{computePoolId}/usage/memory", ComputePoolMemoryUsage.class,
                        computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputePoolMemoryUsageDetail getMemoryUsageDetails(final String computePoolId, final Date time)
                    throws TerremarkException {
        if (time == null) {
            throw new IllegalArgumentException(INVALID_DATE);
        }

        final Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("time", getResourceUsageTime(time));

        return get(VERSION_2_10, "/computePools/{computePoolId}/usage/memory/details", queryParams, null,
                        ComputePoolMemoryUsageDetail.class, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputePoolCpuUsage getProcessorUsage(final String computePoolId) throws TerremarkException {
        return get(VERSION_2_10, "/computePools/{computePoolId}/usage/cpu", ComputePoolCpuUsage.class, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputePoolCpuUsageDetail getProcessorUsageDetails(final String computePoolId, final Date time)
                    throws TerremarkException {
        if (time == null) {
            throw new IllegalArgumentException(INVALID_DATE);
        }

        final Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("time", getResourceUsageTime(time));

        return get(VERSION_2_10, "/computePools/{computePoolId}/usage/cpu/details", queryParams, null,
                        ComputePoolCpuUsageDetail.class, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputePoolStorageUsageDetail getStorageUsage(final String computePoolId) throws TerremarkException {
        return get(VERSION_2_10, "/computePools/{computePoolId}/usage/storage", ComputePoolStorageUsageDetail.class,
                        computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Templates getTemplates(final String computePoolId) throws TerremarkException {
        return get(VERSION_2_10, "/templates/computePools/{computePoolId}", Templates.class, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Template getTemplateByID(final String templateId, final String computePoolId) throws TerremarkException {
        return get(VERSION_2_10, "/templates/{templateId}/computePools/{computePoolId}", Template.class, templateId,
                        computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VirtualMachines getVirtualMachines(final String computePoolId) throws TerremarkException {
        return get(VERSION_2_10, "/virtualMachines/computePools/{computePoolId}", VirtualMachines.class, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssignedIpAddresses getVirtualMachineAssignedIPAddresses(final String virtualMachineId)
                    throws TerremarkException {
        return get(VERSION_2_10, "/virtualMachines/{virtualMachineId}/assignedIps", AssignedIpAddresses.class,
                        virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VirtualMachine getVirtualMachineByID(final String virtualMachineId) throws TerremarkException {
        return get(VERSION_2_10, "/virtualMachines/{virtualMachineId}", VirtualMachine.class, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VirtualMachineConfigurationOptions getVirtualMachinesConfigurationOptions(final String virtualMachineId)
                    throws TerremarkException {
        return get(VERSION_2_10, "/virtualMachines/{virtualMachineId}/configurationOptions",
                        VirtualMachineConfigurationOptions.class, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuestProcesses getVirtualMachinesGuestProcesses(final String virtualMachineId, final String osUserName,
                    final String osPassword) throws TerremarkException {
        if (StringUtils.isEmpty(osUserName)) {
            throw new IllegalArgumentException("Invalid OS user name");
        }
        if (StringUtils.isEmpty(osPassword)) {
            throw new IllegalArgumentException("Invalid OS user password");
        }

        final Map<String, String> extraHeaders = new HashMap<String, String>();

        extraHeaders.put("X-Guest-User", osUserName);
        extraHeaders.put("X-Guest-Password", osPassword);

        return get(VERSION_2_10, "/virtualMachines/{virtualMachineId}/guest/processes", (Map<String, String>) null,
                        extraHeaders, GuestProcesses.class, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HardwareConfiguration getVirtualMachinesHardwareConfiguration(final String virtualMachineId)
                    throws TerremarkException {
        return get(VERSION_2_10, "/virtualMachines/{virtualMachineId}/hardwareConfiguration",
                        HardwareConfiguration.class, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MksTicket getVirtualMachinesMKSTicket(final String virtualMachineId) throws TerremarkException {
        return get(VERSION_2_10, "/virtualMachines/{virtualMachineId}/mksTicket", MksTicket.class, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task disableMemoryBurst(final String computePoolId) throws TerremarkException {
        return post(VERSION_2_10, "/computePools/{computePoolId}/action/disableMemoryBurst", Task.class, null,
                        computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task disableProcessorBurst(final String computePoolId) throws TerremarkException {
        return post(VERSION_2_10, "/computePools/{computePoolId}/action/disableCpuBurst", Task.class, null,
                        computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task enableMemoryBurst(final String computePoolId) throws TerremarkException {
        return post(VERSION_2_10, "/computePools/{computePoolId}/action/enableMemoryBurst", Task.class, null,
                        computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task enableProcessorBurst(final String computePoolId) throws TerremarkException {
        return post(VERSION_2_10, "/computePools/{computePoolId}/action/enableCpuBurst", Task.class, null,
                        computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task virtualMachineAttachDisk(final String virtualMachineId, final AttachDisks obj)
                    throws TerremarkException {
        return post(VERSION_2_12, "/virtualMachines/{virtualMachineId}/hardwareConfiguration/disks/actions/attach",
                        Task.class, obj, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VirtualMachine virtualMachineCreateBlank(final String computePoolId, final CreateBlankVirtualMachine obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/virtualMachines/computePools/{computePoolId}/action/createBlankVirtualMachine",
                        VirtualMachine.class, obj, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VirtualMachine virtualMachineCreateCopy(final String computePoolId, final CopyVirtualMachine obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/virtualMachines/computePools/{computePoolId}/action/copyVirtualMachine",
                        VirtualMachine.class, obj, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VirtualMachine virtualMachineCreateCopyIdentical(final String computePoolId,
                    final CopyIdenticalVirtualMachine obj) throws TerremarkException {
        return post(VERSION_2_10, "/virtualMachines/computePools/{computePoolId}/action/copyIdenticalVirtualMachine",
                        VirtualMachine.class, obj, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VirtualMachine virtualMachineCreateFromTemplate(final String computePoolId, final CreateVirtualMachine obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/virtualMachines/computePools/{computePoolId}/action/createVirtualMachine",
                        VirtualMachine.class, obj, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetachedDisk virtualMachineDetachDisk(final String virtualMachineId, final DetachDisk obj)
                    throws TerremarkException {
        return post(VERSION_2_12, "/virtualMachines/{virtualMachineId}/hardwareConfiguration/disks/actions/detach",
                        DetachedDisk.class, obj, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task virtualMachineEdit(final VirtualMachine obj) throws TerremarkException {
        return put(VERSION_2_10, "/virtualMachines/{virtualMachineId}", Task.class, obj, TerremarkFactory.getId(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task virtualMachineEditAssignedIPAddress(final String virtualMachineId, final AssignedIpAddresses obj)
                    throws TerremarkException {
        return put(VERSION_2_10, "/virtualMachines/{virtualMachineId}/assignedIps", Task.class, obj, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task virtualMachineEditHardwareConfiguration(final String virtualMachineId, final HardwareConfiguration obj)
                    throws TerremarkException {
        return put(VERSION_2_10, "/virtualMachines/{virtualMachineId}/hardwareConfiguration", Task.class, obj,
                        virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task virtualMachineEditUpgradeHardwareVersion(final String virtualMachineId) throws TerremarkException {
        return post(VERSION_2_10, "/virtualMachines/{virtualMachineId}/action/upgradeHardware", Task.class, null,
                        virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CatalogEntry virtualMachineExport(final String virtualMachineId, final ExportVirtualMachineRequest obj)
                    throws TerremarkException {
        return post(VERSION_2_12, "/virtualMachines/{virtualMachineId}/action/export", CatalogEntry.class, obj,
                        virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuestProcess virtualMachineGuestProcess(final String virtualMachineId, final CreateGuestProcess obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/virtualMachines/{virtualMachineId}/guest/action/createProcess", GuestProcess.class,
                        obj, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VirtualMachine virtualMachineImport(final String computePoolId, final ImportVirtualMachine obj)
                    throws TerremarkException {
        return post(VERSION_2_10, "/virtualMachines/computePools/{computePoolId}/action/importVirtualMachine",
                        VirtualMachine.class, obj, computePoolId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void virtualMachineMove(final String virtualMachineId, final LayoutRequest obj) throws TerremarkException {
        post(VERSION_2_10, "/virtualMachines/{virtualMachineId}/action/move", null, obj, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task virtualMachinePowerOff(final String virtualMachineId) throws TerremarkException {
        return post(VERSION_2_10, "/virtualMachines/{virtualMachineId}/action/powerOff", Task.class, null,
                        virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task virtualMachinePowerOn(final String virtualMachineId) throws TerremarkException {
        return post(VERSION_2_10, "/virtualMachines/{virtualMachineId}/action/powerOn", Task.class, null,
                        virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task virtualMachineReboot(final String virtualMachineId) throws TerremarkException {
        return post(VERSION_2_10, "/virtualMachines/{virtualMachineId}/action/reboot", Task.class, null,
                        virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task virtualMachineShutdown(final String virtualMachineId) throws TerremarkException {
        return post(VERSION_2_10, "/virtualMachines/{virtualMachineId}/action/shutdown", Task.class, null,
                        virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task virtualMachineRemove(final String virtualMachineId) throws TerremarkException {
        return delete(VERSION_2_10, "/virtualMachines/{virtualMachineId}", Task.class, virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task virtualMachineToolsInstall(final String virtualMachineId) throws TerremarkException {
        return post(VERSION_2_12, "/virtualMachines/{virtualMachineId}/tools/action/install", Task.class, null,
                        virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task virtualMachineToolsMount(final String virtualMachineId) throws TerremarkException {
        return post(VERSION_2_10, "/virtualMachines/{virtualMachineId}/tools/action/mount", Task.class, null,
                        virtualMachineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task virtualMachineToolsUnmount(final String virtualMachineId) throws TerremarkException {
        return post(VERSION_2_10, "/virtualMachines/{virtualMachineId}/tools/action/unmount", Task.class, null,
                        virtualMachineId);
    }

    /**
     * Returns property formatter query parameters for performance statistic related API calls.
     *
     * @param startTime Start time.
     * @param endTime End time.
     * @return Map containing the query argument name and formatter value.
     */
    private static Map<String, String> getQueryParams(final Date startTime, final Date endTime) {
        final Map<String, String> queryParams = new HashMap<String, String>();

        if (startTime != null) {
            queryParams.put("startTime", getISO8601Time(startTime));
        }
        if (endTime != null) {
            queryParams.put("endTime", getISO8601Time(endTime));
        }

        return queryParams;
    }

    /**
     * Validates and returns the provided argument in ISO 8601 format.
     * <p/>
     * API documentation: The query part is required and the time passed as the parameter must precisely match a time in
     * the preceding 24 hours. Times are on five minute intervals starting on the hour.If the time in the parameter is
     * within the 24 hour window as described above but not an available time (not a minute divisible by five), the call
     * succeeds but returns no information. If the time in the parameter is not within the 24 hour window as described
     * above, the call fails.
     *
     * @param time Date/time.
     * @return ISO 8601 formatt of date/time.
     */
    private static String getResourceUsageTime(final Date time) {
        if (time == null) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
        if (System.currentTimeMillis() - time.getTime() > MAX_RESOURCE_DURATION) {
            throw new IllegalArgumentException("Date/time argument must be with in the preceding 24 hours");
        }
        if (time.getTime() / 1000L % SECONDS_IN_FIVE_MINS != 0L) {
            throw new IllegalArgumentException("Date/time argument must be a multiple of five minute interval");
        }

        return getISO8601Time(time);
    }
}