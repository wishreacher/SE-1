/*
    Написати клас, який описує студента НаУКМА використовуючи наступні елементи:

    змінні екземпляра - +
    змінні класу - +
    public і private методи - +
    javadoc - +
    toString - +
    Та клас який використовує клас Student.

    У Вас мають бути різні конструктори класів
    (наприклад, порожній; тільки ПІБ; та  повний - з усіма параметрами)
 */

public class Student {
    /**
     * Student class constructor with no parameters. Sets name and faculty to default values
     * @autor Fedorych Volodymyr
     */
    public Student(){
        name = "No name";
        faculty = "No faculty";
    }

    /**
     * Student class constructor with 2 parameters
     * @param newName student's name
     * @param newFaculty student's faculty
     * @author Fedorych Volodymyr
     */
    public Student(String newName, String newFaculty){
        name = newName;
        faculty = newFaculty;
    }

    /**
     * Overrides the toString() method to return student's name, faculty and year of study
     * @author Fedorych Volodymyr
     */
    public String toString() {
        return "Student " + name + " from faculty " + faculty +
                " is studying their " + year + " year";
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    private void setYear(int newYear) {
        year = newYear;
    }

    private String name;
    private String faculty;
    private static int year = 1;
}
