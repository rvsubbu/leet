/*
LeetCode, Problem 452: Minimum Number of Arrows to Burst Balloons
There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.
*/

def findMinArrowShots(points: Array[Array[Int]]) : Int = {
  var res: Int = 0
  if (!points.isEmpty) {
    val sorted = points.sortBy(_(1))
    var y = sorted(0)(1)
	res += 1
    for (point <- sorted) {
      if (point(0) > y) {
        y = point(1)
        res += 1
      }
    }
  }
  return res
}

val test1 = Array(Array(10,16), Array(2,8), Array(1,6), Array(7,12))
println(findMinArrowShots(test1))
