func NumberOne() {
	println("Введите входные данные")
	var Towers_string = String()
	Towers_string = readLine()
    var input = readLine()
	var WorkAreaTower = Int(input)
	var Towers = [Int]()
	var AmountOfTower = 0
	for Tower in Towers_string {
		if (Tower == "0") {
			Towers.append(0)
		}
		if (Towers == "1") {
			Towers.append(1)
		}
		AmountOfTower = AmountOfTower + 1
	}
	for i in 0...AmountOfTower {
		if (Towers_string[i] == "1") {
			for j in 1...WorkAreaTower+1 {
				if ((i + j) < AmountOfTower) {
                    Towers[i + j] = 1
                    }
				if ((i - j) >= 0) {
                    Towers[i - j] = 1
                    }
			}
		}
	}
	var IsNotZero = true
	for Tower in Towers {
		if (Tower == 0) {
			IsNotZero = false;
			break;
		}
	}
	if (IsNotZero == true) {
        println("Yes")
        }
	if (IsNotZero == false) {
        println("No")
        }
}
let vegetable = 1
switch vegetable {
case 1:
    NumberOne()
case 2:
    break
case 3:
    break
default:
   break
}