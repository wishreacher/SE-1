/*
    Написати фрагмент коду: вивести в консоль значення (uint32) змінної у бінарному вигляді (за основою 2) шляхом ділення на 2 та виведення остачі.
    Наприклад:
    uint32 a = 7   => 111
    uint32 a = 5   => 101
    Якщо мова не має unsigned integer, використовуємо long.
    Модифікувати фрагмент коду для виведення значення в будь-якій системі числення 2<=n<=16 (для позначення >=10 використовувати a-f).
    Наприклад:
    uint32 a = 17; b=16  => 11 (а - число в десятковій, b - система числення в яку треба перевести a)
    Модифікувати фрагмент коду для виведення знакового бінарного числа у доповнювальному коді (uint32) в будь якій системі числення  2<=n<=16  (від'ємні значення виводити як "-" + абсолютне значення числа). Не можна використовувати знаковий тип даних (int32).
    Наприклад:
    uint32 a = 0xFFFFFFF0, b=10 => -16 (а - бінарне число, b - система числення в яку треба перевести a)
 */
public class Task1 {
    public static void main(String[] args) {
        String binary = toRadix(17, 2);

        System.out.println(toRadixSigned(0xFFFFFFF0L, 10));
    }

    public static String toRadix(long value, int radix) {
        StringBuilder sb = new StringBuilder();
        while (value != 0) {
            long remainder = value % radix;
            sb.insert(0, longToChar(remainder));
            value /= radix;
        }
        return sb.toString();
    }

    public static String toRadixSigned(long value, int radix) {
       if((value &= 0x80000000) == 0) {
           return toRadix(value, radix);
       }
       else {
           return "-" + toRadix(getOnesComplement(value), radix);
       }
    }

    private static long getOnesComplement(long value) {
        value ^= 0xFFFF_FFFFL;
        value += 1;
        return value;
    }

    private static char longToChar(long value) {
        if (value < 10) {
            return (char) ('0' + value);
        } else {
            return (char) ('A' + value - 10);
        }
    }

    private static double getFirstBit(long value) {
        return value & 1;
    }
}
