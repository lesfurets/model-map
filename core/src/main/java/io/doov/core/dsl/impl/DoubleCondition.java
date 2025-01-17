/*
 * Copyright 2017 Courtanet
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package io.doov.core.dsl.impl;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import io.doov.core.dsl.DslField;
import io.doov.core.dsl.DslModel;
import io.doov.core.dsl.lang.Context;
import io.doov.core.dsl.meta.PredicateMetadata;

/**
 * Implements {@link Double} functions for the numeric conditions.
 */
public class DoubleCondition extends NumericCondition<Double> {

    public DoubleCondition(DslField field) {
        super(field);
    }

    public DoubleCondition(DslField field, PredicateMetadata metadata,
                    BiFunction<DslModel, Context, Optional<Double>> value) {
        super(field, metadata, value);
    }

    @Override
    protected NumericCondition<Double> numericCondition(DslField field, PredicateMetadata metadata,
                    BiFunction<DslModel, Context, Optional<Double>> value) {
        return new DoubleCondition(field, metadata, value);
    }

    @Override
    BiFunction<Double, Double, Boolean> lesserThanFunction() {
        return (l, r) -> l < r;
    }

    @Override
    BiFunction<Double, Double, Boolean> lesserOrEqualsFunction() {
        return (l, r) -> l <= r;
    }

    @Override
    BiFunction<Double, Double, Boolean> greaterThanFunction() {
        return (l, r) -> l > r;
    }

    @Override
    BiFunction<Double, Double, Boolean> greaterOrEqualsFunction() {
        return (l, r) -> l >= r;
    }

    @Override
    BinaryOperator<Double> minFunction() {
        return Double::min;
    }

    @Override
    BinaryOperator<Double> sumFunction() {
        return Double::sum;
    }

    @Override
    BiFunction<Double, Integer, Double> timesFunction() {
        return (l, r) -> l * r;
    }

    @Override
    Double identity() {
        return 0d;
    }

}
