/*
   Здійснити шифрування файлу використовуючи зсув символів.

   File: Encryption.java
   Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;
import java.io.*;

public class Encryption extends ConsoleProgram {
    int shift = 3;
    public void run(){
        while(true){
            getConsole().clear();
            int println = readInt("Введіть 1 щоб зашифрувати, 2 щоб розшифрувати: ");
            while(println != 1 && println != 2){
                println = readInt("Введіть 1 щоб зашифрувати, 2 щоб розшифрувати: ");
            }

            String originFileName = readLine("Введіть назву початкового файлу: ");
            String destinationFileName = readLine("Введіть назву вихідного файлу: ");

            if(println == 1){
                encrypt(originFileName, destinationFileName);
            } else {
                decrypt(originFileName, destinationFileName);
            }
            println("Файл успішно оброблено");
            handleExit();
        }
    }

    //shifts every character in file by @shift var
    private void encrypt(String originFileName, String destinationFileName) {
        BufferedReader reader = openFile(getPath(originFileName));
        try {
            PrintWriter writer = new PrintWriter(getPath(destinationFileName));
            String s;
            while ((s = reader.readLine()) != null){
                for(int i = 0; i < s.length(); i++){
                    writer.print((char)((int)s.charAt(i) + shift));
                }
                writer.println();
            }
            writer.close();
        } catch (Exception e) {
            println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //shifts every character in file by @shift * (-1)
    private void decrypt(String originFileName, String destinationFileName){
        BufferedReader reader = openFile(getPath(originFileName));
        try {
            PrintWriter writer = new PrintWriter(getPath(destinationFileName));
            String s;
            while ((s = reader.readLine()) != null){
                for(int i = 0; i < s.length(); i++){
                    writer.print((char)((int)s.charAt(i) - shift));
                }
                writer.println();
            }
            writer.close();
        } catch (Exception e) {
            println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //opens file and returns BufferedReader object
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

    private void handleExit() {
        int exit = readInt("Введіть 0 для виходу, 1 щоб продовжити:");
        if (exit == 0) {
            System.exit(0);
        }
    }

    //adds .txt extension to filename
    private String getPath(String filename) {
        return filename + ".txt";
    }
}
