(fn [xs] (reduce concat (map #(take 2 (repeat %)) xs)))
