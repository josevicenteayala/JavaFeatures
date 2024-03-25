package com.javaevolution.lambda.functionalinterfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsumerExampleWithListTest {

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
    void printCollection_givenNonEmptyList_shouldPrintListContent() {
        List<String> testList = Arrays.asList("Line 1", "Line 2", "Line 3");

        // Build the expected output string
        String expectedOutput = String.join(System.lineSeparator(), testList) + System.lineSeparator();

        ConsumerExample.printCollection(testList);

        assertEquals(expectedOutput, outContent.toString());
    }
}