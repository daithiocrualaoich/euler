/*
 *  Multiples of 3 and 5
 *  ====================
 *  If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 *  get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 *  Find the sum of all the multiples of 3 or 5 below 1000.
 */

trait NumberTheory {
  fn divides(&self, n: u32) -> bool;
}

impl NumberTheory for u32 {
  fn divides(&self, n: u32) -> bool { n % *self == 0 }
}

fn main() {
  // Don't include 1000 in this strange Fizz Buzz.
  let multiples = (1..1000).
    filter(|n: &u32| 3.divides(*n) || 5.divides(*n));

  let answer: u32 = multiples.fold(0, |sum: u32, n: u32| sum + n);
  println!("{}", answer);
}

