package io.doov.core.dsl.field;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.Supplier;

import io.doov.core.dsl.DslField;
import io.doov.core.dsl.impl.DefaultCondition;
import io.doov.core.dsl.lang.StepCondition;

public interface BaseFieldInfo<T> extends DslField {

    // available

    default StepCondition available() {
        return getDefaultCondition().available();
    }

    default StepCondition notAvailable() {
        return getDefaultCondition().notAvailable();
    }

    // eq

    default StepCondition eq(T value) {
        return getDefaultCondition().eq(value);
    }

    default StepCondition eq(DslField value) {
        return getDefaultCondition().eq(value);
    }

    default StepCondition eq(Supplier<T> value) {
        return getDefaultCondition().eq(value);
    }

    default StepCondition notEq(T value) {
        return getDefaultCondition().notEq(value);
    }

    default StepCondition notEq(DslField value) {
        return getDefaultCondition().notEq(value);
    }

    // null

    default StepCondition isNull() {
        return getDefaultCondition().isNull();
    }

    default StepCondition isNotNull() {
        return getDefaultCondition().isNotNull();
    }

    // match

    @SuppressWarnings("unchecked")
    default StepCondition anyMatch(T... values) {
        return getDefaultCondition().anyMatch(values);
    }

    @SuppressWarnings("unchecked")
    default StepCondition anyMatch(Predicate<T> value) {
        return getDefaultCondition().anyMatch(value);
    }

    @SuppressWarnings("unchecked")
    default StepCondition anyMatch(Predicate<T>... values) {
        return getDefaultCondition().anyMatch(values);
    }

    default StepCondition anyMatch(Collection<T> values) {
        return getDefaultCondition().anyMatch(values);
    }

    @SuppressWarnings("unchecked")
    default StepCondition allMatch(T... values) {
        return getDefaultCondition().allMatch(values);
    }

    @SuppressWarnings("unchecked")
    default StepCondition allMatch(Predicate<T> value) {
        return getDefaultCondition().allMatch(value);
    }

    @SuppressWarnings("unchecked")
    default StepCondition allMatch(Predicate<T>... values) {
        return getDefaultCondition().allMatch(values);
    }

    default StepCondition allMatch(Collection<T> values) {
        return getDefaultCondition().allMatch(values);
    }

    @SuppressWarnings("unchecked")
    default StepCondition noneMatch(T... values) {
        return getDefaultCondition().noneMatch(values);
    }

    @SuppressWarnings("unchecked")
    default StepCondition noneMatch(Predicate<T> value) {
        return getDefaultCondition().noneMatch(value);
    }

    @SuppressWarnings("unchecked")
    default StepCondition noneMatch(Predicate<T>... values) {
        return getDefaultCondition().noneMatch(values);
    }

    default StepCondition noneMatch(Collection<T> values) {
        return getDefaultCondition().noneMatch(values);
    }

    // implementation

    DefaultCondition<T> getDefaultCondition();

}
