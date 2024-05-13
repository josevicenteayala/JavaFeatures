package com.javaevolution.dateandtime.advanced;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class InteroperabilityExample {

    LocalDate convertToLocalDate(java.util.Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    java.util.Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
