# Java Evolution: Features from Java 8 to 21

Welcome to the Java Evolution repository, where we document the journey of Java from version 8 through 21, covering all
the major features and changes introduced in each version. This repository aims to serve as a comprehensive guide for
developers at all levels to understand the evolution of Java, enabling them to make the most of the language's
capabilities in their projects.

![JavaEvolution.jpg](Java8%2Fsrc%2Fmain%2Fresources%2Fimages%2FJavaEvolution.jpg)

## Objective

Our goal is to provide a detailed exploration of each feature introduced in Java from version 8 onwards, including
examples and explanations to help Java developers grasp the concepts and apply them in practice.

## Repository Structure

- Version Directories: The repository is organized into directories named after each Java version (e.g., Java_8, Java_9,
  etc.), containing detailed documentation and examples for the features introduced in that version.
- README Files: Each version directory includes a README.md with an overview of the key features introduced in that
  version, along with links to detailed explanations or code examples where applicable.
- Feature Documentation: Complex features have their own Markdown files or code examples within the relevant version
  directory, providing a deeper dive into their usage and benefits.

## How to Navigate

- To explore the features introduced in a specific version of Java, navigate to the corresponding version directory.
- For an overview of the features in each version, refer to the README.md files within each version directory.
- For detailed explanations and examples of specific features, look for additional Markdown files or code examples
  within the version directories.

## How to Contribute

We welcome contributions from the community! Whether you'd like to add examples, improve explanations, or update the
documentation for newer Java versions, your input is valuable. Please refer to the CONTRIBUTING.md file for guidelines
on how to contribute effectively.

## Java Version Features Overview

Below is a brief overview of the key features introduced in Java from version 8 to 21. This serves as a starting point
for the detailed documentation you'll find in this repository.

### Java 8 (March 2014)

Lambda Expressions, Streams API, Date and Time API, Default Methods, Type Annotations

### Java 9 (September 2017)

Module System (Project Jigsaw), JShell, Private Interface Methods, Immutable Collections

### Java 10 (March 2018)

Local-Variable Type Inference (var), Application Class-Data Sharing

### Java 11 (September 2018)

HttpClient API (Standard), New String Methods, Local-Variable Syntax for Lambda Parameters

### Java 12 (March 2019)

Switch Expressions (Preview), Compact Number Formatting

### Java 13 (September 2019)

Text Blocks (Preview), Switch Expressions (Standard)

### Java 14 (March 2020)

Records (Preview), Pattern Matching for instanceof (Preview), Helpful NullPointerExceptions

### Java 15 (September 2020)

Sealed Classes (Preview), Text Blocks (Standard), Pattern Matching for instanceof (Second Preview)

### Java 16 (March 2021)

Records (Standard), Pattern Matching for instanceof (Standard), Sealed Classes (Second Preview)

### Java 17 (September 2021) - LTS

Sealed Classes (Standard), Pattern Matching for Switch (Preview), New macOS Rendering Pipeline

### Java 18 (March 2022)

Simple Web Server (Incubator), Code Snippets in Java API Documentation

### Java 19 (September 2022)

Virtual Threads (Preview), Structured Concurrency (Incubator), Pattern Matching for Switch (Second Preview)

### Java 20 (March 2023)

Record Patterns (Preview), Pattern Matching for Switch (Standard)

### Java 21 (September 2023)

(Features to be documented upon release)

## Additional Resources

For more in-depth information and the latest updates on Java, please refer to the official Java documentation and JDK
Enhancement Proposals (JEPs).

## Stay Updated

Java continues to evolve, and so will this repository. We aim to regularly update the documentation with the latest
features and improvements. Your contributions and feedback are essential to keeping this resource valuable and
up-to-date.

## Feature Implementation Status

### Legend
- ✅ **Implemented** - Code examples and tests available
- ⏳ **Pending** - Documented but implementation needed
- 📝 **Documented** - README available

### Java 8 (March 2014)
| Feature | Status | Location |
|---------|--------|----------|
| Lambda Expressions | ✅ Implemented | `Java8/src/main/java/com/javaevolution/lambda/` |
| Streams API | ✅ Implemented | `Java8/src/main/java/com/javaevolution/streams/` |
| Date and Time API | ✅ Implemented | `Java8/src/main/java/com/javaevolution/dateandtime/` |
| Default Methods | ✅ Implemented | `Java8/src/main/java/com/javaevolution/defaultmethods/` |
| Optional Class | ✅ Implemented | `Java8/src/main/java/com/javaevolution/optional/` |
| Method References | ✅ Implemented | `Java8/src/main/java/com/javaevolution/lambda/methodreferences/` |
| Functional Interfaces | ✅ Implemented | `Java8/src/main/java/com/javaevolution/lambda/functionalinterfaces/` |

