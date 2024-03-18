public class Tires extends Part{
    boolean isWinterTires;
    public Tires(String partName, int partNumber, double partPrice, boolean isWinterTires) {
        super(partName, partNumber, partPrice);
        this.isWinterTires = isWinterTires;
        this.partPrice = getPartPrice();
    }

    public String toString() {
        return super.toString() + " Winter Tires: " + isWinterTires;
    }

    public double getPartPrice() {
        if (isWinterTires) {
            return super.getPartPrice() + 50;
        } else {
            return super.getPartPrice();
        }
    }
}
