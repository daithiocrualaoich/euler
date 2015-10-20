/*
 * Using p022_names.txt, a 46K text file containing over five-thousand first
 * names, begin by sorting it into alphabetical order. Then working out the
 * alphabetical value for each name, multiply this value by its alphabetical
 * position in the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which is
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 */

import scala.language.{implicitConversions, reflectiveCalls}

implicit def String2AlphabeticalValue(s: String) = new {
  val alphabeticalValue: Int = {
    (s.toUpperCase.toList map { c: Char => c.toInt - 'A'.toInt + 1 }).sum
  }
}

// Read p022_names.txt to Iterator[String]
val lines = scala.io.Source.fromFile("p022_names.txt").getLines
val names = lines flatMap { _.split(",") } map { _.replace("\"", "") }

val sorted = names.toList.sorted

val scores = sorted.zipWithIndex map { case (name, index) =>
  name.alphabeticalValue * (index + 1)
}

val answer = scores.sum
println(answer)
