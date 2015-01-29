(fn [x y] 
   (map #(Character/getNumericValue %)
    (into [] (str (* x y)))))
