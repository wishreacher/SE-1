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
        System.out.println(flipNBit(0b0010, 2));
        System.out.println(countOnes(0xF0));
        System.out.println(isNegative(-10));
        System.out.println(isEven(2));
    }

    private static boolean isEven(long value) {
        return (value & 1) == 0; //перевіряємо останній біт
    }

    private static boolean isNegative(int value) {
        return (value & (1 << 31)) != 0; //перевіряємо знаковий біт
    }

    private static long countOnes(long value) {
        if (value == 0) {
            return value;
        }

        int count = 0;
        while (value != 0) {
            value &= (value - 1); //очищаємо ЛСД
            count++;
        }
        return count;
    }

    private static long flipNBit(long value, int position) {
        return value ^ getMask(position);
    }

    public static long getNBit(long value, int n){
        return value & getMask(n);
    }

    private static long getMask(int n) {
        return 1L << n;
    }
}
