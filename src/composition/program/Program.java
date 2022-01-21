package composition.program;

import composition.entities.Departament;
import composition.entities.HourContract;
import composition.entities.Worker;
import composition.entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter departament's name: ");
        String departamentName = scanner.nextLine();
        System.out.print("Enter worker data: ");
        String workName = scanner.nextLine();
        System.out.print("Level: ");
        String workerLevel = scanner.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = scanner.nextDouble();

        Departament departament = new Departament(departamentName);
        Worker worker = new Worker(workName, WorkerLevel.valueOf(workerLevel), baseSalary, departament);

        System.out.print("How many contracts to this worker? ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i ++) {
            System.out.println("Enter contract #" + i + " data");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = simpleDateFormat.parse(scanner.next());
            System.out.print("Value per hour: ");
            double valuePerHour = scanner.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = scanner.nextInt();
            HourContract hourContract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(hourContract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthYear = scanner.next();
        int month = Integer.parseInt(monthYear.split("/")[0]);
        int year = Integer.parseInt(monthYear.split("/")[1]);

        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + worker.getDepartament().getName());
        System.out.println("Income for " + monthYear + " : " + worker.income(year, month));

        scanner.close();
    }
}
