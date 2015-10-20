/*
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 *
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom in p067_triangle.txt, a 15K text
 * file containing a triangle with one-hundred rows.
 *
 */

// Read p067_triangle.txt to Array[Array[Int]]
val lines = scala.io.Source.fromFile("p067_triangle.txt").getLines
val tree = lines.toArray map { _.split(" ").map { _.toInt } }

//
// Build up from the bottom row. The maximum total for top to bottom for the
// subtree located at each of the bottom row nodes is the value in the node.
// For an internal now, the maximum total from it to the bottom is the value in
// the node plus the maximum total in the nodes adjacent to it in the next row.
//

// Mutate `tree` into a maximum heights structure row by row.
for {
  row <- (0 to tree.length-1).reverse.drop(1)
  column <- (0 to row)
} {
  tree(row)(column) += Math.max(
    tree(row+1)(column),
    tree(row+1)(column+1)
  )
}

val answer = tree(0)(0)
println(answer)
