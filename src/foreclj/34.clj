#(loop [iteration %1 result []]
  (if (= iteration %2) result
    (recur (inc iteration) 
           (conj result iteration))))
