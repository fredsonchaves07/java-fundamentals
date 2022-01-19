package matrices;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                System.out.print(mat[i][j] + ",");
            }
        }

        scanner.close();
    }
}
