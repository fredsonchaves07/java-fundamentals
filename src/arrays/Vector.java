package arrays;

import java.util.Scanner;

public class Vector {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double average = 0;
        double[] vect = new double[n];

        for(int i = 0; i < n; i++){
            vect[i] = scanner.nextDouble();
        }

        for(int i = 0; i < n; i++){
            average += vect[i];
        }

        System.out.println(average / n);

        scanner.close();
    }
}
