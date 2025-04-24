package com.rtaylor02.smartcoding.javachallenges;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


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
    }

    @Nested
    @DisplayName("Short Introduction to Divider")
    class ShortIntroductionToDividerTest {
        private _1_MathematicalProblems.ShortIntroductionToDivider sut = new _1_MathematicalProblems.ShortIntroductionToDivider();

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
                    Arguments.of(159, List.of(1, 3, 53)),
                    Arguments.of(0, List.of(1)));
        }
    }

    @Nested
    @DisplayName("Short Introduction to Prime Numbers")
    class ShortIntroductionToPrimeNumbersTest {
        private _1_MathematicalProblems.ShortIntroductionToPrimeNumbers sut = new _1_MathematicalProblems.ShortIntroductionToPrimeNumbers();

        @DisplayName("Checking if a number is a prime number")
        @ParameterizedTest(name = "{0} is a prime number")
        @ValueSource(ints = {1, 2, 3, 5, 7, 11})
        void shouldReturnTrue_whenGivenPrimeNumbers(int numberToCheck) {
            // ARRANGE - ACT
            boolean result = sut.isPrimeNumber(numberToCheck);

            // ASSERT
            assertTrue(result);
        }

        @DisplayName("Checking if a number is NOT a prime number")
        @ParameterizedTest(name = "{0} is NOT a prime number")
        @ValueSource(ints = {4, 6, 8, 9, 12, 14})
        void shouldReturnFalse_whenGivenNonPrimeNumbers(int numberToCheck) {
            // ARRANGE - ACT
            boolean result = sut.isPrimeNumber(numberToCheck);

            // ASSERT
            assertFalse(result);
        }

        @DisplayName("Finding all prime numbers")
        @ParameterizedTest(name = "Prime numbers up to {0}: {1}")
        @MethodSource("argsSource_findAllPrimeNumbers")
        void testFindAllPrimeNumbers(int maxNumber, List<Integer> expected) {
            // ARRANGE - ACT
            List<Integer> result = sut.findAllPrimeNumbers(maxNumber);

            // ASSERT
            assertEquals(expected, result);
        }

        static Stream<Arguments> argsSource_findAllPrimeNumbers() {
            return Stream.of(
                    Arguments.of(8, List.of(2, 3, 5, 7)),
                    Arguments.of(25, List.of(2, 3, 5, 7, 11, 13, 17, 19, 23)),
                    Arguments.of(100, List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)),
                    Arguments.of(160, List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157)),
                    Arguments.of(500, List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499)),
                    Arguments.of(15, List.of(2, 3, 5, 7, 11, 13)));
        }
    }

    @Nested
    @DisplayName("Solutions")
    class SolutionsTest {
        @Nested
        @DisplayName("Solution 1:")
        class Solution_1 {
            @DisplayName("Solution 1a: Basic Arithmetic Operations")
            @ParameterizedTest(name = "({0} * {1} / 2) % 7 = {2}")
            @CsvSource({"6, 7, 0", "3, 4, 6", "5, 5, 5"})
            void testCalc(int n, int m, int expected) {
                // ARRANGE
                _1_MathematicalProblems.Solutions._1a_BasicArithmeticOperations sut = new _1_MathematicalProblems.Solutions._1a_BasicArithmeticOperations();

                // ACT
                int result = sut.calc(n, m);

                // ASSERT
                assertEquals(expected, result);
            }

            @DisplayName("Solution 1b: Statistics. Problem: Find the number as well as the sum of natural numbers, which are divisible by 2 or 7 up to a given maximum value (exclusive) and output it to the console. Write method void calcSumAndCountAllNumbersDivBy_2_Or_7(int). Extend it so that it returns the two values instead of performing the console output.")
            @ParameterizedTest(name = "Numbers divisible by 2 or 7 up to {0} ==> count={1}, sum={2}")
            @CsvSource({"3, 1, 2", "8, 4, 19", "15, 8, 63"})
            void testCalcSumAndCountAllNumbersDivBy_2_Or_7(int n, int expectedCount, int expectedSum) {
                // ARRANGE
                _1_MathematicalProblems.Solutions._1b_Statistics sut = new _1_MathematicalProblems.Solutions._1b_Statistics();

                // ACT
                Map<_1_MathematicalProblems.Solutions._1b_Statistics.ReturnCode, Integer> result = sut.calcSumAndCountAllNumbersDivBy_2_Or_7(n);

                // ASSERT
                assertEquals(expectedCount, result.get(_1_MathematicalProblems.Solutions._1b_Statistics.ReturnCode.COUNT));
                assertEquals(expectedSum, result.get(_1_MathematicalProblems.Solutions._1b_Statistics.ReturnCode.SUM));
            }

            @DisplayName("Solution 1b: Statistics. Problem: Find the number as well as the sum of natural numbers, which are divisible by 2 or 7 up to a given maximum value (exclusive) and output it to the console. Write method void calcSumAndCountAllNumbersDivBy_2_Or_7(int). Extend it so that it returns the two values instead of performing the console output.")
            @ParameterizedTest(name = "Count and sum of numbers divisible by 2 or 7 up to {0}: {1}")
            @MethodSource("argProvider")
            void testCalcSumAndCountAllNumbersDivBy_2_Or_7(int n, Map<_1_MathematicalProblems.Solutions._1b_Statistics.ReturnCode, Integer> expected) {
                // ARRANGE
                _1_MathematicalProblems.Solutions._1b_Statistics sut = new _1_MathematicalProblems.Solutions._1b_Statistics();

                // ACT
                Map<_1_MathematicalProblems.Solutions._1b_Statistics.ReturnCode, Integer> result = sut.calcSumAndCountAllNumbersDivBy_2_Or_7(n);

                // ASSERT
                assertEquals(expected, result);
            }

            private static Stream<Arguments> argProvider() {
                return Stream.of(
                        Arguments.of(3, Map.of(_1_MathematicalProblems.Solutions._1b_Statistics.ReturnCode.COUNT, 1, _1_MathematicalProblems.Solutions._1b_Statistics.ReturnCode.SUM, 2)),
                        Arguments.of(8, Map.of(_1_MathematicalProblems.Solutions._1b_Statistics.ReturnCode.COUNT, 4, _1_MathematicalProblems.Solutions._1b_Statistics.ReturnCode.SUM, 19)),
                        Arguments.of(15, Map.of(_1_MathematicalProblems.Solutions._1b_Statistics.ReturnCode.COUNT, 8, _1_MathematicalProblems.Solutions._1b_Statistics.ReturnCode.SUM, 63)));
            }

            @DisplayName("Solution 1b: Statistics. Problem: Find the number as well as the sum of natural numbers, which are divisible by 2 or 7 up to a given maximum value (exclusive) and output it to the console. Write method void calcSumAndCountAllNumbersDivBy_2_Or_7(int). Extend it so that it returns the two values instead of performing the console output.")
            @ParameterizedTest(name = "Using record, Numbers divisible by 2 or 7 up to {0} ==> count={1}, sum={2}")
            @CsvSource({"3, 1, 2", "8, 4, 19", "15, 8, 63"})
            void testCalcSumAndCountAllNumbersDivBy_2_Or_7_withRecord(int n, int expectedCount, int expectedSum) {
                // ARRANGE
                _1_MathematicalProblems.Solutions._1b_Statistics sut = new _1_MathematicalProblems.Solutions._1b_Statistics();

                // ACT
                _1_MathematicalProblems.Solutions._1b_Statistics.ReturnCode_record result = sut.calcSumAndCountAllNumbersDivBy_2_Or_7_withRecord(n);

                // ASSERT
                assertEquals(expectedCount, result.count());
                assertEquals(expectedSum, result.sum());
            }

            @DisplayName("Solution 1c: Even or Odd Number. Problem: Create the methods boolean isEven(n) and boolean isOdd(n) that will check if the passed integer is even or odd, respectively.")
            @ParameterizedTest(name = "{0}: {1} (0 = even; 1 = odd)")
            @CsvSource({"0, 1", "1, 0", "-1, 0", "-100, 1", "120, 1"})
            void testIsEven(int n, int expected) {
                // ARRANGE
                _1_MathematicalProblems.Solutions._1c_EvenOrOddNumber sut = new _1_MathematicalProblems.Solutions._1c_EvenOrOddNumber();

                // ACT
                int result = sut.isEven(n);

                // ASSERT
                assertEquals(result, expected);
            }

            @DisplayName("Solution 1c: Even or Odd Number. Problem: Create the methods boolean isEven(n) and boolean isOdd(n) that will check if the passed integer is even or odd, respectively.")
            @ParameterizedTest(name = "{0}: {1} (0 = even; 1 = odd)")
            @CsvSource({"0, 0", "1, 1", "-1, 1", "-100, 0", "120, 0"})
            void testIsOdd(int n, int expected) {
                // ARRANGE
                _1_MathematicalProblems.Solutions._1c_EvenOrOddNumber sut = new _1_MathematicalProblems.Solutions._1c_EvenOrOddNumber();

                // ACT
                int result = sut.isOdd(n);

                // ASSERT
                assertEquals(result, expected);
            }
        }

        @Nested
        @DisplayName("Solution 2:")
        class Solution_2 {
            @ParameterizedTest(name = "Number as text: {0} ==> {1}")
            @CsvSource({"0, ZERO", "7, SEVEN", "42, FOUR TWO", "7271, SEVEN TWO SEVEN ONE", "24680, TWO FOUR SIX EIGHT ZERO", "13579, ONE THREE FIVE SEVEN NINE"})
            void testNumberAsText(int number, String expectedText) {
                // ARRANGE
                _1_MathematicalProblems.Solutions._2_NumberAsText sut = new _1_MathematicalProblems.Solutions._2_NumberAsText();

                // ACT
                String result = sut.numberAsText(number);

                // ASSERT
                assertEquals(result, expectedText);
            }
        }
    }
}