(fn [number]
  (let [indexed (map-indexed (fn [idx elem] [idx elem]) (reverse number))
        pow (fn [x] (reduce * (repeat x 2)))]
    (reduce (fn [acc [exp n]] (+ acc (* (- (int n) 48) (pow exp)))) 
            0 indexed)))
