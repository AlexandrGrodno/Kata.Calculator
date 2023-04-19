import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] romNumber = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        String[] keyRomNamber = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] vals = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        int firstNumber = 0;
        int secondNumber = 0;
        int arithmeticResult = 0;
        int ind = 0;
        boolean firstRomeNumberFlag = false;
        boolean secondRomeNumberFlag = false;
        boolean signFlag = false;
        StringBuilder result = new StringBuilder();
        Scanner string = new Scanner(System.in);
        String line = string.nextLine();
        String[] lines = line.split(" "); // /Определение элементов строки .
          // определение римских чисел
        for (var i = 0; i < romNumber.length; i++) {
            if (romNumber[i].equals(lines[0])) {
                firstNumber = i + 1;
                firstRomeNumberFlag = true;
            }

                if (romNumber[i].equals(lines[2])) {
                    secondNumber =
                            i+ 1;
                    secondRomeNumberFlag = true;
                }
            }
            // проверка значений строки
        if ((firstRomeNumberFlag && !secondRomeNumberFlag) || (!firstRomeNumberFlag && secondRomeNumberFlag)) {
            throw new Exception("Вы ввели не правильные значения!");
        }

        if (!firstRomeNumberFlag &&!secondRomeNumberFlag) {
            try {
                firstNumber = Integer.parseInt(lines[0]);
                secondNumber = Integer.parseInt(lines[2]);
                } catch ( NumberFormatException e) {
                throw new Exception("Вы ввели не правильные значения!") ;
            }

        }
        if ((firstNumber >10) || (secondNumber > 10) || (firstNumber < 1) || (secondNumber < 1)){
        throw new Exception("Вы ввели не правильные значения!");
        }
            // Вычисление результата
        switch (lines[1]) {
            case "+" -> {
                arithmeticResult = firstNumber + secondNumber;
                signFlag = true;
            }
            case "-" -> {
                arithmeticResult = firstNumber - secondNumber;
                signFlag = true;
            }
            case "*" -> {
                arithmeticResult = firstNumber * secondNumber;
                signFlag = true;
            }
            case "/" -> {
                arithmeticResult = firstNumber / secondNumber;
                signFlag = true;
            }
        }
         if (!signFlag) {
             throw new Exception(" неверный знак ");}
     if (firstRomeNumberFlag && secondRomeNumberFlag) {
         if (arithmeticResult < 1) {
             throw new Exception("Результат вычисления римских чисел меньше единицы");
         }
            // Вычисление римских чисел
         while (ind < keyRomNamber.length) {
             while (arithmeticResult >= vals[ind]) {
                 var d = arithmeticResult / vals[ind];
                 arithmeticResult = arithmeticResult % vals[ind];
                 for (int i = 0; i < d; i++)
                    result.append(keyRomNamber[ind]);
             }
             ind++;
         }
     } else result.append(arithmeticResult);

     System.out.println("Ответ: " + result);



    }
}