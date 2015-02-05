(defn reduxns
  ([f coll] (reduxns f (first coll) (rest coll)))
  ([f init coll]
    (cons init
      (lazy-seq
        (when-let [s (seq coll)]
          (reduxns f (f init (first s)) (rest s)))))))
