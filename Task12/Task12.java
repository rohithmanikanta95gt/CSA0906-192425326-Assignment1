import java.time.Duration;

import java.time.LocalDate;

import java.time.LocalDateTime;

import java.time.LocalTime;

 

interface ParkingPass {

    boolean isValidOn(LocalDate date);

}

 

class OneDayPass implements ParkingPass {

    private final LocalDate validDate;

 

    OneDayPass(LocalDate validDate) {

        this.validDate = validDate;

    }

 

    @Override

    public boolean isValidOn(LocalDate date) {

        return validDate.equals(date);

    }

}

 

abstract class Vehicle {

    private final String regNo;

 

    Vehicle(String regNo) {

        this.regNo = regNo;

    }

 

    public String getRegNo() {

        return regNo;

    }

 

    public abstract double calculateFee(LocalDateTime entry, LocalDateTime exit);

}

 

class Car extends Vehicle {

    protected static final double RATE_PER_HOUR = 30.0;

 

    Car(String regNo) {

        super(regNo);

    }

 

    protected int billableHours(LocalDateTime entry, LocalDateTime exit) {

        long minutes = Duration.between(entry, exit).toMinutes();

        if (minutes <= 0) return 0;

        return (int) ((minutes + 59) / 60);

    }

 

    @Override

    public double calculateFee(LocalDateTime entry, LocalDateTime exit) {

        return billableHours(entry, exit) * RATE_PER_HOUR;

    }

}

 

class EBike extends Vehicle {

    // Illustrative flat fee; the assignment does not specify an amount.

    private static final double FLAT_FEE = 25.0;

 

    EBike(String regNo) {

        super(regNo);

    }

 

    @Override

    public double calculateFee(LocalDateTime entry, LocalDateTime exit) {

        return FLAT_FEE;

    }

}

 

class DeliveryVan extends Car {

    private static final double PEAK_START = 9.0;

    private static final double PEAK_END = 17.0;

 

    DeliveryVan(String regNo) {

        super(regNo);

    }

 

    @Override

    public double calculateFee(LocalDateTime entry, LocalDateTime exit) {

        int hours = billableHours(entry, exit);

        double total = 0;

        for (int i = 0; i < hours; i++) {

            LocalTime billedHourStart = entry.plusHours(i).toLocalTime();

            double hour = billedHourStart.getHour() + billedHourStart.getMinute() / 60.0;

            double rate = (hour >= PEAK_START && hour < PEAK_END)

                    ? RATE_PER_HOUR * 2 : RATE_PER_HOUR;

            total += rate;

        }

        return total;

    }

}

 

class ParkingFacility {

    private final String[][] slots;

 

    ParkingFacility(int[] slotsPerFloor) {

        slots = new String[slotsPerFloor.length][];

        for (int f = 0; f < slotsPerFloor.length; f++) {

            slots[f] = new String[slotsPerFloor[f]];

        }

    }

 

    int[] allocate(String regNo) {

        for (int f = 0; f < slots.length; f++) {

            for (int s = 0; s < slots[f].length; s++) {

                if (slots[f][s] == null) {

                    slots[f][s] = regNo;

                    return new int[] { f, s };

                }

            }

        }

        return null;

    }

}

 

public class Task12 {

    public static void main(String[] args) {

        LocalDate day = LocalDate.of(2026, 11, 16);

        LocalDateTime entry = day.atTime(10, 0);

        LocalDateTime exit = day.atTime(12, 0);

 

        ParkingFacility facility = new ParkingFacility(new int[] { 3, 4, 2, 5, 3 });

        Vehicle eBike = new EBike("TN11EB1111");

        Vehicle van = new DeliveryVan("TN12DV2222");

        Vehicle visitorCar = new Car("TN13VC3333");

        ParkingPass pass = new OneDayPass(day);

 

        int[] eBikeSlot = facility.allocate(eBike.getRegNo());

        int[] vanSlot = facility.allocate(van.getRegNo());

        int[] visitorSlot = facility.allocate(visitorCar.getRegNo());

 

        System.out.println("CAMPUS SMART PARKING - DESIGN CHALLENGE");

        System.out.println("Floors: 5 (different slot counts)");

        System.out.println("E-Bike Slot: Floor " + eBikeSlot[0] + ", Slot " + eBikeSlot[1]);

        System.out.println("E-Bike Flat Fee: Rs. " + eBike.calculateFee(entry, exit));

        System.out.println("Delivery Van Slot: Floor " + vanSlot[0] + ", Slot " + vanSlot[1]);

        System.out.println("Delivery Van Fee (10 AM-12 PM): Rs. " + van.calculateFee(entry, exit));

        System.out.println("Visitor Slot: Floor " + visitorSlot[0] + ", Slot " + visitorSlot[1]);

        double visitorFee = pass.isValidOn(day) ? 0.0 : visitorCar.calculateFee(entry, exit);

        System.out.println("One-Day Pass Valid: " + pass.isValidOn(day));

        System.out.println("Visitor Parking Fee: Rs. " + visitorFee);

        System.out.println("Note: Flat fee and one-day pass benefit are illustrative assumptions.");

    }

}
