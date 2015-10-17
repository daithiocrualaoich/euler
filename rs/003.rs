/*
 *  Largest prime factor
 * ====================
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */

fn is_divisible_by(n: u64, d: u64) -> bool {
  n % d == 0
}

fn prime_factors(n: u64) -> Vec<u64> {
  let mut factors: Vec<u64> = vec![2];

  let mut factor: u64 = 2;
  let mut quotient: u64 = n;

  while quotient > 1 {
    if is_divisible_by(quotient, factor) {
      factors.push(factor);
      quotient = quotient / factor;
    } else {
      factor = factor + 1;
    }
  }

  factors.sort();

  factors
}

fn main() {
  // Prime decomposition and a sequence maximum will take care of this.
  let factors = prime_factors(600851475143);
  let answer = factors.iter().max().unwrap();
  println!("{}", answer);
}
