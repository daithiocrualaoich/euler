/*
 * Calculate the size of {a^b | 2 <= a <= 100, 2 <= b <= 100}
 */

import scala.math.BigInt

implicit class Crossable[X](xs: Traversable[X]) {
  def cross[Y](ys: Traversable[Y]) = for { x <- xs; y <- ys } yield (x, y)
}

val n = 100
val coefficients = (2 to n).cross(2 to n)
val powers = coefficients.map { case (a, b) => BigInt(a).pow(b) }

val answer = powers.toSet.size
println(answer)
