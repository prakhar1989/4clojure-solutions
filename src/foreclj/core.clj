(ns foreclj.core
  (:gen-class))

;; using iterate
(defn get-multiples [n x]
  (take n (iterate #(+ % x) x)))

(get-multiples 5 7)

;; what are lazy sequences?
(def my-seq (map inc (range 10)))
(realized? my-seq)
(last my-seq)
(realized? my-seq)

;; Prime Sandwich example 1
(defn sandwich? [n]
  (if (<= n 2) false
     (let [sieve (fn sieve [s] (cons (first s)
                                     (lazy-seq (sieve (filter #(not= 0 (mod % (first s))) (rest s))))))
           xs (take-while #(<= % n) (sieve (iterate inc 2)))
           a (last xs)
           b (nth (sieve (concat xs (iterate inc a))) (inc (count xs)))
           c (second (reverse xs))]
       (if (not= a n) false
            (= (/ (+ b c) 2))))))

(sandwich? 563)
(sandwich? 10)
(time (sandwich? 563))
(sandwich? 19)
(take 10 (filter sandwich? (range)))

;; problem 171
;(defn intervals [coll]
;  (let [xs (partition 2 1 (sort coll))]
;    (loop [[a b & rest] xs acc [] ys []]
;      (cond
;        (nil? a) acc
;        (if (= (- b a) 1) (recur rest acc (conj ys a)))
;        :else (recur rest (conj acc (conj ys a)) [])))))


