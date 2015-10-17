Special Pythagorean triplet
===========================
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a^2 + b^2 = c^2

For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.


Answer
======
Include library functions for Number Theory.

    require('./number-theory')

The ordering and additive constraints means we can significantly reduce the
search space.

    triples = []
    for a in [1..1000]
      for b in [a+1..1000]
        c = 1000 - a - b
        triples.push([a, b, c]) if c > b

Test for Pythagorean triplets by evaluating the powers.

    Array.prototype.is_pythagorean = () -> this.length == 3 &&
      Math.pow(triple[0], 2) + Math.pow(triple[1], 2) == Math.pow(triple[2], 2)

Filter for Pythagorean triplets.

    pythagorean = (triple for triple in triples when triple.is_pythagorean())

Take the product of the triple.

    answer = pythagorean[0].product()
    console.log(answer)
