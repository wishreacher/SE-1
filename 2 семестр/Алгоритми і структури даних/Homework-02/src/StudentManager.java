import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class StudentManager {
    public static void main(String[] args){
        addStudents();
    }
    public static Student[] students = new Student[0];

    public static Student[] addValueToArray(Student value, Student[] originalArray) {
        Student[] newArray = new Student[originalArray.length + 1];

        // Copy old values
        for (int i = 0; i < originalArray.length; i++) {
            newArray[i] = originalArray[i];
        }

        // Add new value
        newArray[newArray.length - 1] = value;

        return newArray;
    }

    public static void addStudents(){
        System.out.println("Entering student info");
        //TODO change it to string input
        while(true){
            System.out.println("1 - add a new student. 0 - stop adding");
            int choice = readInt();
            if(choice == 0){
                break;
            } else if(choice == 1){
                String name;
                int grade;

                System.out.println("Enter name:");
                name = read();
                System.out.println("Enter grade:");
                grade = readInt();

                Student newStudent = new Student();
                newStudent.fillStudents(name, grade);

                students = addValueToArray(newStudent, students);
            } else{
                System.out.println("Please enter 1 or 0");
            }
        }
    }

    public static void printStudentInfo(){
        for(Student student : students){
            System.out.println(student);
        }
    }

    static String read(){
        Scanner sc= new Scanner(System.in);
        return sc.nextLine();
    }

    static int readInt(){
        return valueOf(read());
    }
}
