#include <iostream>
#include <vector>

void NumberOne() {
	std::cout << "Введите входные данные" << std::endl;
	std::string Towers_string;
	std::cin >> Towers_string;
	int WorkAreaTower;
	std::cin >> WorkAreaTower;
	std::vector<int> Towers;
	int AmountOfTower = 0;
	for (int i = 0; Towers_string[i] != '\0'; i++) {
		if (Towers_string[i] == '0') {
			Towers.push_back(0);
		}
		if (Towers_string[i] == '1') {
			Towers.push_back(1);
		}
		AmountOfTower = AmountOfTower + 1;
	}
	for (int i = 0; i < AmountOfTower; i++) {
		if (Towers_string[i] == '1') {
			for (int j = 1; j <= WorkAreaTower; j++) {
				if ((i + j) < AmountOfTower) Towers[i + j] = 1;
				if ((i - j) >= 0) Towers[i - j] = 1;
			}
		}
	}
	bool IsNotZero = true;
	for (int Tower : Towers) {
		if (Tower == 0) {
			IsNotZero = false;
			break;
		}
	}
	if (IsNotZero == true) std::cout << "Yes";
	if (IsNotZero == false) std::cout << "No";
}

int TheLongestWay(std::pair<std::string, std::string> Route, std::vector<std::pair<std::string, std::string>> StartEndPoints, std::string& LastPoint, int& LengthPath, int& MaxLengthPath) {
	for (std::pair<std::string, std::string> Path : StartEndPoints) {
		if (Route.second == Path.first) {
			LengthPath += 1;
			TheLongestWay(Path, StartEndPoints, LastPoint, LengthPath, MaxLengthPath);
		}
	}
	if (MaxLengthPath < LengthPath) {
		MaxLengthPath = LengthPath;
		LastPoint = Route.second;
	}
	return 1;
}

void NumberTwo() {
	std::vector<std::pair<std::string, std::string>> StartEndPoints { {"123", "456"}, {"789", "101112"}, {"456", "789"}};
	std::string LastPoint;
	int LengthPath = 0;
	int MaxLengthPath = 0;
	for (std::pair<std::string, std::string> Route: StartEndPoints) {
		LengthPath = 0;
		TheLongestWay(Route, StartEndPoints, LastPoint, LengthPath, MaxLengthPath);
	}
	std::cout << LastPoint;
}

bool IsLengthEven(int Number) {
	int Length = 0;
	int absNumber = abs(Number);
	for (; absNumber > 0; absNumber = absNumber / 10) {
		Length += 1;
	}
	if (Length % 2 == 0) return true;
	else return false;
}

void NumberThree() {
	std::cout << "Введите числа, после введения всех чисел введите 0" << std::endl;
	int AmountNmbrsEvenLngth = 0;
	for (; true; ) {
		int Number;
		std::cin >> Number;
		if (Number == 0) break;
		if (IsLengthEven(Number) == true) AmountNmbrsEvenLngth += 1;
	}
	std::cout << AmountNmbrsEvenLngth;
}

int main() {
	system("chcp 1251");
	system("cls");
	std::cout << "Выберите номер задания" << std::endl;
	int TaskNumber;
	std::cin >> TaskNumber;
	switch (TaskNumber) {
	case 1:
		NumberOne();
		break;
	case 2:
		NumberTwo();
		break;
	case 3:
		NumberThree();
		break;
	default:
		break;
	}
	return 0;
}