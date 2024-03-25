package com.javaevolution.lambda.advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EffectivelyFinalDemoTest {
    @Test
    void multiplyByFive_withPositiveFactor_returnsCorrectResult() {
        EffectivelyFinalDemo demo = new EffectivelyFinalDemo();
        int result = demo.multiplyByFive(4);
        assertEquals(20, result);
    }

    @Test
    void multiplyByFive_withZeroFactor_returnsZero() {
        EffectivelyFinalDemo demo = new EffectivelyFinalDemo();
        int result = demo.multiplyByFive(0);
        assertEquals(0, result);
    }

    @Test
    void multiplyByFive_withNegativeFactor_returnsNegativeResult() {
        EffectivelyFinalDemo demo = new EffectivelyFinalDemo();
        int result = demo.multiplyByFive(-3);
        assertEquals(-15, result);
    }
}