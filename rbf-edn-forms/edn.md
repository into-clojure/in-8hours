# EDN format

This is a summary of the EDN Format specification at https://github.com/edn-format/edn.

> **edn** is an extensible data notation.

> It is used by Datomic and other applications as a data transfer format.

> **edn** is a system for the conveyance of values. It is not a type system, and has no schemas.

> There is no enclosing element at the top level.

## General considerations

1. UTF-8 encoding (i.e. accented chars and so on built-in)

1. Elements are separated by whitespace.

1. Whitespace, other than within strings, is not otherwise significant.

1. Commas `,` **are also considered whitespace**, other than within strings.

1. The delimiters { } ( ) [ ] need not be separated from adjacent elements by whitespace.

1. Tokens beginning with # are reserved.

## Built-in elements

1. **`nil`:** Represents nil, null or nothing.

1. **Booleans:** `true` and `false`.

1. **Strings:** Enclosed in "double quotes". May span multiple lines. Standard C/Java escape characters `\t`, `\r`, `\n, `\\` and `\"` are supported.

1. **Characters:** Characters are preceded by a backslash: `\c`, `\newline`, `\return`, `\space` and `\tab` yield the corresponding characters. Unicode characters are represented with `\uNNNN` as in Java.

