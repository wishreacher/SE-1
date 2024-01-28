/*
    Дано матрицю розміром N х N.
    Знайти суму найменших елементів її непарних рядків і найбільших елементів її парних рядків.
    Впорядкувати елементи у рядках за зростанням
 */

import java.io.IOException;
import java.util.Random;

public class Task5 {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter matrix size: ");
        int matrixSize = DataInput.getInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        fillMatrixWithRandomInts(matrix);
        printMatrix(matrix);
        System.out.println("Smallest element in odd rows: " + findSmallestValueOfOddRows(matrix));
        System.out.println("Largest element in even rows: " + findLargestValueOfEvenRows(matrix));

        sortElementsInRows(matrix);
        System.out.println("Matrix with elements sorted in rows: ");
        printMatrix(matrix);
    }

    public static int findSmallestValueOfOddRows(int[][] matrix){
        int min = matrix[0][0];
        for(int i = 0; i < matrix.length; i++){
            if(i % 2 != 0){
                continue;
            }
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                }
            }
        }
        return min;
    }

    public static int findLargestValueOfEvenRows(int[][] matrix){
        int max = matrix[0][0];
        for(int i = 0; i < matrix.length; i++){
            if(i % 2 == 0){
                continue;
            }
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] > max){
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    public static void fillMatrixWithRandomInts(int[][] matrix) {
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(100);
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //TODO rewrite this in a way i understand with while loop
    public static void sortElementsInRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                for (int k = 0; k < matrix[i].length - j - 1; k++) {
                    if (matrix[i][k] > matrix[i][k + 1]) {
                        // Swap matrix[i][k] and matrix[i][k + 1]
                        int temp = matrix[i][k];
                        matrix[i][k] = matrix[i][k + 1];
                        matrix[i][k + 1] = temp;
                    }
                }
            }
        }
    }
}
