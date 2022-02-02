package poo.employerManagement.program;

import poo.employerManagement.entites.Employee;
import poo.employerManagement.entites.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        System.out.print("Enter the number of employees: ");
        int qtdEmployeer = scanner.nextInt();

        for (int i = 0; i < qtdEmployeer; i ++) {
            System.out.println("Employee #" + (i + 1) + " data");
            System.out.print("Outsourced ? (y/n): ");
            char outsourced = scanner.next().charAt(0);
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Hours: ");
            int hours = scanner.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHours = scanner.nextDouble();
            if (outsourced == 'y') {
                System.out.print("Additional charge: ");
                double additionalCharge = scanner.nextDouble();
                employees.add(new OutsourcedEmployee(name, hours, valuePerHours, additionalCharge));
            } else {
                employees.add(new Employee(name, hours, valuePerHours));
            }
        }

        System.out.println("Payments: ");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        scanner.close();
    }
}
