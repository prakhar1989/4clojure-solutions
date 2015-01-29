(fn [& args] (reduce (fn [x y] (if (> x y) x y)) args))
