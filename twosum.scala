def twoSum(nums: Array[Int], target: Int): Array[Int] = {
  val mymap = scala.collection.mutable.Map[Int, Int]()
  var ans1: Int = -1
  var ans2: Int = -1
  var i: Int = 0
  nums.foreach(num => {
    if (ans1 == -1 && mymap.contains(num)) {
      ans1 = mymap(num)
      ans2 = i
    }
    mymap(target-num) = i
    i += 1
  })
  Array(ans1, ans2)
}
