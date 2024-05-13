package com.javaevolution.dateandtime;

import java.time.LocalTime;

public class LocalTimeExample {

    LocalTime createLocalTime() {
        return LocalTime.now();
    }

    LocalTime createLocalTimeWithHourAndMinute(int minute, int hour) {
        return LocalTime.of(hour, minute);
    }

}
