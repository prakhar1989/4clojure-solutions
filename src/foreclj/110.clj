;; This can be done more easily by using the partition-by function
;; (partition-by identity coll)
(fn get-pronun [coll]
  (let [pron (fn [coll]
               (loop [x (first coll) n 0 counts [] coll coll]
                 (cond
                   (empty? coll) (conj counts n x)
                   (= x (first coll)) (recur x (inc n) counts (rest coll))
                   :else (recur (first coll) 1 (conj counts n x) (rest coll)))))
        p (pron coll)]
    (cons p (lazy-seq (get-pronun p)))))
