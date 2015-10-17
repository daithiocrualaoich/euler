Number Theory
=============
Support functions for Number Theory calculations.


Strings
-------
Treating numbers as strings is a useful technique sometimes but it will require
some helpers.

    String.prototype.reverse = () -> this.split('').reverse().join('')


Lists
-----
We'll need basic arithmetic on sequences of numbers.

    Array.prototype.sum = () -> [0].concat(this).reduce (x,y) -> x + y
    Array.prototype.product = () -> [1].concat(this).reduce (x,y) -> x * y
    Array.prototype.max = () -> Math.max.apply(Math, this)
    Array.prototype.min = () -> Math.min.apply(Math, this)

Tidy the language for getting specific elements of a list.

    Array.prototype.last = () -> this.slice(-1)[0]

A sort is always useful.

    Array.prototype.sorted = () -> this.sort (n, m) -> n - m

Count the distinct elements in a list.

    Array.prototype.count_distinct = () ->
      counts = {}

      for element in this
        if element.toString() not in Object.keys(counts)
          counts[element] = 0
        counts[element] += 1

      counts


Divisibility
------------
Pimp some basic congruence tests onto the Javascript number object.

    Number.prototype.divides = (n) -> n % this == 0


Euclid's Algorithm
------------------
Euclid's insanely beautiful greatest common divisor algorithm.

    module.exports.gcd = (n, m) ->
      a = n
      b = m

      while b > 0
        t = b
        b = a % t
        a = t

      a

    module.exports.lcm = (n, m) -> n * m / module.exports.gcd(n, m)


Sieve of Eratosthenes
---------------------
Well, we've got to find primes somehow.

    module.exports.sieve_of_eratosthenes = (max) ->
      sieve = (true for n in [0..max])

      sieve[0] = sieve[1] = false
      for i in [2..max]
        if sieve[i]
          for n in [2*i..max] by i
            sieve[n] = false

      {
        'max': max,
        'count': () -> (1 for p in sieve when p).length,
        'primes': () -> (i for i in [0..max] when sieve[i]),
        'is_prime': (n) -> sieve[n]
      }



Fundamental Theorem of Arithmetic
---------------------------------
We won't be doing much Number Theory without decomposing integers into their
unique prime factorizations, even this badly.

    Number.prototype.prime_factors = () ->
      factors = []
      factor = 2
      quotient = this

      while quotient > 1
        if factor.divides(quotient)
          factors.push(factor)
          quotient /= factor
        else
          factor++

      factors

    Number.prototype.prime_factor_powers = () ->
      this.prime_factors().count_distinct()


Number of divisors
------------------
The number of divisors that a number has can be calculated from its prime
decomposition. Each divisor must have the same primes as the number itself but
at the same or lower counts.

For instance, 28 = 2 x 2 x 7 = 2^2 x 7^1. This has (2+1)x(1+1) = 6 divisors
corresponding to those with 0,1,2 powers of 2 and 0,1 powers of 7.

    Number.prototype.num_divisors = () ->
      prime_powers = this.prime_factor_powers()
      factor_power_choices = (prime_powers[p]+1 for p in Object.keys(prime_powers))

      factor_power_choices.product()

    module.exports.tau = (n) -> n.num_divisors()
