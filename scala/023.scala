/*
 * Non-Abundant Sums
 * =================
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect
 * number.
 *
 * A number n is called deficient if the sum of its proper divisors is less
 * than n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 */

implicit class Int2Divides(d: Int) {
  def divides(n: Int): Boolean = n % d == 0
}

implicit class Int2IsAbundant(n: Int) {
  lazy val divisors: Seq[Int] = (1 to n-1) filter { _ divides n }
  lazy val isAbundant: Boolean = divisors.sum > n
}

val limit = 28123

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

// Find all abundant numbers <= 28,123.
// val abundants = (1 to limit) filter { _.isAbundant }
val abundants = (1 to limit) filter { n => divisorSums(n) > n }

// Assume all numbers <= 28,123 are non abundant sums and delete all sums of
// abundants.
val nonAbundantSums = Array.fill[Boolean](limit + 1) { true }

for {
  i <- 0 to abundants.length - 1
} {
  // Since the abundants are sorted in increasing order, only need consider
  // sums above index i in the left term by symmetry.
  var j = i
  var sum = abundants(i) + abundants(j)

  // Can stop early when exceeded sum limit since following term sums will be
  // larger again.
  while (sum <= limit && j < abundants.length) {
    nonAbundantSums(sum) = false

    // Update j, sum for next iteration avoiding out of bounds indexing.
    j += 1
    if (j < abundants.length) {
      sum = abundants(i) + abundants(j)
    }
  }
}

val nonAbundants = (nonAbundantSums.zipWithIndex collect {
  case (true, index) => index
})

val answer = nonAbundants.sum // = 4,179,871
println(answer)
