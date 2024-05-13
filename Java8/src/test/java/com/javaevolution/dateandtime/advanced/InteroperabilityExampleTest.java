package com.javaevolution.dateandtime.advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

class InteroperabilityExampleTest {

    private InteroperabilityExample interoperabilityExample;

    @BeforeEach
    void setUp() {
        interoperabilityExample = new InteroperabilityExample();
    }

    @Test
    void convertToLocalDate_withValidDate_returnsCorrectLocalDate() {
        Date date = new Date();
        LocalDate expected = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        assertEquals(expected, interoperabilityExample.convertToLocalDate(date));
    }

    @Test
    void convertToDate_withValidLocalDate_returnsCorrectDate() {
        LocalDate localDate = LocalDate.now();
        Date expected = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        assertEquals(expected, interoperabilityExample.convertToDate(localDate));
    }
}