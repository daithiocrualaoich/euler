/*
 * Starting with the number 1 and moving to the right in a clockwise direction
 * a 5 by 5 spiral is formed as follows:
 *
 *     21 22 23 24 25
 *     20  7  8  9 10
 *     19  6  1  2 11
 *     18  5  4  3 12
 *     17 16 15 14 13
 *
 * It can be verified that the sum of the numbers on the diagonals is 101.
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
 * formed in the same way?
 */


// Recursion is the approach here. Given the diagonal sum of a (n-2) x (n-2)
// spiral, we can calculate the corners of the n x n spiral which contains it
// and then add them to the sum.
//
// The new corner values are:
//
//    Top right => n^2
//    Top left => n^2 - (n-1), i.e. n-1 BACK from the top right corner.
//    Bottom left => n^2 - (n-1) - (n-1), i.e. n-1 back from the top left.
//    Bottom right => n^2 - 3*(n-1), i.e. n-1 back from the bottom left.
//
// Summing up the new contributions gives 4*n^2 - 6n + 6.

def numberSpiralDiagonalSum(n: Int): Int = n match {
  case 1 => 1
  case _ => numberSpiralDiagonalSum(n-2) + 4*n*n - 6*n + 6
}

val answer = numberSpiralDiagonalSum(1001)
println(answer)
