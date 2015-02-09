(fn [x n]
  (loop [x x s []]
    (if (< x n) (cons (mod x n) s)
      (recur (quot x n) (cons (mod x n) s)))))
