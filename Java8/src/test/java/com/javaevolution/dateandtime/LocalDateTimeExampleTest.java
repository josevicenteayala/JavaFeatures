package com.javaevolution.dateandtime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDateTime;

class LocalDateTimeExampleTest {
    private LocalDateTimeExample localDateTimeExample;

    @BeforeEach
    void setUp() {
        localDateTimeExample = new LocalDateTimeExample();
    }

    @Test
    void createLocalDateTime_returnsNonNullLocalDateTime() {
        assertNotNull(localDateTimeExample.createLocalDateTime());
    }

    @Test
    void createLocalDateTimeWithYearMonthDayHourMinute_withValidInputs_returnsCorrectLocalDateTime() {
        assertEquals(LocalDateTime.of(2022, 12, 31, 23, 59), localDateTimeExample.createLocalDateTime(2022, 12, 31, 23, 59));
    }

    @Test
    void createLocalDateTimeWithYearMonthDayHourMinute_withInvalidMonth_throwsDateTimeException() {
        assertThrows(DateTimeException.class, () -> localDateTimeExample.createLocalDateTime(2022, 13, 31, 23, 59));
    }

    @Test
    void createLocalDateTimeWithYearMonthDayHourMinute_withInvalidDay_throwsDateTimeException() {
        assertThrows(DateTimeException.class, () -> localDateTimeExample.createLocalDateTime(2022, 2, 30, 23, 59));
    }

    @Test
    void createLocalDateTimeWithYearMonthDayHourMinute_withInvalidHour_throwsDateTimeException() {
        assertThrows(DateTimeException.class, () -> localDateTimeExample.createLocalDateTime(2022, 12, 31, 24, 59));
    }

    @Test
    void createLocalDateTimeWithYearMonthDayHourMinute_withInvalidMinute_throwsDateTimeException() {
        assertThrows(DateTimeException.class, () -> localDateTimeExample.createLocalDateTime(2022, 12, 31, 23, 60));
    }
}