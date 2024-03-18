// Переробити ієрархію класів car з попереднього практичного так, щоб показати потужність поліморфізму.
public class Tester {
    public static void main(String[] args) {
        Tires tireUltra = new Tires("Tire-Ultra", 123, 100, true);
        Tires suckerTires = new Tires("Sucker-Tires", 321, 100, false);

        Transmission transmissionUltra = new Transmission("Transmission-Ultra", 456, 322);
        Transmission transmissionSucker = new Transmission("Transmission-Sucker", 654, 69);

        Engine engineUltra = new Engine("Engine-Ultra", 789, 1000, Engine.EngineType.V6);
        Engine engineSucker = new Engine("Engine-Sucker", 987, 750, Engine.EngineType.V8);

//        System.out.println(engineUltra);
//        System.out.println(engineSucker);

        Car ultraCar = new Car("UltraCar", engineUltra, tireUltra, transmissionUltra);
        Car suckerCar = new Car("SuckerCar", engineSucker, suckerTires, transmissionSucker);

        System.out.println(ultraCar);
        System.out.println("");
        System.out.println(suckerCar);
        System.out.println("");
        Car plainCar = new Car("PlainCar");
        System.out.println(plainCar);
    }
}
