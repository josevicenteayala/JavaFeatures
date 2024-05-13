package com.javaevolution.dateandtime.advanced;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

class AdvancedCalculationsExampleTest {
    private AdvancedCalculationsExample advancedCalculationsExample;

    @BeforeEach
    void setUp() {
        advancedCalculationsExample = new AdvancedCalculationsExample();
    }

    @Test
    void calculateDaysBetween_returnsCorrectDays() {
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 1, 31);
        assertEquals(30, advancedCalculationsExample.calculateDaysBetween(startDate, endDate));
    }

    @Test
    void calculateMonthsBetween_returnsCorrectMonths() {
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 31);
        assertEquals(11, advancedCalculationsExample.calculateMonthsBetween(startDate, endDate));
    }

    @Test
    void calculateYearsBetween_returnsCorrectYears() {
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 1, 1);
        assertEquals(1, advancedCalculationsExample.calculateYearsBetween(startDate, endDate));
    }

    @Test
    void calculateWeeksBetween_returnsCorrectWeeks() {
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 1, 22);
        assertEquals(3, advancedCalculationsExample.calculateWeeksBetween(startDate, endDate));
    }

    @Test
    void calculateHoursBetween_returnsCorrectHours() {
        LocalDateTime startDateTime = LocalDateTime.of(2022, 1, 1, 0, 0);
        LocalDateTime endDateTime = LocalDateTime.of(2022, 1, 2, 0, 0);
        assertEquals(24, advancedCalculationsExample.calculateHoursBetween(startDateTime, endDateTime));
    }

    @Test
    void calculateMinutesBetween_returnsCorrectMinutes() {
        LocalDateTime startDateTime = LocalDateTime.of(2022, 1, 1, 0, 0);
        LocalDateTime endDateTime = LocalDateTime.of(2022, 1, 1, 1, 0);
        assertEquals(60, advancedCalculationsExample.calculateMinutesBetween(startDateTime, endDateTime));
    }

    @Test
    void calculateNextMonth_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2022, 1, 1);
        assertEquals(LocalDate.of(2022, 2, 1), advancedCalculationsExample.calculateNextMonth(date));
    }
}