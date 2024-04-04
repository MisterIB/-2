package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func NumberOne() {
	fmt.Println("Введите входные данные")
	reader := bufio.NewReader(os.Stdin)
	TowersString, _ := reader.ReadString('\n')
	TowersString = strings.TrimSpace(TowersString)
	var WorkAreaTower int
	fmt.Scanln(&WorkAreaTower)
	Towers := make([]int, len(TowersString))
	for i, char := range TowersString {
		if char == '0' {
			Towers[i] = 0
		} else if char == '1' {
			Towers[i] = 1
		}
	}
	for i, tower := range Towers {
		if tower == 1 {
			for j := 1; j <= WorkAreaTower; j++ {
				if i+j < len(Towers) {
					Towers[i+j] = 1
				}
				if i-j >= 0 {
					Towers[i-j] = 1
				}
			}
		}
	}
	var isNotZero = true
	for _, tower := range Towers {
		if tower == 0 {
			isNotZero = false
			break
		}
	}
	if isNotZero {
		fmt.Println("Yes")
	} else {
		fmt.Println("No")
	}
}

func main() {
	//NumberThree()
	//NumberTwo()
	NumberOne()
}
