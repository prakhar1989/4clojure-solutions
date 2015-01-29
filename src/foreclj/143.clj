(fn [x y] (reduce + (map #(* %1 %2) x y)))
