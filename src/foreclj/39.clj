(fn [x y] 
   (flatten (let [min-count (min (count x) (count y))]
     (map #(list (get x %)(get y %)) (range min-count)))))
