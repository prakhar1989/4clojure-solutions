(ns foreclj.core
  (:gen-class))

;; lazy-seqs
(doc iterate)
(source iterate)

;; using iterate
(defn get-multiples [n x]
  (take n (iterate #(+ % x) x)))

(get-multiples 5 7)

;; what are lazy sequences?
(def my-seq (map inc (range 10)))
(realized? my-seq)
(last my-seq)
(realized? my-seq)

