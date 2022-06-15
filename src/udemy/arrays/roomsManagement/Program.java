package udemy.arrays.roomsManagement;

import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student[] studentsRooms = new Student[10];

        System.out.print("How many rooms will be rented? ");
        int roomsQuantity = scanner.nextInt();
        System.out.println();

        for(int i = 0; i < roomsQuantity; i++){
            scanner.nextLine();
            System.out.println("Rent #" + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Room: ");
            int room = scanner.nextInt();
            System.out.println();
            studentsRooms[room] = new Student(name, email, room);
        }

        System.out.println("Busy rooms: ");

        for(int i = 0; i < studentsRooms.length; i++){
            if(studentsRooms[i] == null){
                continue;
            }
            System.out.println(studentsRooms[i]);
        }

        scanner.close();
    }
}
