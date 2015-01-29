(fn [& expr]
  (loop [[x & xs] expr acc 0 op +]
     (cond 
      (nil? x) acc
      (number? x) (recur xs (op acc x) nil)
      :else (recur xs acc x))))
