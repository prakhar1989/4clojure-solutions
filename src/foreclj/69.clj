(defn my-merge [f mmap & maps]
  (let [m-merge 
        (fn [f m1 m2] ;; fn to merge two maps with fn
          (reduce (fn [m [k v]]
            (if (m k)
              (assoc m k (f (m k) v))
              (assoc m k v)))
          m1 m2))]
   (reduce #(m-merge f %1 %2) mmap maps)))
