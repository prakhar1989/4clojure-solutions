(fn [f coll]
  (reduce
    (fn [acc x]
      (let [k (f x)]
        (assoc acc k (conj (get acc k []) x))))
    {} coll))