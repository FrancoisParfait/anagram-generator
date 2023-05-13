import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
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

        JFrame frame = new JFrame();
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setTitle("Anagram Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 640);
        frame.setResizable(false);
        frame.setVisible(true);

        HashSet<String> wordList = new HashSet<>();
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

        HashSet<String> narrowedList = new HashSet<>();

        for (String a : wordList) {

            boolean wrongLetter = false;

            // Check for any letters that aren't in inputWord
            for (int i = 0; i < a.length(); i++) {
                char letter = a.charAt(i);
                if (!containsLetter(letter, usableChars)) {
                    wrongLetter = true;
                }
            }

            if (!wrongLetter && a.length() == usableChars.length) {
                char[] aChars = new char[a.length()];

                for (int i = 0; i < a.length(); i++) {
                    char letter = a.charAt(i);
                    aChars[i] = letter;
                }

                int match = 0;

                for (int i = 0; i < usableChars.length; i++) {
                    for (int j = 0; j < aChars.length; j++) {
                        if (charUsage(usableChars[i], usableChars) == charUsage(aChars[j], aChars)) {
                            if (usableChars[i] == aChars[j]) {
                                match++;
                                break;
                            }
                        }
                    }
                }

                if (match == inputWord.length() && !a.equals(inputWord)) {
                    narrowedList.add(a);
                }
            }
        }

        if (narrowedList.isEmpty()) {
            System.out.println("No anagrams :(");
        } else {
            System.out.println(narrowedList);
        }

    }
}
