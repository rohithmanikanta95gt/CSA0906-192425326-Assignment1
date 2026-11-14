
import java.util.Scanner;

class ParkingVehicle {

    String regNo;
    String type;
    boolean monthlyPass;

    ParkingVehicle(String regNo, String type, boolean monthlyPass) {
        this.regNo = regNo;
        this.type = type;
        this.monthlyPass = monthlyPass;
    }

    double calculateFee(int minutes) {

        if (monthlyPass) {
            return 0;
        }

        int hours = (minutes + 59) / 60;

        if (type.equalsIgnoreCase("Bike")) {
            return hours * 10;
        } else if (type.equalsIgnoreCase("Car")) {
            return hours * 30;
        } else if (type.equalsIgnoreCase("EV")) {
            return hours * 40;
        }

        return -1;
    }
}

public class Task11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] slots = new String[3];
        ParkingVehicle[] vehicles = new ParkingVehicle[3];

        int count = 0;

        System.out.println("CAMPUS SMART PARKING SYSTEM");

        System.out.print("Enter Vehicle Number: ");
        String regNo = sc.nextLine();

        System.out.print("Enter Vehicle Type (Bike/Car/EV): ");
        String type = sc.nextLine();

        System.out.print("Monthly Pass? (yes/no): ");
        String pass = sc.nextLine();

        boolean monthlyPass = pass.equalsIgnoreCase("yes");

        // Validate vehicle type
        if (!type.equalsIgnoreCase("Bike") &&
            !type.equalsIgnoreCase("Car") &&
            !type.equalsIgnoreCase("EV")) {

            System.out.println("Invalid vehicle type!");
            sc.close();
            return;
        }

        // Check duplicate registration
        for (int i = 0; i < count; i++) {

            if (vehicles[i].regNo.equals(regNo)) {
                System.out.println("Duplicate vehicle number!");
                sc.close();
                return;
            }
        }

        // Find free slot
        int freeSlot = -1;

        for (int i = 0; i < slots.length; i++) {

            if (slots[i] == null) {
                freeSlot = i;
                break;
            }
        }

        if (freeSlot == -1) {
            System.out.println("Parking facility is full!");
            sc.close();
            return;
        }

        ParkingVehicle vehicle =
            new ParkingVehicle(regNo, type, monthlyPass);

        vehicles[count] = vehicle;
        slots[freeSlot] = regNo;
        count++;

        System.out.println("\nVehicle Parked Successfully!");
        System.out.println("Assigned Slot: " + freeSlot);

        System.out.print("\nEnter Parking Duration (minutes): ");
        int minutes = sc.nextInt();

        if (minutes < 0) {
            System.out.println("Invalid parking duration!");
            sc.close();
            return;
        }

        double fee = vehicle.calculateFee(minutes);

        System.out.println("\n----- PARKING BILL -----");
        System.out.println("Vehicle Number: " + regNo);
        System.out.println("Vehicle Type: " + type);
        System.out.println("Parking Duration: " + minutes);
        System.out.println("Parking Fee: Rs. " + fee);

        // Exit processing
        System.out.println("\nVehicle Exited Successfully!");

        slots[freeSlot] = null;
        vehicles[0] = null;

        System.out.println("Parking Slot Released: " + freeSlot);
        System.out.println("Remaining Occupied Slots: " +
                           (count - 1));

        sc.close();
    }
}
