#(sort-by (fn [word] (.toLowerCase word)) (re-seq #"\w+" %))
