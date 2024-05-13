package com.javaevolution.dateandtime.advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

class TemporalQueryExampleTest {
    private TemporalQueryExample temporalQueryExample;

    @BeforeEach
    void setUp() {
        temporalQueryExample = new TemporalQueryExample();
    }

    @Test
    void getWeekDay_withValidLocalDate_returnsCorrectDayOfWeek() {
        assertEquals(DayOfWeek.MONDAY, temporalQueryExample.getWeekDay(LocalDate.of(2022, 3, 14)));
    }

    @Test
    void getWeekDayFromLambda_withValidLocalDate_returnsCorrectDayOfWeek() {
        assertEquals(DayOfWeek.MONDAY, temporalQueryExample.getWeekDayFromLambda(LocalDate.of(2022, 3, 14)));
    }

    @Test
    void getDayOfMonth_withValidLocalDate_returnsCorrectDayOfMonth() {
        assertEquals(14, temporalQueryExample.getDayOfMonth(LocalDate.of(2022, 3, 14)));
    }

    @Test
    void getDayOfMonthFromLambda_withValidLocalDate_returnsCorrectDayOfMonth() {
        assertEquals(14, temporalQueryExample.getDayOfMonthFromLambda(LocalDate.of(2022, 3, 14)));
    }

    @Test
    void getDayOfYear_withValidLocalDate_returnsCorrectDayOfYear() {
        assertEquals(73, temporalQueryExample.getDayOfYear(LocalDate.of(2022, 3, 14)));
    }
}