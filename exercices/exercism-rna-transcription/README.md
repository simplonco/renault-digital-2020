# [RNA Transcription](https://github.com/exercism/java/tree/master/exercises/rna-transcription)

Given a DNA strand, return its RNA complement (per RNA transcription).

Both DNA and RNA strands are a sequence of nucleotides.

The four nucleotides found in DNA are adenine (**A**), cytosine (**C**),
guanine (**G**) and thymine (**T**).

The four nucleotides found in RNA are adenine (**A**), cytosine (**C**),
guanine (**G**) and uracil (**U**).

Given a DNA strand, its transcribed RNA strand is formed by replacing
each nucleotide with its complement:

* `G` -> `C`
* `C` -> `G`
* `T` -> `A`
* `A` -> `U`

## Running the code

Requires a properly installed Java 11 JDK (with `JAVA_HOME` correctly set).

```bash
# On linux or macOS
./gradlew test

# On Windows
./gradlew.bat test
```
