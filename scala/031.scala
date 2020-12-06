/*
 * In the United Kingdom the currency is made up of pound (£) and pence (p).
 * There are eight coins in general circulation:
 *
 *   1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
 *
 * It is possible to make £2 in the following way:
 *
 *   1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 *
 * How many different ways can £2 be made using any number of coins?
 */

// Look at this in terms of finding the number of nodes in the following tree:
//
//  * There is a root node with child nodes labelled for each of the coin
//    denominations, 200, 100, 50, 20, 10, 5, 2, 1.
//  * A node cannot have any descendent nodes labelled with a coin denomination
//    larger than its value.
//  * A node will have a child node of a given coin denomination if the sum of
//    that and all node coin denominations ancestors does not exceed 200.
//
// And depth-first search to count the tree elements.

def countCoinSums(target: Int, coins: List[Int]): Int = {
  val childNodeCoinSums = coins.map { coin =>
    if (coin > target) {
      // Base case: Can't make the target if this coin is included.
      0
    } else if (coin == target) {
      // Base case: Found a unique combination of coins.
      1
    } else {
      // Only include smaller or equal coins in descendants.
      countCoinSums(target - coin, coins.filter { _ <= coin })
    }
  }
  
  childNodeCoinSums.sum
}

val answer = countCoinSums(200, List(200, 100, 50, 20, 10, 5, 2, 1))
println(answer)
