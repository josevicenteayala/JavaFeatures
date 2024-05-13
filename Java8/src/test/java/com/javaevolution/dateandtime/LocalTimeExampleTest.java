package com.javaevolution.dateandtime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalTime;

class LocalTimeExampleTest {
    private final LocalTimeExample localTimeExample = new LocalTimeExample();

    @Test
    void createLocalTime_returnsNonNullLocalTime() {
        assertNotNull(localTimeExample.createLocalTime());
    }

    @Test
    void createLocalTimeWithHourAndMinute_withValidHourAndMinute_returnsCorrectLocalTime() {
        assertEquals(LocalTime.of(10, 30), localTimeExample.createLocalTimeWithHourAndMinute(30, 10));
    }

    @Test
    void createLocalTimeWithHourAndMinute_withInvalidHour_throwsDateTimeException() {
        assertThrows(DateTimeException.class, () -> localTimeExample.createLocalTimeWithHourAndMinute(30, 25));
    }

    @Test
    void createLocalTimeWithHourAndMinute_withInvalidMinute_throwsDateTimeException() {
        assertThrows(DateTimeException.class, () -> localTimeExample.createLocalTimeWithHourAndMinute(61, 10));
    }
}