/*
    Завдання 5. Дано цілочисельну прямокутну матрицю.
    1). Розташувати стовпчики заданої матриці за зростанням сум модулів їх від’ємних непарних елементів.
    2). Знайти суму елементів у тих стовпчиках, які містять хоча б один від’ємний елемент.
 */
public class Task5 {
    public static void main(String[] args){
        int[][] matrix = SillyUtils.generate2DMatrix();
        SillyUtils.fillArrayRandomly(matrix);
        System.out.println("Generated matrix: ");
        SillyUtils.printArray(matrix);
        System.out.println();
        System.out.println("Sum of negative odd elements in each column:");
        SillyUtils.printArray(sumOfNegativeOddElements(matrix));
        System.out.println();
        System.out.println();
        System.out.println("Matrix with columns sorted by sum of negative odd elements:");
        SillyUtils.printArray(sortColumnsBySumOfNegativeOddElements(matrix));
        System.out.println();
        System.out.println("Sum of columns with negative elements:");
        printSumOfColumnsWithNegativeElements(matrix);
    }

    public static int[][] swapColumns(int[][] arr, int a, int b){
        int[][] result = arr;

        int[] temp = new int[0];

        for(int i = 0; i < result.length; i++){
            temp = SillyUtils.addElementToArray(temp, result[i][a]);
        }

        for(int i = 0; i < result.length; i++){
            result[i][a] = result[i][b];
        }

        for(int i = 0; i < result.length; i++){
            result[i][b] = temp[i];
        }

        return result;
    }

    public static int[] sumOfNegativeOddElements(int[][] arr){
        int[] sumArray = new int[0];
        for (int j = 0; j < arr[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][j] < 0 && arr[i][j] % 2 != 0) {
                    sum += Math.abs(arr[i][j]);
                }
            }
            sumArray = SillyUtils.addElementToArray(sumArray, sum);
        }

        return sumArray;
    }

    public static int[][] sortColumnsBySumOfNegativeOddElements(int[][] matrix){
        int[][] result = matrix;
        boolean didSwap = true;

        while(didSwap){
            didSwap = false;
            for (int i = 0; i < result[0].length - 1; i++) {
                if (sumOfNegativeOddElements(result)[i] > sumOfNegativeOddElements(result)[i + 1]) {
                    didSwap = true;
                    result = swapColumns(result, i, i + 1);
                }
            }
        }

        return result;
    }

    public static boolean doesColumnContainNegativeElement(int[][] arr, int column){
        for(int i = 0; i < arr.length; i++){
            if(arr[i][column] < 0){
                return true;
            }
        }
        return false;
    }

    public static int sumOfColumn(int[][] arr, int column){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i][column];
        }
        return sum;
    }

    public static void printSumOfColumnsWithNegativeElements(int[][] arr){
        for(int i = 0; i < arr[0].length; i++){
            if(doesColumnContainNegativeElement(arr, i)){
                System.out.println("Sum of column " + i + ": " + sumOfColumn(arr, i));
            }
        }
    }
}
