/*
    Прочитати з файлу текст і видалити в ньому всі цифри. Результат записати в новий файл.
 */

import acm.program.ConsoleProgram;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class StringTask extends ConsoleProgram {
    public void run(){
        while(true){
            getConsole().clear();

            String originFileName = readLine("Введіть назву початкового файлу: ");
            String destinationFileName = readLine("Введіть назву вихідного файлу: ");

            deleteNumbers(getPath(originFileName), getPath(destinationFileName));

            handleExit();
        }
    }

    private BufferedReader openFile(String filename) {
        BufferedReader rd = null;
        while (rd == null){
            try{
                rd = new BufferedReader(new FileReader(filename));
            } catch (FileNotFoundException e){
                println("Exception: File not found");
                e.printStackTrace();
            }
        }
        return rd;
    }

    private void deleteNumbers(String originFileName, String destinationFileName){
        BufferedReader reader = openFile(originFileName);

        try {
            PrintWriter writer = new PrintWriter(destinationFileName);
            String s;
            while ((s = reader.readLine()) != null){
                for(int i = 0; i < s.length(); i++){
                    if(!Character.isDigit(s.charAt(i))){
                        writer.print(s.charAt(i));
                    }
                }
                writer.println();
            }
            writer.close();
        } catch (Exception e) {
            println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void handleExit() {
        int exit = readInt("Введіть 0 для виходу, 1 щоб продовжити:");
        if (exit == 0) {
            System.exit(0);
        }
    }

    private String getPath(String filename){
        return filename + ".txt";
    }
}
