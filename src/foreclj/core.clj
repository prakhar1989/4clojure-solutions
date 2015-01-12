(ns foreclj.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn needs-matching-part?
  [part]
  (re-find #"^left-" (:name part)))

(defn make-matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts 
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (let [final-body-parts (conj final-body-parts part)]
              (if (needs-matching-part? part)
                (conj final-body-parts (make-matching-part part))
                final-body-parts)))
          [] asym-body-parts))

;; chapter 2 
(defn titleize
  [topic]
  (str topic " for the Brave and True"))

;; extracting key value pairs
(defn label-key-val
  [[key val]]
  (str "key: " key ", val: " val))

;; map to map to vector to map
(into {}
      (map (fn [[key, val]] 
             [key (inc val)]) 
       {:max 20 :min 10}))

(reduce (fn [new-map [key, val]]
          (assoc new-map key (inc val))) 
        {} {:max 30 :min 10})

;; fizzbuzz
(map (fn [n] 
       (if (zero? (mod n 15)) "FizzBuzz" 
         (if (zero? (mod n 3)) "Fizz" 
           (if (zero? (mod n 5)) "Buzz" n)))) 
     (range 1 20)) 


;; Diff fizzbuzz
(map (fn [n] 
       (let [result 
         (str (when (zero? (mod n 3)) "Fizz")
              (when (zero? (mod n 5)) "Buzz"))]
         (if (empty? result) n result)))
     (range 1 20))

;; -> macro awesomeness for pipelining
;;(-> [2 5 4 1 3 6] (reverse) (rest) (sort) (last))

((fn [n key-vec] (reduce (fn [m k] (assoc m k n)) {} key-vec))
 0 [:a :b :c])

(fn [x y] 
   (map #(Character/getNumericValue %)
    (into [] (str (* x y)))))

((fn [xs] (reduce concat (map #(take 2 (repeat %)) xs)))
 [1 2 3]) 

(interleave [0 0 0] [1 2 3])

(into [] (take 3 (repeat 9))) 

(fn [x nums]
  (conj (vec (interleave nums
        (into [] (take (dec (count nums)) (repeat x)))))   
    (last nums)))


(#(rest (interleave (repeat %) %2)) 0 [1 2 3])

(defn get-words [text] (re-seq #"\w+" (.toLowerCase text)))

(defn sum
  ([vals] (sum vals 0))
  ([vals accumulating-total]
    (if (empty? vals) accumulating-total
      (sum (rest vals) (+ (first vals) accumulating-total)))))

(defn another-sum
  ([vals] (another-sum vals 0))
  ([vals accumulating-total])
  (if (empty? vals) accumulating-total)
    (recur (rest vals) (+ (first vals) accumulating-total)))

(defn factorial
  [n]
  (reduce * (range 2 (inc n))))

(factorial 5)
