package com.javaevolution.dateandtime;

import java.time.LocalDateTime;

public class LocalDateTimeExample {

    LocalDateTime createLocalDateTime() {
        return LocalDateTime.now();
    }

    LocalDateTime createLocalDateTime(int year, int month, int dayOfMonth, int hour, int minute) {
        return LocalDateTime.of(year, month, dayOfMonth, hour, minute);
    }

}
