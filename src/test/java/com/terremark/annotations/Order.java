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
package com.terremark.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation used by tests to specify the test execution order.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Order {
    /**
     * Order number. Can be any number, but should avoid specifying same value for two or more tests. Lower numbered
     * tests run first.
     *
     * @return Test order number.
     */
    int value();
}