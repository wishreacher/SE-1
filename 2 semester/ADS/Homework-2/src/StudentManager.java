/*
    Написати окремий клас Student, що буде володіти двома полями: ім'я та середній бал.

    Написати клас, що вміє

    заповнювати масив Student'ів
    вміє сортувати студентів за зростанням або спаданням за ім'ям або середнім балом
    (алгоритм SELECTION SORT).
    вміє виводити інформацію про студентів на екран (з використанням методу toString() класу Student)

    Під час захисту виконаної роботи обов'язкове пояснення і демонстрація роботи вибраного
    алгоритму сортування

    Автор: Федорич Володимир
 */

import java.io.IOException;
public class StudentManager {
    static Student[] students = new Student[0];
    public static void main(String[] args) throws IOException {
        System.out.println("Enter students to add to the array\n-------------------");
        StudentsInput();
        printStudentInfo(students);
        while(true){
            System.out.println("\n1 - add students, \n2 - sort by grade, \n3 - sort by name");
            int choice = DataInput.getInt();
            while(choice != 1 && choice != 2 && choice != 3){
                System.out.println("Wrong input. Enter 1 or 2");
                choice = DataInput.getInt();
            }
            switch (choice){
                case 1 -> {
                    StudentsInput();
                }
                case 2 ->{
                    if(students.length == 0){
                        System.out.println("Student array is empty");
                        continue;
                    }
                    sortByGrade();
                }
                case 3 ->{
                    if(students.length == 0){
                        System.out.println("Student array is empty");
                        continue;
                    }
                    sortByName();
                }
            }
        }
    }

    private static void sortByName() {
        switch(askForSortOrder()){
            case 1 -> {
                SortingAlgorithms.selectionSortByName(students, SortingAlgorithms.sortOrder.ASCENDING);
            }
            case 2 ->{
                SortingAlgorithms.selectionSortByName(students, SortingAlgorithms.sortOrder.DESCENDING);
            }
        }
        printStudentInfo(students);
    }

    private static void sortByGrade() {
        switch(askForSortOrder()){
            case 1 -> {
                SortingAlgorithms.selectionSortByGrade(students, SortingAlgorithms.sortOrder.ASCENDING);
            }
            case 2 ->{
                SortingAlgorithms.selectionSortByGrade(students, SortingAlgorithms.sortOrder.DESCENDING);
            }
        }
        printStudentInfo(students);
    }

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

    public static void StudentsInput() throws IOException {
        System.out.println("Entering student info");
        if(students.length == 0){
            askForStudentDescription();
        }
        while(true){
            System.out.println("1 - add a new student. 0 - stop adding");
            int choice = DataInput.getInt();
            if(choice == 0){
                break;
            } else if(choice == 1){
                askForStudentDescription();
            } else{
                System.out.println("Please enter 1 or 0");
            }
        }
    }

    private static void askForStudentDescription() throws IOException {
        String name;
        int grade;

        System.out.println("Enter name:");
        name = DataInput.getString();
        System.out.println("Enter grade:");
        grade = DataInput.getInt();

        Student newStudent = new Student();
        newStudent.fillStudent(name, grade);

        students = addValueToArray(newStudent, students);
    }

    public static void printStudentInfo(Student[] studentArray){
        System.out.println("-------------------\n");
        for(Student student : studentArray){
            System.out.println(student);
        }
    }

    public static int askForSortOrder(){
        System.out.println("Enter 1 to sort in an ascending order, enter 2 to sort in descending order");
        int sortOrder = DataInput.getInt();
        while(sortOrder != 1 && sortOrder != 2){
            System.out.println("Wrong input. Enter 1 or 2");
            sortOrder = DataInput.getInt();
        }
        return sortOrder;
    }
}
