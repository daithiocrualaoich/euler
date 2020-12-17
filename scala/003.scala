/*
 * Largest Prime Factor
 * ====================
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143?
 */

import scala.collection.mutable.ArrayDeque

implicit class Long2Divides(d: Long) {
  def divides(n: Long): Boolean = n % d == 0
}

implicit class Long2PrimeFactors(n: Long) {
  lazy val primeFactors: List[Long] = {
    val factors = ArrayDeque[Long]()

    var factor = 2L
    var quotient = n

    while (quotient > 1) {
      if (factor divides quotient) {
        factors += factor
        quotient /= factor
      } else {
        factor += 1
      }
    }

    factors.sorted.toList
  }
}

val answer = 600851475143L.primeFactors.max // = 6,857
println(answer)
