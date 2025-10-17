# Java 16 Features Overview

Java 16, released in March 2021, standardized several preview features.

## Key Features

### 1. Records (Standard)

Records became a standard feature in Java 16.

See Java 14 for comprehensive examples: `../Java14/src/main/java/com/javaevolution/records/`

### 2. Pattern Matching for instanceof (Standard)

Pattern matching for instanceof became standard.

See Java 14 for comprehensive examples: `../Java14/src/main/java/com/javaevolution/patternmatching/`

### 3. Sealed Classes (Second Preview)

Continued refinement of sealed classes.

### 4. Unix-Domain Socket Channels

Support for Unix domain sockets in socket and server-socket channels.

### 5. Foreign Linker API (Incubator)

API for calling native code.

### 6. Vector API (Incubator)

Initial version of vector computation API.

### 7. Enable C++14 Language Features

JDK C++ source code can now use C++14 features.

## Migration Notes

- Records are now stable and recommended for data classes
- Pattern matching for instanceof is production-ready
- Consider migrating data classes to records
- Use pattern matching to simplify instanceof checks
