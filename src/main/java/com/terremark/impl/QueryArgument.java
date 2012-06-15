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

/**
 * Some API calls take query arguments. This class can be used to classify the type of query argument.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
class QueryArgument {
    /** Query argument types */
    public enum Type {
        INTEGER, ISO8601_DATE, LIST, IP_ADDRESS, SUBNET, HOSTNAME, URI
    }

    /** Type */
    private Type type;
    /** Min value (for integer types) */
    private int minValue;
    /** Max value (for integer types) */
    private int maxValue;
    /** Valid values (for list types) */
    private String[] args;

    /**
     * Constructor that takes a type with no additional information.
     *
     * @param type Type.
     */
    QueryArgument(final Type type) {
        this.type = type;
        this.minValue = Integer.MAX_VALUE;
        this.maxValue = Integer.MIN_VALUE;
    }

    /**
     * Integer type query argument constructor.
     *
     * @param minValue Min value.
     * @param maxValue Max value.
     */
    QueryArgument(final int minValue, final int maxValue) {
        this.type = Type.INTEGER;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    /**
     * List type query argument constructor.
     *
     * @param args Valid values.
     */
    QueryArgument(final String... args) {
        this(Type.LIST);
        this.args = args;
    }

    /**
     * Return the type.
     *
     * @return Type.
     */
    final Type getType() {
        return type;
    }

    /**
     * Return min value. Only valid for integer types.
     *
     * @return Min value.
     */
    final int getMinValue() {
        return minValue;
    }

    /**
     * Return max value. Only valid for integer types.
     *
     * @return Max value.
     */
    final int getMaxValue() {
        return maxValue;
    }

    /**
     * Returns valid value. Only valid for list types.
     *
     * @return Valid values.
     */
    final String[] getArgs() {
        return args;
    }
}