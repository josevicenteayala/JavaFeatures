package com.javaevolution.dateandtime.advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class CustomDateTimeFormatterExampleTest {

    private CustomDateTimeFormatterExample customDateTimeFormatterExample;

    @BeforeEach
    void setUp() {
        customDateTimeFormatterExample = new CustomDateTimeFormatterExample();
    }

    @Test
    void formatDateTime_withValidDateTimeAndFormatter_returnsCorrectlyFormattedString() {
        LocalDateTime dateTime = LocalDateTime.of(2022, 3, 14, 9, 30);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        assertEquals("2022-03-14 09:30", customDateTimeFormatterExample.formatDateTime(dateTime, formatter));
    }

    @Test
    void formatDateTime_withDifferentPattern_returnsCorrectlyFormattedString() {
        LocalDateTime dateTime = LocalDateTime.of(2022, 3, 14, 9, 30);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        assertEquals("14/03/2022 09:30", customDateTimeFormatterExample.formatDateTime(dateTime, formatter));
    }

    @Test
    void formatDateTime_withDifferentDateTime_returnsCorrectlyFormattedString() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 12, 31, 23, 59);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        assertEquals("2023-12-31 23:59", customDateTimeFormatterExample.formatDateTime(dateTime, formatter));
    }

}