
import java.time.LocalTime;
import java.time.Duration;

interface Chargeable {
    double chargingFee(int kWh);
}

class Vehicle {

    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    double ratePerHour() {
        return 20;
    }

    // Method overloading - first method
    double calculateFee(int minutes) {

        int hours = (minutes + 59) / 60;
        return hours * ratePerHour();
    }

    // Method overloading - second method
    double calculateFee(LocalTime in, LocalTime out) {

        int minutes = (int) Duration.between(in, out).toMinutes();

        return calculateFee(minutes);
    }

    String getRegNo() {
        return regNo;
    }
}

class TwoWheeler extends Vehicle {

    TwoWheeler(String regNo) {
        super(regNo);
    }

    @Override
    double ratePerHour() {
        return 10;
    }
}

class Car extends Vehicle {

    Car(String regNo) {
        super(regNo);
    }

    @Override
    double ratePerHour() {
        return 30;
    }
}

class ElectricCar extends Car implements Chargeable {

    ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    public double chargingFee(int kWh) {
        return kWh * 12;
    }
}

public class Task08 {

    public static void main(String[] args) {

        // Upcasting and runtime polymorphism
        Vehicle[] parked = {
            new TwoWheeler("TN01A1"),
            new Car("TN02B2"),
            new ElectricCar("TN03C3")
        };

        System.out.println("CAMPUS SMART PARKING SYSTEM");

        for (Vehicle v : parked) {

            double fee = v.calculateFee(130);

            if (v instanceof Chargeable) {
                Chargeable c = (Chargeable) v;
                fee += c.chargingFee(10);
            }

            System.out.println(
                v.getClass().getSimpleName() + " " +
                v.getRegNo() + " -> Rs. " + fee
            );
        }

        // Compile-time polymorphism
        Vehicle car = new Car("TN04D4");

        double fee1 = car.calculateFee(120);
        double fee2 = car.calculateFee(
            LocalTime.of(10, 0),
            LocalTime.of(12, 0)
        );

        System.out.println("\nMethod Overloading:");
        System.out.println("Fee using minutes: Rs. " + fee1);
        System.out.println("Fee using time: Rs. " + fee2);

        // Equality demonstration
        System.out.println("\nAre Car and ElectricCar equal? " +
            new Car("TN02B2").getRegNo().equals(
                new ElectricCar("TN02B2").getRegNo()
            ));
    }
}
