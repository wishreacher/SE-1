import java.util.Random;

/*
    Завдання 4. Вивести на консоль всі елементи двохвимірного масиву дійсних чисел, які більші за а та менші за b,
    де а та b – введені з консолі цілі числа. Передбачити можливість генерації масиву та введення з консолі.
    Результат, тобто отриманий масив, вивести на консоль
 */
public class Task4 {
    public static void main(String[] args){
        int[][] arr = SillyUtils.generate2DMatrix();

        SillyUtils.fillArrayRandomly(arr);
        System.out.println("Generated array: ");
        SillyUtils.printArray(arr);

        System.out.println("Numbers that are grater than a and less than b will be printed");
        System.out.println("Enter a: ");
        int a = DataInput.getInt();
        System.out.println("Enter b: ");
        int b = DataInput.getInt();

        System.out.println("All numbers less than " + a);
        SillyUtils.printArray(getAllNumbersLess(arr, a));

        System.out.println("All numbers greater than " + b);
        SillyUtils.printArray(getAllNumbersGreater(arr, a));
    }

    public static int[] getAllNumbersLess(int[][] arr, int value){
        int[] result = new int[0];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] < value){
                    result = SillyUtils.addElementToArray(result, arr[i][j]);
                }
            }
        }
        return result;
    }

    public static int[] getAllNumbersGreater(int[][] arr, int value){
        int[] result = new int[0];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] > value){
                    result = SillyUtils.addElementToArray(result, arr[i][j]);
                }
            }
        }
        return result;
    }
}
