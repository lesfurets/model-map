package io.doov.core.dsl.mapping;

import io.doov.core.FieldModel;
import io.doov.core.dsl.DslField;
import io.doov.core.dsl.lang.BiMappingRule;
import io.doov.core.dsl.lang.BiTypeConverter;
import io.doov.core.dsl.lang.MappingRegistry;
import io.doov.core.dsl.meta.MetadataVisitor;

public class DefaultBiMappingRule<I, J, O> implements BiMappingRule<I, J, O> {

    private DslField<I> inFieldInfo;
    private DslField<J> in2FieldInfo;
    private DslField<O> outFieldInfo;
    private BiTypeConverter<I, J, O> typeConverter;

    public DefaultBiMappingRule(DslField<I> inFieldInfo, DslField<J> in2FieldInfo,
                                DslField<O> outFieldInfo, BiTypeConverter<I, J, O> typeConverter) {
        this.inFieldInfo = inFieldInfo;
        this.in2FieldInfo = in2FieldInfo;
        this.outFieldInfo = outFieldInfo;
        this.typeConverter = typeConverter;
    }

    @Override
    public boolean validate(FieldModel inModel, FieldModel outModel) {
        return inModel.getFieldInfos().stream().anyMatch(f -> f.id().equals(inFieldInfo.id()))
                && inModel.getFieldInfos().stream().anyMatch(f -> f.id().equals(in2FieldInfo.id()))
                && outModel.getFieldInfos().stream().anyMatch(f -> f.id().equals(outFieldInfo.id()));
    }

    @Override
    public void executeOn(FieldModel inModel, FieldModel outModel) {
        outModel.set(outFieldInfo.id(), typeConverter.convert(inModel, inFieldInfo, in2FieldInfo));
    }

    @Override
    public BiMappingRule<I, J, O> registerOn(MappingRegistry registry) {
        registry.register(this);
        return this;
    }

    @Override
    public String readable() {
        return null;
    }

    @Override
    public void accept(MetadataVisitor visitor, int depth) {
        // TODO
    }
}