(fn [nums] (count (filter 
  (fn [x] (< x (reduce + (map #(* % %)
       (map #(Character/getNumericValue %) (seq (str x))))))) nums)))
