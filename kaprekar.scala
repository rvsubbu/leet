import java.lang.IllegalArgumentException

kaprekarDriver()

def kaprekarDriver(): Unit = {
  var mymap = scala.collection.mutable.Map[Int, Int]()
  var maxSteps: Int = 0
  for (i <- 9999 to 1000 by -1) {
    mymap(i) = kaprekar(i)
    if (maxSteps < mymap(i)) maxSteps = mymap(i)
    println(i, mymap(i))
  }
  println(maxSteps)
}

def kaprekar(n: Int): Int = {
  val KAPREKARS_CONSTANT = 6174
  var mynum: Int = n

  if (mynum > 9999)
    throw new IllegalArgumentException(s"${mynum} too big, > 9999, only 4 digit numbers or less are allowed")
  var steps: Int = 0
  var reached: Boolean = false
  var digits:Array[Int] = new Array[Int](4)
  while (!reached && mynum != KAPREKARS_CONSTANT) {
    for (i <- 0 to 3) digits(i) = 0
    var i: Int = 0
    for (d <- mynum.toString.map(_.asDigit).toArray) {
      digits(i) = d
      i += 1
    }
    if ( digits(0) == digits(1) &&
         digits(0) == digits(2) &&
         digits(0) == digits(3) ){
      reached = true
    } else {
      digits = digits.sorted
      val smaller: Int = digits(0) * 1000 + digits(1) * 100 +
                         digits(2) * 10   + digits(3)
      val bigger: Int  = digits(3) * 1000 + digits(2) * 100 +
                         digits(1) * 10   + digits(0)
      mynum = bigger - smaller
      steps += 1
    }
  }
  steps
}
