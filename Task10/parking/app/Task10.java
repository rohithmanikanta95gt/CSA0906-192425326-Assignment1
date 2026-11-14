
package parking.app;

import java.util.Scanner;
import parking.model.Vehicle;

public class Task10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("PARKING ENCAPSULATION SYSTEM");

        System.out.print("Enter Vehicle Number: ");
        String regNo = sc.nextLine();

        System.out.print("Enter Parking Duration: ");
        int duration = sc.nextInt();

        Vehicle v = new Vehicle(regNo, duration);

        System.out.println("\nVehicle Details:");

        v.display();

        System.out.print("\nEnter New Duration: ");
        int newDuration = sc.nextInt();

        v.setDuration(newDuration);

        System.out.println("\nUpdated Vehicle Details:");
        v.display();

        // Wrapper class and autoboxing
        Integer parkingHours = 2;

        System.out.println("\nParking Hours: " + parkingHours);

        sc.close();
    }
}
