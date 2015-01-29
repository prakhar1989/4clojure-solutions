(fn [n string]
  (let [len (count string)
        zs (if (pos? n) string (reverse string))
        [xs ys] (split-at (mod (Math/abs n) len) zs)
        rot (concat ys xs)]
    (if (pos? n) rot (reverse rot))))
