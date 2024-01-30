import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class DataInput {
    private static Scanner scanner = new Scanner(System.in);
    public static Double getDouble() throws IOException {
        String s = "";
        try {
            s = getString();
            Double value = Double.valueOf(s);
            return value;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Input error. Please enter an double value");
            getDouble();
        }
        return 0.0;
    }

    public static char getChar() throws IOException{
        try{
            String s = getString();
            if(s.length() > 1){
                System.out.println("Input error. Please enter a single character");
                getChar();
            }
            return s.charAt(0);
        } catch(IOException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static int getInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a number! Try again:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}