(defn my-comp [& fs]
  (let [fs (reverse fs)]
    (fn [& args]
      (loop [ret (apply (first fs) args) fs (next fs)]
        (if fs
          (recur ((first fs) ret) (next fs))
          ret)))))