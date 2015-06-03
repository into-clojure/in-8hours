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

### Scalars

1. **`nil`:** Represents nil, null or nothing.

1. **Booleans:** `true` and `false`.

1. **Strings:** Enclosed in "double quotes". May span multiple lines. Standard C/Java escape characters `\t`, `\r`, `\n, `\\` and `\"` are supported.

1. **Characters:** Characters are preceded by a backslash: `\c`, `\newline`, `\return`, `\space` and `\tab` yield the corresponding characters. Unicode characters are represented with `\uNNNN` as in Java.

1. **Symbols:** are used to represent identifiers and begin with a **non-numeric** character and can contain alphanumeric characters and `. * + ! - _ ? $ % & = < >`, e.g. `my-symbol`, `my-namespace/my-symbol`.

1. **Keywords:** are identifiers that designate themselves and follow the rules of symbols, except they begin with `:`, e.g. `:fred` or `:my/fred`.

1. **Integers:** 64-bit (signed integer) precision is expected. An integer can have the suffix `N` to indicate that arbitrary precision is desired.

1. **floating point numbers:** 64-bit (double) precision is expected. In addition, a floating-point number may have the suffix `M` to indicate that exact precision is desired.

## Collections

1. **Lists:** A list is a sequence of values. Lists are represented by zero or more elements enclosed in parentheses `()`. Note that lists can be heterogeneous. E.g. `(a b 42)`.

1. **vectors:** A vector is a sequence of values that supports random access. Vectors are represented by zero or more elements enclosed in square brackets `[]`. Note that vectors can be heterogeneous. E.g. `[a b 42]`.

1. **maps:** A map is a collection of associations between keys and values. Maps are represented by zero or more key and value pairs enclosed in curly braces `{}`. Each key should appear at most once. No semantics should be associated with the order in which the pairs appear. Keys and values can be elements of any type. E.g. `{:a 1, "foo" :bar, [1 2 3] four}`. (Note that the use of commas is optional, as they are parsed as whitespace.)

1. **sets:** A set is a collection of unique values. Sets are represented by zero or more elements enclosed in curly braces preceded by `#`: `#{}`. No semantics should be associated with the order in which the elements appear. Note that sets can be heterogeneous. E.g. `#{a b [1 2 3]}`


