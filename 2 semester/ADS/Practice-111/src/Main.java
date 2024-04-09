/*
    Написати програму, що формує групу студентів і корисні методи.
    Використовуючи колекції.

    Федорич Володимир
 */

public class Main {
    public static void main(String[] args){
        Group group = new Group();

        group.addStudent(new Student("Ivan", 20, 2));
        group.addStudent(new Student("Petro", 21, 3));
        group.addStudent(new Student("Vasyl", 19, 1));

        System.out.println("Students sorted by name: ");
        group.sortByName();
        group.printStudents();

        System.out.println("Students sorted by age: ");
        group.sortByAge();
        group.printStudents();

        System.out.println("Students sorted by course: ");
        group.sortByCourse();
        group.printStudents();

        System.out.println("Some students removed: ");
        group.removeStudent(1);
        group.printStudents();
    }

}
