package com.javaevolution.dateandtime.advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

class ParsingDateExampleTest {
    private ParsingDateExample parsingDateExample;

    @BeforeEach
    void setUp() {
        parsingDateExample = new ParsingDateExample();
    }

    @Test
    void parsingDate_withValidDateAndPattern_returnsCorrectLocalDate() {
        assertEquals(LocalDate.of(2022, 3, 14), parsingDateExample.parsingDate("2022-03-14", "yyyy-MM-dd"));
    }

    @Test
    void parsingDate_withDifferentPattern_returnsCorrectLocalDate() {
        assertEquals(LocalDate.of(2022, 3, 14), parsingDateExample.parsingDate("14/03/2022", "dd/MM/yyyy"));
    }

    @Test
    void parsingDate_withInvalidDate_throwsDateTimeParseException() {
        assertThrows(DateTimeParseException.class, () -> parsingDateExample.parsingDate("2022-03-32", "yyyy-MM-dd"));
    }

    @Test
    void parsingDate_withInvalidPattern_throwsDateTimeParseException() {
        assertThrows(DateTimeParseException.class, () -> parsingDateExample.parsingDate("2022-03-14", "yyyy/MM/dd"));
    }
}