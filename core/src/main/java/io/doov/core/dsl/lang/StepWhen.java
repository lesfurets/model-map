/*
 * Copyright 2017 Courtanet
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
package io.doov.core.dsl.lang;

import io.doov.core.FieldId;
import io.doov.core.dsl.DslId;
import io.doov.core.dsl.meta.SyntaxTree;

public interface StepWhen<F extends FieldId & DslId> extends Readable, SyntaxTree {

    StepCondition<F> stepCondition();

    ValidationRule<F> validate();

    <I, O, T extends FieldId & DslId> ConditionalMappingRule<I, O, F, T> then(
                                    SimpleMappingRule<I, O, F, T> map);

    <I, J, O, T extends FieldId & DslId> ConditionalBiMappingRule<I, J, O, F, T> then(
                    BiMappingRule<I, J, O, F, T> map);

    <O, T extends FieldId & DslId> ConditionalNaryMappingRule<O, F, T> then(
                    NaryMappingRule<O, F, T> map);

}
