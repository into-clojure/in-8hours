
### Your very first steps with Clojure

* These notes are not meant to be an exhaustive presentation of Clojure, but rather help you discover this language. Would you notice any big mistake, discuss it in the Meetup group.*

#### Play with the REPL
We assume that Leiningen is installed.
(see [install Leiningen](https://github.com/into-clojure/in-8hours/blob/master/rbf-leiningen/notes.md) for details.)

Let's create a Clojure project named **into-1**
```Shell
$> lein new into-1
```
A folder with a basic structure has been created.
We will open a REPL inside this new project (note that we must 'cd' in it first)
```Shell
$> cd into-1 
$> lein repl

```
Now, free up the monkey in you and try things you would expect the REPL to understand. (REPL never bites).
And see what happens.

```clojure
1
;; 1
"hello"
;; "hello"
'hello'
;; hello'
1+2
;; NumberFormatException Invalid number: 1+2  clojure.lang.LispReader.
readNumber (LispReader.java:256)
:abc
;; :abc
```

This illustrates some of the **scalars** Clojure understands. More details in
[edn/scalars](https://github.com/into-clojure/in-8hours/blob/master/rbf-edn-forms/edn.md#scalars)

#### Calling a function

You have noticed that ```1+2``` was not well received by the REPL.
Well, Clojure is a LISP. The first rule is 
> Clojure evaluates a list by using the first element as the function, and the following ones are the arguments
> 
> **(a-function arg1 arg2)**
>

> is how you call **a-function** with **arg1** and **arg2**

```Clojure
;; To add 1 and 2
(+ 1 2)
;; 3
(+ 1 2 3)
;; 6
(1 2 3)
;; ClassCastException java.lang.Long cannot be cast to clojure.lang.IFn  user/eval783 (NO_SOURCE_FILE:1)
;;
;; Now, this error makes more sense **1** is read as a **java.lang.Long** and cannot be cast as a function **clojure.lang.IFn**
;; To avoid the evaluation, just use the **quote** function
(quote quote)
;; quote
```
(quote quote) [codec](https://www.youtube.com/watch?v=w-T73n94-S4)...
```Clojure
(quote (1 2 3))
;; (1 2 3)
;; Clojure provides some syntax sugar for that with ' (the quote character)
'(1 2 3)
;; (1 2 3)
```

#### Collections

#### Lists
```Clojure
'(1 2 3)
;; (1 2 3)
```

#### Vector
They play a very important role. (More later on the subject)
```Clojure
[1 2 3]
;; [1 2 3]
```
Note that:
* lists and vectors are **not homogeneous** and can be arbitrarily **nested**
```CLojure
["a" 1 '(1 2 3)]
;; ["a" 1 (1 2 3)]
'(nil :abc ["a" 1 '(1 2 3)])
;; (nil :abc ["a" 1 (quote (1 2 3))])
```

#### Sets
A **set** can not contain twice the same element.
```Clojure
#{1 2 3}
;; #{1 2 3}
#{1 2 3 3}}
;; IllegalArgumentException Duplicate key: 3  clojure.lang.PersistentHashSet.createWithCheck (PersistentHashSet.java:68)
;; What did you expect?
```

#### Maps

[Maps](http://en.wikipedia.org/wiki/Hash_table) play a crucial role.

```Clojure
{:firstname "Robert"}
;; {:firstname "Robert"}
{:firstname "Robert" :age 12}
;; {:age 12, :firstname "Robert"}
{"a" 1 "a" 2}
IllegalArgumentException Duplicate key: a  clojure.lang.PersistentArrayMap.createWithCheck (PersistentArrayMap.java:70)
{"a" 1 nil 2 }
;; OK
{"a" 1 [1 2 3] 2 }
;; 
{:firstname "Robert" :age 12}
;; {:firstname "Robert" :age 12}
({:firstname "Robert" :age 12} :firstname)
;; "Robert"
{:firstname "Robert" :age 12 :friends ["Mike" "John"]}
```
Typically keys are keywords. 
This is practical, because keywords can act a function "indexing" a map.
Note also that commas are not mandatory, they can be used to separate key value pairs.
```Clojure
({:firstname "Robert" :age 12} :firstname)
;; "Robert"
(:firstname {:firstname "Robert" :age 12})
;; "Robert"
;; Thanks to :firstname being a keyword
```

### Some special forms
#### def

**def** associates a symbol with a value

```Clojure
(def a 1)
;; #'user/a
a
;; 1
b
;; CompilerException java.lang.RuntimeException: Unable to resolve symbol: b in this context, compiling:(NO_SOURCE_PATH:0:0) 
(def b 2)
;; #'user/b
b
;; 2
```

#### let
```Clojure
(let [x 10 y 2]) 
;; oups, x is still unknown
x
(let [x 10 y 2] x)
;; 2 
(let [x 10 y 2]  (+ x y))
```

#### fn
To create functions: **fn** 
```Clojure
;; a function with 2 arguments x and y and that return always 1
(fn [x y] 1)
;; #<user$eval13995$fn__13996 user$eval13995$fn__13996@252bb0e3>
;; alright, but the function is out in the air, not very useful...
;; let's use straight away:
((fn [x y] 1) 1 2)
;; 1
((fn [x y] 1) :abc [])
;; 1
((fn [x y] 1) 10 20)
;; 1
((fn [x y] 1) "a" "b")
;; 1

;; let's give a name to a function
(def one (fn [x y] 1))
;; #'user/one
(one)
;; ArityException Wrong number of args (0) passed to: user/one  clojure.lang.AFn.throwArity (AFn.java:429)
```
oups :-/ (fortunately this error message is quite clear)
```Clojure
(one 1 2)
;; 1
```

As you would have guessed, a shortcut is available: **defn**
```Clojure
(defn plus [a b c] (+ a b c))
;; #'user/plus
(plus 1 2 3)
;; 6
```

#### if
```clojure
(if (> 2 1) "YEAH" "booh")
;; "YEAH"
```

### To recap

| 					 				|            				|
| ------------------ 				| -------------------------:|
| *number*    		 				| ```1``` 						|
| *string*			 				| ```"one"``` 					|
| *keyword* 		 				| ```:one```  					|
| *list* 			 				| ```'(1 2 3)```      			|
| *list* 			 				| ```'("a" '(1 2) '(3 4))``` 		|
| *vector* 			 				| ```[1 2 3]```  					|
| *vector* 			 				| ```['(a b) 1 [2 3] 4]```		|
| *map* 			 				| ```{:a 1 :b 2}```				|
| *call a function*  				| ```(+ 1 2)```					|
| *associate a symbol to a value*  	| ```(def a 1)```					|
| *local binding*  					| ```(let [a 1]  (+ a 1))```   	|
| *create an anonymous function*    | ```(fn [x]  (* x x))```			|
| *create a function*				| ```(defn cube [x]  (* x x x))```	|


That's it (for the moment)...

## License

Copyright © 2015 into-clojure

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/" target="_blank">Creative Commons Attribution-ShareAlike 4.0 International License</a>.
