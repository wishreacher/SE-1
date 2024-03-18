import java.io.IOException;

/*
    Написати клас який на вхід отримує стрічку символів і зберігає її.

    На запит користувача повертається закодована стрічка. В якості кодування стрічки
    можна взяти шифр Цезаря.

    На запит користувача повертається розкодована стрічка.
 */
public class Encryption {
    public static void main(String[] args) throws IOException {
        String s;
        outer:while(true){
            System.out.flush();
            System.out.println("Enter a string");
            s = DataInput.getString();

            while(true){
                System.out.println("1 - encrypt and save, \n2 - decrypt current, " +
                        "\n3 - reenter a string");
                int choice = DataInput.getInt();
                while(choice != 1 && choice != 2 && choice != 3){
                    System.out.println("Enter 1, 2 or 3");
                    choice = DataInput.getInt();
                }

                switch(choice){
                    case 1 ->{
                        System.out.println("Enter cipher offset");
                        int n = DataInput.getInt();
                        s = encrypt(s, n);
                        System.out.println("Encrypted string: " + s + " with key " + n);
                    }

                    case 2 ->{
                        System.out.println("Enter cipher offset");
                        int n = DataInput.getInt();
                        s = decrypt(s, n);
                        System.out.println("Decrypted string: " + s + " with key " + n);
                    }

                    case 3 ->{
                        continue outer;
                    }
                }

            }
        }
    }

    public static String encrypt(String s, int n){
        n = n % 26; // For English alphabet
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)){
                if(Character.isLowerCase(c)){
                    if(c >= 'a' && c <= 'z'){
                        c = (char)('a' + (c - 'a' + n) % 26);
                    } else if(c >= 'а' && c <= 'я'){
                        c = (char)('а' + (c - 'а' + n) % 33);
                    }
                } else{
                    if(c >= 'A' && c <= 'Z'){
                        c = (char)('A' + (c - 'A' + n) % 26);
                    } else if(c >= 'А' && c <= 'Я'){
                        c = (char)('А' + (c - 'А' + n) % 33);
                    }
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static String decrypt(String s, int n){
        return encrypt(s, -n);
    }
}
