package chalenges;

import java.util.Scanner;

public class WeighteadAverage {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int countNumber = scanner.nextInt();

        for(int i = 0; i < countNumber; i++){
            float firstWeigh = scanner.nextFloat() * 2;
            float secondWeigh = scanner.nextFloat() * 3;
            float thirdWeigh = scanner.nextFloat() * 5;
            float averageValue = (firstWeigh + secondWeigh + thirdWeigh ) / 10;

            System.out.println(averageValue);
        }

        scanner.close();
    }
}
