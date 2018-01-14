package io.doov.core.dsl.lang;

import io.doov.core.FieldId;
import io.doov.core.dsl.DslId;
import io.doov.core.dsl.DslModel;

public interface NaryMappingRule<O, S extends FieldId & DslId, T extends FieldId & DslId> extends MappingRule<S, T> {

    void executeOn(DslModel<S> inModel, DslModel<T> outModel);

    NaryMappingRule<O, S, T> registerOn(MappingRegistry<S, T> registry);
}
