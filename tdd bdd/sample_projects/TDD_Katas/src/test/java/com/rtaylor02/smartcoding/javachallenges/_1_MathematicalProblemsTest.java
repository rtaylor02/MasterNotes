package com.rtaylor02.smartcoding.javachallenges;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class _1_MathematicalProblemsTest {
    @Nested
    @DisplayName("Short Introduction to Division and Modulo")
    class ShortIntroductionToDivisionAndModuloTest {
        private _1_MathematicalProblems.ShortIntroductionToDivisionAndModulo sut = new _1_MathematicalProblems.ShortIntroductionToDivisionAndModulo();

        @Test
        @DisplayName("Extracting digits of 123")
        void testExtractDigits() {
            // ARRANGE
            List<Integer> expected = List.of(1, 2, 3);
            // ACT
            List<Integer> result = sut.extractDigits(123);

            // ASSERT
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Counting digits of 123")
        void testCountDigits() {
        }
    }
}