import java.util.Scanner;
import static java.lang.Integer.valueOf;

public class MagicSquareMain {
    public static void main(String[] args){
        System.out.println("Enter square size");
        int size = readInt();
        int[][] square = new int[size][size];

        fillSquare(square);
        printSquare(square);

        MagicSquare sq = new MagicSquare(square);
        System.out.println(sq.isMagic() ? "Magic" : "Not magic");
        //System.out.println(sq.checkColumns() ? "Magic rows" : "Stupid rows");
    }

    static void fillSquare(int[][] square){
        for(int rowIndex = 0; rowIndex < square.length; rowIndex++){
            System.out.println("Entering row " + rowIndex);
            for(int columnIndex = 0; columnIndex < square[rowIndex].length; columnIndex++){
                square[rowIndex][columnIndex] = readInt();
            }
            System.out.println();
        }
    }

    static void printSquare(int[][] square){
        for(int[] row : square){
            for(int element : row){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    static String read(){
        Scanner sc= new Scanner(System.in);
        return sc.nextLine();
    }

    static int readInt(){
        return valueOf(read());
    }
}
