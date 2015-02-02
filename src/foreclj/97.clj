(fn [n]
  (let [nextrow (fn [x] (concat [1] (map #(apply + %) (partition 2 1 x)) [1]))]
    (loop [i 1 x '(1)]
      (if (= i n) x
        (recur (inc i) (nextrow x))))))
