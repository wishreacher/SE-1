/*
    Створити клас з методом, що буде обраховувати факторіал від 0 до 20 використовуючи кешовані
    результати обчислення факторіалів. Тобто якщо клас до цього порахував факторіал 5,
    то для обрахування факторіала 6 ми можемо скористуватися вже отриманим попереднім результатом.
    Для цього в класі реалізувати статичний масив значень факторіала від 0 до 20, і статичну змінну,
    що буде вказувати на кількість вже обрахованних факторіалів. При спробі обрахувати факторіал
    більше 20 або менше 0 видавати помилку. (в цьому класі немає методу main він буде в подальшому
    використовуватися в інших програмах).
 */
public class CacheFactorial {
    static long[] cache = new long[21];
    static {
        cache[0] = 1L;
    }
    static int calculatedFactorialSteps = 1;

    public long calculate(int n){
        if(n <= calculatedFactorialSteps){
            System.out.println("Factorial value is already in cache!");
            return cache[n];
        } else{
            int lastCalculatedIndex = 0;
            //we need to find the last calculated factorial in cache
            for(int i = n; i >= 0; i--){
                if(cache[i] != 0){
                    lastCalculatedIndex = i;
                    System.out.println("Last calculated factorial is for " + lastCalculatedIndex);
                    break;
                }
            }
            for(int i = lastCalculatedIndex + 1; i <= n; i++){
                System.out.println("Calculating factorial for " + i);
                cache[i] = cache[i - 1] * i;
            }
            calculatedFactorialSteps = n;
            return cache[n];
        }
    }
}