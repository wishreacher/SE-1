/*
    Написати програму, що копіює зміст тектового файлу в інший з розширення ".bak".
    Назва файлу вводиться користувачем.

    File: CopyBAK.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

import java.io.*;

public class CopyBAK extends ConsoleProgram {
    public void run() {
        while (true){
            getConsole().clear();
            String sourceFileName = readLine("Enter the source file name: ");
            String destinationFileName = readLine("Enter the new file name: ");

            try {
                copyFile(sourceFileName, destinationFileName);
                println("File copied successfully to " + destinationFileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            handleExit();
        }
    }

    private void copyFile(String sourceFileName, String destinationFileName) throws Exception {
        FileReader fileReader = new FileReader(sourceFileName);
        FileWriter fileWriter = new FileWriter(destinationFileName);

        int ch;
        while ((ch = fileReader.read()) != -1) {
            fileWriter.write(ch);
        }

        fileReader.close();
        fileWriter.close();
    }

    private void handleExit() {
        int exit = readInt("Введіть 0 для виходу, 1 щоб продовжити:");
        if (exit == 0) {
            System.exit(0);
        }
    }
}
