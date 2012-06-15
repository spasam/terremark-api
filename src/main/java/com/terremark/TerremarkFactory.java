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

import java.net.MalformedURLException;
import java.util.regex.Pattern;

import com.terremark.api.Entity;
import com.terremark.api.OperatingSystem;
import com.terremark.api.Reference;
import com.terremark.api.Resource;
import com.terremark.config.PropertiesBuilder;
import com.terremark.exception.TerremarkException;
import com.terremark.impl.TerremarkClientImpl;

/**
 * Factory that provider various utility methods. {@link #getClient(PropertiesBuilder)} can be used to create an
 * instance of {@link TerremarkClient}. {@link #getId(Reference)} and {@link #getId(Resource)} can be used to get a
 * unique identifier for a reference or resource respectively.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public final class TerremarkFactory {
    /** Pattern to split string by '/' character. */
    private static final Pattern SLASH_PATTERN = Pattern.compile("/");
    /** Pattern to get template identifier. */
    private static final Pattern TEMPLATE_PATTERN = Pattern.compile(".*/templates/\\d+/computePools/\\d+",
                    Pattern.CASE_INSENSITIVE);
    /** Pattern to get OS identifier. */
    private static final Pattern OS_PATTERN = Pattern.compile(".*/operatingSystems/.+/computePools/\\d+",
                    Pattern.CASE_INSENSITIVE);

    /**
     * Private constructor.
     */
    private TerremarkFactory() {
    }

    /**
     * Returns an instance of Terremark client.
     *
     * @param builder Properties for creating the client instance.
     * @return Terremark client instance.
     * @throws TerremarkException If an error occurs while creating the Terremark client.
     * @throws MalformedURLException If the API end-point URL is malformed.
     */
    public static TerremarkClient getClient(final PropertiesBuilder builder) throws TerremarkException,
                    MalformedURLException {
        return new TerremarkClientImpl(builder);
    }

    /**
     * Returns the identifier of the specified resource.
     * <p/>
     * Note: For templates, use {@link #getTemplateId(Resource)}.
     * <p/>
     * Note: For {@link OperatingSystem}, use {@link #getOsShortName(OperatingSystem)}.
     *
     * @param resource Resource.
     * @return Resource identifier.
     */
    public static String getId(final Resource resource) {
        if (resource == null) {
            return null;
        }

        return getId(resource.getHref());
    }

    /**
     * Returns the identifier for the specified reference.
     * <p/>
     * Note: For templates, use {@link #getTemplateId(Reference)}.
     *
     * @param reference Reference.
     * @return Reference identifier.
     */
    public static String getId(final Reference reference) {
        if (reference == null) {
            return null;
        }

        return getId(reference.getHref());
    }

    /**
     * Returns the identifier for the specified template.
     *
     * @param resource Template.
     * @return Template identifier.
     */
    public static String getTemplateId(final Resource resource) {
        if (resource == null) {
            return null;
        }

        return getValueUsingPattern(resource.getHref(), TEMPLATE_PATTERN);
    }

    /**
     * Returns the identifier for the specified template.
     *
     * @param reference Template.
     * @return Template identifier.
     */
    public static String getTemplateId(final Reference reference) {
        if (reference == null) {
            return null;
        }

        return getValueUsingPattern(reference.getHref(), TEMPLATE_PATTERN);
    }

    /**
     * Returns the operating system identifier.
     *
     * @param os Operating system resource.
     * @return Operating system identifier.
     */
    public static String getOsShortName(final OperatingSystem os) {
        if (os == null) {
            return null;
        }

        return getValueUsingPattern(os.getHref(), OS_PATTERN);
    }

    /**
     * Utility method to convert a resource to a reference.
     *
     * @param resource Resource to convert.
     * @return Reference for the resource.
     */
    public static <T extends Resource> Reference getReference(final T resource) {
        if (resource == null) {
            return null;
        }

        final Reference r = new Reference();
        r.setHref(resource.getHref());
        r.setName(resource.getName());
        r.setType(resource.getType());

        return r;
    }

    /**
     * Utility method to convert a reference to a resource.
     *
     * @param reference Reference to convert
     * @return Resource for the reference.
     */
    public static <T extends Reference> Reference getReference(final T reference) {
        if (reference == null) {
            return null;
        }

        final Reference r = new Reference();
        r.setAccessible(reference.isAccessible());
        r.setHref(reference.getHref());
        r.setName(reference.getName());
        r.setType(reference.getType());

        return r;
    }

    /**
     * Utility method to convert a entity to a reference.
     *
     * @param entity Entity to convert.
     * @return Reference for the entity.
     */
    public static <T extends Entity> Reference getReference(final T entity) {
        if (entity == null) {
            return null;
        }

        final Reference r = new Reference();
        r.setHref(entity.getHref());
        r.setName(entity.getName());
        r.setType(entity.getType());

        return r;
    }

    /**
     * Helper method to get identifier from a {@code href}.
     *
     * @param href Relative URL.
     * @return Identifier.
     */
    private static String getId(final String href) {
        if (href == null) {
            return null;
        }

        final int index = href.lastIndexOf('/');
        if (index > -1) {
            return href.substring(index + 1);
        }

        return null;
    }

    /**
     * Helper method to get identifier from a {@code href}.
     *
     * @param href Relative URL.
     * @param pattern Pattern that {@code href} should match.
     * @return Identifier.
     */
    private static String getValueUsingPattern(final String href, final Pattern pattern) {
        if (href == null) {
            return null;
        }

        if (pattern.matcher(href).matches()) {
            final String[] parts = SLASH_PATTERN.split(href);

            // We should get at least 5 parts
            if (parts.length > 3) {
                return parts[parts.length - 3];
            }
        }

        return null;
    }
}