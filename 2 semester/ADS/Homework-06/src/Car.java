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

    public Car (String model, Engine engine, Tires tires){
        this.model = model;
        this.engine = engine;
        this.tires = tires;
    }

    public Car (String model, Engine engine, Transmission transmission) {
        this.model = model;
        this.engine = engine;
    }

    public Car (String model){
        this.model = model;
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
        return engine.getPartPrice() + tires.getPartPrice() + transmission.partPrice;
    }

    public String toString(){
        if(tires != null && engine != null && transmission != null){
            return "Model: " + model + " \nEngine: " + engine + " \nTires: " + tires + " \nTransmission: " + transmission;
        } else if (tires != null && engine != null){
            return "Model: " + model + " \nEngine: " + engine + " \nTires: " + tires;
        } else if (engine != null && transmission != null){
            return "Model: " + model + " \nEngine: " + engine + " \nTransmission: " + transmission;
        } else if (tires != null && transmission != null){
            return "Model: " + model + " \nTires: " + tires + " \nTransmission: " + transmission;
        } else if (tires != null){
            return "Model: " + model + " \nTires: " + tires;
        } else if (engine != null){
            return "Model: " + model + " \nEngine: " + engine;
        } else if (transmission != null){
            return "Model: " + model + " \nTransmission: " + transmission;
        } else {
            return "Model: " + model;
        }
    }
}
