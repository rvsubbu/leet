/*
Number of ways to climb a flight of n steps, taking 1, 2 or 3 steps at a time
Write a function to compute the number of ways to climb a flight of n steps. Taking 1, 2, or 3 steps at a time. Do it in Linear time and constant space.
Example: n = 3 4 ways to do this: 1+1+1, 1+2, 2+1, 3
1+3,2+2,3+1, 1+1+2,1+2+1,2+1+1,1+1+1+1 Insight: This is just a recurrence relation
F(1) = 1
F(2) = 2 (1+1 OR 2)
F(3) = 4 (1+1+1, 1+2, 2+1, 3)
F(n) = F(n-1)+ F(n-2) + F(n-3)
*/

package main

import (
	"fmt"
	"strconv"
)

func CountWays(n int) int {
	if (n < 1) {
		return 0
	}
	if (n == 1) {
		return 1
	}
	if (n == 2) {
		return 2
	}
	if (n == 3) {
		return 4
	}
    return CountWays(n-3) + CountWays(n-2) + CountWays(n-1)
}

func testCountWays() {
	var inputs  = [...] int{0, 1, 2, 3, 4}
	var outputs = [...] int{0, 1, 2, 4, 7}
    for i := 0; i < len(inputs); i++ {
        var result = CountWays(inputs[i])
        if (result != outputs[i]) {
            panic("Test Failed for input " + strconv.Itoa(inputs[i]) +
                  ": Expected "             + strconv.Itoa(outputs[i]) +
                  ", got "                 + strconv.Itoa(result))
		}
	}
    fmt.Println("All tests passed\n")
}

func main() {
    testCountWays()
}
