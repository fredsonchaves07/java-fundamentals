package exceptions.program;

import exceptions.model.entities.Reservation;
import exceptions.model.exceptions.ReservationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Room number: ");
            int roomNumber = scanner.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkin = simpleDateFormat.parse(scanner.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkout = simpleDateFormat.parse(scanner.next());

            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println(reservation);
            System.out.println();
            System.out.println("Enter the date to update ther reservation");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = simpleDateFormat.parse(scanner.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = simpleDateFormat.parse(scanner.next());

            reservation.updateDate(checkin, checkout);
            System.out.println(reservation);
        } catch (ParseException error) {
            System.out.println("Invalid date format");
        } catch (ReservationException error) {
            System.out.println(error.getMessage());
        }
    }
}
