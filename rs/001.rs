/*
 *  Multiples of 3 and 5
 *  ====================
 *  If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 *  get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 *  Find the sum of all the multiples of 3 or 5 below 1000.
 */

fn is_divisible_by(n: u32, d: u32) -> bool {
  n % d == 0
}

fn main() {
  // Don't include 1000 in this strange Fizz Buzz.
  let multiples = (1..1000).
    filter(|n| is_divisible_by(*n, 3) || is_divisible_by(*n, 5));

  let answer = multiples.fold(0, |sum, n| sum + n);
  println!("{}", answer);
}

