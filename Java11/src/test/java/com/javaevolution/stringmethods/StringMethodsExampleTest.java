package com.javaevolution.stringmethods;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringMethodsExampleTest {

    private final StringMethodsExample example = new StringMethodsExample();

    @Test
    void isBlankExample_givenBlankString_shouldReturnTrue() {
        assertTrue(example.isBlankExample(""));
        assertTrue(example.isBlankExample("   "));
        assertTrue(example.isBlankExample("\t"));
        assertTrue(example.isBlankExample("\n"));
    }

    @Test
    void isBlankExample_givenNonBlankString_shouldReturnFalse() {
        assertFalse(example.isBlankExample("hello"));
        assertFalse(example.isBlankExample("  hello  "));
    }

    @Test
    void linesExample_shouldSplitIntoLines() {
        String multiline = "Line 1\nLine 2\nLine 3";
        List<String> lines = example.linesExample(multiline);
        assertEquals(3, lines.size());
        assertEquals("Line 1", lines.get(0));
        assertEquals("Line 2", lines.get(1));
        assertEquals("Line 3", lines.get(2));
    }

    @Test
    void linesExample_withDifferentLineBreaks_shouldHandle() {
        String multiline = "Line 1\rLine 2\r\nLine 3";
        List<String> lines = example.linesExample(multiline);
        assertEquals(3, lines.size());
    }

    @Test
    void stripExample_shouldRemoveWhitespace() {
        assertEquals("Hello", example.stripExample("  Hello  "));
        assertEquals("Hello", example.stripExample("\tHello\t"));
        assertEquals("Hello World", example.stripExample("  Hello World  "));
    }

    @Test
    void stripLeadingExample_shouldRemoveLeadingWhitespace() {
        assertEquals("Hello  ", example.stripLeadingExample("  Hello  "));
        assertEquals("Hello", example.stripLeadingExample("  Hello"));
    }

    @Test
    void stripTrailingExample_shouldRemoveTrailingWhitespace() {
        assertEquals("  Hello", example.stripTrailingExample("  Hello  "));
        assertEquals("Hello", example.stripTrailingExample("Hello  "));
    }

    @Test
    void repeatExample_shouldRepeatString() {
        assertEquals("", example.repeatExample("x", 0));
        assertEquals("x", example.repeatExample("x", 1));
        assertEquals("xxx", example.repeatExample("x", 3));
        assertEquals("HiHiHi", example.repeatExample("Hi", 3));
    }

    @Test
    void processTextLines_shouldFilterAndCleanLines() {
        String text = "  Line 1  \n\n  Line 2  \n   \n  Line 3  ";
        List<String> result = example.processTextLines(text);
        assertEquals(3, result.size());
        assertEquals("Line 1", result.get(0));
        assertEquals("Line 2", result.get(1));
        assertEquals("Line 3", result.get(2));
    }

    @Test
    void createSeparator_shouldCreateRepeatedCharacter() {
        assertEquals("-----", example.createSeparator("-", 5));
        assertEquals("==========", example.createSeparator("=", 10));
        assertEquals("***", example.createSeparator("*", 3));
    }

    @Test
    void removeIndentation_shouldRemoveLeadingSpaces() {
        String code = "    public void method() {\n        return;\n    }";
        List<String> result = example.removeIndentation(code);
        assertEquals(3, result.size());
        assertEquals("public void method() {", result.get(0));
        assertEquals("return;", result.get(1));
        assertEquals("}", result.get(2));
    }
}
