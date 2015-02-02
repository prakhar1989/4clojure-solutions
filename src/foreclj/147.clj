(fn [xs]
  (let [next-row
        (fn [coll]
          (concat [(first coll)]
                  (map #(apply +' %) (partition 2 1 coll))  ;; +' for integer overflow
                  [(last coll)]))]
    (iterate next-row xs)))
