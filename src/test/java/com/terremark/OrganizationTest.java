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

import org.junit.Test;

import com.terremark.annotations.Order;
import com.terremark.api.DeviceTagList;
import com.terremark.api.Environment;
import com.terremark.api.Location;
import com.terremark.api.Organization;
import com.terremark.api.Organizations;
import com.terremark.api.Roles;
import com.terremark.api.Users;
import com.terremark.exception.TerremarkException;

/**
 * TODO
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class OrganizationTest extends AbstractCloudApiAuthTestBase {
    /** TODO */
    private static String locationId;

    /**
     * TODO
     *
     * @throws TerremarkException If there is a problem retrieving the organizations.
     */
    @Order(1)
    @Test
    public void testOrganizations() throws TerremarkException {
        final Organizations orgs = getOrganizations();

        assertTrue("Invalid locations: " + orgs, orgs.getOrganizations().get(0).getLocations().size() > 0);
        locationId = TerremarkFactory.getId(orgs.getOrganizations().get(0).getLocations().get(0));
    }

    /**
     * TODO
     *
     * @throws TerremarkException If there is a problem retrieving a organization.
     */
    @Order(2)
    @Test
    public void testOrganization() throws TerremarkException {
        final Organization org = client.getOrganizationHandler().getOrganizationByID(organizationId);
        assertResource(org);
        assertNotNull("Invalid locations: " + org, org.getLocations());
        // assertNotNull("Invalid tasks: " + org, org.getTasks());
    }

    /**
     * TODO
     *
     * @throws TerremarkException If there is a problem retrieving location information.
     */
    @Order(3)
    @Test
    public void testLocation() throws TerremarkException {
        final Location location = client.getOrganizationHandler().getLocationByID(locationId);
        assertResource(location);
        assertNotNull("Invalid friendly name: " + location, location.getFriendlyName());
        assertNotNull("Invalid ISO3166: " + location, location.getISO3166());
        assertNotNull("Invalid locode: " + location, location.getLocode());
    }

    /**
     * TODO
     *
     * @throws TerremarkException If there is a problem retrieving the tags.
     */
    @Order(4)
    @Test
    public void testTags() throws TerremarkException {
        final DeviceTagList tags = client.getOrganizationHandler().getTags(organizationId);
        assertResourceNoName(tags);
        assertNotNull("Invalid device tags: " + tags, tags.getDeviceTags());
        // assertTrue("Invalid device tags: " + tags, tags.getDeviceTags().size() > 0);
    }

    /**
     * TODO
     *
     * @throws TerremarkException If there is a problem retrieving all environments.
     */
    @Order(5)
    @Test
    public void testEnvironments() throws TerremarkException {
        getEnvironmentId();
    }

    /**
     * TODO
     *
     * @throws TerremarkException If there is a problem retrieving a environment.
     */
    @Order(6)
    @Test
    public void testEnvironment() throws TerremarkException {
        final Environment env = client.getOrganizationHandler().getEnvironmentByID(environmentId);
        assertResource(env);
        assertNotNull("Invalid compute pools: " + env, env.getComputePools());
        assertNotNull("Invalid networks: " + env, env.getNetworks());
        assertNotNull("Invalid tasks: " + env, env.getTasks());
    }

    /**
     * TODO
     *
     * @throws TerremarkException If there is a problem retrieving the users.
     */
    @Order(7)
    @Test
    public void testUsers() throws TerremarkException {
        final Users users = client.getOrganizationHandler().getUsers(organizationId);
        assertResourceNoName(users);
        assertTrue("Invalid users", users.getUsers().size() > 0);
    }

    /**
     * TODO
     *
     * @throws TerremarkException If there is a problem retrieving the users.
     */
    @Order(8)
    @Test
    public void testRoles() throws TerremarkException {
        final Roles roles = client.getOrganizationHandler().getRoles(organizationId);
        assertTrue("Invalid roles", roles.getRoles().size() > 0);
    }
}