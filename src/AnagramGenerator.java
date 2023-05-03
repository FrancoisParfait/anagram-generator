import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.HashSet;
public class AnagramGenerator {

    public static boolean containsLetter(char a, char[] arrB) {

        for (int i = 0; i < arrB.length; i++) {
            if (a == arrB[i]) {
                return true;
            }
        }
        return false;
    }

    public static int charUsage(char a, char[] arrB) {

        int count = 0;

        for (int i = 0; i < arrB.length; i++) {
            if (arrB[i] == a) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {

        HashSet<String> wordList = new HashSet<String>();
        Scanner file = new Scanner(new File("enable1.txt"));

        while (file.hasNext()) {
            wordList.add(file.next());
        }

        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter word: ");
        String inputWord = myObj.nextLine().toLowerCase();

        char[] usableChars = new char[inputWord.length()];

        for (int i = 0; i < inputWord.length(); i++) {
            char letter = inputWord.charAt(i);
            usableChars[i] = letter;
        }

        HashSet<String> narrowedList = new HashSet<String>();

        for (String a : wordList) {
            if (a.length() == usableChars.length) {
                char[] aChars = new char[a.length()];

                for (int i = 0; i < a.length(); i++) {
                    char letter = a.charAt(i);
                    if (!containsLetter(letter, usableChars)) {
                        break;
                    } else {
                        aChars[i] = letter;
                    }
                }

                int match = 0;
                int charCount = 0;

                for (int i = 0; i < usableChars.length; i++) {
                    for (int j = 0; j < aChars.length; j++) {
                        if (usableChars[i] == aChars[j]) {
                            match++;
                        }
                    }
                    charCount += charUsage(aChars[i], aChars);
                }

                if (match == inputWord.length() && charCount == inputWord.length()) {
                    narrowedList.add(a);
                }
            }
        }

        System.out.println(narrowedList);
    }
}
