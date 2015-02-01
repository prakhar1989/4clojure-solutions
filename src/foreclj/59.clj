(fn [& fs]
  (fn
    ([x] (reduce #(conj %1 (%2 x)) [] fs))
    ([x & args] (reduce #(conj %1 (apply %2 (list* x args))) [] fs))))
