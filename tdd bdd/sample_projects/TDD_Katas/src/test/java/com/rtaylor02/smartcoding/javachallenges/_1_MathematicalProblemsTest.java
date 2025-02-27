package com.rtaylor02.smartcoding.javachallenges;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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

        @DisplayName("Extracting digits")
        @ParameterizedTest(name = "Digits of {0}: {1}")
        @MethodSource("argsSource_extractDigits")
        void testExtractDigits_multiples(int number, List<Integer> expected) {
            // ARRANGE - ACT
            List<Integer> digits = sut.extractDigits(number);

            // ASSERT
            assertEquals(expected, digits);
        }

        static Stream<Arguments> argsSource_extractDigits() {
            return Stream.of(
                    Arguments.of(123, List.of(1, 2, 3)),
                    Arguments.of(1, List.of(1)),
                    Arguments.of(123456, List.of(1, 2, 3, 4, 5, 6))
            );
        }

        @DisplayName("Counting digits")
        @ParameterizedTest(name = "Total digits of {0}: {1}")
        @CsvSource({"123, 3", "12, 2", "1, 1", "123456789, 9"})
        void testCountDigits(int number, int expected) {
            // ARRANGE - ACT
            int digits = sut.countDigits(number);

            // ASSERT
            assertEquals(expected, digits);
        }

        @DisplayName("Finding real divisors")
        @ParameterizedTest(name = "Real divisors of {0}: {1}")
        @MethodSource("argsSource_findProperDivisors")
        void testFindProperDivisors(int number, List<Integer> expected) {
            // ARRANGE - ACT
            List<Integer> result = sut.findProperDivisors(number);

            // ASSERT
            assertEquals(expected, result);
        }

        static Stream<Arguments> argsSource_findProperDivisors() {
            return Stream.of(Arguments.of(10, List.of(1, 2, 5)),
                            Arguments.of(7, List.of(1)),
                            Arguments.of(18, List.of(1, 2, 3, 6, 9)),
                            Arguments.of(24, List.of(1, 2, 3, 4, 6, 8, 12)),
                            Arguments.of(150, List.of(1, 2, 3, 5, 6, 10, 15, 25, 30, 50, 75)),
                            Arguments.of(0, List.of(1)));
        }
    }
}