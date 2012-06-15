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
package com.terremark.junit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import com.terremark.annotations.Order;

/**
 * Extension of JUnit's runner to support running test methods in a specific order.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class OrderedTestRunner extends BlockJUnit4ClassRunner {
    /**
     * Default constructor.
     *
     * @param klass Test class
     * @throws InitializationError If the test class is malformed.
     */
    public OrderedTestRunner(final Class<?> klass) throws InitializationError {
        super(klass);
    }

    /**
     * Check if the test methods are annotated with {@link com.terremark.annotations.Order} annotation. The order value
     * is used to identify/sort the test methods. Returns the ordered test methods.
     *
     * @see org.junit.runners.BlockJUnit4ClassRunner#computeTestMethods()
     */
    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        final List<FrameworkMethod> methods = super.computeTestMethods();
        final List<FrameworkMethod> orderedMethods = new ArrayList<FrameworkMethod>(methods);

        Collections.sort(orderedMethods, new Comparator<FrameworkMethod>() {
            @Override
            public int compare(final FrameworkMethod m1, final FrameworkMethod m2) {
                final Order o1 = m1.getAnnotation(Order.class);
                final Order o2 = m2.getAnnotation(Order.class);

                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }

                return o1.value() - o2.value();
            }
        });

        return orderedMethods;
    }
}