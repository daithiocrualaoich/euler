/*
 * The following iterative sequence is defined for the set of positive integers:
 *
 *    n → n/2 (n is even)
 *    n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following
 * sequence:
 *
 *    13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1)
 * contains 10 terms. Although it has not been proved yet (Collatz Problem), it
 * is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */

import scala.collection.mutable.MutableList
import scala.language.{implicitConversions, reflectiveCalls}

implicit def Int2Divides(d: Int) = new {
  def divides(n: Long): Boolean = n % d == 0
}

def nextCollatz(n: Long): Long = {
  if (2 divides n) {
    n/2
  } else {
    3*n + 1
  }
}

def maxChain(length: Int): Int = {
  //
  // Reuse previous computations for values less than current n.
  //
  val chains: Array[Int] = Array.fill(length) { 0 }
  chains(1) = 1

  (2 to chains.length) map { n =>
    // Calculate the chain, until we reach a value previously calculated.
    val chain = MutableList[Long]()
    var current: Long = n

    // Note that chains can become larger than `length`
    while (current >= chains.length || chains(current.toInt) == 0) {
      // Push current onto chain and update for next in Collatz chain
      chain += current
      current = nextCollatz(current)
    }

    // Find the chain lengths for each new number in the chain.
    val lengths: Map[Long, Int] = chain.reverse.zipWithIndex.toMap mapValues { length =>
      chains(current.toInt) + length + 1
    }

    lengths foreach {
      case (n, length) if n < chains.length => chains(n.toInt) = length
      case _ =>
    }
  }

  val (_, maxIndex) = chains.zipWithIndex.maxBy(_._1)
  
  maxIndex
}

val answer = maxChain(1000000)
println(answer)
