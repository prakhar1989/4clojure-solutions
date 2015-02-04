(defn between [f val coll]
  (if (empty? coll) coll
    (let [xs (partition 2 1 coll)]
      (reduce
        (fn [acc [a b]]
          (if (f a b) (conj acc val b) (conj acc b)))
        [(first coll)] xs))))

