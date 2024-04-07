
isLengthEven :: Int -> Bool
isLengthEven number = even (length (show (abs number)))

numberThree :: IO ()
numberThree = do
    putStrLn "Введите числа, после ввода всех чисел введите 0"
    let countEvenLength = countEvenLengthHelper 0
    countEvenLength

countEvenLengthHelper :: Int -> IO ()
countEvenLengthHelper count = do
    number <- readLn
    if number == 0
        then print count
        else do
            let newCount = if isLengthEven number then count + 1 else count
            countEvenLengthHelper newCount

main :: IO ()
main = do
    numberThree