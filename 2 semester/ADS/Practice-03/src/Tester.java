public class Tester {
    public static void main(String[] args) {
        CacheFactorial cacheFactorial = new CacheFactorial();
        while(true){
            System.out.println("Enter a number to calculate its factorial");
            int i = DataInput.getInt();
            if(i < 0){
                System.out.println("Number must be positive");
                continue;
            }
            if(i > 20){
                System.out.println("Number must be less than 20");
                continue;
            }
            if(i == 0){
                System.out.println("Factorial of 0 is 1");
                continue;
            }
            System.out.println("Cache factorial for " + i + " is " + cacheFactorial.calculate(i));
            System.out.println("Big factorial for " + i + " is " + BigFactorial.factorial(i));
        }
    }
}
