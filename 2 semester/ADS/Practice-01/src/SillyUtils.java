import java.util.Random;

public class SillyUtils {
    public static int[] addElementToArray(int[] arr, int element){
        int[] newArray = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++){
            newArray[i] = arr[i];
        }
        newArray[newArray.length - 1] = element;
        return newArray;
    }

    public static void printArray(int[][] arr){
        for(int[] i : arr){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    public static void fillArrayRandomly(int[][] arr){
        Random random = new Random();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = random.nextInt(-100,100);
            }
        }
    }

    public static int[][] generate2DMatrix(){
        System.out.println("Enter amount of rows in array: ");
        int rows = DataInput.getInt();
        System.out.println("Enter amount of columns in array: ");
        int columns = DataInput.getInt();

        return new int[rows][columns];
    }

    public static void fill2DArrayFromConsole(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter " + arr[i].length + " integers for row " + (i+1) + ":");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = DataInput.getInt();
            }
        }
    }
}
