(fn [& args]
  (and (not-every? true? args)
       (not (nil? (some true? args)))))
