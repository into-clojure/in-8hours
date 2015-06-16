I;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.

;;
;; what is true (in a if for example) ?
;; everything except false and nil

;; arities

;; we have seen
(defn plus
  [a b]
  (+ a b))

(plus 2 3)

;; to deal with multiple arities
; (plus 1 2 3)
(defn plus
  ([a b]
    (+ a b))
  ([a b c]
    (+ a b c)))

(plus 1 2 3)

(defn plus
  "Returns the addtions of the given numbers"
  ([a b]
    (+ a b))
  ([a b c]
    (+ a b c))
  ([a b c d]
    (+ a b c d)))

;; ? generic form?
(defn plus [& ns]
  (+ ns))

;; comment marche le &
;; les valeurs sont "ramassées" dans une liste
(defn f
  [a & more]
  (println a)
  (println more))

(f 1 2 3 4)

; (plus 1 2 3 4)
;; ouch
;;
;; explanation :
(doc +)

;; One solution : apply
(defn plus [& ns]
  (apply + ns))

(plus 1 2 3 4 5 6 7)

;; 2 functions to help us

;; access to doc umentation

(doc doc)

(doc range)
;; takes some time to emphasize that lazy word
;; we'll explain later

(range 10)

(range 1 11)


;; Filter
(range 1 101)
(def one-to-hundred (range 1 101))

;; exo returns a new list that contains only even numbers

(defn divide-by-2?
  [n]
  (= 0 (mod n 2)))

(divide-by-2? 2)
(divide-by-2? 3)

(map divide-by-2? (range 10))

(filter divide-by-2? one-to-hundred)


;; exo : the list of one-to-hundred of numbers bigger than 50


;; the list of numbers not divided by two
;; you may not touch divide-by-2?, or declare a new function not-divide-by-2
;; higher order only

(defn contrary
  [f?]
  (fn [x]
    (if (f? x)
      false
      true)))

 (filter (contrary divide-by-2?) one-to-hundred)

;; it turns out, contrary already exists
;; it's called complement
(doc complement)
(source complement)

;; another exo
;; write a function that takes 2 functions and compose them
;; f and g => the function that applies f(g(x))

(defn compose
  [f g]
  (fn [x]
    (f (g x))))

(defn square
  [x]
  (* x x))

((compose square inc) 10)


;; map
;; apply a function to a collection
(map inc (range 10))


;; reduce
;;

;; we must first introduce assoc for a map
;; assoc m k v

(assoc {:name "Peter"} :age 65)

;; re-implement frequencies with reduce
;; reduce f val col


(defn frek [xs]
  (reduce (fn [a e] (let [already-seen (a e)] (assoc a e (if already-seen (inc already-seen) 1)))) {} xs))


;; exo
;; we give you tennis scores like this [[a1 b1] [a2 b2]] where an and bn are the number of games for player a and b.
;; [[6 0] [6 2]] represents a victory for player a (2 sets to none)
;; [[6 2] [4 6] [5 7]] represents a victory for player b
;; Write a function that returns who wins, i.e :a or :b given a score.

(defn winner-set [s]
  (if (> (first s) (second s))
    :a 
    :b))

;; Bof bof...
(defn winner-set [s]
  (if (apply > s)
    :a 
    :b))

(defn winner
  [match]
  (let [f (frek (map winner-set match))]
    (if (> (:a f) (:b f))
      :a
      :b)))
  
;; 
;; -----------------
;;
(defn count-set [s]
  (if (apply > s)
      1 
      -1))

(defn winner2
  [match]
  (if (pos? (apply + (map count-set match)))
    :a
    :b))
;; 
;; -----------------
;;


;; loop recur
(defn kount 
  ([xs] (kount xs 0))
  ([xs r] 
    (if 
      (empty? xs)
      r
      (recur (rest xs) (inc r)))))


;; next : 
;; checks scores are valid ...
;; in 3 winning sets, :a :a :a :b is not possible but :a :a :b :a yes ...

;; first, rest... ?

;; http://www.4clojure.com/problem/19

;; http://www.4clojure.com/problem/21

;; Faire un exo de 4 clojure ensemble

 ;; the datastructure map

{:a 1 :b 2 :c 3}

(def m {:a 1 :b 2 :c 3})

(m :a)
;; or
(:a m)






