;; checks if the tree is balanced or not
(defn balanced-tree? [[root left right :as tree]]
  (or (and
        (not (nil? root))
        (nil? left)
        (nil? right))
      (and
        (= 3 (count tree))
        (balanced-tree? left)
        (balanced-tree? right))))

;; checks if tree is symmetric
(defn symm-tree? [[_ left right]]
  (let [symmetric?
        (fn symmetric? [[ra La Ra :as a]  [rb Lb Rb :as b]]
          (or (= nil a b)
              (and (= ra rb) (symmetric? La Rb) (symmetric? Ra Lb))))]
    (symmetric? left right)))
