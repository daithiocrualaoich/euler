/*
 * Multiples of 3 and 5
 * ====================
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 */

def divides(n: Int, d: Int): Boolean = n % d == 0

val multiples = Range(1, 1000) filter { n =>
  divides(n, 3) || divides(n, 5)
}

val answer = multiples.sum
println(answer)
