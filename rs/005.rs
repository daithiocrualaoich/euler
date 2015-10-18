/* 
 * Smallest multiple
 * =================
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 */

fn gcd(n: u64, m: u64) -> u64 {
  // Euclid's insanely beautiful greatest common divisor algorithm.
  let mut a = n;
  let mut b = m;

  while b > 0 {
    let t = b;
    b = a % t;
    a = t;
  }

  a
}

fn lcm(n: u64, m: u64) -> u64 {
  n * m / gcd(n, m)
}

fn main() {
  // Lowest common multiple can be calculated piecewise. Uses Euclid's Algorithm
  // to calculate greatest common divisors and form lowest common multiples.
  let answer = (1..21).fold(1, |acc, n| lcm(acc, n));
  println!("{}", answer);
}
