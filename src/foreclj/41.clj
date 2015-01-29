(fn [xs n]
  (loop [ys xs zs [] i 1]
    (cond
      (empty? ys) zs
      (= i n) (recur (rest ys) zs 1)
      :else (recur (rest ys) (conj zs (first ys)) (inc i)))))
