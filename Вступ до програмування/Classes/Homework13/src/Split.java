/*
    Написати програму, що відкриває файл на читання і формує два інших файли. Перший файл формується з 
    непарних стрічок початкового файлу, а інший з парних.
    
    File: Split.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;
import java.io.*;

public class Split extends ConsoleProgram {
    public void run() {
        while(true){
            getConsole().clear();
            String inputFileName = readLine("Enter the source file name: ");
            String fileContent;
            try {
                fileContent = readFile(inputFileName);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            println("Current file content:");
            println(fileContent);
            String oddFileName = "odd.txt";
            String evenFileName = "even.txt";

            try {
                createOddEvenFiles(inputFileName, oddFileName, evenFileName);
                println("Odd and even files created successfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }

            handleExit();
        }
    }
    private void handleExit() {
        int exit = readInt("Введіть 0 для виходу, 1 щоб продовжити:");
        if (exit == 0) {
            System.exit(0);
        }
    }
    private void createOddEvenFiles(String inputFileName, String oddFileName, String evenFileName) throws Exception {
        java.io.FileReader fileReader = new java.io.FileReader(inputFileName);
        java.io.FileWriter oddFileWriter = new java.io.FileWriter(oddFileName);
        java.io.FileWriter evenFileWriter = new java.io.FileWriter(evenFileName);

        int ch;
        int lineNumber = 1;

        while ((ch = fileReader.read()) != -1) {
            if (lineNumber % 2 == 1) {
                oddFileWriter.write(ch);
            } else {
                evenFileWriter.write(ch);
            }

            if (ch == '\n') {
                lineNumber++;
            }
        }

        fileReader.close();
        oddFileWriter.close();
        evenFileWriter.close();
    }
    private String readFile(String filePath) throws Exception {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
