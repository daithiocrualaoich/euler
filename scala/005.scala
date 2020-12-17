/*
 * Smallest Multiple
 * =================
 * 2520 is the smallest number that can be divided by each of the numbers from
 * 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 */

def gcd(n: Long, m: Long): Long = {
  var a = n
  var b = m

  while (b > 0) {
    val t = b
    b = a % t
    a = t
  }

  a
}

def lcm(n: Long, m: Long): Long = n * m / gcd(n, m)

// Lowest common multiple can be calculated piecewise. Uses Euclid's Algorithm
// to calculate greatest common divisors and form lowest common multiples.
val answer = (1L to 20L).reduce { (n: Long, m: Long) => lcm(n, m) } // = 232,792,560
println(answer)
