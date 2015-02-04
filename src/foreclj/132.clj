;; using mapcat
(defn between [f val coll]
  (if (empty? coll) coll
    (let [xs (partition 2 1 coll)]
      (cons (first coll)
            (mapcat (fn [[a b]]
                      (rest (if (f a b) [a val b] [a b])))
                    xs)))))


;; using lazy-seq
(defn between [pred? val coll]
  (lazy-seq
    (let [[a b & _] coll
          xs (between pred? val (rest coll))]
      (if b
        (cons a (if (pred? a b) (cons val xs) xs))
        coll))))
