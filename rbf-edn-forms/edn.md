**Table of Contents**  *generated a bit with [DocToc](http://doctoc.herokuapp.com/)*

- [EDN format](#edn-format)
  - [Purpose](#purpose)
  - [General considerations](#general-considerations)
  - [Built-in elements](#built-in-elements)
    - [Scalars](#scalars)
    - [Collections](#collections)
    - [Tagged elements](#tagged-elements)
  - [Other stuff](#other-stuff)
- [Clojure topping](#clojure-topping)
  - [Call things](#call-things)
  - [Special forms](#special-forms) 


# EDN format

This is a summary of the EDN Format specification at https://github.com/edn-format/edn.

## Purpose

1. **edn** is an extensible data notation.

1. Is a data transfer format. (think JSON or XML)

1. **edn** is a system for the conveyance of values. It is not a type system, and has no schemas.

1. There is no enclosing element at the top level.


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

### Collections

1. **Lists:** A list is a sequence of values. Lists are represented by zero or more elements enclosed in parentheses `()`. Note that lists can be heterogeneous. E.g. `(a b 42)`.

1. **Vectors:** A vector is a sequence of values that supports random access. Vectors are represented by zero or more elements enclosed in square brackets `[]`. Note that vectors can be heterogeneous. E.g. `[a b 42]`.

1. **Maps:** A map is a collection of associations between keys and values. Maps are represented by zero or more key and value pairs enclosed in curly braces `{}`. Each key should appear at most once. No semantics should be associated with the order in which the pairs appear. Keys and values can be elements of any type. E.g. `{:a 1, "foo" :bar, [1 2 3] four}`. (Note that the use of commas is optional, as they are parsed as whitespace.)

1. **Sets:** A set is a collection of unique values. Sets are represented by zero or more elements enclosed in curly braces preceded by `#`: `#{}`. No semantics should be associated with the order in which the elements appear. Note that sets can be heterogeneous. E.g. `#{a b [1 2 3]}`

### Tagged elements

1. **`#inst`:** An instant in time. The tagged element is a string in `RFC-3339` format. E.g. `#inst "1985-04-12T23:20:50.52Z"`.

1. **`#uuid`:** A [UUID](http://en.wikipedia.org/wiki/Universally_unique_identifier). The tagged element is a canonical UUID string representation. E.g. `#uuid "f81d4fae-7dec-11d0-a765-00a0c91e6bf6"`.

## Other stuff

1. **Comments:** If a `;` character is encountered outside of a string, that character and all subsequent characters to the next newline are be ignored.

1. **Discard:** `#_` is the discard sequence, indicating that the next element (whether separated from `#_` by whitespace or not) is discarded. Note that the next element must still be a readable element.E.g. `[a b #_foo 42] => [a b 42]`


# Clojure topping

Clojure is a superset of the EDN format. Since Clojure is [homoiconic]() just need a _light_ layer on top of EDN which implies some few special words and adding a way to _call_ things.

## Call things

In Clojure the **first** element in a **list** will be called with the **rest** of the elements as arguments:

``` clojure
(function a b c)
```

And that's it. That's the one rule to retain in order to understand and write Clojure code. And there are just a handful.

## Special forms

Some words have a special meaning:

1. **`let`**

1. **`def`**

1. **`fn`**

1. **`if`**

1. **`do`**

1. And some few others like **`quote`**, **`var`** and **`try catch throw`**.
