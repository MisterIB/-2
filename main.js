function NumberOne() {
	alert("Введите входные данные");
	let Towers_string = prompt();
	let WorkAreaTower = prompt();
    let Towers = [];
	let AmountOfTower = 0;
	for (let i = 0; i < Towers_string.length; i++) {
		if (Towers_string[i] == '0') {
			Towers[i] = 0;
		}
		if (Towers_string[i] == '1') {
			Towers[i] = 1;
		}
		AmountOfTower = AmountOfTower + 1;
	}
	for (let i = 0; i < AmountOfTower; i++) {
		if (Towers_string[i] == '1') {
			for (let j = 1; j <= WorkAreaTower; j++) {
				if ((i + j) < AmountOfTower) Towers[i + j] = 1;
				if ((i - j) >= 0) Towers[i - j] = 1;
			}
		}
	}
	let IsNotZero = true;
    Towers.forEach((Tower)=>{
		if (Tower == 0) {
			IsNotZero = false;
		}
	})
	if (IsNotZero == true) alert("Yes");
	if (IsNotZero == false) alert("No");
}

function TheLongestWay(Route, StartEndPoints, LastPoint, LengthPath, MaxLengthPath) {
	for (Path of StartEndPoints) {
		if (Route[1] == Path[0]) {
			LengthPath.lp += 1;
			TheLongestWay(Path, StartEndPoints, LastPoint, LengthPath, MaxLengthPath);
		}
	}
	if (MaxLengthPath.mlp < LengthPath.lp) {
		MaxLengthPath.mlp = LengthPath.lp;
		LastPoint.lp = Route[1];
		LengthPath.lp = 0;
	}
}

function NumberTwo() {
    const StartEndPoints = [
        ["Новосибирск", "Дубай"],
        ["Дубай", "Улан-Удэ"],
        ["Искитим", "Лондон"],
        ["Дубай", "Искитим"],
        ["Лондон", "Стамбул"],
        ["Новосибирск", "Линево"]
      ];
	const LastPoint = {lp: ""};
	const LengthPath = {lp: 0};
	const MaxLengthPath = {mlp: 0};
	for (Route of StartEndPoints) {
		LengthPath.lp = 0;
		TheLongestWay(Route, StartEndPoints, LastPoint, LengthPath, MaxLengthPath);
	}
	alert(LastPoint.lp);
}

function IsLengthEven(Number) {
	let Length = 0;
	let absNumber = Math.abs(Number);
	for (; absNumber > 0; absNumber = Math.floor(absNumber/10)) {
		Length += 1;
	}
	if (Length % 2 == 0) return true;
	else return false;
}

function NumberThree() {
	alert("Введите числа, после введения всех чисел введите 0");
	let AmountNmbrsEvenLngth = 0;
	while (true) {
		let Number = prompt();
		if (Number == 0) break;
		if (IsLengthEven(Number) == true) AmountNmbrsEvenLngth += 1;
	}
	alert(AmountNmbrsEvenLngth);
}

alert("Выберите номер задания")
let TaskNumber = prompt()
switch(TaskNumber) {
    case '1':
        NumberOne();
        break;
    case '2': 
        NumberTwo();
        break;
    case '3':
        NumberThree();
        break;
    default:
      break;
  }