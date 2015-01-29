(fn [card]
  (let [ suits {\D :diamond \H :heart \C :club \S :spade}
         ranks {\T 8 \J 9 \Q 10 \K 11 \A 12}
         [s r] (seq card)
         suit (get suits s)]
    (if-let [rank (get ranks r)]
       {:suit suit :rank rank}
       {:suit suit :rank (- (Character/getNumericValue r) 2)})))
