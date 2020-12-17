/*
 * Power Digit Sum
 * ===============
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 */

// 2^1000 will overflow 64 bit arithmetic so we calculate this columnwise.

def powerDigitSum(exponent: Int): Long = {
  val digits = exponent // 2^n has <= n digits (n > 0)

  var currentExponent = 1
  val currentValue = Array.fill(digits) { 0 }
  currentValue(0) = 2

  while (currentExponent < exponent) {
    // Multiple the columns by 2.
    for (i <- (0 to digits-1)) {
      currentValue(i) *= 2
    }
    currentExponent += 1

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

val answer = powerDigitSum(1000) // = 1,366
println(answer)
