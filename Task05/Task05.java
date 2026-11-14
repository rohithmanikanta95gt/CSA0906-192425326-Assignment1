
class ParkingTicket {

    // Static variable shared by all objects
    static int ticketCounter;

    // Instance variables
    int ticketNo;
    String vehicleNo;

    // Static block
    static {
        ticketCounter = 1000;
        System.out.println("Parking System Initialized");
    }

    // Constructor
    ParkingTicket(String vehicleNo) {
        ticketCounter++;
        ticketNo = ticketCounter;
        this.vehicleNo = vehicleNo;
    }

    // Static method
    static void displayCounter() {
        System.out.println("Total Tickets Generated: " + ticketCounter);
    }

    void displayTicket() {
        System.out.println("Ticket Number: " + ticketNo);
        System.out.println("Vehicle Number: " + vehicleNo);
    }
}

public class Task05 {

    public static void main(String[] args) {

        System.out.println("CAMPUS SMART PARKING SYSTEM");

        ParkingTicket t1 = new ParkingTicket("TN01AB1234");
        ParkingTicket t2 = new ParkingTicket("TN02CD5678");
        ParkingTicket t3 = new ParkingTicket("TN03EF9012");

        System.out.println("\n----- TICKET DETAILS -----");

        t1.displayTicket();
        System.out.println();

        t2.displayTicket();
        System.out.println();

        t3.displayTicket();

        System.out.println();
        ParkingTicket.displayCounter();

        // Removing reference
        t1 = null;

        System.out.println("\nFirst ticket reference removed.");
        System.out.println("Ticket 1 may now be eligible for garbage collection.");

        System.out.println("Other tickets are still accessible.");
    }
}
