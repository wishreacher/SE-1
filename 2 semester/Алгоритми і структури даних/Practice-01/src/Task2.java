/*
    Завдання 2. Знайти середньоарифметичне значення елементів одновимірного масиву цілих чисел.
    Масив задати генерацією псевдовипадкових чисел. Результат вивести на консоль.
 */

import java.util.Random;

public class Task2 {
    public static void main(String[] args){
        Random random = new Random();
        System.out.println("Generated array: ");
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++){
            int value = random.nextInt(100);
            arr[i] = value;
            System.out.print(value + " ");
        }
        System.out.println("Average value: " + getAverage(arr));
    }

    public static double getAverage(int[] arr){
        return (double) Task1.sum(arr) / arr.length;
    }
}
