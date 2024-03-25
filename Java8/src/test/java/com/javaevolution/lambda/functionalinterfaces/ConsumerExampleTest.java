package com.javaevolution.lambda.functionalinterfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsumerExampleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        outContent.reset();
        // Redirect the System.out to capture output
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() throws IOException {
        // Restore the original System.out
        System.setOut(originalOut);
    }

    @Test
    void printString_givenNonEmptyString_shouldPrintInConsole() {
        String printThisTextInConsole = "Print this text in console";
        ConsumerExample.printString(printThisTextInConsole);

        assertEquals(printThisTextInConsole + System.lineSeparator(), outContent.toString());
    }

}