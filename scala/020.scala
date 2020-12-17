/*
 * Factorial Digit Sum
 * ===================
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */

// 100! will overflow 64 bit arithmetic so we calculate this by column.

def factorialDigitSum(factorial: Int): Long = {
  val digits = factorial*factorial // n! has <= n^2 digits

  var currentFactorial = 1
  val currentValue = Array.fill(digits) { 0 }
  currentValue(0) = 1

  while (currentFactorial < factorial) {
    // Multiple the columns by currentFactorial + 1.
    for (i <- (0 to digits-1)) {
      currentValue(i) *= (currentFactorial + 1)
    }
    currentFactorial += 1

    // Fix the carries.
    for (i <- (0 to digits-1)) {
      if (currentValue(i) > 9) {
        val carry = currentValue(i) / 10
        currentValue(i) %= 10
        currentValue(i + 1) += carry
      }
    }
  }

  currentValue.sum
}

val answer = factorialDigitSum(100) // = 648
println(answer)
