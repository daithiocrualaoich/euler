Number Theory
=============
Support functions for number theoretic calculations.


Divisibility
------------
Pimp some basic congruence tests onto the Javascript number object.

    Number.prototype.divides = (n) -> n % this == 0


Lists
-----
We'll be doing a lot of array summing.

    Array.prototype.sum = () -> this.reduce (x,y) -> x + y

Tidy the language for getting the last element of an array.

    Array.prototype.last = () -> this.slice(-1)[0]
