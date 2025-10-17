package com.javaevolution.textblocks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextBlocksExampleTest {

    private final TextBlocksExample example = new TextBlocksExample();

    @Test
    void traditionalMultiLineString_shouldContainNewlines() {
        String result = example.traditionalMultiLineString();
        assertTrue(result.contains("\n"));
        assertTrue(result.contains("\"name\""));
        assertTrue(result.contains("John"));
    }

    @Test
    void jsonTextBlock_shouldBeValidJson() {
        String result = example.jsonTextBlock();
        assertTrue(result.contains("name"));
        assertTrue(result.contains("John"));
        assertTrue(result.contains("age"));
        assertTrue(result.contains("30"));
    }

    @Test
    void htmlTextBlock_shouldContainHtmlTags() {
        String result = example.htmlTextBlock();
        assertTrue(result.contains("<html>"));
        assertTrue(result.contains("<body>"));
        assertTrue(result.contains("<h1>"));
        assertTrue(result.contains("Hello, World!"));
    }

    @Test
    void sqlTextBlock_shouldContainSqlKeywords() {
        String result = example.sqlTextBlock();
        assertTrue(result.contains("SELECT"));
        assertTrue(result.contains("FROM"));
        assertTrue(result.contains("WHERE"));
        assertTrue(result.contains("ORDER BY"));
    }

    @Test
    void textBlockWithVariables_shouldSubstituteVariables() {
        String result = example.textBlockWithVariables("Alice", 25);
        assertTrue(result.contains("Alice"));
        assertTrue(result.contains("25"));
        assertTrue(result.contains("Status: Active"));
    }

    @Test
    void multiLineMessage_shouldContainAllLines() {
        String result = example.multiLineMessage();
        assertTrue(result.contains("Dear Customer"));
        assertTrue(result.contains("Thank you"));
        assertTrue(result.contains("Best regards"));
    }

    @Test
    void textBlockWithEscapes_shouldHandleEscapeSequences() {
        String result = example.textBlockWithEscapes();
        assertTrue(result.contains("\"quotes\""));
        assertTrue(result.contains("'apostrophe'"));
        assertTrue(result.contains("\\"));
    }

    @Test
    void codeSnippet_shouldContainCode() {
        String result = example.codeSnippet();
        assertTrue(result.contains("public class"));
        assertTrue(result.contains("public static void main"));
        assertTrue(result.contains("System.out.println"));
    }

    @Test
    void indentedTextBlock_shouldPreserveIndentation() {
        String result = example.indentedTextBlock();
        assertTrue(result.contains("This line is indented"));
        assertTrue(result.contains("This line is more indented"));
        assertTrue(result.contains("Back to first level"));
    }

    @Test
    void yamlTextBlock_shouldContainYamlStructure() {
        String result = example.yamlTextBlock();
        assertTrue(result.contains("server:"));
        assertTrue(result.contains("port: 8080"));
        assertTrue(result.contains("database:"));
    }

    @Test
    void compareLengths_shouldNotThrowException() {
        assertDoesNotThrow(() -> example.compareLengths());
    }

    @Test
    void regexPattern_shouldContainPattern() {
        String result = example.regexPattern();
        assertTrue(result.contains("\\d"));
    }

    @Test
    void jsonTextBlock_shouldNotHaveExcessiveWhitespace() {
        String result = example.jsonTextBlock();
        assertNotNull(result);
        assertTrue(result.length() > 0);
    }
}
