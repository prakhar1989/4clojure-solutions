(fn [t]
  (into {} (for [[x y] t [k v] y] [[x k] v])))
