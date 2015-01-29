(fn [seqs]
  (->>
    (clojure.string/split seqs #",")
    (map #(Integer/parseInt %))
    (filter #(let [x (Math/sqrt %)] (== x (int x))))
    (clojure.string/join ",")))
