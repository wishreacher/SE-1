/*
    Створити ієрархію класів, що описує машину використовуючи наслідування і композицію.

    Ступінь деталізації власний. Мають бути присутні обидва компоненти.
 */

public class Car {

    private String model;
    private Engine engine;
    private Tires tires;
    private Transmission transmission;

    public Car(String model, Engine engine, Tires tires, Transmission transmission) {
        this.model = model;
        this.engine = engine;
        this.tires = tires;
        this.transmission = transmission;
    }

    public Engine getEngine() {
        return engine;
    }

    public Tires getTires() {
        return tires;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public String getModel() {
        return model;
    }

    public double calculatePrice(){
        return engine.partPrice + tires.partPrice + transmission.partPrice;
    }
}
