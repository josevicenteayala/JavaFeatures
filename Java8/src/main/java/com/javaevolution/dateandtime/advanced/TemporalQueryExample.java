package com.javaevolution.dateandtime.advanced;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class TemporalQueryExample {

    public DayOfWeek getWeekDay(LocalDate localDate) {
        return DayOfWeek.from(localDate);
    }

    public DayOfWeek getWeekDayFromLambda(LocalDate localDate) {
        return localDate.query(DayOfWeek::from);
    }

    public long getDayOfMonth(LocalDate localDate) {
        return ChronoField.DAY_OF_MONTH.getFrom(localDate);
    }

    public long getDayOfMonthFromLambda(LocalDate localDate) {
        return localDate.query(ChronoField.DAY_OF_MONTH::getFrom);
    }

    public long getDayOfYear(LocalDate localDate) {
        return ChronoField.DAY_OF_YEAR.getFrom(localDate);
    }
}
