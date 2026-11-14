
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Jagged array: different slots on each floor
        String[][] slots = {
            new String[2],
            new String[3],
            new String[4]
        };

        System.out.println("CAMPUS SMART PARKING SYSTEM");
        System.out.println("Total Floors: " + slots.length);

        // Display available slots on each floor
        for (int i = 0; i < slots.length; i++) {
            System.out.println("Floor " + i + " has " + slots[i].length + " slots");
        }

        System.out.print("\nEnter Vehicle Number: ");
        String vehicleNo = sc.nextLine();

        System.out.print("Enter Floor Number (0-2): ");
        int floor = sc.nextInt();

        System.out.print("Enter Slot Number: ");
        int slot = sc.nextInt();

        // Validate floor and slot
        if (floor < 0 || floor >= slots.length ||
            slot < 0 || slot >= slots[floor].length) {

            System.out.println("Invalid floor or slot number!");

        } else if (slots[floor][slot] != null) {

            System.out.println("Slot is already occupied!");

        } else {

            slots[floor][slot] = vehicleNo;

            System.out.println("\nVehicle parked successfully!");
            System.out.println("Vehicle Number: " + vehicleNo);
            System.out.println("Floor Number: " + floor);
            System.out.println("Slot Number: " + slot);
        }

        System.out.print("\nEnter Parking Duration in Minutes: ");
        int minutes = sc.nextInt();

        // Calculate hours using integer arithmetic
        int hours = (minutes + 59) / 60;

        // Parking rate: Rs. 30 per hour
        double rate = 30.0;
        double fee = hours * rate;

        System.out.println("\n----- PARKING FEE DETAILS -----");
        System.out.println("Parking Duration: " + minutes + " minutes");
        System.out.println("Billable Hours: " + hours);
        System.out.println("Rate Per Hour: Rs. " + rate);
        System.out.println("Total Parking Fee: Rs. " + fee);

        sc.close();
    }
}
