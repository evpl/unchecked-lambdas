# Unchecked lambdas

Use lambda functions to ignore checked exceptions

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.plugatar/unchecked-lambdas/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.plugatar/unchecked-lambdas)
[![Javadoc](https://javadoc.io/badge2/com.plugatar/unchecked-lambdas/javadoc.svg)](https://javadoc.io/doc/com.plugatar/unchecked-lambdas)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Table of Contents

* [How to use](#How-to-use)
* [Example](#Examples)

## How to use

Requires Java 8+ version.

Maven:

```xml

<dependency>
  <groupId>com.plugatar</groupId>
  <artifactId>unchecked-lambdas</artifactId>
  <version>1.0</version>
</dependency>
```

Gradle:

```groovy
dependencies {
    implementation 'com.plugatar:unchecked-lambdas:1.0'
}
```

Kotlin DSL:

```groovy
dependencies {
    implementation("com.plugatar:unchecked-lambdas:1.0")
}
```

## Examples

```java
import java.net.URI;

import static com.plugatar.uncheckedlambdas.UncheckedLambdas.unchecked;
import static com.plugatar.uncheckedlambdas.UncheckedLambdas.uncheckedRes;

public class Example {

  public void runnable(String strUri) {
    unchecked(() -> {
      //...
      new URI(strUri);
    });
  }

  public URI supplier(String strUri) {
    return uncheckedRes(() -> {
      //...
      return new URI(strUri);
    });
  }

  public void consumer(String strUri) {
    unchecked(strUri, str -> {
      //...
      new URI(str);
    });
  }

  public void biConsumer(String strUriPart1,
                         String strUriPart2) {
    unchecked(strUriPart1, strUriPart2, (str1, str2) -> {
      //...
      new URI(str1 + str2);
    });
  }

  public void triConsumer(String strUriPart1,
                          String strUriPart2,
                          String strUriPart3) {
    unchecked(strUriPart1, strUriPart2, strUriPart3, (str1, str2, str3) -> {
      //...
      new URI(str1 + str2 + str3);
    });
  }

  public URI function(final String strUri) {
    return uncheckedRes(strUri, str -> {
      //...
      return new URI(str);
    });
  }

  public URI biFunction(String strUriPart1,
                        String strUriPart2) {
    return uncheckedRes(strUriPart1, strUriPart2, (str1, str2) -> {
      //...
      return new URI(str1 + str2);
    });
  }

  public URI triFunction(String strUriPart1,
                         String strUriPart2,
                         String strUriPart3) {
    return uncheckedRes(strUriPart1, strUriPart2, strUriPart3, (str1, str2, str3) -> {
      //...
      return new URI(str1 + str2 + str3);
    });
  }
}
```
