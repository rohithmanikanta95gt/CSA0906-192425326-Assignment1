
class ParkingTicket {

    int ticketNo;
    String vehicleNo;
    String vehicleType;
    String entryTime;

    // Default constructor
    ParkingTicket() {
        this(1001, "UNKNOWN", "Unknown", "Not Recorded");
    }

    // Parameterized constructor
    ParkingTicket(int ticketNo, String vehicleNo,
                  String vehicleType, String entryTime) {

        this.ticketNo = ticketNo;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.entryTime = entryTime;
    }

    // Overloaded constructor
    ParkingTicket(int ticketNo, String vehicleNo) {
        this(ticketNo, vehicleNo, "Car", "10:00 AM");
    }

    void display() {
        System.out.println("\nTicket Number : " + ticketNo);
        System.out.println("Vehicle Number: " + vehicleNo);
        System.out.println("Vehicle Type  : " + vehicleType);
        System.out.println("Entry Time    : " + entryTime);
    }
}

public class Task04 {

    public static void main(String[] args) {

        // Using default constructor
        ParkingTicket t1 = new ParkingTicket();

        // Using parameterized constructor
        ParkingTicket t2 = new ParkingTicket(
            1002, "TN01AB1234", "Bike", "09:30 AM"
        );

        // Using overloaded constructor
        ParkingTicket t3 = new ParkingTicket(
            1003, "TN02CD5678"
        );

        System.out.println("CAMPUS PARKING TICKET SYSTEM");

        System.out.println("\nTicket 1:");
        t1.display();

        System.out.println("\nTicket 2:");
        t2.display();

        System.out.println("\nTicket 3:");
        t3.display();
    }
}
