Smallest multiple
=================
2520 is the smallest number that can be divided by each of the numbers from 1 to
10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the
numbers from 1 to 20?


Answer
======
Include library functions for Number Theory.

    lcm = require('./number-theory').lcm

Lowest common multiple can be calculated piecewise. Uses Euclid's Algorithm to
calculate greatest common divisors and form lowest common multiples.

    answer = [1..20].reduce (x, y) -> lcm(x, y)
    console.log(answer)
