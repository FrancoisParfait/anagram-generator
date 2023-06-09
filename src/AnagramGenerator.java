import java.io.*;
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

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        InputStream stream = AnagramGenerator.class.getClassLoader().getResourceAsStream("enable1.txt");

        GUI gui = new GUI();

        HashSet<String> wordList = new HashSet<>();
        Scanner file = new Scanner(stream);

        while (file.hasNext()) {
            wordList.add(file.next());
        }

        while (!gui.running) {
            Thread.sleep(10);
        }

        boolean run = true;

        while (run) {

            String inputWord = gui.userWord.toLowerCase();

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

            String narrowedString = String.join(", ", narrowedList);

            try {
                int i = Integer.parseInt(gui.userWord);
                gui.outputArea.setText("Words, not numbers!");
            } catch (NumberFormatException e) {
                if (inputWord.equals("")) {
                    gui.outputArea.setText("Enter a word!");
                } else if (narrowedList.isEmpty()){
                    gui.outputArea.setText("No anagrams :(");
                } else {
                    gui.outputArea.setText(narrowedString);
                }
            }
        }
    }
}
