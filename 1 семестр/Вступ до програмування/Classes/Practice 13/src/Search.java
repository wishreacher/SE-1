/*
    Написати програму, що шукає в тексті файлу задану фразу і виводить інформацію про її наявність та кількість.

    File: Search.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Search extends ConsoleProgram {

    public void run(){
        while(true){
            String filename = ("test.txt");
            printText(filename);

            String s = readLine("Введіть стрічку:");
            println(search(s, filename));

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

    //case-insensitive search
    private String search(String s, String filename) {
        int count = 0;
        try {
            BufferedReader reader = openFile(filename);
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.toLowerCase().contains(s.toLowerCase())) {
                    //i need to cycle through the line to find all occurrences of the string
                    //because the contains() method only finds the first occurrence
                    for (int i = 0; i < currentLine.length(); i++) {
                        if (currentLine.toLowerCase().charAt(i) == s.toLowerCase().charAt(0)) {
                            if (currentLine.substring(i, i + s.length()).equalsIgnoreCase(s)) {
                                count++;
                            }
                        }
                    }
                }
            }
            reader.close();
            if(count == 0) {
                return "Фраза " + s + " не знайдена";
            } else if(count == 1) {
                return "Фраза " + s + " знайдена " + count + " раз";
            } else if(count > 1 && count < 5) {
                return "Фраза " + s + " знайдена " + count + " рази";
            } else if(count > 4) {
                return "Фраза " + s + " знайдена " + count + " разів";
            }
        } catch (Exception e) {
            println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return "Помилка";
    }

    private void handleExit(){
        int exit = readInt("Введіть 0 для виходу, 1 щоб продовжити:");
        if(exit == 0){
            System.exit(0);
        }
    }
}
