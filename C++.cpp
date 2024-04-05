#include <iostream>
#include <vector>

void NumberOne() {// Задача 1
	std::cout << "Введите входные данные" << std::endl;
	std::string Towers_string;// Входная строка
	std::cin >> Towers_string;
	int WorkAreaTower;// Зона работы вышки
	std::cin >> WorkAreaTower;
	std::vector<int> Towers;
	int AmountOfTower = 0;// Количество вышек
	for (int i = 0; Towers_string[i] != '\0'; i++) {// Проходимся по вышкам
		if (Towers_string[i] == '0') {
			Towers.push_back(0);
		}
		if (Towers_string[i] == '1') {// Переносим значения из строки в массив
			Towers.push_back(1);
		}
		AmountOfTower = AmountOfTower + 1;// Считаем количество вышек
	}
	for (int i = 0; i < AmountOfTower; i++) {// Проходимся по каждой вышке
		if (Towers_string[i] == '1') {// Рассчитываем какую зону покроют вышки
			for (int j = 1; j <= WorkAreaTower; j++) {
				if ((i + j) < AmountOfTower) Towers[i + j] = 1;
				if ((i - j) >= 0) Towers[i - j] = 1;
			}
		}
	}
	bool IsNotZero = true;
	for (int Tower : Towers) {//Проверка: могут ли все кооперативы пользоваться сотовой связью
		if (Tower == 0) {
			IsNotZero = false;
			break;
		}
	}
	if (IsNotZero == true) std::cout << "Yes";
	if (IsNotZero == false) std::cout << "No";
}

void TheLongestWay(std::pair<std::string, std::string> Route, std::vector<std::pair<std::string, std::string>> StartEndPoints, std::string& LastPoint, int& LengthPath, int& MaxLengthPath) {
	for (std::pair<std::string, std::string> Path : StartEndPoints) {
		if (Route.second == Path.first) {
			LengthPath += 1;
			TheLongestWay(Path, StartEndPoints, LastPoint, LengthPath, MaxLengthPath);
		}
	}
	if (MaxLengthPath < LengthPath) {// Если находим самый длинный путь
		MaxLengthPath = LengthPath;
		LastPoint = Route.second;// Сохраняем конечный пункт
		LengthPath = 0;
	}
}

void NumberTwo() {//Задача 2
	std::vector<std::pair<std::string, std::string>> StartEndPoints{ {"Новосибирск", "Дубай"}, {"Новосибирск", "Искитим"}, {"Искитим", "Линево"}, {"Искитим", "Лондон"}, {"Лондон","Стамбул"}, {"Дубай", "Улан-Удэ"}};
	std::string LastPoint;// Переменная для сохранения результата
	int LengthPath = 0;// Длина пути
	int MaxLengthPath = 0;// Максимальная длина пути
	for (std::pair<std::string, std::string> Route: StartEndPoints) {
		LengthPath = 0;
		TheLongestWay(Route, StartEndPoints, LastPoint, LengthPath, MaxLengthPath);// Функция находит самый длинный путь
	}
	std::cout << LastPoint;
}

bool IsLengthEven(int Number) {// Функция проверяет четная ли длина у числа
	int Length = 0;
	int absNumber = abs(Number);
	for (; absNumber > 0; absNumber = absNumber / 10) {
		Length += 1;
	}
	if (Length % 2 == 0) return true;
	else return false;
}

void NumberThree() {// Задача 3
	std::cout << "Введите числа, после введения всех чисел введите 0" << std::endl;
	int AmountNmbrsEvenLngth = 0; // Количество чисел четной длины
	while (true) {
		int Number;
		std::cin >> Number;// Вводим число
		if (Number == 0) break;
		if (IsLengthEven(Number) == true) AmountNmbrsEvenLngth += 1;// Если четная увеличиваем счетчик
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