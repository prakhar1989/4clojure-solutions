(fn cmp [f a b]
  (cond
    (f a b) :lt
    (f b a) :gt
    :else :eq))
