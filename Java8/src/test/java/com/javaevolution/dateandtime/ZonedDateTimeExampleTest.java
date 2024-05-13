package com.javaevolution.dateandtime;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

class ZonedDateTimeExampleTest {
    private ZonedDateTimeExample zonedDateTimeExample;

    @BeforeEach
    void setUp() {
        zonedDateTimeExample = new ZonedDateTimeExample();
    }

    @Test
    void createZonedDateTime_returnsNonNullZonedDateTime() {
        assertNotNull(zonedDateTimeExample.createZonedDateTime());
    }

    @Test
    void createZonedDateTimeWithDetails_withValidInputs_returnsCorrectZonedDateTime() {
        ZonedDateTime expected = ZonedDateTime.of(2022, 12, 31, 23, 59, 59, 999, ZoneId.of("UTC"));
        assertEquals(expected, zonedDateTimeExample.createZonedDateTime(2022, 12, 31, 23, 59, 59, 999, "UTC"));
    }

    @Test
    void createZonedDateTimeWithDetails_withInvalidMonth_throwsDateTimeException() {
        assertThrows(DateTimeException.class, () -> zonedDateTimeExample.createZonedDateTime(2022, 13, 31, 23, 59, 59, 999, "UTC"));
    }

    @Test
    void createZonedDateTimeWithDetails_withInvalidDay_throwsDateTimeException() {
        assertThrows(DateTimeException.class, () -> zonedDateTimeExample.createZonedDateTime(2022, 2, 30, 23, 59, 59, 999, "UTC"));
    }

    @Test
    void createZonedDateTimeWithDetails_withInvalidHour_throwsDateTimeException() {
        assertThrows(DateTimeException.class, () -> zonedDateTimeExample.createZonedDateTime(2022, 12, 31, 24, 59, 59, 999, "UTC"));
    }

    @Test
    void createZonedDateTimeWithDetails_withInvalidMinute_throwsDateTimeException() {
        assertThrows(DateTimeException.class, () -> zonedDateTimeExample.createZonedDateTime(2022, 12, 31, 23, 60, 59, 999, "UTC"));
    }

    @Test
    void createZonedDateTimeWithDetails_withInvalidSecond_throwsDateTimeException() {
        assertThrows(DateTimeException.class, () -> zonedDateTimeExample.createZonedDateTime(2022, 12, 31, 23, 59, 60, 999, "UTC"));
    }

    @Test
    void createZonedDateTimeWithDetails_withInvalidNano_throwsDateTimeException() {
        assertThrows(DateTimeException.class, () -> zonedDateTimeExample.createZonedDateTime(2022, 12, 31, 23, 59, 59, 1000000000, "UTC"));
    }

    @Test
    void createZonedDateTimeWithDetails_withInvalidZoneId_throwsDateTimeException() {
        assertThrows(DateTimeException.class, () -> zonedDateTimeExample.createZonedDateTime(2022, 12, 31, 23, 59, 59, 999, "InvalidZoneId"));
    }
}