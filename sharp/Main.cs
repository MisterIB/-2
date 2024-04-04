using System;
using System.Collections.Generic;
using System.IO;

class Program
{
    public static void Main()
    {
        Console.WriteLine("Выберите номер задания");
        int TaskNumber = Convert.ToInt32(Console.ReadLine());
        switch (TaskNumber)
        {
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
    static void NumberOne()
    {
        Console.WriteLine("Введите входные данные");
        string Towers_string = Console.ReadLine();
        int WorkAreaTower = Convert.ToInt32(Console.ReadLine());
        List<int> Towers = new List<int>();
        int AmountOfTower = 0;
        for (int i = 0; i < Towers_string.Length; i++)
        {
            if (Towers_string[i] == '0')
            {
                Towers.Add(0);
            }
            if (Towers_string[i] == '1')
            {
                Towers.Add(1);
            }
            AmountOfTower = AmountOfTower + 1;
        }
        for (int i = 0; i < AmountOfTower; i++)
        {
            if (Towers_string[i] == '1')
            {
                for (int j = 1; j <= WorkAreaTower; j++)
                {
                    if ((i + j) < AmountOfTower) Towers[i + j] = 1;
                    if ((i - j) >= 0) Towers[i - j] = 1;
                }
            }
        }
        bool IsNotZero = true;
        foreach (int Tower in Towers)
        {
            if (Tower == 0)
            {
                IsNotZero = false;
                break;
            }
        }
        if (IsNotZero == true) Console.WriteLine("Yes");
        if (IsNotZero == false) Console.WriteLine("No");
    }
    static void TheLongestWay(Tuple<string, string> Route, List<Tuple<string, string>> StartEndPoints, ref string LastPoint, ref int LengthPath, ref int MaxLengthPath)
    {
        foreach (Tuple<string, string> Path in StartEndPoints)
        {
            if (Route.Item2 == Path.Item1)
            {
                LengthPath += 1;
                TheLongestWay(Path, StartEndPoints, ref LastPoint, ref LengthPath, ref MaxLengthPath);
            }
        }
        if (MaxLengthPath < LengthPath)
        {
            MaxLengthPath = LengthPath;
            LastPoint = Route.Item2;
            LengthPath = 0;
        }
    }

    static void NumberTwo()
    {
        List<Tuple<string, string>> StartEndPoints = new List<Tuple<string, string>>()
        { 
        new Tuple<string, string>("123", "456"),
        new Tuple<string, string>("789", "101112"),
        new Tuple<string, string>("456", "789"),
        new Tuple<string, string>("456", "9080"),
        new Tuple<string, string>("9080","1040"),
        new Tuple<string, string>("101112", "098") 
        };
        string LastPoint = "";
        int LengthPath = 0;
        int MaxLengthPath = 0;
        foreach (Tuple<string, string> Route in StartEndPoints)
        {
            LengthPath = 0;
            TheLongestWay(Route, StartEndPoints, ref LastPoint, ref LengthPath, ref MaxLengthPath);
        }
        Console.WriteLine(LastPoint);
    }
    static bool IsLengthEven(int Number)
    {
        int Length = 0;
        int absNumber = Math.Abs(Number);
        for (; absNumber > 0; absNumber = absNumber / 10)
        {
            Length += 1;
        }
        if (Length % 2 == 0) return true;
        else return false;
    }

    static void NumberThree()
    {
        Console.WriteLine("Введите числа, после введения всех чисел введите 0");
        int AmountNmbrsEvenLngth = 0;
        for (; true;)
        {
            int Number = Convert.ToInt32(Console.ReadLine());
            if (Number == 0) break;
            if (IsLengthEven(Number) == true) AmountNmbrsEvenLngth += 1;
        }
        Console.WriteLine(AmountNmbrsEvenLngth);
    }
}