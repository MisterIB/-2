import java.util.*
fun NumberOne() {
    val scan = Scanner(System.`in`)
    println("Введите входные данные")
    var Towers_string: String = scan.next()
    var WorkAreaTower: Int = scan.nextInt()
    var Towers = Vector<Int>()
    var AmountOfTower: Int = 0
    for (Tower in Towers_string) {
        if (Tower == '0') {
            Towers.add(0)
        }
        if (Tower == '1') {
            Towers.add(1)
        }
        AmountOfTower = AmountOfTower + 1;
    }
    for (i in 0..AmountOfTower - 1) {
        if (Towers_string[i] == '1') {
            for (j in 1..WorkAreaTower) {
                if ((i + j) < AmountOfTower) Towers[i + j] = 1;
                if ((i - j) >= 0) Towers[i - j] = 1;
            }
        }
    }
    var IsNotZero: Boolean = true;
    for (Tower in Towers) {
        if (Tower == 0) {
            IsNotZero = false;
            break;
        }
    }
    if (IsNotZero == true) println("Yes")
    if (IsNotZero == false) println("No")
}

fun theLongestWay(route: Pair<String, String>, startEndPoints: List<Pair<String, String>>, lastPoint: StringBuilder, lengthPath: Int, maxLengthPath: Int): Int {
    var currentLengthPath = lengthPath
    var currentMaxLengthPath = maxLengthPath

    for (path in startEndPoints) {
        if (route.second == path.first) {
            currentLengthPath += 1
            currentMaxLengthPath = theLongestWay(path, startEndPoints, lastPoint, currentLengthPath, currentMaxLengthPath)
        }
    }

    if (currentMaxLengthPath < currentLengthPath) {
        currentMaxLengthPath = currentLengthPath
        lastPoint.setLength(0)
        lastPoint.append(route.second)
        currentLengthPath = 0
    }

    return currentMaxLengthPath
}

fun NumberTwo() {
    val startEndPoints = listOf(
        Pair("123", "456"),
        Pair("789", "101112"),
        Pair("456", "789"),
        Pair("456", "9080"),
        Pair("9080", "1040"),
        Pair("101112", "098")
    )
    val lastPoint = StringBuilder()
    var lengthPath = 0
    var maxLengthPath = 0

    for (route in startEndPoints) {
        lengthPath = 0
        maxLengthPath = theLongestWay(route, startEndPoints, lastPoint, lengthPath, maxLengthPath)
    }

    println(lastPoint)
}

fun IsLengthEven(Number: Int): Boolean {
    var Length: Int = 0
    var absNumber: Int = Math.abs(Number)
    while(absNumber > 0) {
        Length += 1;
        absNumber = absNumber / 10
    }
    if (Length % 2 == 0) return true;
    else return false;
}

fun NumberThree() {
    val scan = Scanner(System.`in`)
    println("Введите числа, после введения всех чисел введите 0")
    var AmountNmbrsEvenLngth: Int = 0
    while (true) {
        var Number: Int = scan.nextInt()
        if (Number == 0) break;
        if (IsLengthEven(Number) == true) AmountNmbrsEvenLngth += 1;
    }
    println(AmountNmbrsEvenLngth)
}

fun main(){
    val scan = Scanner(System.`in`)
    println("Выберите номер задания")
    var TaskNumber: Int = scan.nextInt()
    if (TaskNumber == 1) NumberOne()
    else if (TaskNumber == 2) NumberTwo()
    else if (TaskNumber == 3) NumberThree()
}