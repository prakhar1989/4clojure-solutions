(ns foreclj.core
  (:gen-class))

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

(defn infix [v & more]
  (reduce (fn [acc [op x]] (op acc x)) v (partition 2 more)))

(defn infix [& exprs]
  (loop [[x & xs] exprs acc 0 oper +]
     (cond 
      (nil? x) acc
      (number? x) (recur xs (oper acc x) nil)
      :else (recur xs acc x))))

(defn infix-2
  ([x op y] (op x y))
  ([x op y & xs]
   (apply infix-2 (cons (infix-2 x op y) xs))))

(defn gcd [x y] 
  (if (zero? y) x (gcd y (mod x y))))

(defn lcm [x y]
  (/ (* x y) (gcd x y)))

(defn answer [r1 r2]
  (let [a (numerator r1)
        b (denominator r1)
        c (numerator r2)
        d (denominator r2)]))

(defn divide [a b]
  (let [quot (count (take-while (fn [n] (<= n a)) 
                                (iterate #(+ b %) b))) 
        rem  (- a (* quot b))]
    {:quot quot :rem rem }))

(defn cmp [f a b]
  (cond
    (f a b) :lt
    (f b a) :gt
    :else :eq))

(defn set-inter [a b]
  (let [xs (for [x a y b] (set [x y]))
        ys (filter #(= 1 (count %)) xs)]
    (reduce clojure.set/union #{} ys)))

(defn rev-inter [xs n]
  (let [i (/ (count xs) n)]
    (partition i xs)))

(defn cc [chrs-seqs]
  (let [counter (fn [acc k] (assoc acc k (inc (get acc k 0))))
        count-char (fn [chrs] (reduce counter {} (seq chrs)))
        get-counts (map count-char chrs-seqs)
        counts-map (zipmap chrs-seqs get-counts)
        anagram-map (reduce (fn [acc [k v]] 
                                (assoc acc v (conj (get acc v []) k))) 
                            {} counts-map)]
      (->>
        (vals anagram-map) (map set) (filter second) (set))))

(defn get-map-count 
  "increments count of word in provided map(counts)"
  [counts word]
  (assoc counts word 
         (inc (get counts word 0))))

(defn card-game [card]
  (let [ suits {\D :diamond \H :heart \C :club \S :spade}
         ranks {\T 8 \J 9 \Q 10 \K 11 \A 12}
         [s r] (seq card)
         suit (get suits s)]
    (if-let [rank (get ranks r)]
       {:suit suit :rank rank}
       {:suit suit :rank (- (Character/getNumericValue r) 2)})))

(defn perfect-squares [seqs]
  (->>
    (clojure.string/split seqs #",")
    (map #(Integer/parseInt %))
    (filter #(let [x (Math/sqrt %)] (== x (int x))))
    (clojure.string/join ",")))

(defn get-distinct [seqs]
  (loop [xs seqs
         uniq #{}]
    (if (uniq (first xs)) 
      (recur (rest xs) (conj uniq (first xs)))
      (recur (rest xs) uniq))))

(defn perfect-nums [n]
  (->>
    (range 1 n)
    (filter #(zero? (rem n %)))
    (reduce +)
    (= n)))

(defn to-camel-case [word]
  (let [[x & xs] (.split word #"-")]
    (apply str (conj (map clojure.string/capitalize xs) x))))

(defn balanced-num [xs]
  (let [xs (->> (Integer/toString xs) (seq) (map #(Character/getNumericValue %)))
        len (/ (count xs) 2)]
    (if (zero? (mod (count xs) 2)) 
      (let [[a b] (split-at len xs)] (= (reduce + a) (reduce + b)))
      (let [[a b] (split-at (dec len) xs)] (= (reduce + a) (reduce + (rest b)))))))

