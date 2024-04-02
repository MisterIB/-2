def NumberOne():
    print("Введите входные данные")
    Towers_string = input()
    WorkAreaTower = int(input())
    Towers = []
    AmountOfTower = 0
    for i in range(0, len(Towers_string)):
        if Towers_string[i] == '0':
            Towers.append(0)
        if Towers_string[i] == '1':
            Towers.append(1)
        AmountOfTower = AmountOfTower + 1
    for i in range(0, AmountOfTower):
        if Towers_string[i] == '1':
            for j in range(1, WorkAreaTower + 1):
                if (i + j) < AmountOfTower: Towers[i + j] = 1
                if (i - j) >= 0: Towers[i - j] = 1
    IsNotZero = True
    for Tower in Towers:
        if Tower == 0:
            IsNotZero = False
            break
    if IsNotZero == True:
        print("Yes")
    if IsNotZero == False:
        print("No")
def IsLengthEven(Number):
    Length = 0
    absNumber = abs(Number)
    while (absNumber > 0):
        Length = Length + 1
        absNumber = absNumber // 10
    if Length % 2 == 0:
        return True
    else:
        return False

def NumberThree():
    print("Введите числа, после введения всех чисел введите 0")
    AmountNmbrsEvenLngth = 0
    while (True):
        Number = int(input())
        if Number == 0:
            break
        if IsLengthEven(Number) == True:
            AmountNmbrsEvenLngth += 1
    print(AmountNmbrsEvenLngth)

print("Выберите номер задания")
TaskNumber = int(input())
match TaskNumber:
    case 1:
        NumberOne()
    case 2:
        print("")
    case 3:
        NumberThree()