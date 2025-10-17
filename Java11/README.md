# Java 11 Features Overview

Java 11 (LTS), released in September 2018, is a Long-Term Support version with several important enhancements.

## Key Features

### 1. HttpClient API (Standard)

Modern HTTP client API supporting HTTP/1.1 and HTTP/2, with synchronous and asynchronous modes.

**Synchronous Request:**
```java
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com"))
    .GET()
    .build();
HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
```

**Asynchronous Request:**
```java
client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
      .thenApply(HttpResponse::body)
      .thenAccept(System.out::println);
```

See examples in: `src/main/java/com/javaevolution/httpclient/`

### 2. New String Methods

**isBlank()** - Returns true if string is empty or contains only whitespace
```java
"   ".isBlank();  // true
```

**lines()** - Returns stream of lines
```java
String multiline = "Line 1\nLine 2\nLine 3";
multiline.lines().forEach(System.out::println);
```

**strip()** - Unicode-aware whitespace removal
```java
"  Hello  ".strip();  // "Hello"
```

**stripLeading()** / **stripTrailing()** - Remove leading/trailing whitespace
```java
"  Hello  ".stripLeading();   // "Hello  "
"  Hello  ".stripTrailing();  // "  Hello"
```

**repeat()** - Repeat string n times
```java
"*".repeat(5);  // "*****"
```

See examples in: `src/main/java/com/javaevolution/stringmethods/`

### 3. Local-Variable Syntax for Lambda Parameters

```java
(var x, var y) -> x + y
```

### 4. Nest-Based Access Control

Improved access control for nested classes.

### 5. Dynamic Class-File Constants

Performance improvements for constant pool.

### 6. Launch Single-File Source-Code Programs

Run Java source files directly:
```bash
java HelloWorld.java
```

## Migration from Java 8

- Removed Java EE and CORBA modules
- Use HttpClient instead of HttpURLConnection
- Consider using new String methods for cleaner code
