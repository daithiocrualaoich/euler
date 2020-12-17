/*
 * Sum Square Difference
 * =====================
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 */

// There are formulas for sum of integers and sum of integer squares:
//
//   1 + 2 + 3 + ... + n= n(n+1)/2
//   1^2 + 2^2 + ... + n^2 = n(n+1)(2n+1)/6
//
// But as easy to calculate it out.

val sum = (1 to 100).sum
val sumSquares = (1 to 100).map { n => n * n }.sum

val answer = sum*sum - sumSquares // = 25,164,150
println(answer)
