package com.rtaylor02.smartcoding.javachallenges;

import java.util.ArrayList;
import java.util.List;

public class _1_MathematicalProblems {
    public static void main(String... args) {

    }

    static class ShortIntroductionToDivisionAndModulo {
        public static void main(String... args) {

        }

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
}

/*
====================== Test ==========================
extractDigits:
123 ==> 3 2 1
3456 ==> 6 5 4 3
----------------
countDigits:
123 ==> 3
3456 ==> 4
 */
