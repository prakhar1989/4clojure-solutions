(fn compute-lcm [& fracs]
  (let [denoms (map #(if (ratio? %) (denominator %) 1) fracs)
        numers (map #(if (ratio? %) (numerator %) %) fracs)
        lcm (fn [& nums]
              (let [l (apply max nums)]
                (->> (iterate #(+ % l) l)
                     (filter (fn [mult] (every? #(zero? (mod mult %)) nums)))
                     (first))))
        gcd (fn [& args]                                    ;; euclid's algorithm
              (let [g (fn g [a b] (if (zero? b) a (g b (mod a b))))]
                (reduce g args)))]
    (/ (apply lcm numers)                                   ;; lcm numers / hcf denoms
       (apply gcd denoms))))
