/*
    Написати програму, що зчитує з клавіатури стрічку і повертає одразу всі результати
    (кожен пункт оформити у вигляді методу)

    кількість слів (в слові можуть зустрічатися: тільки літери; тільки символи;
    літери+символи+цифри; літери+символи;літери+цифри; символи(окрім крапки та коми)+цифри;
    якщо відділені пропусками символи цифри, або цифри та кома чи крапка, то даний ланцюжок є числом)

    кількість чисел

    стрічку в якій прибрані усі символи крім літер

    стрічку в якій множинні проміжки перетворені в один проміжок ("А   пр" ="А пр")

    стрічку яка містить лише слова, що починаються з великої літери ("А   пр" ="А")

    File: Calculations.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

public class Calculations extends ConsoleProgram {
    public void run(){
        String str = readLine("Enter string: ");
        println("Number of words: " + countWords(str));
        println("Number of numbers: " + countNumbers(str));
        println("String without symbols: " + removeSymbols(str));
        println("String with one space: " + removeSpaces(str));
        println("String with words with big letter: " + removeSmallLetters(str));
    }

    private String removeSmallLetters(String str) {
        String newString = "";
        boolean isWord = false;
        for(int i = 0; i < str.length(); i++) {
            if(isLetter(str.charAt(i)) && isUpperCase(str.charAt(i))) {
                newString += str.charAt(i);
                isWord = true;
            } else if(isLetter(str.charAt(i)) && isWord) {
                newString += str.charAt(i);
            } else if(isWhiteSpace(str.charAt(i))) {
                while(i < str.length() - 1 && isWhiteSpace(str.charAt(i + 1))) {
                    i++;
                }
                newString += " ";
                isWord = false;
            }
        }
        return newString;
    }

    private String removeSpaces(String str) {
        String newString = "";
        for(int i = 0; i < str.length(); i++) {
            if(isLetter(str.charAt(i)) || isDigit(str.charAt(i))) {
                newString += str.charAt(i);
            } else if(isWhiteSpace(str.charAt(i))) {
                while(i < str.length() - 1 && isWhiteSpace(str.charAt(i + 1))) {
                    i++;
                }
                newString += " ";
            }
        }
        return newString;
    }

    private String removeSymbols(String str) {
        String newString = "";
        for(int i = 0; i < str.length(); i++) {
            if(isLetter(str.charAt(i))) {
                newString += str.charAt(i);
            }
        }
        return newString;
    }

    private int countNumbers(String str) {
        int charsCount = 0;
        for(int i = 0; i < str.length(); i++) {
            if(isDigit(str.charAt(i))) {
                while(i < str.length() && isDigit(str.charAt(i))) {
                    i++;
                }
                charsCount++;
            }
        }
        return charsCount;
    }

    private int countWords(String str) {
        int wordCount = 0;
        boolean isWord = false;
        int endOfLine = str.length() - 1;

        for (int i = 0; i < str.length(); i++) {
            if ((isLetter(str.charAt(i)) || isDigit(str.charAt(i))) && i != endOfLine) {
                isWord = true;
            } else if (!isLetter(str.charAt(i)) && !isDigit(str.charAt(i)) && isWord) {
                wordCount++;
                isWord = false;
            } else if ((isLetter(str.charAt(i)) || isDigit(str.charAt(i))) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }
    
    private boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
    
    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
    
    private boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
    
    private boolean isWhiteSpace(char ch) {
        return ch == ' ';
    }
}
