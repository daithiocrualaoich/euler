Largest prime factor
====================
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?


Answer
======
Include library functions for Number Theory.

    require('./number-theory')

Prime decomposition and a sequence maximum will take care of this.

    answer = 600851475143.prime_factors().max()
    console.log(answer)
