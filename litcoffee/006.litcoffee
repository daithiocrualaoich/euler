Sum square difference
=====================
The sum of the squares of the first ten natural numbers is,
1^2 + 2^2 + ... + 10^2 = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)^2 = 55^2 = 3025

Hence the difference between the sum of the squares of the first ten natural
numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred
natural numbers and the square of the sum.


Answer
======
Include library functions for Number Theory.

    require('./number-theory')

Straightforward list comprehensions and sums.

    sum = (n for n in [1..100]).sum()
    sum_squares = (n*n for n in [1..100]).sum()

    answer = sum*sum - sum_squares
    console.log(answer)
