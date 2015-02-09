(fn [f coll]
  (->> coll (group-by f) (vals) (map #(set %)) set))
