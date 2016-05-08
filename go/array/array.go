/* array.go */

package main

import "fmt"

func main() {
	var a [4]int
	b := [...]int{ 10, 20, 30, 40, 50 }
	var c [6]int = [6]int{ 1, 2, 3, 4, 5, 6 }

	fmt.Println(a)
	fmt.Println(b)
	fmt.Println(c)

	fmt.Println("---")
	fmt.Println(len(a))
	fmt.Println(len(b))
	fmt.Println(len(c))

	fmt.Println("---")
	b[1] = b[1] * 10
	c[2] = c[2] * 100
	fmt.Println(b)
	fmt.Println(c)
}

