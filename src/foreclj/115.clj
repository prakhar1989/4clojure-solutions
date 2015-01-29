(fn [xs]
  (let [xs (->> (Integer/toString xs) (seq) (map #(Character/getNumericValue %)))
        len (/ (count xs) 2)]
    (if (zero? (mod (count xs) 2)) 
      (let [[a b] (split-at len xs)] (= (reduce + a) (reduce + b)))
      (let [[a b] (split-at (dec len) xs)] (= (reduce + a) (reduce + (rest b)))))))
