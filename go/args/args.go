/* args.go */

package main

import (
	"fmt"
	"os"
	"strings"
)

func main() {
	fmt.Println(os.Args);
	fmt.Println(len(os.Args));
	fmt.Println(strings.Join(os.Args, ","))

	// for _, arg := range os.Args { ... }
	for i, arg := range os.Args {
		fmt.Println(i, ":", arg)
	}
}

