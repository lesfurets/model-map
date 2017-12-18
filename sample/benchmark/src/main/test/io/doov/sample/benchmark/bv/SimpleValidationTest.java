package io.doov.sample.benchmark.bv;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.infra.Blackhole;

public class SimpleValidationTest {

    @Test
    public void test() {
        SimpleValidation bench = new SimpleValidation();
        bench.testSimpleBeanValidation(
                new SimpleValidation.ValidationState(),
                new Blackhole("Today's password is swordfish. " +
                        "I understand instantiating Blackholes directly is dangerous."));
    }

}