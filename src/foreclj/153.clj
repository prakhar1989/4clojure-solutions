(fn [sets]
  (let [val (some #(pos? (count %))
              (for [x sets y sets :when (not= x y)]
                (clojure.set/intersection x y)))]
    (nil? val)))

