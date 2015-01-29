(fn [word]
  (let [[x & xs] (clojure.string/split word #"-")]
    (apply str (conj (map clojure.string/capitalize xs) x))))
