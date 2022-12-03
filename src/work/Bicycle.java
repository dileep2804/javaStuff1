package work;

public class Bicycle {
    int gear;
    int speed;

//    public Bicycle(int gear, int speed) {
//        super();
//        System.out.println("Bicycle: constructor");
//    }

    public Bicycle(){
        System.out.println("Bicycle : default constructor");
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "gear=" + gear +
                ", speed=" + speed +
                '}';
    }
}
