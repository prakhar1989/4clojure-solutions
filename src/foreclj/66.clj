(fn gcd [a b] (if (zero? b) a (gcd b (mod a b))))
