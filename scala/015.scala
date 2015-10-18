/*
 * Starting in the top left corner of a 2×2 grid, and only being able to move to
 * the right and down, there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 */

//
// There are 20 + 20 steps to be taken, 20 of which must be to the right, the
// rest have to be down. There are (40 choose 20) ways of picking which moves
// are to the right. i.e.
//
//    40! / (20! * 20!)
//
// But even 20! overflows 64 bit arithmetic so we have to calculate this
// recursively.
//
//      (Base) The number of paths from (x, 20) to (20, 20) is 1.
//      (Base) The number of paths from (20, y) to (20, 20) is 1.
//
// (Inductive) The number of paths from (x, y) to (20, 20) is number of paths
//             from (x+1, y) to (20, 20) plus the number of paths from (x, y+1)
//             to (20, 20)
//
// There is a lot of recalculation in the naive recursion so build a table of
// values instead.
//

def paths(x: Int, y: Int, width: Int, height: Int): Long = {
  val paths: Array[Array[Long]] = Array.fill(width + 1) { Array.fill(height + 1) { 0L } }
  
  // Fill in known base values.
  (0 to width) foreach { x => paths(x)(height) = 1L }
  (0 to height) foreach { y => paths(width)(y) = 1L }

  // Work bottom to top, right to left to fill in remaining values.
  for {
    x <- (0 to width - 1).reverse
    y <- (0 to height - 1).reverse
  } {
    paths(x)(y) = paths(x+1)(y) + paths(x)(y+1)
  }
  
  paths(0)(0)
}

val answer = paths(0, 0, 20, 20)
println(answer)
