/*
    Написати фрагмент коду: отримати бінарне значення у змінній (uint32) за символьним представленням десяткового числа, наприклад “5555”.
    Приклад: "543" => 543 та ...1000011111 (посимвольно перевели у int, '3'*10^0 + '4'*10^1 + '5'*10^2)
    Модифікувати фрагмент коду для введення значення в будь-якій системі числення 2<=n<=16 (для позначення цифр >=10 a-f)
    Приклад: a='543', b=16 => 1347 та ...10101000011 ('3'*16^0 + '4'*16^1 + '5'*16^2)
    Модифікувати фрагмент коду для підтримки від’ємних значень (такі мають символьне представлення, що починається з “-”, наприклад “-5555”).
    Приклад: a='-543', b=16 => -1347 та бінарний вигляд у доповнювальному коді
 */

public class Task2 {
    public static void main(String[] args) {
        System.out.println(signedRadixStringToLong("543", 16));
    }

    public static long radixStringToLong(String str, int radix){
        long res = 0;
        for(int i = 0; i < str.length(); i++){
            res *= radix;
            res += charToLong(str.charAt(i));
        }
        return res;
    }

    private static long charToLong(char ch){
        if(Character.isDigit(ch)){
            return ch - '0';
        }
        else{
            return ch - 'A' + 10;
        }
    }

    public static long signedRadixStringToLong(String str, int radix){
        boolean isSigned = str.charAt(0) == '-';
        if(!isSigned){
            return radixStringToLong(str, radix);
        }
        else {
            long res = radixStringToLong(str.substring(1), radix);
            res ^= 0xFFFF_FFFF; // get twos complement
            res += 1;
            return res;
        }
    }
}
