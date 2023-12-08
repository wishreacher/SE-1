/*
       Написати програму, що замінює підстрічку в файлі заданою стрічкою

       File:Interchange.java
       Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Interchange extends ConsoleProgram {
    public void run(){
        while(true){
            getConsole().clear();
            String filename = ("test.txt");
            printText(filename);

            String s = readLine("Введіть стрічку яку хочете замінити:");
            String changed = readLine("Введіть стрічку на яку хочете замінити:");
            interchange(s, changed, filename);

            handleExit();
        }
    }
    //opens file and returns BufferedReader object
    private BufferedReader openFile(String filename){
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

    //prints the whole text from file
    private void printText(String filename){
        BufferedReader reader = openFile(filename);
        try {
            String currentLine;
            while ((currentLine = reader.readLine()) != null){
                println(currentLine);
            }
        } catch (Exception e) {
            println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void handleExit(){
        int exit = readInt("Введіть 0 для виходу, 1 щоб продовжити:");
        if(exit == 0){
            System.exit(0);
        }
    }

    private void interchange(String s, String changed, String filename){
        try {
            BufferedReader reader = openFile(filename);
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                currentLine = customReplaceAll(currentLine, s, changed);
                println(currentLine);
            }
            reader.close();
        } catch (Exception e) {
            println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String customReplaceAll(String original, String oldSubstring, String newSubstring) {
        StringBuilder result = new StringBuilder();
        String lowerCaseOriginal = original.toLowerCase();
        String lowerCaseOldSubstring = oldSubstring.toLowerCase();
        int index;
        while ((index = lowerCaseOriginal.indexOf(lowerCaseOldSubstring)) != -1) {
            result.append(original, 0, index).append(newSubstring);
            original = original.substring(index + oldSubstring.length());
            lowerCaseOriginal = original.toLowerCase();
        }
        result.append(original);
        return result.toString();
    }
}
