package udemy.model.program;

import udemy.model.entities.CarRental;
import udemy.model.entities.Vehicle;
import udemy.model.services.BazilTaxService;
import udemy.model.services.RentalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:ss");
        System.out.println("Enter rental data");
        System.out.print("Car model: ");
        String carModel = scanner.nextLine();
        System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
        Date start = simpleDateFormat.parse(scanner.nextLine());
        System.out.print("Return (dd/MM/yyyy hh:ss): ");
        Date finish = simpleDateFormat.parse(scanner.nextLine());
        CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));
        System.out.print("Enter price per hour: ");
        double pricePerHour = scanner.nextDouble();
        System.out.print("Enter price per day: ");
        double pricePerDay = scanner.nextDouble();
        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BazilTaxService());
        rentalService.processInvoice(carRental);
        System.out.println("INVOICE");
        System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));
        scanner.close();
    }
}
