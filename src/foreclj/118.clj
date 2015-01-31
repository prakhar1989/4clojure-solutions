(fn my-map [f coll]
  (lazy-seq 
    (if (empty? coll) ()
    (cons (f (first coll)) 
          (my-map f (rest coll))))))
