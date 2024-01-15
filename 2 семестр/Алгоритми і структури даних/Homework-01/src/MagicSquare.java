/*
    Написати програму, що визначає чи є введений двумірний масив магічним квадратом
    (містить однакову суму в усіх стовпчиках, рядках, діагоналях).
    Має бути два класи MagicSquare та MagicSquareMain
    Клас MagicSquare в конструктор має приймати двовимірний масив
    Клас MagicSquare має містити метод, що повертає чи це магічний квадрат
    В класі MagicSquareMain в окремому методі отримати введений з клавіатури
    двовимірний масив, створити клас MagicSquare та використовуючи відповідний
    метод вивести в консоль двовимірний масив, та  інформацію про те чи введені дані є магічним квадратом
    Передбачити різноманітні перевірки на коректність введення даних
 */
public class MagicSquare {
    MagicSquare(int[][] square){
        this.square = square;
    }
    int[][] square;
    public boolean isMagic(){
        return checkColumns() && checkRows() && checkDiagonals();
    }

    boolean checkRows(){
        int[] sumArray = new int[0];

        for(int i = 0; i < getRowsAmount(); i++){
            //calculate the sum of numbers in one row
            int sum = 0;
            for(int j = 0; j < getColumnsAmount(); j++){
                sum += square[i][j];
            }

            //add new sum value to the array
            sumArray = addValueToArray(sum, sumArray);
        }

        return areElementsEqualTo(sumArray, getSquareDeterminant());
    }

    boolean checkColumns(){
        int[] sumArray = new int[0];

        for(int i = 0; i < getColumnsAmount(); i++){
            //calculate the sum of numbers in one column
            int sum = 0;
            for(int j = 0; j < getRowsAmount(); j++){
                sum += square[i][j];
            }

            //add new sum value to the array
            sumArray = addValueToArray(sum, sumArray);
        }
        return areElementsEqualTo(sumArray, getSquareDeterminant());
    }

    boolean checkDiagonals(){
        int[] sumArray = new int[0];
        //descending diagonal
        int sum = 0;
        for(int i = 0; i < getRowsAmount(); i++){
            sum += square[i][i];
        }

        sumArray = addValueToArray(sum, sumArray);

        //ascending diagonal
        sum = 0;
        for(int i = 0, j = square.length - 1; i < getRowsAmount(); i++, j--){
            sum += square[i][j];
        }
        sumArray = addValueToArray(sum, sumArray);

        return areElementsEqualTo(sumArray, getSquareDeterminant());
    }

    int getRowsAmount(){
        return square.length;
    }

    int getColumnsAmount(){
        return square[0].length;
    }

    public static int[] addValueToArray(int value, int[] originalArray) {
        int[] newArray = new int[originalArray.length + 1];

        // Copy old values
        for (int i = 0; i < originalArray.length; i++) {
            newArray[i] = originalArray[i];
        }

        // Add new value
        newArray[newArray.length - 1] = value;

        return newArray;
    }

    public static boolean areElementsEqualTo(int[] array, int equalTo){
        for(int element : array){
            if(element != equalTo) return false;
        }

        return true;
    }

    //get a value of a magic square to compare to
    private int getSquareDeterminant(){
        int det = 0;
        for (int[] ints : square) {
            det += ints[0];
        }
        return det;
    }
}
