package com.rtaylor02.fizzbuzz;

public class Application {
    public String compute(int number) {
        StringBuilder result = new StringBuilder();

        if (divisibleBy(number, 3)) {
            result.append("FIZZ");
        }

        if (divisibleBy(number, 5)) {
            result.append("BUZZ");
        }

        if (!(divisibleBy(number, 3) || divisibleBy(number, 5))) {
            result.append(Integer.toString(number));
        }

        return result.toString();
    }

    private static boolean divisibleBy(int number, int factor) {
        return number % factor == 0;
    }
}
