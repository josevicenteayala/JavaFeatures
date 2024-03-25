package com.javaevolution.lambda.advanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Consumer;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

class HigherOrderFunctionDemoTest {
    @Test
    void createPrinter_withPrefix_returnsConsumerThatLogsCorrectly() {
        String prefix = "Warning: ";
        String message = "Check system health.";
        Logger logger = Logger.getLogger(HigherOrderFunctionDemo.class.getName());
        logger.setUseParentHandlers(false);
        TestHandler handler = new TestHandler();
        logger.addHandler(handler);

        Consumer<String> printer = HigherOrderFunctionDemo.createPrinter(prefix);
        printer.accept(message);

        LogRecord record = handler.getLogRecord();
        assertEquals(String.format("%s%s", prefix, message), record.getMessage());
    }

    @Test
    void createPrinter_withEmptyPrefix_returnsConsumerThatLogsCorrectly() {
        String prefix = "";
        String message = "Check system health.";
        Logger logger = Logger.getLogger(HigherOrderFunctionDemo.class.getName());
        logger.setUseParentHandlers(false);
        TestHandler handler = new TestHandler();
        logger.addHandler(handler);

        Consumer<String> printer = HigherOrderFunctionDemo.createPrinter(prefix);
        printer.accept(message);

        LogRecord record = handler.getLogRecord();
        assertEquals(message, record.getMessage());
    }
}