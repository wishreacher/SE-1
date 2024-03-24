/*
    Написати програму, що зчитує інформацію з текстового файлу і рахує кількість слів в файлі,
    кількість унікальних слів в файлі, виводить інформацію про кількість слів, кількість
    унікальних слів, унікальні слова за алфавітом і поруч скільки разів це слово зустрілося.
    Унікальні слова - це, так би мовити, словарний запас файлу. Тобто, якщо у вас у файлі сто слів,
    але при цьому там двадцять п'ять різних слів, кожне з яких повторюється чотири рази, то унікальних
    слів - 25.

    Продумати ієрархію класів.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Word {
    String text;
    int count;

    Word(String text) {
        this.text = text;
        this.count = 1;
    }

    void incrementCount() {
        this.count++;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Word> words = new ArrayList<>();
        int totalWords = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    String wordText = st.nextToken();
                    totalWords++;
                    Word word = findWord(words, wordText);
                    if (word == null) {
                        words.add(new Word(wordText));
                    } else {
                        word.incrementCount();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(words, (w1, w2) -> w1.text.compareTo(w2.text));

        for(Word word : words){
            System.out.println(word.text + ": " + word.count);
        }

        System.out.println("Total words: " + totalWords);
        System.out.println("Unique words: " + words.size());
//        for (Word word : words) {
//            System.out.println(word.text + ": " + word.count);
//        }
    }

    private static Word findWord(List<Word> words, String text) {
        for (Word word : words) {
            if (word.text.equals(text)) {
                return word;
            }
        }
        return null;
    }
}