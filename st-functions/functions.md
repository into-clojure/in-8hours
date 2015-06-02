
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

* range

### filter

```
(filter even? (range 100))
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

## Composition

> (def dd [f] (comp f f))
