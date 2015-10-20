/*
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 */

import scala.language.{implicitConversions, reflectiveCalls}

implicit def Int2Divides(d: Int) = new {
  def divides(n: Int): Boolean = n % d == 0
}

implicit def Int2IsAbundant(n: Int) = new {
  lazy val divisors: Seq[Int] = (1 to n-1) filter { _ divides n }
  lazy val isAbundant: Boolean = divisors.sum > n
}

val limit = 28123

// Find all abundant numbers <= 28123.
val abundants = (1 to limit) filter { _.isAbundant }

// Assume all numbers <= 28123 are non abundant sums and delete all sums of
// abundants.
val nonAbundantSums = Array.fill[Boolean](limit + 1) { true }
for {
  n <- abundants
  m <- abundants
  if n + m <= limit
} {
  nonAbundantSums(n + m) = false
}

val answer = (nonAbundantSums.zipWithIndex collect {
  case (true, index) => index
}).sum

println(answer)
