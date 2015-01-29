(fn [coll]
  (seq
   (reduce
    (fn my-flatten [v e]
      (if (coll? e)
        (reduce my-flatten v e)
        (conj v e)))
    [] coll)))
