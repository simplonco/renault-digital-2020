# [Two Fer](https://github.com/exercism/java/tree/master/exercises/two-fer)

## Description

`Two-fer` or `2-fer` is short for two for one. One for you and one for me.

Given a name, return a string with the message:

```text
One for X, one for me.
```

Where X is the given name.

However, if the name is missing, return the string:

```text
One for you, one for me.
```

Here are some examples:

|Name    |String to return 
|:-------|:------------------
|Alice   |One for Alice, one for me. 
|Bob     |One for Bob, one for me.
|        |One for you, one for me.
|Zaphod  |One for Zaphod, one for me.

## Running the code

Requires a properly installed Java 11 JDK (with `JAVA_HOME` correctly set).

```bash
# On linux or macOS
./gradlew test

# On Windows
./gradlew.bat test
```