### Java 9 (September 2017)
| Feature | Status | Location |
|---------|--------|----------|
| Private Interface Methods | ✅ Implemented | `Java9/src/main/java/com/javaevolution/privateinterface/` |
| Immutable Collections | ✅ Implemented | `Java9/src/main/java/com/javaevolution/immutable/` |
| Module System | 📝 Documented | `Java9/README.md` |
| JShell | 📝 Documented | `Java9/README.md` |

### Java 10 (March 2018)
| Feature | Status | Location |
|---------|--------|----------|
| Local Variable Type Inference (var) | ✅ Implemented | `Java10/src/main/java/com/javaevolution/var/` |

### Java 11 (September 2018) - LTS
| Feature | Status | Location |
|---------|--------|----------|
| HttpClient API | ✅ Implemented | `Java11/src/main/java/com/javaevolution/httpclient/` |
| String Methods | ✅ Implemented | `Java11/src/main/java/com/javaevolution/stringmethods/` |

### Java 12 (March 2019)
| Feature | Status | Location |
|---------|--------|----------|
| Switch Expressions | ✅ Implemented | `Java12/src/main/java/com/javaevolution/switchexpr/` |
| Compact Number Formatting | ✅ Implemented | `Java12/src/main/java/com/javaevolution/compactnumber/` |

### Java 13 (September 2019)
| Feature | Status | Location |
|---------|--------|----------|
| Text Blocks | ✅ Implemented | `Java13/src/main/java/com/javaevolution/textblocks/` |

### Java 14 (March 2020)
| Feature | Status | Location |
|---------|--------|----------|
| Records | ✅ Implemented | `Java14/src/main/java/com/javaevolution/records/` |
| Pattern Matching for instanceof | ✅ Implemented | `Java14/src/main/java/com/javaevolution/patternmatching/` |

### Java 15 (September 2020)
| Feature | Status | Location |
|---------|--------|----------|
| Sealed Classes | ⏳ Pending | - |
| Text Blocks (Standard) | ✅ See Java 13 | `Java13/` |

### Java 16 (March 2021)
| Feature | Status | Location |
|---------|--------|----------|
| Records (Standard) | ✅ See Java 14 | `Java14/src/main/java/com/javaevolution/records/` |
| Pattern Matching (Standard) | ✅ See Java 14 | `Java14/src/main/java/com/javaevolution/patternmatching/` |

### Java 17 (September 2021) - LTS
| Feature | Status | Location |
|---------|--------|----------|
| Sealed Classes | ⏳ Pending | - |
| Pattern Matching for Switch | ⏳ Pending | - |

### Java 18 (March 2022)
| Feature | Status | Location |
|---------|--------|----------|
| Simple Web Server | ⏳ Pending | - |

### Java 19 (September 2022)
| Feature | Status | Location |
|---------|--------|----------|
| Virtual Threads | ✅ See Java 21 | `Java21/src/main/java/com/evolution/virtualthreads/` |
| Structured Concurrency | ⏳ Pending | - |

### Java 20 (March 2023)
| Feature | Status | Location |
|---------|--------|----------|
| Record Patterns | ⏳ Pending | - |

### Java 21 (September 2023) - LTS
| Feature | Status | Location |
|---------|--------|----------|
| Virtual Threads | ✅ Implemented | `Java21/src/main/java/com/evolution/virtualthreads/` |
| Sequenced Collections | ⏳ Pending | - |
| String Templates | ⏳ Pending | - |
| Pattern Matching for Switch | ⏳ Pending | - |
| Record Patterns | ⏳ Pending | - |

## Quick Start

### Building the Project
```bash
./gradlew build
```

### Running Tests
```bash
# Test all modules
./gradlew test

# Test specific Java version
./gradlew :Java8:test
./gradlew :Java14:test
```

### Exploring Examples

Each Java version directory contains:
- `src/main/java/` - Implementation examples
- `src/test/java/` - Comprehensive unit tests
- `README.md` - Feature documentation

Start with Java 8 to understand foundational features, then progress through versions to see how Java has evolved.

## Statistics

- **17+ feature categories** covered
- **30+ implementation classes** with working examples
- **30+ test classes** with comprehensive coverage
- **15,000+ lines of code** demonstrating Java features
- **All tests passing** for Java 8-14

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines on contributing to this repository.

For a detailed analysis of feature coverage, see [FEATURE_ANALYSIS.md](FEATURE_ANALYSIS.md).
