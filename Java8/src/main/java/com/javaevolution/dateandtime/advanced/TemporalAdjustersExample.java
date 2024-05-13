package com.javaevolution.dateandtime.advanced;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersExample {

    public LocalDate getFirstDayOfMonth(LocalDate date) {
        return date.with(TemporalAdjusters.firstDayOfMonth());
    }

    public LocalDate getFirstDayOfNextMonth(LocalDate date) {
        return date.with(TemporalAdjusters.firstDayOfNextMonth());
    }

    public LocalDate getFirstDayOfYear(LocalDate date) {
        return date.with(TemporalAdjusters.firstDayOfYear());
    }

    public LocalDate getFirstDayOfNextYear(LocalDate date) {
        return date.with(TemporalAdjusters.firstDayOfNextYear());
    }

    public LocalDate getLastDayOfMonth(LocalDate date) {
        return date.with(TemporalAdjusters.lastDayOfMonth());
    }

    public LocalDate getLastDayOfYear(LocalDate date) {
        return date.with(TemporalAdjusters.lastDayOfYear());
    }

    public LocalDate getFirstInMonth(LocalDate date, DayOfWeek dayOfWeek) {
        return date.with(TemporalAdjusters.firstInMonth(dayOfWeek));
    }

    public LocalDate getLastInMonth(LocalDate date, DayOfWeek dayOfWeek) {
        return date.with(TemporalAdjusters.lastInMonth(dayOfWeek));
    }

    public LocalDate getDayOfWeekInMonth(LocalDate date, int ordinal, DayOfWeek dayOfWeek) {
        return date.with(TemporalAdjusters.dayOfWeekInMonth(ordinal, dayOfWeek));
    }

    public LocalDate getNext(LocalDate date, DayOfWeek dayOfWeek) {
        return date.with(TemporalAdjusters.next(dayOfWeek));
    }

    public LocalDate getNextOrSame(LocalDate date, DayOfWeek dayOfWeek) {
        return date.with(TemporalAdjusters.nextOrSame(dayOfWeek));
    }

    public LocalDate getPrevious(LocalDate date, DayOfWeek dayOfWeek) {
        return date.with(TemporalAdjusters.previous(dayOfWeek));
    }

    public LocalDate getPreviousOrSame(LocalDate date, DayOfWeek dayOfWeek) {
        return date.with(TemporalAdjusters.previousOrSame(dayOfWeek));
    }

    public LocalDate getNextSunday(LocalDate date) {
        return date.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
    }
}
