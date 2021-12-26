package chalenges;

import java.util.Scanner;

public class CountIntervalNumbers {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int countNumbers = scanner.nextInt();
        int outInterval = 0;
        int inInverval = 0;

        for(int i = 0; i < countNumbers; i++){
            int number = scanner.nextInt();

            if(number >= 10 && number <= 20){
                inInverval++;
            } else {
                outInterval++;
            }
        }

        System.out.println(inInverval + " in");
        System.out.println(outInterval + " in");

        scanner.close();
    }
}
