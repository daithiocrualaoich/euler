10001st prime
=============
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that
the 6th prime is 13.

What is the 10,001st prime number?


Answer
======
Include library functions for Number Theory.

    sieve_of_eratosthenes = require('./number-theory').sieve_of_eratosthenes

We were bound to have to list primes eventually. The Sieve of Eratostenes is
good enough for our purposes and an upper bound of 150,000 is fine for this
problem.

    primes = sieve_of_eratosthenes(150000).primes()

Mind for the off by one error.

    answer = primes[10000]
    console.log(answer)
