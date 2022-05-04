package Activities;

public class Activity1 {
    public static void main(String[]arg) {
        Car honda=new Car();
        honda.make=2014;
        honda.color="brown";
        honda.transmission="Automatic";
        //using Card Class method
        honda.displayCharacterstics();
        honda.accelerate();
        honda.brake();
    }
}
