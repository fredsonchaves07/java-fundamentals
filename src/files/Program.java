package files;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        File file = new File("in.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) System.out.println(scanner.nextLine());
        } catch (IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        } finally {
            if (scanner != null) scanner.close();
        }
    }
}
