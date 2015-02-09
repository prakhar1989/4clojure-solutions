(defn powerset [coll]
  (letfn [(combine [acc x] (conj (into acc (map #(conj % x) acc)) #{x}))]
    (reduce combine #{#{}} coll)))
