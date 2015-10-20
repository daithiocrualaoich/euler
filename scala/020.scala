/*
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */

//
// 100! will overflow 64 bit arithmetic so we calculate this by column.
//

val factorial = 100

val length = factorial*factorial // n! has <= n^2 digits
var currentFactorial = 1
val currentValue = new Array[Int](length)
currentValue(0) = 1

while (currentFactorial < factorial) {
  // Multiple the columns by currentFactorial + 1.
  for (i <- (0 to length-1)) {
    currentValue(i) *= (currentFactorial + 1)
  }
  currentFactorial += 1

  // Fix the carries.
  for (i <- (0 to length-1)) {
    if (currentValue(i) > 9) {
      val carry = currentValue(i) / 10
      currentValue(i) %= 10
      currentValue(i + 1) += carry
    }
  }
}

val answer = currentValue.sum
println(answer)
