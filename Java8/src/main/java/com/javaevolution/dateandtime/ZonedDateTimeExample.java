package com.javaevolution.dateandtime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeExample {

    ZonedDateTime createZonedDateTime() {
        return ZonedDateTime.now();
    }

    ZonedDateTime createZonedDateTime(int year, int month, int dayOfMonth, int hour, int minute, int second, int nano, String zoneId) {
        return ZonedDateTime.of(year, month, dayOfMonth, hour, minute, second, nano, ZoneId.of(zoneId));
    }

}
