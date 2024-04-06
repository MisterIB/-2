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

fun theLongestWay(Route: Pair<String, String>, StartEndPoints: List<Pair<String, String>>, lastPoint: StringBuilder, lengthPath: Int, maxLengthPath: Int): Int {
    var currentLengthPath = lengthPath
    var currentMaxLengthPath = maxLengthPath

    for (Path in StartEndPoints) {
        if (Route.second == Path.first) {
            currentLengthPath += 1
            currentMaxLengthPath = theLongestWay(Path, StartEndPoints, lastPoint, currentLengthPath, currentMaxLengthPath)
        }
    }

    if (currentMaxLengthPath < currentLengthPath) {
        currentMaxLengthPath = currentLengthPath
        lastPoint.setLength(0)
        lastPoint.append(Route.second)
        currentLengthPath = 0
    }

    return currentMaxLengthPath
}

fun NumberTwo() {
    val StartEndPoints = listOf(
        Pair("Новосибирск", "Дубай"),
        Pair("Дубай", "Искитим"),
        Pair("Дубай", "Улан-Удэ"),
        Pair("Искитим", "Лондон"),
        Pair("Лондон", "Стамбул"),
        Pair("Новосибирск", "Искитим")
    )
    val lastPoint = StringBuilder()
    var lengthPath = 0
    var maxLengthPath = 0

    for (Route in StartEndPoints) {
        lengthPath = 0
        maxLengthPath = theLongestWay(Route, StartEndPoints, lastPoint, lengthPath, maxLengthPath)
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