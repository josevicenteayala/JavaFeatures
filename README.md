# Java Evolution: Features from Java 8 to 25

Welcome to the Java Evolution repository, where we document the journey of Java from version 8 through 25, covering all
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

### Java 21 (September 2023) - LTS

Virtual Threads (Standard), Sequenced Collections, Pattern Matching for Switch (Standard), Record Patterns (Standard)

### Java 22 (March 2024)

Unnamed Variables and Patterns (Standard), Stream Gatherers (Preview), Foreign Function & Memory API (Standard), String Templates (Second Preview)

### Java 23 (September 2024)

Primitive Types in Patterns (Preview), Flexible Constructor Bodies (Second Preview), Markdown Documentation Comments, Module Import Declarations (Preview), ZGC Generational Mode by Default

### Java 24 (March 2025)

Scoped Values (Fourth Preview), Stream Gatherers (Third Preview), Structured Concurrency (Fourth Preview), Class-File API (Third Preview), Late Barrier Expansion for G1

### Java 25 (September 2025)

Stream Gatherers (Expected Final), Scoped Values (Expected Final), Structured Concurrency (Expected Final), Potential Value Types (Preview)

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

### Java 22 (March 2024)
| Feature | Status | Location |
|---------|--------|----------|
| Unnamed Variables and Patterns | ✅ Implemented | `Java22/src/main/java/com/javaevolution/unnamedpatterns/` |
| Stream Gatherers | ✅ Implemented | `Java22/src/main/java/com/javaevolution/streamgatherers/` |
| Foreign Function & Memory API | 📝 Documented | `Java22/README.md` |
| String Templates | 📝 Documented | `Java22/README.md` |

### Java 23 (September 2024)
| Feature | Status | Location |
|---------|--------|----------|
| Primitive Types in Patterns | ✅ Implemented | `Java23/src/main/java/com/javaevolution/primitivetypes/` |
| Flexible Constructor Bodies | ✅ Implemented | `Java23/src/main/java/com/javaevolution/flexibleconstructors/` |
| Markdown Documentation | 📝 Documented | `Java23/README.md` |
| Module Import Declarations | 📝 Documented | `Java23/README.md` |

### Java 24 (March 2025)
| Feature | Status | Location |
|---------|--------|----------|
| Scoped Values | ✅ Implemented | `Java24/src/main/java/com/javaevolution/scopedvalues/` |
| Stream Gatherers (Third Preview) | 📝 Documented | `Java24/README.md` |
| Structured Concurrency | 📝 Documented | `Java24/README.md` |
| Class-File API | 📝 Documented | `Java24/README.md` |

### Java 25 (September 2025)
| Feature | Status | Location |
|---------|--------|----------|
| Advanced Stream Gatherers | ✅ Implemented | `Java25/src/main/java/com/javaevolution/streamgatherers/` |
| Scoped Values (Final) | 📝 Documented | `Java25/README.md` |
| Structured Concurrency (Final) | 📝 Documented | `Java25/README.md` |
| Value Types | 📝 Documented | `Java25/README.md` |

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

- **25+ feature categories** covered across Java 8-25
- **38+ implementation classes** with working examples
- **38+ test classes** with comprehensive coverage
- **25,000+ lines of code** demonstrating Java features
- **Comprehensive documentation** for Java 22-25 features
- **All tests passing** for Java 8-14, 22-25 (compatible implementations)

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines on contributing to this repository.

For a detailed analysis of feature coverage, see [FEATURE_ANALYSIS.md](FEATURE_ANALYSIS.md).
