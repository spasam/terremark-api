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

import org.junit.Test;

import com.terremark.annotations.Order;
import com.terremark.api.ComputePool;
import com.terremark.api.ComputePoolReference;
import com.terremark.api.ComputePoolResourceSummary;
import com.terremark.api.ComputePoolResourceSummaryList;
import com.terremark.api.ComputePools;
import com.terremark.api.CreateLayoutGroup;
import com.terremark.api.CreateLayoutRow;
import com.terremark.api.DeviceLayout;
import com.terremark.api.LayoutGroup;
import com.terremark.api.LayoutRow;
import com.terremark.exception.TerremarkException;

/**
 * TODO
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class EnvironmentTest extends AbstractCloudApiAuthTestBase {
    /** TODO */
    private static final String NEW_COMPUTE_POOL_NAME = "Compute Pool Rename Test";

    /**
     * TODO
     *
     * @throws TerremarkException
     */
    @Order(1)
    @Test
    public void testComputePools() throws TerremarkException {
        getComputePoolId();
    }

    /**
     * TODO
     *
     * @throws TerremarkException
     */
    @Order(2)
    @Test
    public void testComputePool() throws TerremarkException {
        final ComputePool pool = client.getEnvironmentHandler().getComputePoolByID(computePoolId);
        assertResource(pool);
        assertNotNull("Invalid CPU burst: " + pool, pool.getCpuBurst());
        assertNotNull("Invalid memory burst: " + pool, pool.getMemoryBurst());
        assertNotNull("Invalid purchased: " + pool, pool.getPurchased());
        assertNotNull("Invalid virtual machines: " + pool, pool.getVirtualMachines());
    }

    /**
     * TODO
     *
     * @throws TerremarkException
     */
    @Order(3)
    @Test
    public void testComputePoolEdit() throws TerremarkException {
        ComputePool pool = client.getEnvironmentHandler().getComputePoolByID(computePoolId);
        assertResource(pool);

        String oldName = pool.getName();
        pool.setName(NEW_COMPUTE_POOL_NAME);
        pool = client.getEnvironmentHandler().computePoolEdit(pool);
        assertEquals("Compute pool not renamed", NEW_COMPUTE_POOL_NAME, pool.getName());

        pool.setName(oldName);
        client.getEnvironmentHandler().computePoolEdit(pool);
        assertEquals("Compute pool not renamed", oldName, pool.getName());
    }

    /**
     * TODO
     *
     * @throws TerremarkException
     */
    @Order(4)
    @Test(expected = IllegalArgumentException.class)
    public void testComputePoolEditNull() throws TerremarkException {
        client.getEnvironmentHandler().computePoolEdit(null);
    }

    /**
     * TODO
     *
     * @throws TerremarkException
     */
    @Order(5)
    @Test(expected = IllegalArgumentException.class)
    public void testComputePoolEditNoName() throws TerremarkException {
        ComputePool pool = client.getEnvironmentHandler().getComputePoolByID(computePoolId);
        assertResource(pool);

        pool.setName(null);
        pool = client.getEnvironmentHandler().computePoolEdit(pool);
    }

    /**
     * TODO
     *
     * @throws TerremarkException
     */
    @Order(6)
    @Test(expected = IllegalArgumentException.class)
    public void testComputePoolEditLongName() throws TerremarkException {
        ComputePool pool = client.getEnvironmentHandler().getComputePoolByID(computePoolId);
        assertResource(pool);

        pool.setName("abcdefghijklmnopqrstuvwxyz0123456789");
        pool = client.getEnvironmentHandler().computePoolEdit(pool);
    }

    /**
     * TODO
     *
     * @throws TerremarkException
     */
    @Order(7)
    @Test
    public void testLayouts() throws TerremarkException {
        DeviceLayout layout = client.getEnvironmentHandler().getLayouts(environmentId);
        assertResourceNoName(layout);

        // Create row 1
        CreateLayoutRow createLayoutRow = new CreateLayoutRow();
        createLayoutRow.setName("Row 1" + TEST_ID);
        LayoutRow row1 = client.getEnvironmentHandler().layoutRowCreate(environmentId, createLayoutRow);
        assertResource(row1);

        // Create row 2
        createLayoutRow.setName("Row 2" + TEST_ID);
        LayoutRow row2 = client.getEnvironmentHandler().layoutRowCreate(environmentId, createLayoutRow);
        assertResource(row2);

        // Create group 1 in row 1
        CreateLayoutGroup createLayoutGroup = new CreateLayoutGroup();
        createLayoutGroup.setRow(TerremarkFactory.getReference(row1));
        createLayoutGroup.setName("Group 1" + TEST_ID);
        LayoutGroup group11 = client.getEnvironmentHandler().layoutGroupCreate(environmentId, createLayoutGroup);
        assertResource(group11);

        // Create group 2 in row 1
        createLayoutGroup.setName("Group 2" + TEST_ID);
        LayoutGroup group12 = client.getEnvironmentHandler().layoutGroupCreate(environmentId, createLayoutGroup);
        assertResource(group12);

        // Get row 1 and group 1 by ID
        assertResource(client.getEnvironmentHandler().getLayoutRowByID(TerremarkFactory.getId(row1)));
        assertResource(client.getEnvironmentHandler().getLayoutGroupByID(TerremarkFactory.getId(group11)));

        // Edit row 1
        row1.setName("New Row 1" + TEST_ID);
        client.getEnvironmentHandler().layoutRowEdit(row1);

        // Edit group 1
        group11.setName("New Group 1" + TEST_ID);
        client.getEnvironmentHandler().layoutGroupEdit(group11);

        // Move row 1 down and then up
        client.getEnvironmentHandler().layoutRowMoveDown(TerremarkFactory.getId(row1));
        client.getEnvironmentHandler().layoutRowMoveUp(TerremarkFactory.getId(row1));

        // Move group 1 down and then up. The following calls fail in Livespec environment
        //client.getEnvironmentHandler().layoutGroupOrderLower(TerremarkFactory.getId(group11));
        //client.getEnvironmentHandler().layoutGroupOrderHigher(TerremarkFactory.getId(group11));

        // Remove all groups and rows
        client.getEnvironmentHandler().layoutGroupRemove(TerremarkFactory.getId(group11));
        client.getEnvironmentHandler().layoutGroupRemove(TerremarkFactory.getId(group12));
        client.getEnvironmentHandler().layoutRowRemove(TerremarkFactory.getId(row1));
        client.getEnvironmentHandler().layoutRowRemove(TerremarkFactory.getId(row2));
    }

    /**
     * TODO
     *
     * @throws Exception If there is a problem retrieving resource summary information.
     */
    @Order(8)
    @Test
    public void testResourceSummary() throws Exception {
        ComputePoolResourceSummaryList summaryList = client.getComputePoolHandler().getResourceSummaryList(environmentId);
        assertResourceNoName(summaryList);

        ComputePools pools = client.getEnvironmentHandler().getComputePools(environmentId);
        for (ComputePoolReference pool : pools.getComputePools()) {
            assertReference(pool);

            ComputePoolResourceSummary summary = client.getComputePoolHandler().getResourceSummary(TerremarkFactory.getId(pool));
            assertResourceNoName(summary);
        }
    }
}