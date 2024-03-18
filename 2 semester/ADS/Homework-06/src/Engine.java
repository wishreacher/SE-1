public class Engine extends Part{
    enum EngineType {V4, V6, V8, V12};
    private EngineType engineType;

    public Engine(String partName, int partNumber, double partPrice, EngineType engineType) {
        super(partName, partNumber, partPrice);
        this.partPrice = getPartPrice();
        this.engineType = engineType;
    }

    public double getPartPrice(){
        return super.getPartPrice() + 1000.00;
    }

    public String toString(){
        return super.toString() + " EngineType: " + engineType;
    }
}
