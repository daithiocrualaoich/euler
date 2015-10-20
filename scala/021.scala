/*
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n).
 *
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and
 * each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */

import scala.language.{implicitConversions, reflectiveCalls}

implicit def Int2Divides(d: Int) = new {
  def divides(n: Int): Boolean = n % d == 0
}

implicit def Int2Divisors(n: Int) = new {
  lazy val divisors: Seq[Int] = (1 to n-1) filter { _ divides n }
}

def d(n: Int): Int = n.divisors.sum

val divisorSums = (1 to 9999) map { a => (a, d(a)) }
val amicablePairs = divisorSums filter { case (a, b) =>
  a < b && d(b) == a
}

val amicables = amicablePairs flatMap { case (a ,b) => List(a, b) }

val answer = amicables.sum
println(answer)
