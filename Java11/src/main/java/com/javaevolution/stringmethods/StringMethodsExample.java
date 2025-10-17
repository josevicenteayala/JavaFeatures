package com.javaevolution.stringmethods;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates new String methods introduced in Java 11.
 */
public class StringMethodsExample {

    /**
     * isBlank() - Returns true if the string is empty or contains only white space
     */
    public boolean isBlankExample(String str) {
        return str.isBlank();
    }

    /**
     * lines() - Returns a stream of lines extracted from the string
     */
    public List<String> linesExample(String multilineString) {
        return multilineString.lines()
                .collect(Collectors.toList());
    }

    /**
     * strip() - Removes leading and trailing whitespace (Unicode-aware)
     */
    public String stripExample(String str) {
        return str.strip();
    }

    /**
     * stripLeading() - Removes leading whitespace
     */
    public String stripLeadingExample(String str) {
        return str.stripLeading();
    }

    /**
     * stripTrailing() - Removes trailing whitespace
     */
    public String stripTrailingExample(String str) {
        return str.stripTrailing();
    }

    /**
     * repeat() - Repeats the string n times
     */
    public String repeatExample(String str, int count) {
        return str.repeat(count);
    }

    /**
     * Demonstrates the difference between trim() and strip()
     */
    public void trimVsStripExample() {
        // strip() is Unicode-aware, trim() is not
        String unicodeSpace = "\u2000Hello\u2000"; // Unicode space
        
        // trim() doesn't remove Unicode spaces
        String trimmed = unicodeSpace.trim();
        
        // strip() removes Unicode spaces
        String stripped = unicodeSpace.strip();
    }

    /**
     * Practical example: Processing multi-line text
     */
    public List<String> processTextLines(String text) {
        return text.lines()
                .map(String::strip)
                .filter(line -> !line.isBlank())
                .collect(Collectors.toList());
    }

    /**
     * Practical example: Creating a separator line
     */
    public String createSeparator(String character, int length) {
        return character.repeat(length);
    }

    /**
     * Practical example: Formatting code with indentation
     */
    public List<String> removeIndentation(String code) {
        return code.lines()
                .map(String::stripLeading)
                .collect(Collectors.toList());
    }
}
