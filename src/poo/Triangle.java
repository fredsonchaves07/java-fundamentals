package poo;

import java.util.Scanner;

public class Triangle {
    
    public double a;
    public double b;
    public double c;

    public double calcArea(){
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Triangle x, y;
        x = new Triangle();
        y = new Triangle();

        System.out.println("Enter the measure of triangle x");
        x.a = scanner.nextDouble();
        x.b = scanner.nextDouble();
        x.c = scanner.nextDouble();
        System.out.println("Enter the measure of triangle x");
        y.a = scanner.nextDouble();
        y.b = scanner.nextDouble();
        y.c = scanner.nextDouble();

        System.out.println("Area of triangle x: " + x.calcArea());
        System.out.println("Area of triangle y: " + y.calcArea());

        if(x.calcArea() > y.calcArea()){
            System.out.println("large: X");
        } else {
            System.out.println("large: Y");
        }
        
        scanner.close();
    }
}

