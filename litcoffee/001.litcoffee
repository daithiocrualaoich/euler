Multiples of 3 and 5
====================
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get
3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.


Answer
======
Include library functions for Number Theory.

    require('./number-theory')

Don't include 1000 in this strange Fizz Buzz.

    multiples = (n for n in [1..999] when 3.divides(n) || 5.divides(n))

    answer = multiples.sum()
    console.log(answer)
