(fn [n key-vec] (reduce (fn [m k] (assoc m k n)) {} key-vec))
