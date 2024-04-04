use std::io;
 use std::convert::TryInto;
fn NumberOne() {
	println!("Введите входные данные");
	let mut Towers_string = String::new();
	io::stdin().read_line(&mut Towers_string).unwrap();
	let WorkAreaTower: i32;
	let mut input = String::new();
	io::stdin().read_line(&mut input).unwrap();
	WorkAreaTower = input.trim().parse().expect("");
	let mut Towers = Vec::new();
	let mut AmountOfTower: i32 = -1;
	for Tower in Towers_string.chars() { 
		if Tower == '0' {
			Towers.push(0);
		}
		if Tower == '1' {
			Towers.push(1);
		}
		AmountOfTower = AmountOfTower + 1;
	}
	for i in 0..AmountOfTower {
		if Towers_string.chars().nth(i.try_into().unwrap()) == Some('1') {
			for j in 1..=WorkAreaTower {
				if (i + j) < AmountOfTower {
					Towers[(i + j) as usize] = 1;
				}
				if (i - j) >= 0 {
					Towers[(i - j) as usize] = 1;
				}
			}
		}
	}
	let mut IsNotZero = true;
	for Tower in Towers {
		if Tower == 0 {
			IsNotZero = false;
			break;
		}
	}
	if IsNotZero == true {
		println!("Yes");
	}
	if IsNotZero == false {
		println!("No");
	}
}

fn TheLongestWay(
    Route: (&str, &str),
    StartEndPoints: &[(String, String)],
    LastPoint: &mut String,
    LengthPath: &mut usize,
    MaxLengthPath: &mut usize,
) {
    for Path in StartEndPoints {
        if Route.1 == Path.0 {
            *LengthPath += 1;
            TheLongestWay(
                (Path.0.as_str(), Path.1.as_str()),
                StartEndPoints,
                LastPoint,
                LengthPath,
                MaxLengthPath,
            );
        }
    }
    if *MaxLengthPath < *LengthPath {
        *MaxLengthPath = *LengthPath;
        *LastPoint = Route.1.to_string();
        *LengthPath = 0;
    }
}

fn NumberTwo() {
    let StartEndPoints = vec![
        ("123".to_string(), "456".to_string()),
        ("789".to_string(), "101112".to_string()),
        ("456".to_string(), "789".to_string()),
        ("456".to_string(), "9080".to_string()),
        ("9080".to_string(), "1040".to_string()),
        ("101112".to_string(), "098".to_string()),
    ];
    let mut LastPoint = String::new();
    let mut LengthPath = 0;
    let mut MaxLengthPath = 0;
    for Route in &StartEndPoints {
        LengthPath = 0;
        TheLongestWay(
            (Route.0.as_str(), Route.1.as_str()),
            &StartEndPoints,
            &mut LastPoint,
            &mut LengthPath,
            &mut MaxLengthPath,
        );
    }
    println!("{}", LastPoint);
}

fn IsLengthEven(Number: i32) -> bool {
    let absNumber = Number.abs();
    let Length = absNumber.to_string().len();
    Length % 2 == 0
}

fn NumberThree() {
    println!("Введите числа, после введения всех чисел введите 0");
    let mut AmountNmbrsEvenLngth = 0;
    loop {
        let mut Number = String::new();
        io::stdin().read_line(&mut Number).unwrap();
        let Number: i32 = match Number.trim().parse(){
            Ok(num) => num,
            Err(_) => break,
        };
        if Number == 0 {
            break;
        }
        if IsLengthEven(Number) {
            AmountNmbrsEvenLngth += 1;
        }
    }
    println!("{}", AmountNmbrsEvenLngth);
}

fn main() {
    println!("Выберите номер задания");
    let mut TaskNumber = String::new();
    io::stdin().read_line(&mut TaskNumber).unwrap();
    let TaskNumber: u32 = TaskNumber.trim().parse().unwrap();
    match TaskNumber {
        1 => NumberOne(),
        2 => NumberTwo(),
        3 => NumberThree(),
        _ => (),
    }
}