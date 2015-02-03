(fn part
  ([n coll] (part n n coll))
  ([n step coll]
    (when-let [s (seq coll)]
      (let [p (doall (take n s))]
        (when (= n (count p))
          (cons p (partition n step (nthrest s step))))))))
