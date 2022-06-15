package udemy.poo;

import java.util.Scanner;

public class Employee {
    
    private String name;
    private double grossSalary;
    private double tax;

    public Employee(String name, double grossSalary, double tax){
        this.name = name;
        this.grossSalary = grossSalary;
        this.tax = tax;
    }

    public double netSalary(){
        return this.grossSalary - this.tax;
    }

    public void increaseSalary(double percentage){
        this.grossSalary += this.grossSalary *  (percentage / 100);
    }

    @Override
    public String toString() {
        return this.name + ", $" + this.netSalary();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Gross salary: ");
        double grossSalary = scanner.nextDouble();
        System.out.print("Tax: ");
        double tax = scanner.nextDouble();
        Employee employee = new Employee(name, grossSalary, tax);
        System.out.println("Employee: " + employee);
        System.out.print("Which percentage to increase salary? ");
        double percentage = scanner.nextDouble();
        employee.increaseSalary(percentage);
        System.out.println("Employee: " + employee);
        scanner.close();
    }
}
