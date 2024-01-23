/*
        Написати окремий клас Student, що буде володіти двома полями: ім'я та середній бал.
    Написати клас, що вміє
    •	заповнювати масив Student'ів
    •	вміє сортувати студентів за зростанням або спаданням за ім'ям або середнім балом (алгоритм сортування узгоджується з викладачем на практичному занятті).
    •	вміє виводити інформацію про студентів на екран (з використанням методу toString() класу Student)
    Методи сортування для узгодження:
    •
    1.	Сортування вибором — ( англ.  Selection sort ) — пошук найменшого або найбільшого елемента і переміщення його в початок або кінець впорядкованого списку.
    2.	Сортування вставкою — (англ. Insertion sort) — Визначаємо місце де поточний елемент повинен знаходитися в упорядкованому списку, і вставляємо його туди.
    3.	Сортування обміном (сортування бульбашкою ( англ.  Bubble sort )) — для кожної пари індексів проводиться обмін, якщо елементи розташовані не по порядку.
    4.	Швидке сортування
    5.	Сортування злиттям

 */

import java.util.Random;
import java.util.Scanner;
import static java.lang.Integer.valueOf;

public class StudentManager {
    public static void main(String[] args){
        Random random = new Random();

        Student[] test = new Student[10];

        for(int i = 0; i < test.length; i++){
            test[i] = new Student();
            test[i].averageGrade = random.nextInt(100);
            System.out.print(test[i].averageGrade + ", ");
        }
        System.out.println("\n ---------------------");
//        SortingAlgorithms.selectionSort(test, SortingAlgorithms.sortOrder.DESCENDING);
//        SortingAlgorithms.insertionSort(test, SortingAlgorithms.sortOrder.DESCENDING);
//        SortingAlgorithms.bubbleSort(test, SortingAlgorithms.sortOrder.DESCENDING);
        SortingAlgorithms.quickSort(test, 0, test.length - 1,
        SortingAlgorithms.sortOrder.ASCENDING);
        printStudentInfo(test);
        //addStudents();
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

    public static void printStudentInfo(Student[] studentArray){
        for(Student student : studentArray){
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
