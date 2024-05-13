package com.javaevolution.dateandtime.advanced;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParsingDateExample {
    LocalDate parsingDate(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, formatter);
    }
}
