/*
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

val length = 1000

var currentFibonacci = 2
var currentValue = Array.fill[Int](length) { 0 }
currentValue(0) = 1

var lastValue = Array.fill[Int](length) { 0 }
lastValue(0) = 1

var nextValue = Array.fill[Int](length) { 0 }


while (currentValue(length - 1) == 0) {
  // Make nextValue by summing currentValue and lastValue
  for (i <- (0 to length-1)) {
    nextValue(i) = currentValue(i) + lastValue(i)
  }

  val tmp = lastValue
  lastValue = currentValue
  currentValue = nextValue
  nextValue = tmp

  currentFibonacci += 1

  // Fix the carries.
  for (i <- (0 to length-1)) {
    if (currentValue(i) > 9) {
      val carry = currentValue(i) / 10
      currentValue(i) %= 10
      currentValue(i + 1) += carry
    }
  }
}

val answer = currentFibonacci
println(answer)
