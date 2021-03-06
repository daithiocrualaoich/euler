/*
 * Reciprocal Cycles
 * =================
 * A unit fraction contains 1 in the numerator. The decimal representation of
 * the unit fractions with denominators 2 to 10 are given:
 *
 *   1/2  = 0.5
 *   1/3  = 0.(3)
 *   1/4  = 0.25
 *   1/5  = 0.2
 *   1/6  = 0.1(6)
 *   1/7  = 0.(142857)
 *   1/8  = 0.125
 *   1/9  = 0.(1)
 *   1/10 = 0.1
 *
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be
 * seen that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest recurring
 * cycle in its decimal fraction part.
 */

// What matters for determining cycles in a decimal expansion is the remainder
// being carried at each position, not the actual value at each position in
// the expansion.
//
// If the remainder is 0, then the decimal expansion is terminating.
//
// If the remainder is the same as a previous remainder then this delimits a
// recurring cycle in the expansion.

def decimalExpansion(d: Int): Iterator[Int] = new Iterator[Int] {
  var remainder = 1

  override def hasNext: Boolean = remainder != 0
  override def next(): Int = {
    remainder *= 10
    val result = remainder / d
    remainder %= d

    result
  }
}

def decimalExpansionRemainders(d: Int): Iterator[Int] = new Iterator[Int] {
  var remainder = 1

  override def hasNext: Boolean = remainder != 0
  override def next(): Int = {
    remainder *= 10
    remainder %= d

    remainder
  }
}

def decimalExpansionRecurringCycleLength(d: Int): Int = {
  val remainders: Iterator[Int] = decimalExpansionRemainders(d)

  // When dividing by d the remainder will always be less than d. So there are
  // d possible values for the remainder, i.e. zero up to d-1. And once a
  // remainder value is repeated then a cycle will continue from there.
  //
  // If we take the first d+1 remainders from the iterator then we know there
  // must be a repeated remainder.

  val remaindersList: List[Int] = remainders.take(d + 1).toList

  // Case 1: If the last remainder in the list is 0 then the expansion was
  //         terminating and there is no recurring cycle.
  if (remaindersList.last == 0) {
    0
  } else {
    // Case 2: There is a cycle. So find the first repeated remainder value.

    // Note that we can search forward from remainder values to the end of the
    // list. Because suppose the remainders were something like:
    //
    //   n...m.m...n...
    //
    // i.e. a shorter cycle contained within the cycle beginning at the first
    // remainder and searching forward. Then there would have to be an n
    // between the two m's. Otherwise the m to m cycle would repeat and there
    // would never be a following n.
    //
    // Similarly there cannot be a shorter cycle bridging the second n, e.g.:
    //
    //   n...m.n...m...
    //
    // i.e. where m...n...m is shorter than n...m...n. In fact they both must
    // have the same length because they both contain the same subsegments.
    //
    //    n...m.n => contains n...m and m.n
    //    m.n...m => contains m.n and n...m

    val cycle = remaindersList.tails.find {
      case cycleStart :: followingRemainders => followingRemainders.contains(cycleStart)
    }

    // Now determine the length of the cycle from the evidence tail. i.e. the
    // evidence may be longer than necessary and contain additional trailing
    // remainders. Note: cycle cannot be None so .get is safe.
    cycle.get match {
      case cycleStart :: followingRemainders => followingRemainders.indexOf(cycleStart) + 1
    }
  }
}

val answer = (2 to 1000).maxBy { decimalExpansionRecurringCycleLength } // = 983
println(answer)
