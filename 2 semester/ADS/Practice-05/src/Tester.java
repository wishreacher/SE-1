public class Tester {
    public static void main(String[] args) {
        Tires tireUltra = new Tires("Tire-Ultra", 123, 1488);
        Tires suckerTires = new Tires("Sucker-Tires", 321, 100);

        Transmission transmissionUltra = new Transmission("Transmission-Ultra", 456, 322);
        Transmission transmissionSucker = new Transmission("Transmission-Sucker", 654, 69);

        Engine engineUltra = new Engine("Engine-Ultra", 789, 1939);
        Engine engineSucker = new Engine("Engine-Sucker", 987, 228);

        Car ultraCar = new Car("UltraCar", engineUltra, tireUltra, transmissionUltra);
        Car suckerCar = new Car("SuckerCar", engineSucker, suckerTires, transmissionSucker);

        System.out.println("Price of " + ultraCar.getModel() + " - " + ultraCar.calculatePrice());
        System.out.println("Price of " + suckerCar.getModel() + " - " + suckerCar.calculatePrice());
    }
}
