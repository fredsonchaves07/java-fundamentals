package udemy.poo;

import java.util.Scanner;

public class ClassRoom {
    
    private String studentName;
    private double average;

    public ClassRoom(String studentName, double grade1, double grade2, double grade3){
        this.studentName = studentName;
        this.average = grade1 + grade2 + grade3;
    }

    public double getAverage(){
        return this.average;
    }

    public boolean isPass(){
        if(this.average < 60){
            return false;
        }
        return true;
    }

    public double getMissing(){
        return 60 - this.average;
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String student = scanner.nextLine();
        double grade1 = scanner.nextDouble();
        double grade2 = scanner.nextDouble();
        double grade3 = scanner.nextDouble();
        ClassRoom classRoom = new ClassRoom(student, grade1, grade2, grade3);
        System.out.println("FINAL GRADE = " + classRoom.getAverage());
        if(classRoom.isPass()){
            System.out.println("PASS");
        } else {
            System.out.println("FAILED");
            System.out.println("MISSING " + classRoom.getMissing() + " points");
        }
        scanner.close();
    }
}
