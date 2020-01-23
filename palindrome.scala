/*
 * Project Euler, Problem # 4
 * A palindromic number reads the same both ways. The largest palindrome
 * made from the product of two 2-digit numbers is 9009 = 91 × 99.

 * Find the largest palindrome made from the product of two 3-digit
 * numbers.
 */

def is_palindrome(s: String): Boolean = (s == s.reverse)
def is_palindrome(num: Int): Boolean  = is_palindrome(num.toString)


def get_biggest_palindrome(digits: Int): Int = {
  val start: Int   = scala.math.pow(10, digits).toInt - 1
  var biggest: Int = 0

  var i = start
  while (i > 0 && i * start > biggest) {
    var j = start
    while (j > 0 && j * i > biggest) {
      if (is_palindrome(i*j))
        biggest = i*j
      j -= 1
    }
    i -= 1
  }
  biggest
}

println("9 "   + is_palindrome(9))
println("abc " + is_palindrome("abc"))

println(get_biggest_palindrome(1))
println(get_biggest_palindrome(2))
println(get_biggest_palindrome(3))
