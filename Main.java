import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите номер задания");
        int TaskNumber = in.nextInt();
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
    }
    
    static void NumberOne() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите входные данные");
        String Towers_string = in.next();
        int WorkAreaTower = in.nextInt();
        Vector<Integer> Towers = new Vector<Integer>();
        int AmountOfTower = 0;
        for (int i = 0; i < Towers_string.length(); i++) {
            if (Towers_string.charAt(i) == '0') {
                Towers.add(0);
            }
            if (Towers_string.charAt(i) == '1') {
                Towers.add(1);
            }
            AmountOfTower = AmountOfTower + 1;
        }
        for (int i = 0; i < AmountOfTower; i++) {
            if (Towers_string.charAt(i) == '1') {
                for (int j = 1; j <= WorkAreaTower; j++) {
                    if ((i + j) < AmountOfTower) Towers.set(i + j, 1);
                    if ((i - j) >= 0) Towers.set(i - j, 1);
                }
            }
        }
        boolean IsNotZero = true;
        for (int Tower : Towers) {
            if (Tower == 0) {
                IsNotZero = false;
                break;
            }
        }
        if (IsNotZero == true) System.out.println("Yes");
        if (IsNotZero == false) System.out.println("No");
    }

   static class Pair<T, U> {
        T first;
        U second;

         Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }   

    static void TheLongestWay(Pair<String, String> Route, List<Pair<String, String>> StartEndPoints, StringBuilder LastPoint, int[] LengthPath, int[] MaxLengthPath) {
        for (Pair<String, String> Path : StartEndPoints) {
            if (Route.second.equals(Path.first)) {
                LengthPath[0] += 1;
                TheLongestWay(Path, StartEndPoints, LastPoint, LengthPath, MaxLengthPath);
            }
        }
        if (MaxLengthPath[0] < LengthPath[0]) {
            MaxLengthPath[0] = LengthPath[0];
            LastPoint.setLength(0);
            LastPoint.append(Route.second);
            LengthPath[0] = 0;
        }
    }

    public static void NumberTwo() {
        List<Pair<String, String>> StartEndPoints = new ArrayList<>();
        StartEndPoints.add(new Pair<>("Новосибирск", "Дубай"));
        StartEndPoints.add(new Pair<>("Дубай", "Улан-Удэ"));
        StartEndPoints.add(new Pair<>("Искитим", "Лондон"));
        StartEndPoints.add(new Pair<>("Дубай", "Искитим"));
        StartEndPoints.add(new Pair<>("Лондон", "Стамбул"));
        StartEndPoints.add(new Pair<>("Новосибирск", "Линево"));

        StringBuilder LastPoint = new StringBuilder();
        int[] LengthPath = {0};
        int[] MaxLengthPath = {0};

        for (Pair<String, String> Route : StartEndPoints) {
            LengthPath[0] = 0;
            TheLongestWay(Route, StartEndPoints, LastPoint, LengthPath, MaxLengthPath);
        }

        System.out.println(LastPoint);
    }

    static boolean IsLengthEven(int Number) {
        int Length = 0;
        int absNumber = Math.abs(Number);
        for (; absNumber > 0; absNumber = absNumber / 10) {
            Length += 1;
        }
        if (Length % 2 == 0) return true;
        else return false;
    }
    
    static void NumberThree() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите числа, после введения всех чисел введите 0");
        int AmountNmbrsEvenLngth = 0;
        for (; true; ) {
            int Number = in.nextInt();
            if (Number == 0) break;
            if (IsLengthEven(Number) == true) AmountNmbrsEvenLngth += 1;
        }
        System.out.println(AmountNmbrsEvenLngth);
    }
    
}

