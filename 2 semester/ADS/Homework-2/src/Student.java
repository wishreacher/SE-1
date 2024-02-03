public class Student {
    @Override
    public String toString() {
        return "Name: " + name + ". Average grade: " + averageGrade + ".";
    }

    public void fillStudent(String name, int grade){
        this.name = name;
        this.averageGrade = grade;
    }

    public String name = "default";
    //todo add surname
    public int averageGrade = 0;
}
