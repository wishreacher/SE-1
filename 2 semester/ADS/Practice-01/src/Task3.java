/*
    Завдання 3. В двохвимірному масиві дійсних чисел знайти мінімальний та максимальний елементи.
    Масив задати генерацією псевдовипадкових чисел. Результат вивести на консоль.
 */
import java.util.Random;

public class Task3 {
    public static void main(String[] args){
        int[][] arr = new int[3][3];
        SillyUtils.fillArrayRandomly(arr);
        System.out.println("Generated array: ");
        SillyUtils.printArray(arr);
        System.out.println("Min: " + getMin(arr));
        System.out.println("Max: " + getMax(arr));
    }

    public static int getMin(int[][] arr){
        int min = arr[0][0];
        for(int[] i : arr){
            for(int j : i){
                if(j < min){
                    min = j;
                }
            }
        }
        return min;
    }

    public static int getMax(int[][] arr){
        int max = arr[0][0];
        for(int[] i : arr){
            for(int j : i){
                if(j > max){
                    max = j;
                }
            }
        }
        return max;
    }
}