(fn [n]
  (->> (range 1 n) (filter #(zero? (rem n %))) (reduce +) (= n)))
