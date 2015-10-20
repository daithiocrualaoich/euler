/*
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 */

//
// 2^1000 will overflow 64 bit arithmetic so we calculate this by column.
//

val power = 1000

val length = power // 2^n has <= n digits
var currentPower = 0
val currentValue = new Array[Int](length)
currentValue(0) = 1

while (currentPower < power) {
  // Multiple the columns by 2.
  for (i <- (0 to length-1)) {
    currentValue(i) *= 2
  }
  currentPower += 1 

  // Fix the carries.
  for (i <- (0 to length-1)) {
    if (currentValue(i) > 9) {
      currentValue(i) %= 10
      currentValue(i + 1) += 1
    }
  }  
}

val answer = currentValue.sum
println(answer)
