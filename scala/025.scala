/*
 * 1000-Digit Fibonacci Number
 * ===========================
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 *    Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 *
 * Hence the first 12 terms will be:
 *
 *    F1 = 1
 *    F2 = 1
 *    F3 = 2
 *    F4 = 3
 *    F5 = 5
 *    F6 = 8
 *    F7 = 13
 *    F8 = 21
 *    F9 = 34
 *    F10 = 55
 *    F11 = 89
 *    F12 = 144
 *
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000
 * digits?
 */

// 1000 digits will overflow 64 bit arithmetic so we calculate this by column.

val digits = 1000

var currentFibonacci = 2
var currentValue = Array.fill[Int](digits) { 0 }
currentValue(0) = 1

var previousValue = Array.fill[Int](digits) { 0 }
previousValue(0) = 1

var nextValue = Array.fill[Int](digits) { 0 }

// Iterate until have a 1,000 digit Fibonacci number.
while (currentValue(digits - 1) == 0) {
  // Make nextValue by summing currentValue and previousValue.
  for (i <- (0 to digits-1)) {
    nextValue(i) = currentValue(i) + previousValue(i)
  }

  // Move currentValue -> previousValue, nextValue -> currentValue.
  val tmp = previousValue
  previousValue = currentValue
  currentValue = nextValue
  // And recycle the previousValue array for nextValue since reference copies.
  nextValue = tmp

  currentFibonacci += 1

  // Fix the carries.
  for (i <- (0 to digits-1)) {
    if (currentValue(i) > 9) {
      val carry = currentValue(i) / 10
      currentValue(i) %= 10
      currentValue(i + 1) += carry
    }
  }
}

val answer = currentFibonacci // = 4,782
println(answer)
