package list.employeesManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int quantityEmployee = scanner.nextInt();

        for(int i = 0; i < quantityEmployee; i++){
            System.out.println("Employee #" + (i + 1));
            System.out.print("Id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            employeeList.add(new Employee(id, name, salary));
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int idEmployeeIncrease = scanner.nextInt();
        Integer pos = position(employeeList, idEmployeeIncrease);

        if(pos != null){
            System.out.print("Enter ther percentage: ");
            double percentageIncrease = scanner.nextDouble();
            employeeList.get(pos).increaseSalary(percentageIncrease);
        } else {
            System.out.print("The id does not exists!!");
        }

        System.out.println("List of employess:");
        for(Employee employee : employeeList){
            System.out.println(employee);
        }

        scanner.close();
    }

    public static Integer position(List<Employee> employeeList, int id) {
        for(int i = 0; i < employeeList.size(); i ++){
            if(employeeList.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }
}
