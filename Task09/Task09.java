
abstract class Vehicle {

    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    abstract double calculateFee(int hours);

    void display() {
        System.out.println("Vehicle Number: " + regNo);
    }
}

interface Chargeable {

    double chargingFee(int units);
}

class TwoWheeler extends Vehicle {

    TwoWheeler(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours) {
        return hours * 10;
    }
}

class Car extends Vehicle {

    Car(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours) {
        return hours * 30;
    }
}

class ElectricCar extends Vehicle implements Chargeable {

    ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours) {
        return hours * 30;
    }

    @Override
    public double chargingFee(int units) {
        return units * 12;
    }
}

public class Task09 {

    public static void main(String[] args) {

        int hours = 2;

        TwoWheeler bike = new TwoWheeler("TN01AB1234");
        Car car = new Car("TN02CD5678");
        ElectricCar ev = new ElectricCar("TN03EF9012");

        System.out.println("CAMPUS SMART PARKING SYSTEM");

        System.out.println("\nTwo Wheeler:");
        bike.display();
        System.out.println("Parking Fee: Rs. " +
                           bike.calculateFee(hours));

        System.out.println("\nCar:");
        car.display();
        System.out.println("Parking Fee: Rs. " +
                           car.calculateFee(hours));

        System.out.println("\nElectric Car:");
        ev.display();
        System.out.println("Parking Fee: Rs. " +
                           ev.calculateFee(hours));
        System.out.println("Charging Fee: Rs. " +
                           ev.chargingFee(10));

        double total = ev.calculateFee(hours)
                     + ev.chargingFee(10);

        System.out.println("Total EV Fee: Rs. " + total);
    }
}
