/*
 * Lexicographic Permutations
 * ==========================
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order. The
 * lexicographic permutations of 0, 1 and 2 are:
 *
 *    012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 */

// The first 9! = 362,880 permutations have a leading 0.
// The next 9! = 362,880 permutations have a leading 1.
//
// => The first 725,760 permutations have a leading 0 or 1.
//
// The next 9! = 362,880 permutations have a leading 2, so the millionth
// lexicographic permutation has a leading 2.
//
// => We need to find the (1,000,000 - 725,760)-th lexicographical permutation
// of 0, 1, 3, 4, 5, 6, 7, 8, 9.
//
// This generalises to a recursive solution.

def factorial(n: Int): Int = (1 to n).product

def findNthLexicographicPermutation(n: Int, elements: Seq[Int]): String = n match {
  case 1 => elements.sorted.mkString

  case _ =>
    val rangeSize = factorial(elements.length - 1)
    val block = (n - 1) / rangeSize

    val sorted = elements.sorted
    val first = sorted(block)

    val remainingN = n - block*rangeSize
    val remainingElements = sorted.take(block) ++ sorted.drop(block + 1)

    first.toString + findNthLexicographicPermutation(remainingN, remainingElements)
}

val answer = findNthLexicographicPermutation(1_000_000, 0 to 9) // = 2,783,915,460
println(answer)
