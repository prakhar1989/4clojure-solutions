;; fizzbuzz
(map (fn [n] 
       (if (zero? (mod n 15)) "FizzBuzz" 
         (if (zero? (mod n 3)) "Fizz" 
           (if (zero? (mod n 5)) "Buzz" n)))) 
     (range 1 20)) 


;; Diff fizzbuzz
(map (fn [n] 
       (let [result 
         (str (when (zero? (mod n 3)) "Fizz")
              (when (zero? (mod n 5)) "Buzz"))]
         (if (empty? result) n result)))
     (range 1 20))
