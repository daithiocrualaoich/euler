Multiples of 3 and 5
====================
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get
3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.


Answer
======
Pimp a little number theory onto the Javascript number object.

    Number.prototype.divides = (n) -> n % this == 0

Don't include 1000 in this perverted Fizz Buzz.

    candidates = (n for n in [1..999] when 3.divides(n) || 5.divides(n))
    answer = candidates.reduce (x,y) -> x + y

    console.log(answer)