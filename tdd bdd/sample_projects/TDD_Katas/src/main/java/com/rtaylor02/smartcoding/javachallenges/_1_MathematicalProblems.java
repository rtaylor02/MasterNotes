package com.rtaylor02.smartcoding.javachallenges;

import jdk.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1_MathematicalProblems {
    public static void main(String... args) {

    }

    static class ShortIntroductionToDivisionAndModulo {
        List<Integer> extractDigits(final int number) {
            List<Integer> numbers = new ArrayList<>();

            int remainingValue = Math.abs(number);
            while (remainingValue > 0) {
                final int digit = remainingValue % 10;
                numbers.add(digit);
                remainingValue = remainingValue / 10;
            }

            return numbers.reversed();
        }

        int countDigits(int number) {
            int counter = 0;
            int remainingValue = number;
            while (remainingValue > 0) {
                remainingValue = remainingValue / 10;
                counter = counter + 1;
            }

            return counter;
        }
    }

    static class ShortIntroductionToDivider {
        List<Integer> findProperDivisors(int number) {
            final List<Integer> divisors = new ArrayList<>();
            divisors.add(1); // All numbers have 1 as a real divisor

            for (int divisor = 2; divisor <= number / 2; divisor++) {
                if (number % divisor == 0) {
                    divisors.add(divisor);
                }
            }

            return divisors;
        }
    }

    static class ShortIntroductionToPrimeNumbers {
        boolean isPrimeNumber(int numberToCheck) {
            for (int i = 2; i <= numberToCheck / 2; i++) {
                if (numberToCheck % i == 0) {
                    return false;
                }
            }
            return true;
        }

        // Algorithm: Sieve of Eratosthenes - removal of number multiplications
        List<Integer> findAllPrimeNumbers(int maxNumber) {
            // Initialise the list first
            List<Integer> primeNumbers = new ArrayList<>();
            for (int i = 2; i <= maxNumber; i++) {
                primeNumbers.add(i);
            }

            int sqrt = (int) Math.sqrt(maxNumber); // All divisors  of maxNumber will ALWAYS be < sqrt(n). E.g. 150 ==> 1, 2, 3, 5, 6, 10, 15, 25, 30, 50, 75. sqrt(150) = 12. Any numbers > 12 are multiples of 1, 2, 3, 5, 6, or 10.
            for (int i = 0; i < sqrt; i++) {
                int divisor = primeNumbers.get(i);
                primeNumbers.removeIf(x -> (x != divisor) && (x % divisor == 0));
            }

            return primeNumbers;
        }
    }

    static class Solutions {
        // Problem: Write method int calc(int, int) that multiplies two variables, m and n of type int, then divides the product by two, and outputs the remainder with respect to division by 7.
        static class _1a_BasicArithmeticOperations {
            public int calc(int n, int m) {
                return (n * m / 2) % 7;
            }
        }

        // Problem: Find the number as well as the sum of natural numbers, which are divisible by 2 or 7 up to a given maximum value (exclusive) and output it to the console. Write method void calcSumAndCountAllNumbersDivBy_2_Or_7(int). Extend it so that it returns the two values instead of performing the console output.
        static class _1b_Statistics {
            enum ReturnCode {
                COUNT, SUM;
            }

            record ReturnCode_record(int count, int sum) {}

            private boolean divisibleBy2Or7(int i) {
                return i % 2 == 0 || i % 7 == 0;
            }

            public Map<ReturnCode, Integer> calcSumAndCountAllNumbersDivBy_2_Or_7(final int max) {
                int count = 0;
                int sum = 0;

                for (int i = 1; i < max; i++) {
                    if (divisibleBy2Or7(i)) {
                        count++;
                        sum = sum + i;
                    }
                }
                return Map.of(ReturnCode.COUNT, count, ReturnCode.SUM, sum);
            }

            public ReturnCode_record calcSumAndCountAllNumbersDivBy_2_Or_7_withRecord(final int max) {
                int count = 0;
                int sum = 0;

                for (int i = 1; i < max; i++) {
                    if (divisibleBy2Or7(i)) {
                        count++;
                        sum = sum + i;
                    }
                }
                return new ReturnCode_record(count, sum);
            }
        }

        static class _1c_EvenOrOddNumber {

            public int isEven(int number) {
                return number % 2 == 0 ? 1 : 0;
            }

            // REMINDER: modulo operator in Java is reduction towards 0.
            public int isOdd(int number) {
                return number % 2 != 0 ? 1 : 0;
            }
        }

        static class _2_NumberAsText {

            public String numberAsText(int number) {
                Map<Integer, String> numberToTextMapping = Map.of(
                        0, "ZERO",
                        1, "ONE",
                        2, "TWO",
                        3, "THREE",
                        4, "FOUR",
                        5, "FIVE",
                        6, "SIX",
                        7, "SEVEN",
                        8, "EIGHT",
                        9, "NINE");

                StringBuilder result = new StringBuilder();
                int remainingNumber = number;

                while (remainingNumber > 0) {
                    int digit = remainingNumber % 10;
                    String text = numberToTextMapping.get(digit);
                    result.insert(0, text + " ");
                    remainingNumber = remainingNumber / 10;
                }

                return result.toString().trim();
            }
        }
    }
}

