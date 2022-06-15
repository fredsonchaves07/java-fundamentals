package udemy.introduction;

import java.util.Scanner;

public class DataInput2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1, s2, s3;

        s1 = scanner.nextLine();
        s2 = scanner.nextLine();
        s3 = scanner.nextLine();

        System.out.println("Dados digitados:");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        scanner.close();
    }
}
