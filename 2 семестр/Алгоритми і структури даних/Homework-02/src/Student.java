public class Student {
    @Override
    public String toString() {
        return "Name: " + name + ". Average grade: " + averageGrade + ".";
    }

    public void fillStudents(String name, int grade){
        this.name = name;
        this.averageGrade = grade;
    }

    public String name = "";
    public int averageGrade = 0;
}
