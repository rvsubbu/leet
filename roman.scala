/* Convert Roman Numeral to number and vice versa */

def romanToNum(roman: String): Int = {
  val romanMap = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)
  var res: Int = 0

  for (i <- 0 to roman.size-1) {
    val curr = roman(i)
    val currNum = romanMap(curr)
    res += currNum
    if (i > 0) {
      val prev = roman(i-1)
      val prevNum = romanMap(prev)
      if (prevNum < currNum) res -= 2*prevNum
    }
  }
  res
}

def numToRoman(num: Int): String = {
  val romanInts = Array(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
  val romanMap = Map(1 -> "I", 4 -> "IV", 5 -> "V", 9 -> "IX", 10 -> "X", 40 -> "XL", 50 -> "L", 90 -> "XC", 100 -> "C", 400 -> "CD", 500 -> "D", 900 -> "CM", 1000 -> "M")
  var res: String = ""
  var curr: Int = num

  while (curr > 0) {
    var found: Boolean = false
    for (i <- romanInts; if !found) {
      if (curr >= i) {
        res += romanMap(i)
        curr -= i
        found = true
      }
    }
  }
  res
}

def test(): Unit = {
  for (i <- 1 to 2000) {
    val s: String = numToRoman(i)
    val n: Int = romanToNum(s)
    assert(n == i)
  }
  println("All tests passed")
}

test()

