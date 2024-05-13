package com.javaevolution.dateandtime.advanced;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Set;

public class TimeZoneHandlingExample {

    public ZoneId getDefaultTimeZone() {
        return ZoneId.systemDefault();
    }

    public Set<String> getAvailableTimeZones() {
        return ZoneId.getAvailableZoneIds();
    }

    public ZoneId getTimeZoneById(String id) {
        return ZoneId.of(id);
    }

    public ZoneId getTimeZoneByOffsetHours(int hours) {
        return ZoneId.ofOffset("UTC", ZoneOffset.ofHours(hours));
    }

    public ZoneId getTimeZoneByOffsetHoursMinutes(int hours, int minutes) {
        return ZoneId.ofOffset("UTC", ZoneOffset.ofHoursMinutes(hours, minutes));
    }

    public ZoneId getTimeZoneByOffsetHoursMinutesSeconds(int hours, int minutes, int seconds) {
        return ZoneId.ofOffset("UTC", ZoneOffset.ofHoursMinutesSeconds(hours, minutes, seconds));
    }

    public ZoneId getTimeZoneByOffsetTotalSeconds(int totalSeconds) {
        return ZoneId.ofOffset("UTC", ZoneOffset.ofTotalSeconds(totalSeconds));
    }

    public ZoneId getTimeZoneByOffsetString(String offset) {
        return ZoneId.ofOffset("UTC", ZoneOffset.of(offset));
    }
}
