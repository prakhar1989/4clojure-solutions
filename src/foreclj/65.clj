(fn [coll]
  (let [base (empty coll)]
    (cond
      (= base {})  :map
      (= base #{}) :set
      (= base '()) (if (reversible? base) :vector :list))))
