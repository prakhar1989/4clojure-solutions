(fn [a b]
  (let [xs (for [x a y b] (set [x y]))
        ys (filter #(= 1 (count %)) xs)]
    (reduce clojure.set/union #{} ys)))
