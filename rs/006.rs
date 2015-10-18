/*
 * Sum square difference
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

fn main() {
  // Straightforward list comprehensions and sums.
  let sum = (1..101).fold(0, |sum, n| sum + n);
  let sum_squares = (1..101).map(|n| n * n).fold(0, |sum, n| sum + n);

  let answer = sum*sum - sum_squares;
  println!("{}", answer);
}
