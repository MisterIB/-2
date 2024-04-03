import (
	"fmt"
	"os"
	"strings"
)
func NumberOne() {
	fmt.Fprintln(os.Stdout, "Введите входные данные")
	var Towers_string string
	fmt.Fscan(os.Stdin, &Towers_string)
	var WorkAreaTower int
	fmt.Fscan(os.Stdin, &WorkAreaTower)
	var Towers []int
	var AmountOfTower int = 0;
	for i := 0; i < len(Towers_string); i++ {
		if (Towers_string[i] == '0') {
			Towers = append(Towers, 0)
		}
		if (Towers_string[i] == '1') {
			Towers = append(Towers, 1)
		}
		AmountOfTower = AmountOfTower + 1;
	}
	for i := 0; i < AmountOfTower; i++ {
		if (Towers_string[i] == '1') {
			for (int j = 1; j <= WorkAreaTower; j++) {
				if ((i + j) < AmountOfTower) Towers[i + j] = 1;
				if ((i - j) >= 0) Towers[i - j] = 1;
			}
		}
	}
	var IsNotZero bool = true;
	for Tower := range Towers {
		if (Tower == 0) {
			IsNotZero = false;
			break;
		}
	}
	if (IsNotZero == true) fmt.Fprintln(os.Stdout, "Yes")
	if (IsNotZero == false) fmt.Fprintln(os.Stdout, "No")
}
func main() {
	//NumberThree()
	//NumberTwo()
	NumberOne()
}
