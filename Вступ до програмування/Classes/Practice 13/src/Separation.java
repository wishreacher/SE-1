/*
    Великі числа при друку прийнято розділяти комами.
    Так наприклад число один мільйон при друку має виглядати - 1,000,000.
    Напишіть програму, що на вхід приймає число (саме число, INT),
    а на вихід виводить число в наведеному вище форматі.
    Числа мають зчитуватися до тих пір, поки користувач не введе 0.
    String.valueOf використовувати не можна.

    * File: Separation.java
    * Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

public class Separation extends ConsoleProgram {
    public void run() {
        while (true) {
            int number = readInt("Enter number: ");
            if (number == 0) {
                break;
            }
            println(separate(number));
        }
    }

    //separates number with commas
    private String separate(int number) {
        boolean isNegative = false;
        if (number < 0) {
            isNegative = true;
            number = -number;
        }

        String result = "";
        int count = 0;
        while (number > 0) {
            if (count == 3) {
                result = "," + result;
                count = 0;
            }
            result = number % 10 + result;
            number /= 10;
            count++;
        }

        if (isNegative) {
            result = "-" + result;
        }

        return result;
    }
}
