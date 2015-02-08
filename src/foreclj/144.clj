;; oscillating iterate
(fn oscill [num & fs]
  (let [[f & args] fs]
    (cons num (lazy-seq (apply oscill (f num) (concat args (list f)))))))
