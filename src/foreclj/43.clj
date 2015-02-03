;; horribly inefficient solution - mine :(
(defn rev-interleave [xs n]
  (->>
    (for [y (range n) x (partition n xs)] (nth x y))
    (partition (/ (count xs) n))))

;; neater and faster - not mine
(defn new-interleave [xs n]
  (apply map list (partition n xs)))
