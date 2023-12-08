/*
    Написати клас який реалізує метод, що видаляє заданий символ з стрічки і повертає результат:
    public String removeAllOccurences(String str, char ch);

    File: RemoveOccurrences.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;
import java.util.Objects;

public class RemoveOccurrences extends ConsoleProgram {
    public void run(){
        while(true){
            String s = readLine("Введіть стрічку:");
            if(Objects.equals(s, "0")){
                break;
            }
            char c = readLine("Введіть сивол який бажаєте прибрати:").charAt(0);
            println(removeAllOccurrences(s, c));
        }
    }

    private String removeAllOccurrences(String s, char c){
        String result = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != c){
                result += s.charAt(i);
            }
        }
        return result;
    }
}
