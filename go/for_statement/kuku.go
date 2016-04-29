/* kuku.go */

package main

import "fmt"

func main() {
	for x := 1; x <= 9; x++ {
		for y := 1; y <= 9; y++ {
			r := x * y
			fmt.Printf(" %2d", r)
		}
		fmt.Println()
	}
}

