import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter word: ");

        String inputWord = myObj.nextLine();
        System.out.println("Word is: " + inputWord);
    }
}
