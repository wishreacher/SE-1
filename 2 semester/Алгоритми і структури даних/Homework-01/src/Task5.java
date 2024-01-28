import static java.util.Collections.swap;

/*
    Дано матрицю розміром N х N.
    Знайти суму найменших елементів її непарних рядків і найбільших елементів її парних рядків.
    Впорядкувати елементи у рядках за зростанням
 */
public class Task5 {
    public static void main(String[] args){
        int[][] matrix = SillyUtils.generate2DMatrix();
        SillyUtils.fillArrayRandomly(matrix);
        matrix = sortRows(matrix);
        SillyUtils.printArray(matrix);
    }

    public static int[][] sortRows(int[][] arr){
        int[][] result = arr;

        for(int j = 0; j < result[0].length; j++){
            boolean didSwap = true;
            while(didSwap){
                didSwap = false;
                for(int i = 0; i < result.length - 1; i++){
                    if(result[i][j] > result[i + 1][j]){
                        didSwap = true;
                        swap(result, i, i + 1, j);
                    }
                }
            }
        }
        return result;
    }

    public static void swap(int[][] arr, int a, int b, int c){
        int temp = arr[a][c];
        arr[a][c] = arr[b][c];
        arr[b][c] = temp;
    }

}
