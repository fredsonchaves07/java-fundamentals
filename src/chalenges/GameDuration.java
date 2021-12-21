package chalenges;

import java.util.Scanner;

public class GameDuration {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int initial_hour = scanner.nextInt();
        int final_hour = scanner.nextInt();
        int duration = 10;

        if (initial_hour < final_hour){
            duration = Math.abs(initial_hour - final_hour);
        } else {
            duration = Math.abs(24 - initial_hour + final_hour);
        }

        System.out.println("O jogo durou " + duration + " hora(s)");

        scanner.close();
    }
}
