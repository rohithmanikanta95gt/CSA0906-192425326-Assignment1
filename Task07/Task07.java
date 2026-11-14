
class Vehicle {

    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    double calculateFee(int hours) {
        return hours * 20;
    }

    @Override
    public String toString() {
        return "Vehicle Number: " + regNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Vehicle)) return false;

        Vehicle other = (Vehicle) obj;
        return regNo.equals(other.regNo);
    }

    @Override
    public int hashCode() {
        return regNo.hashCode();
    }
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

class ElectricCar extends Vehicle {

    ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours) {
        return hours * 40;
    }
}

public class Task07 {

    public static void main(String[] args) {

        final int hours = 3;

        Vehicle bike = new TwoWheeler("TN01AB1234");
        Vehicle car = new Car("TN02CD5678");
        Vehicle ev = new ElectricCar("TN03EF9012");

        System.out.println("CAMPUS PARKING FEE SYSTEM");

        System.out.println(bike + " -> Rs. " + bike.calculateFee(hours));
        System.out.println(car + " -> Rs. " + car.calculateFee(hours));
        System.out.println(ev + " -> Rs. " + ev.calculateFee(hours));

        Vehicle v1 = new Car("TN02CD5678");
        Vehicle v2 = new Car("TN02CD5678");

        System.out.println("\nComparing Vehicles:");
        System.out.println("Are both vehicles equal? " + v1.equals(v2));
        System.out.println("Same Hash Code? " +
                           (v1.hashCode() == v2.hashCode()));
    }
}
