/*
 * Quadratic Primes
 * ================
 * Euler discovered the remarkable quadratic formula:
 *
 *   n^2 + n + 41
 *
 * It turns out that the formula will produce 40 primes for the consecutive
 * integer values 0 <= n <= 39. However, when n = 40, 40^2 + 40 + 41 is
 * divisible by 41, and certainly when n = 41, 41^2 + 41 + 41 is clearly
 * divisible by 41.
 *
 * The incredible formula n^2 - 79 * n + 1601 was discovered, which produces
 * 80 primes for the consecutive values 0 <= n <= 79. The product of the
 * coefficients, −79 and 1601, is −126,479.
 *
 * Considering quadratics of the form:
 *
 *   n^2 + a * n + b, where |a| < 1000 and |b| <= 1000
 *
 * where |n| is the modulus/absolute value of n.
 * e.g. |11| = 11 and |-4| = 4.
 *
 * Find the product of the coefficients, a and b, for the quadratic expression
 * that produces the maximum number of primes for consecutive values of n,
 * starting with n = 0.
 */

import scala.math.sqrt

implicit class Traversable2Crossable[X](xs: Traversable[X]) {
  def cross[Y](ys: Traversable[Y]) = for { x <- xs; y <- ys } yield (x, y)
}

def isPrime(n: Int): Boolean = {
  n > 1 && (2 to sqrt(n).intValue).forall { d => n % d != 0 }
}

def consecutivePrimesFromZero(f: Int => Int): Int = {
  Iterator.from(0).takeWhile { n => isPrime(f(n)) }.length
}

// Note |b| is less than or equal to 1000 whereas |a| is strictly less than.
val coefficients = (-999 to 999).cross(-1000 to 1000)

val (maxA, maxB) = coefficients.maxBy { case (a, b) =>
  consecutivePrimesFromZero(n => n*n + a*n + b)
}

val answer = maxA * maxB // = -59,231
println(answer)
