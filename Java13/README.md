# Java 13 Features Overview

Java 13, released in September 2019, introduced text blocks as a preview feature.

## Key Features

### 1. Text Blocks (Preview)

Multi-line string literals that avoid escape sequences and improve readability.

**Traditional Multi-line String:**
```java
String json = "{\n" +
              "  \"name\": \"John\",\n" +
              "  \"age\": 30\n" +
              "}";
```

**Text Block:**
```java
String json = """
              {
                "name": "John",
                "age": 30
              }
              """;
```

**Benefits:**
- No need for escape sequences
- Automatic formatting preservation
- More readable code
- Perfect for JSON, HTML, SQL, XML

**Common Use Cases:**

**JSON:**
```java
String json = """
    {
      "users": [
        {"name": "Alice", "age": 30},
        {"name": "Bob", "age": 25}
      ]
    }
    """;
```

**HTML:**
```java
String html = """
    <html>
      <body>
        <h1>Hello, World!</h1>
      </body>
    </html>
    """;
```

**SQL:**
```java
String sql = """
    SELECT id, name, email
    FROM users
    WHERE age > 18
    ORDER BY name
    """;
```

See examples in: `src/main/java/com/javaevolution/textblocks/`

### 2. Switch Expressions (Standard)

Switch expressions, introduced in Java 12 as preview, became standard in Java 13 (though still evolved in later versions).

### 3. Reimplemented Legacy Socket API

Modern implementation of Socket and ServerSocket APIs.

### 4. Dynamic CDS Archives

Improved application class-data sharing.

## Text Block Features

**Escape Sequences Still Work:**
```java
String text = """
    Line with "quotes"
    Line with 'apostrophe'
    Line with backslash: \\
    """;
```

**Formatting with formatted():**
```java
String message = """
    Name: %s
    Age: %d
    """.formatted(name, age);
```

**Indentation Management:**
- Opening delimiter must be followed by newline
- Closing delimiter position determines indentation level
- Incidental whitespace is removed automatically
