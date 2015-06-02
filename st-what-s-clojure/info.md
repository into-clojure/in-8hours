No slides (almost)
Some random notes to guide discussion.

http://www-formal.stanford.edu/jmc/recursive.pdf
A programming system called LISP (for LISt Processor) has been developed for the IBM 704 computer by the Artificial Intelligence group at M.I.T.

LISP ~ AI 

## LISP
http://fr.wikipedia.org/wiki/John_McCarthy
John McCarthy (né le 4 septembre 1927, à Boston, dans le Massachusetts - mort le 24 octobre 20111) est le principal pionnier de l'intelligence artificielle avec Marvin Lee Minsky ; il incarne le courant mettant l'accent sur la logique symbolique.
Il est également le créateur du langage LISP, en 1958. Il reçoit le prix Turing en 1971 pour ses travaux en intelligence artificielle.

## Functional

### Function is a first class citizen.
What is a pure function ? (no side effect, same input => same result)

http://clojure.org/functional_programming
Clojure is a functional programming language. It provides the tools to avoid mutable state, provides functions as first-class objects, and emphasizes recursive iteration instead of side-effect based looping. Clojure is impure, in that it doesn't force your program to be referentially transparent, and doesn't strive for 'provable' programs. The philosophy behind Clojure is that most parts of most programs should be functional, and that programs that are more functional are more robust.

### Favor of immutable structures
Clojure provides a set of immutable lists, vectors, sets and maps.

### STM
http://en.wikipedia.org/wiki/Software_transactional_memory
Clojure has STM support built into the core language

### Syntax, what syntax ?
(f a b ...)

### Homo-iconicity
... uniformity, makes macros "easy"

### REPL
Read Eval Print Loop
In other languages, for example, ruby has irb. 

### Hosted language 
On JVM (jar, ...)
Intero, to Java:
exos.core=> (.println System/out "hello Java")
hello Java
nil







Illustrate interop with some live examples?
