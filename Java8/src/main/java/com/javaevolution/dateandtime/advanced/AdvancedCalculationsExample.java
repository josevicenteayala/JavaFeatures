package com.javaevolution.dateandtime.advanced;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AdvancedCalculationsExample {

    public long calculateDaysBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    public long calculateMonthsBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.MONTHS.between(startDate, endDate);
    }

    public long calculateYearsBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.YEARS.between(startDate, endDate);
    }

    public long calculateWeeksBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.WEEKS.between(startDate, endDate);
    }

    public long calculateHoursBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return ChronoUnit.HOURS.between(startDateTime, endDateTime);
    }

    public long calculateMinutesBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return ChronoUnit.MINUTES.between(startDateTime, endDateTime);
    }

    public LocalDate calculateNextMonth(LocalDate date) {
        return date.plusMonths(1);
    }
}
