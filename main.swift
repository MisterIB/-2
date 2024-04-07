// Задача 1
func numberOne() {
    print("Введите входные данные")
    var towersString: String // Входная строка
    towersString = readLine()!
    var workAreaTower: Int // Зона работы вышки
    workAreaTower = Int(readLine()!)!
    var towers = [Int]()
    var amountOfTower = 0 // Количество вышек
    for tower in towersString {
        if tower == "0" {
            towers.append(0)
        }
        if tower == "1" {
            towers.append(1)
        }
        amountOfTower += 1 // Считаем количество вышек
    }
    for i in 0..<amountOfTower {
        if towers[i] == 1 {
            for j in 1..<workAreaTower {
                if i + j < amountOfTower { towers[i + j] = 1 }
                if i - j >= 0 { towers[i - j] = 1 }
            }
        }
    }
    var isNotZero = true
    for i in 0..<amountOfTower {
        if towers[i] == 0 {
            isNotZero = false
            break
        }
    }
    if isNotZero {
        print("Yes")
    } else {
        print("No")
    }
}

func theLongestWay(route: (String, String), startEndPoints: [(String, String)], lastPoint: inout String, lengthPath: inout Int, maxLengthPath: inout Int) {
    for path in startEndPoints {
        if route.1 == path.0 {
            lengthPath += 1
            theLongestWay(route: path, startEndPoints: startEndPoints, lastPoint: &lastPoint, lengthPath: &lengthPath, maxLengthPath: &maxLengthPath)
        }
    }
    if maxLengthPath < lengthPath {
        maxLengthPath = lengthPath
        lastPoint = route.1
        lengthPath = 0
    }
}

// Задача 2
func numberTwo() {
    let startEndPoints = [("Новосибирск", "Дубай"), ("Новосибирск", "Искитим"), ("Искитим", "Линево"), ("Искитим", "Лондон"), ("Лондон", "Стамбул"), ("Дубай", "Улан-Удэ")]
    var lastPoint = "" // Переменная для сохранения результата
    var lengthPath = 0 // Длина пути
    var maxLengthPath = 0 // Максимальная длина пути
    for route in startEndPoints {
        lengthPath = 0
        theLongestWay(route: route, startEndPoints: startEndPoints, lastPoint: &lastPoint, lengthPath: &lengthPath, maxLengthPath: &maxLengthPath)
    }
    print(lastPoint)
}

func isLengthEven(number: Int) -> Bool {
    var length = 0
    var absNumber = abs(number)
    while absNumber > 0 {
        absNumber = absNumber / 10
        length += 1
    }
    return length % 2 == 0
}

// Задача 3
func numberThree() {
    print("Введите числа, после введения всех чисел введите 0")
    var amountNmbrsEvenLngth = 0 // Количество чисел четной длины
    while true {
        let number = Int(readLine()!) ?? 0
        if number == 0 { break }
        if isLengthEven(number: number) { amountNmbrsEvenLngth += 1 }
    }
    print(amountNmbrsEvenLngth)
}

print("Выберите номер задания")
if let taskNumber = Int(readLine()!) {
    switch taskNumber {
    case 1:
        numberOne()
    case 2:
        numberTwo()
    case 3:
        numberThree()
    default:
        break
    }
}