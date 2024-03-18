public class Student {
    private String name;
    private double averageScore;
    private String address;

    public Student(String name, double averageScore, String address) {
        this.name = name;
        this.averageScore = averageScore;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public String getAddress() {
        return address;
    }
}