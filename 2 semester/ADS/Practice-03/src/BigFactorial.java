/*
    Створити клас з методом, що буде обраховувати факторіал додатнього цілого числа.
    Працювати з BigInteger (в цьому класі немає методу main він буде в подальшому
    використовуватися в інших програмах).
 */

public class BigFactorial {
    public static java.math.BigInteger factorial(int n) {
        java.math.BigInteger result = java.math.BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(java.math.BigInteger.valueOf(i));
        }
        return result;
    }
}
