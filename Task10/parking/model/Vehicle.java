
package parking.model;

public class Vehicle {

    private String regNo;
    private int duration;

    public Vehicle(String regNo, int duration) {
        this.regNo = regNo;
        setDuration(duration);
    }

    public String getRegNo() {
        return regNo;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {

        if (duration > 0) {
            this.duration = duration;
        } else {
            System.out.println("Invalid duration!");
        }
    }

    public void display() {
        System.out.println("Vehicle Number: " + regNo);
        System.out.println("Duration: " + duration + " minutes");
    }
}
