/*
    Завдання 1. Знайти суму елементів одновимірного масиву дійсних чисел.
    Передбачити введення елементів масиву з консолі. Результат вивести на консоль.
 */

public class ElementSum {
    public static void main(String[] args){
        int[] arr = new int[0];
        System.out.println("Enter an int to add to the array. Enter -1 to stop");
        while(true){
            int n = DataInput.getInt();
            if(n == -1){
                break;
            }
            arr = addElementToArray(arr, n);
        }
        System.out.println("Sum of elements: " + sum(arr));
    }

    public static int[] addElementToArray(int[] arr, int element){
        int[] newArray = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++){
            newArray[i] = arr[i];
        }
        newArray[newArray.length - 1] = element;
        return newArray;
    }

    public static int sum(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        return sum;
    }

}
