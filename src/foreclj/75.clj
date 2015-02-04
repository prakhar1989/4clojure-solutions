(fn [n]
  (if (= 1 n) n
    (let [gcd (fn g [a b] (if (zero? b) a (g b (mod a b))))
          coprime? (fn [a b] (= 1 (gcd a b)))]
        (->>
          (range 1 n) (filter #(coprime? % n)) (count)))))
