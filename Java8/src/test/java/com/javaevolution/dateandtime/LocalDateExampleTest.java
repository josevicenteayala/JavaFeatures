package com.javaevolution.dateandtime;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

class LocalDateExampleTest {
    private LocalDateExample localDateExample;

    @BeforeEach
    void setUp() {
        localDateExample = new LocalDateExample();
    }

    @Test
    void createLocalDate_withValidDate_returnsCorrectLocalDate() {
        assertEquals(LocalDate.of(2022, 12, 31), localDateExample.createLocalDate(2022, 12, 31));
    }

    @Test
    void createLocalDate_withLeapYear_returnsCorrectLocalDate() {
        assertEquals(LocalDate.of(2020, 2, 29), localDateExample.createLocalDate(2020, 2, 29));
    }

    @Test
    void createLocalDate_withNonLeapYear_throwsDateTimeException() {
        assertThrows(DateTimeException.class, () -> localDateExample.createLocalDate(2021, 2, 29));
    }
}