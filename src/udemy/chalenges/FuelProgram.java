package udemy.chalenges;

import java.util.Scanner;

public class FuelProgram {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int fuelType = scanner.nextInt();
        int totalGasoline = 0;
        int totalAlcohol = 0;
        int totalDiesel = 0;

        while(true){
            if(fuelType == 1){
                totalAlcohol +=  1;
            }

            if(fuelType == 2){
                totalGasoline += 1;
            }

            if(fuelType == 3){
                totalDiesel += 1;
            }

            if(fuelType == 4){
                break;
            }
            
            fuelType = scanner.nextInt();
        }

        System.out.println("MUITO OBRIGADO");
        System.out.println("Alcool: " + totalAlcohol);
        System.out.println("Gasolina: " + totalGasoline);
        System.out.println("Diesel: " + totalDiesel);

        scanner.close();
    }
}
