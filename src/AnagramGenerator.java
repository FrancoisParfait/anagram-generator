import java.util.Scanner;
public class AnagramGenerator {

    public static void main (String[] args) {
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
