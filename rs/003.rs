/*
 *  Largest prime factor
 * ====================
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */

trait NumberTheory {
  fn divides(&self, n: u64) -> bool;
  fn prime_factors(&self) -> Vec<u64>;
}

impl NumberTheory for u64 {
  fn divides(&self, n: u64) -> bool { n % *self == 0}
  
  fn prime_factors(&self) -> Vec<u64> {
    let mut factors: Vec<u64> = vec![];
  
    let mut factor: u64 = 2;
    let mut quotient: u64 = *self;
  
    while quotient > 1 {
      if factor.divides(quotient) {
          factors.push(factor);
          quotient = quotient / factor;
      } else {
        factor = factor + 1;
      }
    }
  
    factors.sort();
  
    factors
  }
}

fn main() {
  // Prime decomposition and a sequence maximum will take care of this.
  let factors = 600851475143.prime_factors();
  let answer = factors.iter().max().unwrap();
  println!("{}", answer);
}
