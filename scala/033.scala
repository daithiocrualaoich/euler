/*
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician
 * in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which
 * is correct, is obtained by cancelling the 9s.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 *
 * There are exactly four non-trivial examples of this type of fraction, less
 * than one in value, and containing two digits in the numerator and
 * denominator.
 *
 * If the product of these four fractions is given in its lowest common terms,
 * find the value of the denominator.
 */

// The fractions have double digit numerators and denominators, with a
// denominator that is strictly larger than the numerators. (Since the
// fraction must be less than one in value.) So 10/11 is the example with the
// smallest possible denominator.
//
// Iterate the denominator from 11 to 99 and consider all numerators between
// 10 and denominator - 1 inclusive.
//
// Eliminate 30/50 type candidates by checking if numerator and denominator
// both divide 10.
//
// Then expand the digits and do naive cancellation.
//
//


def digitExpansion(n: Int): List[Int] = n match {
  case _ if n < 10 => List(n)
  case _ =>
    digitExpansion(n / 10) :+ (n % 10)
}

def gcd(n: Long, m: Long): Long = {
  // Euclid's insanely beautiful greatest common divisor algorithm.
  var a = n
  var b = m

  while (b > 0) {
    val t = b
    b = a % t
    a = t
  }

  a
}


val candidates = for (
  denominator <- 11 until 100;
  numerator <- 10 until denominator;
  if !(numerator % 10 == 0 && denominator % 10 == 0)
) yield { (numerator, denominator) }

// Perform naive cancellation, keeping only those fractions which have an
// actual naive cancellation.
val cancelled = candidates.flatMap { case (numerator, denominator) =>
  // Because the two numbers can only be double digit, it is easier to do the
  // cancellation manually.
  val List(n1, n2) = digitExpansion(numerator)
  val List(d1, d2) = digitExpansion(denominator)

  // Test if the first digit in the numerator can be cancelled.
  // Note that the fraction is not 1 so the second digits will
  // have to be different.
  if (n1 == d1) {
    Some(numerator, denominator, n2, d2)
  } else if (n2 == d2) {
    Some(numerator, denominator, n1, d1)
  } else if (n1 == d2) {
    Some(numerator, denominator, n2, d1)
  } else if (n2 == d1) {
    Some(numerator, denominator, n1, d2)
  } else {
    // No cancellation
    None
  }
}

// We don't need to reduce the fractions to lowest form to check equality.
//
//  n/d = n'/d'  => nd' = dn'
//
// So we check cross multiplication results are equal.
val curious = cancelled.filter { case (numerator, denominator, naiveNumerator, naiveDenominator) =>
  numerator * naiveDenominator == denominator * naiveNumerator
}

// For calculating the product, use the naively cancelled terms since they
// are already reduced to single digit terms. (And are equal to the original
// fractions, of course.)

val productNumerator = curious.map { case (_, _, naiveNumerator, _) => naiveNumerator }.product
val productDenominator = curious.map { case (_, _, _, naiveDenominator) => naiveDenominator }.product

// Express the product in lowest terms and take the denominator as the answer.
val answer = productDenominator / gcd(productNumerator, productDenominator)
println(answer)
