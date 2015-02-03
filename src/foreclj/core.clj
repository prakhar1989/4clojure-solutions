(ns foreclj.core
  (:gen-class))

(take 5 (reductions + (range)))

(source reductions)

;; lazy seq
;; problems on lazy seq - 60
;;
(def foo (lazy-seq [1 2 3 4]))
;; gives false
(realized? foo)

(last foo)
;; gives true
(realized? foo)


(source iterate)


(defn random-ints [limit]
  (lazy-seq
    (cons (rand-int limit)
          (random-ints limit))))

(take 5 (iterate #(+ % 2) 2))

(source iterate)

;; two's lazy seq
(defn twos-increment [start]
  (cons start
        (lazy-seq
          (twos-increment (+ 2 start)))))


(take 5 (twos-increment 0))

