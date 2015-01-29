(fn [seqs]
  (loop [xs seqs ys [] uniq #{}]
    (cond 
      (empty? xs) ys
      (uniq (first xs)) (recur (rest xs) ys uniq) 
      :else (recur (rest xs) 
                   (conj ys (first xs)) 
                   (conj uniq (first xs))))))
