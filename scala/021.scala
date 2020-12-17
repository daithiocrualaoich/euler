/*
 * Amicable Numbers
 * ================
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n).
 *
 * If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair
 * and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */

implicit class Int2Divides(d: Int) {
  def divides(n: Int): Boolean = n % d == 0
}

implicit class Int2Divisors(n: Int) {
  lazy val divisors: Seq[Int] = (1 to n-1) filter { _ divides n }
}

def d(n: Int): Int = n.divisors.sum

val limit = 9999

// Precalculate the divisor sums by marking off multiples of each divisor
// instead of performing all possible candidate divisions each time.
val divisorSums = Array.fill(limit + 1) { 0 }

for (divisor <- 1 to limit / 2) {
  // Divisors must be smaller than the number they divide itself so start from
  // next multiple up when marking them off in divisorSums.
  var divides = 2 * divisor
  while (divides < limit) {
    divisorSums(divides) += divisor
    divides += divisor
  }
}

val amicablePairs = divisorSums.zipWithIndex filter {
  case (sum, index) if sum <= index =>
    // Require index < sum to avoid double counting.
    false

  case (sum, index) if sum < divisorSums.length =>
    // Have already precalcuated the divisor sum for the pair here.
    index < sum && divisorSums(sum) == index

  case (sum, index) =>
    // It just happens that none of the amicable numbers < 10,000 are amicable
    // with a number >= 10,000. But this is the (slow) manual check in case
    // there was such an instance.
    d(sum) == index
}

val amicables = amicablePairs flatMap { case (a, b) => List(a, b) }

val answer = amicables.sum // = 31,626
println(answer)
