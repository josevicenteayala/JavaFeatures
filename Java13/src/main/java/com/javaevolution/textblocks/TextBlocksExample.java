package com.javaevolution.textblocks;

/**
 * Demonstrates Text Blocks introduced in Java 13 (Preview) and standardized in Java 15.
 * Text blocks provide a way to create multi-line string literals without escape sequences.
 */
public class TextBlocksExample {

    /**
     * Traditional multi-line string (pre-Java 13)
     */
    public String traditionalMultiLineString() {
        return "{\n" +
               "  \"name\": \"John\",\n" +
               "  \"age\": 30,\n" +
               "  \"city\": \"New York\"\n" +
               "}";
    }

    /**
     * Text block for JSON
     */
    public String jsonTextBlock() {
        return """
               {
                 "name": "John",
                 "age": 30,
                 "city": "New York"
               }
               """;
    }

    /**
     * Text block for HTML
     */
    public String htmlTextBlock() {
        return """
               <html>
                 <body>
                   <h1>Hello, World!</h1>
                   <p>This is a text block example.</p>
                 </body>
               </html>
               """;
    }

    /**
     * Text block for SQL query
     */
    public String sqlTextBlock() {
        return """
               SELECT id, name, email
               FROM users
               WHERE age > 18
               ORDER BY name
               """;
    }

    /**
     * Text block with embedded expressions
     */
    public String textBlockWithVariables(String name, int age) {
        return """
               Name: %s
               Age: %d
               Status: Active
               """.formatted(name, age);
    }

    /**
     * Text block for multi-line message
     */
    public String multiLineMessage() {
        return """
               Dear Customer,
               
               Thank you for your purchase.
               Your order has been confirmed.
               
               Best regards,
               The Team
               """;
    }

    /**
     * Text block with escape sequences
     */
    public String textBlockWithEscapes() {
        return """
               Line 1
               Line 2 with "quotes"
               Line 3 with 'apostrophe'
               Line 4 with backslash: \\
               """;
    }

    /**
     * Text block for code snippet
     */
    public String codeSnippet() {
        return """
               public class HelloWorld {
                   public static void main(String[] args) {
                       System.out.println("Hello, World!");
                   }
               }
               """;
    }

    /**
     * Text block with intentional indentation
     */
    public String indentedTextBlock() {
        return """
                   This line is indented
                       This line is more indented
                   Back to first level
               """;
    }

    /**
     * Text block for YAML
     */
    public String yamlTextBlock() {
        return """
               server:
                 port: 8080
                 host: localhost
               database:
                 url: jdbc:postgresql://localhost/mydb
                 username: admin
               """;
    }

    /**
     * Comparing lengths: traditional vs text block
     */
    public void compareLengths() {
        String traditional = "Line 1\nLine 2\nLine 3";
        String textBlock = """
                           Line 1
                           Line 2
                           Line 3
                           """;
        // Both should have similar content
    }

    /**
     * Text block for regular expression
     */
    public String regexPattern() {
        return """
               \\d{3}-\\d{3}-\\d{4}
               """;
    }
}
