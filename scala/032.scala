/*
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1
 * through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing
 * multiplicand, multiplier, and product is 1 through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity
 * can be written as a 1 through 9 pandigital.
 */

// NOTE: There are two ways of writing 5,346 as a pandigital sum but the
// question is careful to ask for products whose identity is pandigital.
// i.e. should only include 5,346 once.

// We only need to be concerned with generating the possible multiplicand and
// multiplier values. If these are enumerated then they can be multiplied to
// get the product and the whole identity tested for pandigital.
//
// * 9 digits on the left hand side is not possible since each value needs at
//   least one digit. e.g. must have a right hand side.
// * 8 digits on the left hand side is not possible since at least one of the
//   multiplicand and multiplier will have more than 1 digit and cannot result
//   in a product of just 2 digit.
// * 7 digits on the left hand side is not possible either. At least one of the
//   multiplicand and multiplier will have more than 2 digits and cannot result
//   in a product of just 2 digits.
// * 6 digits on the left hand side is not possible either. The cases on the
//   left hand side with a 4 or 5 digit multiplicand or multiplier is not
//   possible as above. The 3 digit by 3 digit case would also result in a
//   product > 1000.
//
// Exclusions from the other end:
// 
// * 2 digits on the left hand side cannot produce a product containing 7
//   digits.
// * 3 digits on the left hand side must be single digit by double digit,
//   at most 9 * 87 = 783, cannot contain 6 digits.
// * 4 digits on the left hand side can only make a 4 digit product. e.g.
//   96*87 = 8,352, 9*876=7,884
//
// Suffices to only check the case of 5 digits on the left hand side.
//
// We take the five digit subsets of 1-9 in turn and produce all the 1 and
// 2 digit possibles. Then we permutate the remaining digits and calculate
// if the product produces a pandigital expression.

def digitExpansion(n: Int): List[Int] = n match {
  case _ if n < 10 => List(n)
  case _ =>
    digitExpansion(n / 10) :+ (n % 10)
}

def isPandigital(a: Int, b: Int): Boolean = {
  val digits = digitExpansion(a) ++ digitExpansion(b) ++ digitExpansion(a * b)

  digits.length == 9 && !digits.contains(0) && digits.distinct.length == 9
}

// Start by selecting all five element subsets of 1 to 9.
val fiveDigitSubsets: List[List[Int]] = (1 to 9).toList.combinations(5).toList

// And produce candidate multiplicand-multiplier pairs. To avoid duplicates,
// make sure the multiplicand is always the smaller number.
val candidates: List[(Int, Int)] = fiveDigitSubsets.flatMap { fiveDigits: List[Int] =>

  val multiplicands: Iterator[List[Int]] = fiveDigits.combinations(1) ++ fiveDigits.combinations(2)

  // For each multiplicand, calculate the remaining digits in the five digit
  // subset and permute into all possible multipliers.
  multiplicands.flatMap { multiplicand: List[Int] =>
    val remainingDigits: List[Int] = fiveDigits.filter { digit => !multiplicand.contains(digit) }
    remainingDigits.permutations.map { multiplier =>
      (multiplicand.mkString.toInt, multiplier.mkString.toInt)
    }
  }
}

val pandigital = candidates.filter { pair => isPandigital(pair._1, pair._2) }

pandigital.sorted.foreach { pair =>
  println(s"${pair._1} x ${pair._2} = ${pair._1 * pair._2}")
}

val answer = pandigital.map { pair => pair._1 * pair._2 }.distinct.sum
println(answer)
