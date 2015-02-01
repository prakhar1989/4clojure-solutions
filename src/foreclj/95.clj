(fn tree? [n]
  (or (nil? n)                                              ;; nil is a tree
      (and (coll? n)                                        ;; else it should be a collection
           (= 3 (count n))                                  ;; of length 3
           (every? tree? (rest n)))))                       ;; where each child is a tree