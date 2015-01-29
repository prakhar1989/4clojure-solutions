(fn [xs]
  (reduce + (map #(if-not (nil? %) 1 0) xs)))
