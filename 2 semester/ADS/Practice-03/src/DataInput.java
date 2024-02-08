import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {
    public static Long getLong(){
        while(true) {
            try {
                String s = getString();
                Long value = Long.valueOf(s);
                return value;
            } catch(IOException | NumberFormatException e) {
                System.out.println("Wrong input! Please enter a valid long integer.");
            }
        }
    }

    public static char getChar() throws IOException{
        while(true){
            String s = getString();
            if(s.length() == 0){
                return s.charAt(0);
            } else{
                System.out.println("Wrong input. Please enter one character");
            }

        }
    }

    public static Integer getInt(){
        while(true) {
            try {
                String s = getString();
                Integer value = Integer.valueOf(s);
                return value;
            } catch(IOException | NumberFormatException e) {
                System.out.println("Wrong input! Please enter a valid integer.");
            }
        }
    }

    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}