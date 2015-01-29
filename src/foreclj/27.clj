#(if (string? %) 
   (= (clojure.string/reverse %) %) 
   (= (reverse %) %))
