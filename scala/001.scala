/*
 * Multiples of 3 and 5
 * ====================
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

implicit class Int2Divides(d: Int) {
  def divides(n: Int): Boolean = n % d == 0
}

val multiples = (1 to 1000) filter { n =>
  (3 divides n) || (5 divides n)
}

val answer = multiples.sum // = 233,168
println(answer)
