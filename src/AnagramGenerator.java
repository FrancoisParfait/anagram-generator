import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
public class AnagramGenerator {

    public static void main(String[] args) throws FileNotFoundException {

        HashSet<String> wordList = new HashSet<String>();
        Scanner file = new Scanner(new File("enable1.txt"));

        while (file.hasNext()) {
            wordList.add(file.next());
        }

        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter word: ");
        String inputWord = myObj.nextLine();

        char[] usableChars = new char[inputWord.length()];

        for (int i = 0; i < inputWord.length(); i++) {
            char letter = inputWord.charAt(i);

            usableChars[i] = letter;
        }
    }
}
