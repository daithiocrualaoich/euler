/*
 * Truncatable Primes
 * ==================
 * The number 3797 has an interesting property. Being prime itself, it is
 * possible to continuously remove digits from left to right, and remain prime
 * at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from left to
 * right and right to left.
 *
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */

import kotlin.math.sqrt

/**
 * Returns true if the receiving collection contains none of the specified
 * elements.
 *
 * (https://stackoverflow.com/questions/48096204/in-kotlin-how-to-check-contains-one-or-another-value)
 *
 * @param elements the elements to look for in the receiving collection.
 * @return true if no element in [elements] is found in the receiving
 *         collection.
 */
fun <T> Collection<T>.containsAny(vararg elements: T): Boolean {
    return any(elements.toSet()::contains)
}

/**
 * Returns the prefixes of the receiving List.
 */
fun <T> List<T>.prefixes(): List<List<T>> {
  return indices.map { i -> slice(0..i) }
}

/**
 * Returns the suffixes of the receiving List.
 */
fun <T> List<T>.suffixes(): List<List<T>> {
  return indices.map { i -> slice(i..lastIndex) }
}

/**
 * Get the closest integer below the square root of [n].
 *
 * @retur n floor(sqrt(n))
 */
fun isqrt(n: Int): Int {
  return sqrt(n.toFloat()).toInt()
}

/**
 * Determine if [n] is prime by trial division.
 */
fun isPrime(n: Int): Boolean {
  return n > 1 && (2..isqrt(n)).all { d -> n % d != 0 }
}

/**
 * Expand [n] into a list of single digit integers.
 */
fun digitExpansion(n: Int): List<Int> {
  return if (n < 10) {
    listOf(n)
  } else {
    digitExpansion(n / 10) + (n % 10)
  }
}

/**
 * Determine if [n] is a left- and right-truncatable prime.
 */
fun isTruncatablePrime(n: Int): Boolean {
  // Single digit primes cannot be truncatable.
  if (n < 10) {
    return false
  }

  // Calculate left and right truncations.
  val digits = digitExpansion(n)
  val expansions: List<List<Int>> = digits.prefixes() + digits.suffixes()
  val truncations: List<Int> = expansions.map { expansion: List<Int> ->
    expansion.joinToString("").toInt()
  }

  // And test truncations are primes.
  return truncations.all { t -> isPrime(t) }
}

val integers = generateSequence(1) { it + 1 }
val truncatablePrimes = integers.filter { isTruncatablePrime(it) }

// The question tells us there are only 11 truncatable primes.
val answer = truncatablePrimes.take(11).sumBy { it } // = 748,317
println(answer)
