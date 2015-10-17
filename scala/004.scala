/* 
 * Largest palindrome product
 * ==========================
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 x 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

import scala.language.{implicitConversions, reflectiveCalls}

// Test for palindromic numbers by converting to strings and reversing.
implicit def Int2IsPalindromic(n: Int) = new {
  val isPalindromic: Boolean = n.toString.reverse == n.toString
}

// Form all the products of two 3-digit numbers.
val products = for {
  n <- 100 to 1000
  m <- 100 to 1000
} yield n * m

// Filter nonpalindromic numbers.
val palindromes = products filter { _.isPalindromic }

// And take the maximum.
val answer = palindromes.max
println(answer)