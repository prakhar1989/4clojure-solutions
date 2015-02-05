(defn tramp
  ([f] (let [ret (f)] (if (fn? ret) (tramp ret) ret)))
  ([f & args] (tramp #(apply f args))))

