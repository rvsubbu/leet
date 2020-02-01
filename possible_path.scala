/*`
  Hacker Rank, Possible Path

  Problem: Adam is standing at point (a,b) in an infinite 2D grid. He wants to know if he can reach point (x,y) or not. The only operation he can do is to move to point (a+b,b), (a-b,b), (a,b+a), (a, b-a)  from some point (a,b). It is given that he can move to any point on this 2D grid, i.e., the points having positive or negative (or ) co-ordinates.
  Tell Adam whether he can reach (x,y) or not.

  Input Format: The first line contains an integer T, followed by T lines, each containing 4 space-separated integers i.e. a,b, x and y.

  Constraints: 1 <= T <= 100, 1 <= a,b,x,y <= 10^18

  Output Format: For each test case, display YES or NO that indicates if Adam can reach (x,y) or not.

  Sample Input:
    3
    1 1 2 3
    2 1 2 3
    3 3 1 1

  Sample Output:
    YES
    YES
    NO

  Explanation:
    (1,1) -> (2,1) -> (2,3)
    (2,1) -> (2,3)
    No way to reach (1,1) from (3,3)
*/

def gcd(a: Int, b: Int): Int = {
  if (a>b) gcd(b,a)
  if (a==0) b
  else if (a==1) 1
  else gcd(b%a,a)
}

def pathExists(a: Int, b: Int, x: Int, y: Int): String = {
  if (gcd(a,b) == gcd(x,y)) "YES"
  else "NO"
}

def test(): Unit = {
  assert (pathExists(1,1,2,3) == "YES")
  assert (pathExists(2,1,2,3) == "YES")
  assert (pathExists(3,3,1,1) == "NO")
  println("All tests passed for Possible Path")
}

test()
