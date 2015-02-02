(fn [xs] (reduce #(assoc % %2 (inc (get % %2 0))) {} xs))
