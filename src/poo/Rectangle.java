package poo;

import java.util.Scanner;

public class Rectangle {
    
    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return this.width * this.height;
    }

    public double getPerimeter(){
        return this.width * 2 + this.height * 2;
    }

    public double getDiagonal(){
        return Math.hypot(width, height);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rectangle width and height");    
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("AREA = " + rectangle.getArea());
        System.out.println("PERIMETER = " + rectangle.getPerimeter());
        System.out.println("DIAGONAL = " + rectangle.getDiagonal());
        scanner.close();
    }
}
