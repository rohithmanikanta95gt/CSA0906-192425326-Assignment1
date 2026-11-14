
import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Parking slots: 2 floors, 3 slots each
        boolean[][] slots = new boolean[2][3];

        System.out.println("CAMPUS SMART PARKING SYSTEM");

        System.out.print("Enter Vehicle Number: ");
        String vehicleNo = sc.nextLine();

        int floorFound = -1;
        int slotFound = -1;

        // Search for a free slot
        for (int i = 0; i < slots.length; i++) {

            for (int j = 0; j < slots[i].length; j++) {

                if (slots[i][j]) {
                    continue;
                }

                slots[i][j] = true;
                floorFound = i;
                slotFound = j;
                break;
            }

            if (floorFound != -1) {
                break;
            }
        }

        if (floorFound == -1) {
            System.out.println("No parking slot available!");
            return;
        }

        System.out.println("\nParking Successful!");
        System.out.println("Vehicle Number: " + vehicleNo);
        System.out.println("Floor Number: " + floorFound);
        System.out.println("Slot Number: " + slotFound);

        // Calculate parking fee
        System.out.print("\nEnter Parking Duration (minutes): ");
        int minutes = sc.nextInt();

        if (minutes <= 0) {
            System.out.println("Invalid parking duration!");
            sc.close();
            return;
        }

        int hours = (minutes + 59) / 60;
        double fee;

        if (hours <= 1) {
            fee = 30;
        } else if (hours <= 3) {
            fee = 30 + (hours - 1) * 20;
        } else {
            fee = 70 + (hours - 3) * 10;
        }

        System.out.println("\n----- PARKING FEE -----");
        System.out.println("Billable Hours: " + hours);
        System.out.println("Total Fee: Rs. " + fee);

        sc.close();
    }
}
