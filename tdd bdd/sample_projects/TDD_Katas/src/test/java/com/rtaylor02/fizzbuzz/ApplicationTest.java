package com.rtaylor02.fizzbuzz;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApplicationTest {
    private Application app = new Application();

    @ParameterizedTest(name = "{0}: {1}")
    @CsvSource({"1, 1", "2, 2", "3, FIZZ", "4, 4", "5, BUZZ", "6, FIZZ", "7, 7", "15, FIZZBUZZ"})
    void testCsvData(int number, String expected) {
        // ARRANGE - ACT - ASSERT
        assertEquals(expected, app.compute(number));
    }

    @ParameterizedTest(name = "{0}: {1}")
    @CsvFileSource(resources = "")
    void testMediumSizeCsvFile() {

    }
}