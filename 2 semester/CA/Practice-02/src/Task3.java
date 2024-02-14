/*
    Написати фрагменти коду для таких операцій (результат має бути виведено в консоль):

    Для будь якого введеного числа x та n (0<=n<=31)
    1) вивести значення n-го біта
    2) вивести значення числа з переключеним n-м бітом
    3) вивести кількість 1 в бінарному записі числа x
    4) Перевірити, чи є 32-бітне число від’ємним, не використовуючи умову “більше” або “менше”
    5) Перевірити, чи є введене число парним, не використовуючи операцію ділення.
 */

public class Task3 {
    public static void main(String[] args) {
        System.out.println(getNBit(0b0100, 3));
        System.out.println(flipNBit(0b0110, 3));
        System.out.println(countOnes(0b01110));
        System.out.println(isNegative(-10));
        System.out.println(isEven(2));
        System.out.println(isEven(13));
    }

    public static int getNBit(long value, int n){
    }

    public static long flipNBit(long value, int n){
    }

    private static long getMask(int n) {
    }

    public static int countOnes(long value){
    }

    public static boolean isNegative(int value){
    }

    public static boolean isEven(int value){
    }
}
