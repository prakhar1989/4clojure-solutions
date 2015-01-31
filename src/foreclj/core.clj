(ns foreclj.core
  (:gen-class))

(defn gcd [a b & args]
  (let [g (fn g [a b]
            (if (zero? b) a
              (g b (mod a b))))]
    (reduce g (g a b) args)))

(defn lcm [& nums]
  (let [l (apply max nums)]
    (->>
      (iterate #(+ % l) l)
      (filter (fn [mult] (every? #(zero? (mod mult %)) nums)))
      (first))))

(defn compute_lcm [& fracs]
  (lcm fracs))

(def fractions '(3/4 1/6 3/5 10))

