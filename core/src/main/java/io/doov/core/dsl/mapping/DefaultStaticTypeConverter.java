/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package io.doov.core.dsl.mapping;

import static io.doov.core.dsl.meta.ast.AstVisitorUtils.astToString;

import java.util.Locale;
import java.util.function.Function;

import io.doov.core.dsl.lang.StaticTypeConverter;
import io.doov.core.dsl.meta.*;

public class DefaultStaticTypeConverter<I, O> implements StaticTypeConverter<I, O> {

    private static final DefaultStaticTypeConverter<?, ?> IDENTITY =
            new DefaultStaticTypeConverter<>(Function.identity(), ConverterMetadata.identity());

    private final Function<I, O> function;
    private final ConverterMetadata metadata;

    @SuppressWarnings("unchecked")
    public static <I> StaticTypeConverter<I, I> identity() {
        return (StaticTypeConverter<I, I>) IDENTITY;
    }

    public DefaultStaticTypeConverter(Function<I, O> function, String description) {
        this(function, ConverterMetadata.metadata(description));
    }

    public DefaultStaticTypeConverter(Function<I, O> function, ConverterMetadata metadata) {
        this.function = function;
        this.metadata = metadata;
    }

    @Override
    public O convert(I input) {
        return function.apply(input);
    }

    @Override
    public void accept(MetadataVisitor visitor, int depth) {
        metadata.accept(visitor, depth);
    }

    @Override
    public String readable(Locale locale) {
        return astToString(this, locale);
    }
}
