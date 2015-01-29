(fn re-iterate [f x] (cons x (lazy-seq (re-iterate f (f x)))))
