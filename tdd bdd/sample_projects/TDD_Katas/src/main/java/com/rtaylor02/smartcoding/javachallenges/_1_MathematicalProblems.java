package com.rtaylor02.smartcoding.javachallenges;

import jdk.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.List;

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


        static class _1a_BasicArithmeticOperations {
            public int calc(int n, int m) {
                return (n * m / 2) % 7;
            }
        }
    }
}

