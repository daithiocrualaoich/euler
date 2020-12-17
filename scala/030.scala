/*
 * Digit Fifth Powers
 * ==================
 *
 * Surprisingly there are only three numbers that can be written as the sum of
 * fourth powers of their digits:
 *
 *   1634 = 1^4 + 6^4 + 3^4 + 4^4
 *   8208 = 8^4 + 2^4 + 0^4 + 8^4
 *   9474 = 9^4 + 4^4 + 7^4 + 4^4
 *
 * As 1 = 1^4 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth
 * powers of their digits.
 */

// Note: 1 is excluded since it is not a sum.
//
// The largest possible sum of seven fifth powers is 7*9^5 = 413,343.
// Since this itself is not a seven digit number we know that no seven
// digit numbers can possibly be sums of the fifth powers of their digits.
//
// The largest possible sum of six fifth powers is 6*9^5 = 354,294 so
// we can take this as a generous upper bound of our search.

import scala.math.BigInt

def digitExpansion(n: Int): List[Int] = n match {
  case _ if n < 10 => List(n)
  case _ =>
    digitExpansion(n / 10) :+ (n % 10)
}

def digitFifthPowerSum(n: Int): Int = {
  digitExpansion(n).map { d => BigInt(d).pow(5).toInt }.sum
}

val range = (2 to 6*BigInt(9).pow(5).toInt)
val digitFifthPowerSums = range.filter { n =>
  n == digitFifthPowerSum(n)
}

val answer = digitFifthPowerSums.sum // = 443,839
println(answer)
