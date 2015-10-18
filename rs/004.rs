/* 
 * Largest palindrome product
 * ==========================
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 x 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

trait NumberTheory {
  fn is_palindromic(&self) -> bool;
}

impl NumberTheory for u32 {
  fn is_palindromic(&self) -> bool {
    // Test for palindromic numbers by converting to strings and reversing.
    let n: u32 = *self;
    let reverse: Vec<char> = n.to_string().chars().rev().collect();
    let chars: Vec<char> = n.to_string().chars().collect();
    reverse == chars
  }
}

fn main() {
  // Form all the products of two 3-digit numbers.
  let mut products = vec![];
  for n in 100..1000 {
    for m in 100..1000 {
      products.push(n * m);
    }
  }

  // Filter nonpalindromic numbers.
  let palindromes = products.iter().filter(|n: &&u32| (**n).is_palindromic());
  
  // And take the maximum.
  let answer = palindromes.max().unwrap();
  println!("{}", answer);
}
