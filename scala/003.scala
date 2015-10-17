/*
 * Largest prime factor
 * ====================
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */

import scala.collection.mutable.MutableList
import scala.language.{implicitConversions, reflectiveCalls}

implicit def Long2Divides(d: Long) = new {
    def divides(n: Long): Boolean = n % d == 0
}

implicit def Long2PrimeFactors(n: Long) = new {
  val primeFactors: List[Long] = {
    val factors = MutableList[Long]()

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

// Prime decomposition and a sequence maximum will take care of this.

val answer = 600851475143L.primeFactors.max
println(answer)
