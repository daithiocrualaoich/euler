Summation of primes
===================
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.


Answer
======
Include library functions for Number Theory.

    sieve_of_eratosthenes = require('./number-theory').sieve_of_eratosthenes

Luckily, we have that Sieve of Eratosthenes

    answer = sieve_of_eratosthenes(2000000).primes().sum()
    console.log(answer)
