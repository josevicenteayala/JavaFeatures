package com.javaevolution.dateandtime.advanced;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Set;

class TimeZoneHandlingExampleTest {
    private TimeZoneHandlingExample timeZoneHandlingExample;

    @BeforeEach
    void setUp() {
        timeZoneHandlingExample = new TimeZoneHandlingExample();
    }

    @Test
    void getDefaultTimeZone_returnsSystemDefault() {
        assertEquals(ZoneId.systemDefault(), timeZoneHandlingExample.getDefaultTimeZone());
    }

    @Test
    void getAvailableTimeZones_containsSystemDefault() {
        Set<String> zones = timeZoneHandlingExample.getAvailableTimeZones();
        assertTrue(zones.contains(ZoneId.systemDefault().getId()));
    }

    @Test
    void getTimeZoneById_withValidId_returnsCorrectZoneId() {
        assertEquals(ZoneId.of("UTC"), timeZoneHandlingExample.getTimeZoneById("UTC"));
    }

    @Test
    void getTimeZoneByOffsetHours_withValidHours_returnsCorrectZoneId() {
        assertEquals(ZoneId.ofOffset("UTC", ZoneOffset.ofHours(2)), timeZoneHandlingExample.getTimeZoneByOffsetHours(2));
    }

    @Test
    void getTimeZoneByOffsetHoursMinutes_withValidHoursAndMinutes_returnsCorrectZoneId() {
        assertEquals(ZoneId.ofOffset("UTC", ZoneOffset.ofHoursMinutes(2, 30)), timeZoneHandlingExample.getTimeZoneByOffsetHoursMinutes(2, 30));
    }

    @Test
    void getTimeZoneByOffsetHoursMinutesSeconds_withValidHoursMinutesAndSeconds_returnsCorrectZoneId() {
        assertEquals(ZoneId.ofOffset("UTC", ZoneOffset.ofHoursMinutesSeconds(2, 30, 15)), timeZoneHandlingExample.getTimeZoneByOffsetHoursMinutesSeconds(2, 30, 15));
    }

    @Test
    void getTimeZoneByOffsetTotalSeconds_withValidTotalSeconds_returnsCorrectZoneId() {
        assertEquals(ZoneId.ofOffset("UTC", ZoneOffset.ofTotalSeconds(3600)), timeZoneHandlingExample.getTimeZoneByOffsetTotalSeconds(3600));
    }

    @Test
    void getTimeZoneByOffsetString_withValidOffset_returnsCorrectZoneId() {
        assertEquals(ZoneId.ofOffset("UTC", ZoneOffset.of("+02:00")), timeZoneHandlingExample.getTimeZoneByOffsetString("+02:00"));
    }
}