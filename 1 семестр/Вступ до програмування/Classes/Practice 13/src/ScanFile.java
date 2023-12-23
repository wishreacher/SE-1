/*
    Написати програму, що читає текстову інформацію з файлу і виводить на екран

    File: ScanFile.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ScanFile extends ConsoleProgram {
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

    public void run(){
        try {
            BufferedReader reader = openFile("test.txt");
            String s;
            while ((s = reader.readLine()) != null){
                println(s);
            }
            reader.close();
        } catch (Exception e) {
            println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
