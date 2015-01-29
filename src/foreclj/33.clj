(fn [nums n] (mapcat #(take n (repeat %)) nums))
