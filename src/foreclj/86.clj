(fn [n]
  (let [digits (fn digits [n] (if (< n 10) [n] (conj (digits (quot n 10)) (rem n 10))))
        new-num (fn [n] (->> (digits n) (map #(* % %)) (reduce +)))]
    (loop [i n nums #{}]
      (cond
        (= i 1) true
        (nums i) false
        :else (recur (new-num i) (conj nums i))))))