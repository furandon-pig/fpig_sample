/* type.go */

package main

import "fmt"

func main() {
	/*
	 * int8, int16, int32, int64,
	 * int -> int32(32bit env),int64(64bit)
	 * byte, uint8, uint32, uint64,
	 * float32, float64,
	 * complex64, complex128
	 */
	var a int = 10
	var (
		b, c = 20, 30
		d, e = 20.22, 30.33
	)

	fmt.Println(a)
	fmt.Println(b)
	fmt.Println(c)
	fmt.Println(d)
	fmt.Println(e)

	/* local variable */
	local_a := 100
	local_hello := "hello"
	local_world := "world"
	local_str := local_hello + "," + local_world

	fmt.Println(local_a)
	fmt.Println(local_str)
}

