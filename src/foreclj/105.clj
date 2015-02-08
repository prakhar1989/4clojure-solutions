;; the below works, but see how you can use `reduce` cleverly
;; to store the intermediate state required at each step
(fn [coll]
  (loop [coll coll m {}]
    (if (empty? coll) m
      (let [[k & xs] coll
            [ns ys] (split-with number? xs)]
        (recur ys (assoc m k ns))))))
