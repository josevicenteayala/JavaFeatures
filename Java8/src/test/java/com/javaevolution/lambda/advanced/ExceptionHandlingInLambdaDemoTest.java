package com.javaevolution.lambda.advanced;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.LogRecord;
import java.util.logging.Logger;

class ExceptionHandlingInLambdaDemoTest {

    private TestHandler handler;

    @BeforeEach
    void setUp() {
        Logger logger = Logger.getLogger(ExceptionHandlingInLambdaDemo.class.getName());
        logger.setUseParentHandlers(false);
        handler = new TestHandler();
        logger.addHandler(handler);
    }
    @Test
    void printListElements_logsCorrectMessage() {
        String message = "Hello, World!";

        ExceptionHandlingInLambdaDemo.printListElements();

        LogRecord record = handler.getLogRecord();
        assertEquals(message, record.getMessage());
    }

    @Test
    void printArrayContent_withValuesLessThanNine_logsAllValues() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8};

        ExceptionHandlingInLambdaDemo.printArrayContent(array);

        LogRecord record = handler.getLogRecord();
        assertEquals("8", record.getMessage());
    }

    @Test
    void printArrayContent_withValuesGreaterThanEight_throwsException() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        assertThrows(LambdaRuntimeException.class, () -> ExceptionHandlingInLambdaDemo.printArrayContent(array));
    }
}