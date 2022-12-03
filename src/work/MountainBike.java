package work;

public class MountainBike extends Bicycle{
    Integer seatHeight;

    public MountainBike(int seatHeight) {
        this.seatHeight = seatHeight;
        System.out.println("MountainBike : parameterised constructor");
    }

    public MountainBike() {
        System.out.println("MountainBike : default constructor");
    }

    @Override
    public String toString() {
        return "MountainBike{" +
                "seatHeight=" + seatHeight +
                '}';
    }
}
