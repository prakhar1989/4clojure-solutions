; The key idea in this problem is that series
; of 1, 2, 3 is a Arithmetic Progression, and hence, the sum can
; simply be computed by the formula s = n(n+1)/2.
; The other trick is that the sum of series k, 2k, 3k can be
; computed by k * n(n+1)/2. Simply, find this sum for the two coprimes
; and add them. The last part is subtracting the common factors which
; have been added *twice* e.g. 15 will be added for both 3 and 5
; Note: the N below casts 2 to BigInt

(fn [n a b]
  (let [f #(if (even? %)
            (* (inc %) (quot % 2))
            (* % (quot (inc %) 2N)))
        x (* a (f (quot (dec n) a)))
        y (* b (f (quot (dec n) b)))
        z (* (* a b) (f (quot (dec n) (* a b))))]
    (- (+ x y) z)))
