package com.javaevolution.dateandtime.advanced;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

class TemporalAdjustersExampleTest {
    private TemporalAdjustersExample temporalAdjustersExample;

    @BeforeEach
    void setUp() {
        temporalAdjustersExample = new TemporalAdjustersExample();
    }

    @Test
    void getFirstDayOfMonth_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 3, 14);
        assertEquals(LocalDate.of(2022, 3, 1), temporalAdjustersExample.getFirstDayOfMonth(date));
    }

    @Test
    void getFirstDayOfNextMonth_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 3, 14);
        assertEquals(LocalDate.of(2022, 4, 1), temporalAdjustersExample.getFirstDayOfNextMonth(date));
    }

    @Test
    void getFirstDayOfYear_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 3, 14);
        assertEquals(LocalDate.of(2022, 1, 1), temporalAdjustersExample.getFirstDayOfYear(date));
    }

    @Test
    void getFirstDayOfNextYear_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 3, 14);
        assertEquals(LocalDate.of(2023, 1, 1), temporalAdjustersExample.getFirstDayOfNextYear(date));
    }

    @Test
    void getLastDayOfMonth_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 3, 14);
        assertEquals(LocalDate.of(2022, 3, 31), temporalAdjustersExample.getLastDayOfMonth(date));
    }

    @Test
    void getLastDayOfYear_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 3, 14);
        assertEquals(LocalDate.of(2022, 12, 31), temporalAdjustersExample.getLastDayOfYear(date));
    }

    @Test
    void getFirstInMonth_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 3, 14);
        assertEquals(LocalDate.of(2022, 3, 1), temporalAdjustersExample.getFirstInMonth(date, DayOfWeek.TUESDAY));
    }

    @Test
    void getLastInMonth_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 3, 14);
        assertEquals(LocalDate.of(2022, 3, 29), temporalAdjustersExample.getLastInMonth(date, DayOfWeek.TUESDAY));
    }

    @Test
    void getDayOfWeekInMonth_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 3, 14);
        assertEquals(LocalDate.of(2022, 3, 8), temporalAdjustersExample.getDayOfWeekInMonth(date, 2, DayOfWeek.TUESDAY));
    }

    @Test
    void getNext_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 3, 14);
        assertEquals(LocalDate.of(2022, 3, 15), temporalAdjustersExample.getNext(date, DayOfWeek.TUESDAY));
    }

    @Test
    void getNextOrSame_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 3, 14);
        assertEquals(LocalDate.of(2022, 3, 14), temporalAdjustersExample.getNextOrSame(date, DayOfWeek.MONDAY));
    }

    @Test
    void getPrevious_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 3, 14);
        assertEquals(LocalDate.of(2022, 3, 7), temporalAdjustersExample.getPrevious(date, DayOfWeek.MONDAY));
    }

    @Test
    void getPreviousOrSame_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 3, 14);
        assertEquals(LocalDate.of(2022, 3, 14), temporalAdjustersExample.getPreviousOrSame(date, DayOfWeek.MONDAY));
    }

    @Test
    void getNextSunday_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 3, 14);
        assertEquals(LocalDate.of(2022, 3, 20), temporalAdjustersExample.getNextSunday(date));
    }
}