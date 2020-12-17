/*
 * Largest Palindrome Product
 * ==========================
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 x 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

// Test for palindromic numbers by converting to strings and reversing.
implicit class Int2IsPalindromic(n: Int) {
  val isPalindromic: Boolean = n.toString.reverse == n.toString
}

// Form all the products of two 3-digit numbers.
val products = for {
  n <- 100 to 999
  m <- 100 to 999
} yield n * m

// Filter nonpalindromic numbers.
val palindromes = products filter { _.isPalindromic }

// And take the maximum.
val answer = palindromes.max // = 906,609
println(answer)
