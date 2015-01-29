(fn [chrs-seqs]
  (let [counter (fn [acc k] (assoc acc k (inc (get acc k 0))))
        count-char (fn [chrs] (reduce counter {} (seq chrs)))
        get-counts (map count-char chrs-seqs)
        counts-map (zipmap chrs-seqs get-counts)
        anagram-map (reduce (fn [acc [k v]] 
                                (assoc acc v (conj (get acc v []) k))) 
                            {} counts-map)]
      (->>
        (vals anagram-map) (map set) (filter second) (set))))
