
Follow edn, forms that can have introduce the 'inc' function.
first class

## NB
Remark that + is not an operator but a function
Advantages of prefix notation:
* non ambiguous
* no pb with arities

## higher order

(mk-inc which builds a incrementor with a step)

exo: 
Write a function that returns a function (returning always 0)

* A word on (( 

## The "classics"

### doc
```
(doc doc)
"entrez"
```

### range
```
(range 10)
(range) ;; ;-)
```

### filter

```
(filter even? (range 100))
(defn vowel? [c] (> (.indexOf "aeiou" (int c)) -1))
(defn sv [s] (filter (complement vowel?) s))
```

### map
(not to be confused with the structure)

```
(map (fn [x] (* x x)) (range 10))
```

### reduce
 
```
(defn my-c [xs] (reduce (fn[a e] (inc a)) 0 xs))
```

### Structures seen as functions

map : returns val for key

Special case with :keyword!

vector : return value by index

## Composition

```
(def dd [f] (comp f f))
```
