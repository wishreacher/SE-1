public class Part {
    public Part(String partName, int partNumber, double partPrice){
        this.partName = partName;
        this.partNumber = partNumber;
        this.partPrice = partPrice;
    }

    String partName;
    int partNumber;
    double partPrice;

    public String toString(){
        return "Part Name: " + partName + " Part Number: " + partNumber + " Part Price: " + partPrice;
    }
}
