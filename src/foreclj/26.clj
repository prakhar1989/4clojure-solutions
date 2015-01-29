#(map (fn fib [x] 
        (if (< x 2) x 
          (+ (fib (- x 2)) (fib (- x 1))))) 
      (range 1 (+ 1 %)))
