package exceptions.program;

import exceptions.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkin = simpleDateFormat.parse(scanner.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkout = simpleDateFormat.parse(scanner.next());

        if (!checkout.after(checkin)) {
            System.out.println("Error in reservation: check-out date must be afeter check-in");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println(reservation);
            System.out.println();
            System.out.println("Enter the date to update ther reservation");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = simpleDateFormat.parse(scanner.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = simpleDateFormat.parse(scanner.next());

            Date now = new Date();

            if (checkin.before(now) || checkout.before(now)) {
                System.out.println("Error in reservation: reservation for update must be future dates");
            } else if (!checkout.after(checkin)){
                System.out.println("Error in reservation: check-out date must be afeter check-in");
            } else {
                reservation.updateDate(checkin, checkout);
            }
        }

        scanner.close();
    }
}
