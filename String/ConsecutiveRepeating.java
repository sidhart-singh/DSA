package String;

public class ConsecutiveRepeating {
    static String word = "Yahhiooo";

    public static String encryptString() {
        StringBuilder encryptedWord = new StringBuilder();
        int count = 1;
        char prevChar = '\0';

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (currentChar == prevChar) {
                count++;
            } else {
                if (count > 1) {
                    encryptedWord.append(count);
                }
                encryptedWord.append(prevChar);
                count = 1;
                prevChar = currentChar;
            }
        }

        if (count > 1) {
            encryptedWord.append(count);
        }
        encryptedWord.append(prevChar);

        return encryptedWord.toString();
    }


    public static void main(String[] args) {

        System.out.println(encryptString());
    }
}
