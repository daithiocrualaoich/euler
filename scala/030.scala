/*
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

val answer = digitFifthPowerSums.sum
println(answer)
