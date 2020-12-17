/*
 * Counting Sundays
 * ================
 * You are given the following information, but you may prefer to do some
 * research for yourself.
 *
 * - 1 Jan 1900 was a Monday.
 * - Thirty days has September,
 * - April, June and November.
 * - All the rest have thirty-one,
 * - Saving February alone,
 * - Which has twenty-eight, rain or shine.
 * - And on leap years, twenty-nine.
 * - A leap year occurs on any year evenly divisible by 4, but not on a century
 *   unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 */

case class Date(year: Int, month: Int, day: Int) {
  lazy val isLeapYear: Boolean = {
    (year % 100 != 0 && year % 4 == 0) || year % 400 == 0
  }

  lazy val nextDate: Date = {
    (isLeapYear, month, day) match {
      // February in a regular year
      case (false, 2, 28) => Date(year, month + 1, 1)

      // February in a leap year
      case (true, 2, 29) => Date(year, month + 1, 1)

      // April, June, September, and November.
      case (_, 4, 30) => Date(year, month + 1, 1)
      case (_, 6, 30) => Date(year, month + 1, 1)
      case (_, 9, 30) => Date(year, month + 1, 1)
      case (_, 11, 30) => Date(year, month + 1, 1)

      // New year rollover.
      case (_, 12, 31) => Date(year + 1, 1, 1)

      // All the rest have 31.
      case (_, _, 31) => Date(year, month + 1, 1)

      // No rollover case.
      case _ => Date(year, month, day + 1)
    }
  }
}

var date = Date(1900, 1, 1)
var weekday = 1 // Sunday = 0, Monday = 1, ...

// Advance to 1 Jan 1901
while (date.year < 1901) {
  weekday = (weekday + 1) % 7
  date = date.nextDate
}

// Count weekday == 0, day == 1 combinations while year < 2001.
var sundays = 0
while (date.year < 2001) {
  if (weekday == 0 && date.day == 1) {
    sundays += 1
  }

  weekday = (weekday + 1) % 7
  date = date.nextDate
}

val answer = sundays // = 171
println(answer)
