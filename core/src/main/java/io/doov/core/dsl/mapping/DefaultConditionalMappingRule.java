package io.doov.core.dsl.mapping;

import io.doov.core.FieldId;
import io.doov.core.dsl.DslId;
import io.doov.core.dsl.DslModel;
import io.doov.core.dsl.lang.*;
import io.doov.core.dsl.meta.MetadataVisitor;

public class DefaultConditionalMappingRule<I, O, S extends FieldId & DslId, T extends FieldId & DslId>
                implements ConditionalMappingRule<I, O, S, T> {

    private final ValidationRule<S> validationRule;
    private final SimpleMappingRule<I, O, S, T> mappingRule;

    public DefaultConditionalMappingRule(ValidationRule<S> validationRule, SimpleMappingRule<I, O, S, T> mappingRule) {
        this.validationRule = validationRule;
        this.mappingRule = mappingRule;
    }

    @Override
    public ValidationRule<S> validation() {
        return validationRule;
    }

    @Override
    public void executeOn(DslModel<S> inModel, DslModel<T> outModel) {
        if (validationRule.executeOn(inModel).isTrue()) {
            mappingRule.executeOn(inModel, outModel);
        }
    }

    @Override
    public SimpleMappingRule<I, O, S, T> registerOn(MappingRegistry<S, T> registry) {
        registry.register(this);
        return this;
    }

    @Override
    public String readable() {
        // TODO
        return "if " + validationRule.readable() + " then " + mappingRule.readable();
    }

    @Override
    public void accept(MetadataVisitor visitor, int depth) {
        // TODO
    }
}
