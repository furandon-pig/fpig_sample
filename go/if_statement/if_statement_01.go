/* if_statement_01.go */

package main

import "fmt"

func main() {
	i := 0
	for i < 10 {
		if (i % 2) == 0 {
			fmt.Printf("%d: even\n", i)
		} else {
			fmt.Printf("%d: odd\n", i)
		}
		i++
	}
}

