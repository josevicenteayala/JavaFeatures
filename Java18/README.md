# Java 18 Features Overview

Java 18, released in March 2022, introduced several developer-friendly features.

## Key Features

### 1. Simple Web Server

Command-line tool for serving static files.

**Usage:**
```bash
jwebserver
# Starts server on http://localhost:8000
```

**Programmatic API:**
```java
var server = SimpleFileServer.createFileServer(
    new InetSocketAddress(8000),
    Path.of("/public"),
    SimpleFileServer.OutputLevel.VERBOSE
);
server.start();
```

**Status:** Implementation needed

### 2. Code Snippets in Java API Documentation

Enhanced Javadoc with @snippet tag for better code examples.

**Example:**
```java
/**
 * Example method.
 * {@snippet :
 * String result = example.process("input");
 * System.out.println(result);
 * }
 */
```

### 3. UTF-8 by Default

UTF-8 is now the default charset for standard Java APIs.

### 4. Internet-Address Resolution SPI

Service-provider interface for host name and address lookup.

### 5. Vector API (Second Incubator)

Continued development of vector computation API.

### 6. Foreign Function & Memory API (Second Incubator)

API for interacting with native code and memory.

### 7. Pattern Matching for Switch (Second Preview)

Continued refinement of pattern matching in switch.

### 8. Deprecate Finalization for Removal

Finalization mechanism deprecated.

## Use Cases

**Simple Web Server:**
- Prototyping and testing
- Serving static content during development
- Educational purposes
- Quick file sharing

## To Be Implemented

- Simple Web Server examples
- Internet-Address Resolution examples
