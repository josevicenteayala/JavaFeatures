package com.javaevolution.lambda.advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

class LazyEvaluationDemoTest {
    @Test
    void logIf_withTrueCondition_logsMessage() {
        String message = "This is a debug message.";
        Logger logger = Logger.getLogger(LazyEvaluationDemo.class.getName());
        logger.setUseParentHandlers(false);
        TestHandler handler = new TestHandler();
        logger.addHandler(handler);

        LazyEvaluationDemo.logIf(() -> true, () -> message);

        LogRecord record = handler.getLogRecord();
        assertEquals(message, record.getMessage());
    }

    @Test
    void logIf_withFalseCondition_doesNotLogMessage() {
        String message = "This is a debug message.";
        Logger logger = Logger.getLogger(LazyEvaluationDemo.class.getName());
        logger.setUseParentHandlers(false);
        TestHandler handler = new TestHandler();
        logger.addHandler(handler);

        LazyEvaluationDemo.logIf(() -> false, () -> message);

        LogRecord record = handler.getLogRecord();
        assertNull(record);
    }
}