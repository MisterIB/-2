package main

import (
	"fmt"
)

func NumberOne() {
	fmt.Println("Введите данные")
	var TowersString string
	fmt.Scan(&TowersString)
	var WorkAreaTower int
	fmt.Scan(&WorkAreaTower)
	var Towers []int
	AmountOfTower := 0
	for i := 0; i < len(TowersString); i++ {
		if TowersString[i] == '0' {
			Towers = append(Towers, 0)
		}
		if TowersString[i] == '1' {
			Towers = append(Towers, 1)
		}
		AmountOfTower++
	}
	for i := 0; i < AmountOfTower; i++ {
		if TowersString[i] == '1' {
			for j := 1; j <= WorkAreaTower; j++ {
				if i+j < AmountOfTower {
					Towers[i+j] = 1
				}
				if i-j >= 0 {
					Towers[i-j] = 1
				}
			}
		}
	}
	IsNotZero := true
	for _, Tower := range Towers {
		if Tower == 0 {
			IsNotZero = false
			break
		}
	}
	if IsNotZero {
		fmt.Println("Yes")
	} else {
		fmt.Println("No")
	}
}

func TheLongestWay(Route [2]string, StartEndPoints [][2]string, LastPoint *string, LengthPath, MaxLengthPath *int) {
	for _, Path := range StartEndPoints {
		if Route[1] == Path[0] {
			*LengthPath++
			TheLongestWay(Path, StartEndPoints, LastPoint, LengthPath, MaxLengthPath)
		}
	}
	if *MaxLengthPath < *LengthPath {
		*MaxLengthPath = *LengthPath
		*LastPoint = Route[1]
		*LengthPath = 0
	}
}

func NumberTwo() {
	StartEndPoints := [][2]string{{"Новосибирск", "Дубай"}, {"Дубай", "Искитим"}, {"Лондон", "Стамбул"}, {"Искитим", "Лондон"}, {"Дубай", "Улан-Удэ"}, {"Новосибирск", "Линево"}}
	var LastPoint string
	LengthPath := 0
	MaxLengthPath := 0
	for _, Route := range StartEndPoints {
		LengthPath = 0
		TheLongestWay(Route, StartEndPoints, &LastPoint, &LengthPath, &MaxLengthPath)
	}
	fmt.Println(LastPoint)
}

func IsLengthEven(Number int) bool {
	Length := 0
	for Number > 0 {
		Length++
		Number = Number / 10
	}
	if Length%2 == 0 {
		return true
	}
	return false
}

func NumberThree() {
	fmt.Println("Введите все числа, для продолжения введите 0")
	AmountNmbrsEvenLngth := 0
	for {
		var Number int
		fmt.Scan(&Number)
		if Number == 0 {
			break
		}
		if IsLengthEven(Number) {
			AmountNmbrsEvenLngth++
		}
	}
	fmt.Println(AmountNmbrsEvenLngth)
}

func main() {
	fmt.Println("Выберите номер задания")
	var TaskNumber int
	fmt.Scan(&TaskNumber)
	switch TaskNumber {
	case 1:
		NumberOne()
	case 2:
		NumberTwo()
	case 3:
		NumberThree()
	default:
	}
}
