;; better way to do it by destructing the board completely
;; into this constituents.
(fn tic-tac [board]
  (let [cols (map #(map % board) [first second last])
        d1 (for [x [[0 0] [1 1] [2 2]]] (get-in board x))
        d2 (for [x [[0 2] [1 1] [2 0]]] (get-in board x))
        colls (concat board cols [d1 d2])
        check (fn [sym]     ;; checks whether sym exists completely 
                (some true? ;; in one coll of colls
                   (map (fn [coll] (every? #(= % sym) coll)) 
                        colls)))]
    (cond
      (check :x) :x (check :o) :o
      :else nil)))
