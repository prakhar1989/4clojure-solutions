(fn [n]
  (let [sieve (fn sieve [s] (cons (first s)
                                  (lazy-seq (sieve (filter #(not= 0 (mod % (first s)))
                                                           (rest s))))))]
    (take n (sieve (iterate inc 2)))))
