/*
    Написати программу, що робить перевірку, чи є значення символьної змінної,
    що введена з клавіатури (повертаються одразу всі три результати) :

    цифрою від '0' до '9';
    малою латинською літерою;
    латинською літерою (великою чи малою)

    File: ValueCheck.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

public class ValueCheck extends ConsoleProgram {
    boolean isOneChar = false;
    public void run(){
        while(true){
            while(!isOneChar){
                String stringValue = readLine("Enter value: ");
                if(stringValue.length() != 1){
                    println("Error: value must be one character");
                } else {
                    isOneChar = true;
                    char value = stringValue.charAt(0);
                    println("Is digit: " + isDigit(value));
                    println("Is lowercase: " + isLowercase(value));
                    println("Is letter: " + isLetter(value));
                }
            }
            handleExit();
        }

    }

    private boolean isDigit(char value){
        return value >= '0' && value <= '9';
    }
    private boolean isLowercase(char value){
        return value >= 'a' && value <= 'z';
    }
    private boolean isLetter(char value){
        return isLowercase(value) || isUppercase(value);
    }
    private boolean isUppercase(char value) {
        return value >= 'A' && value <= 'Z';
    }
    private void handleExit(){
       int exit = readInt("Enter 0 to exit and 1 to continue: ");
       while(exit != 0 && exit != 1){
           println("Error: value must be 0 or 1");
           exit = readInt("Enter 0 to exit and 1 to continue: ");
       }
       if(exit == 0){
           exit();
       } else {
           isOneChar = false;
       }
    }
}
