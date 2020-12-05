/*
 * Find the quadratic n^2 + an + b which produces the longest series of primes
 * when n=0,1,2,... for |a|,|b| < 1000.
 */

import scala.math.sqrt

implicit class Crossable[X](xs: Traversable[X]) {
  def cross[Y](ys: Traversable[Y]) = for { x <- xs; y <- ys } yield (x, y)
}

def isPrime(n: Int): Boolean = {
  n > 1 && (2 to sqrt(n).intValue).forall { d => n % d != 0 }
}

def consecutivePrimesFromZero(f: Int => Int): Int = {
  Iterator.from(0).takeWhile { n => isPrime(f(n)) }.length
}

val coefficients = (-999 to 999).cross(-999 to 999)

val (maxA, maxB) = coefficients.maxBy { case (a, b) =>
  consecutivePrimesFromZero(n => n*n + a*n + b)
}

val answer = maxA * maxB
println(answer)
