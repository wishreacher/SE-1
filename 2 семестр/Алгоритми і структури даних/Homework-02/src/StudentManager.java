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
    enum sortOrder{
        ASCENDING,
        DESCENDING
    }
    public static void main(String[] args){
        Random random = new Random();

        Student[] test = new Student[10];

        for(int i = 0; i < test.length; i++){
            test[i] = new Student();
            test[i].averageGrade = random.nextInt(100);
            System.out.print(test[i].averageGrade + ", ");
        }
        System.out.println("\n ---------------------");
        //selectionSort(test, sortOrder.DESCENDING);
        //insertionSort(test, sortOrder.DESCENDING);
        //bubbleSort(test, sortOrder.DESCENDING);

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

    /*  Короткий опис цього алгоритму:
        Ми починаємо з найпершого елементу масиву, визначаємо його як найменший елемент. Далі ми рухаємось через весь масив у пошуках нового мінімуму.
        Коли знаходимо нове мінімальне число - міняємо його місцями з тим елементом від якого починали пошук та повторюємо це поки не закінчиться масив.
     */
    private static void selectionSort(Student[] array, sortOrder order){
        switch(order){
            case ASCENDING -> {
                for(int i = 0; i < array.length - 1; i++){
                    int min = array[i].averageGrade;
                    int indexMin = i;
                    for(int j = i + 1; j < array.length; j++){
                        if(array[j].averageGrade < min){
                            min = array[j].averageGrade;
                            indexMin = j;
                        }
                    }
                    swap(array, i, indexMin);
                }
            }
            case DESCENDING -> {
                for(int i = 0; i < array.length - 1; i++){
                    int max = array[i].averageGrade;
                    int indexMax = i;
                    for(int j = i + 1; j < array.length; j++){
                        if(array[j].averageGrade > max){
                            max = array[j].averageGrade;
                            indexMax = j;
                        }
                    }
                    swap(array, i, indexMax);
                }
            }
        }
    }

    private static void swap(Student[] array, int a, int b){
        Student temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /*  Короткий опис цього алгоритму:
        Починаємо з другого елементу масиву оскільки перший елемент завжди "відсортований".
        Ми дивимось чи попередній елемент масиву більше числа, яка ми маємо перемістити і якщо так, значення поперднього елементу призначаємо теперішньому
        і декрементуємо індекс, щоб рухатись далі ліворуч. Коли ми дійшли до потрібного місця, тобто початку масиву або ситуації, коли елемент зліва не більший
        теперішнього, ставимо на це місце початковий елемент та повторюємо цикл.

        логічніше було б назвати це якось типу shiftSort, це більше відповідає його практичній реалізації в коді
     */
    private static void insertionSort(Student[] array, sortOrder order){
        switch (order){
            case ASCENDING -> {
                //починаємо з одиниці, оскільки перший елемент завжди "відсортований"
                for(int i = 1; i < array.length; i++){
                    Student temp = array[i];
                    int j = i - 1;
                    while(j >= 0 && array[j].averageGrade > temp.averageGrade){
                        array[j + 1] = array[j];
                        j--;
                    }
                    array[j + 1] = temp;
                }
            }
            case DESCENDING -> {
                for(int i = 1; i < array.length; i++){
                    Student temp = array[i];
                    int j = i - 1;
                    while(j >= 0 && array[j].averageGrade < temp.averageGrade){
                        array[j + 1] = array[j];
                        j--;
                    }
                    array[j + 1] = temp;
                }
            }
        }
    }

    /* Короткий опис алгоритму:
        В списку елементів ми розглядаємо елементи по два, як своєрідну бульбашку. Якщо другий елемент в бульбашці більше першого - міняємо їх місцями і йдемо длалі.
        Після однієї ітерації свапа масив скоріш за все не буде відсортованим повністю, тому це має бути у вайл лупі. Ми можемо дізнатись чи масив відсортувався
        увівши булеву змінну яка відслідковувала би чи міняли ми щось місцями, якщо при одній ітерації нічого не змінилось, то масив вважаємо відсортованим.

     */
    private static void bubbleSort(Student[] array, sortOrder order){
        boolean didSwap = true;

        switch(order){
            case ASCENDING -> {
                while(didSwap){
                    didSwap = false;
                    for(int i = 0; i < array.length - 1; i++){
                        if(array[i].averageGrade > array[i + 1].averageGrade){
                            didSwap = true;
                            swap(array, i, i + 1);
                        }
                    }
                }
            }
            case DESCENDING -> {
                while(didSwap){
                    didSwap = false;
                    for(int i = 0; i < array.length - 1; i++){
                        if(array[i].averageGrade < array[i + 1].averageGrade){
                            didSwap = true;
                            swap(array, i, i + 1);
                        }
                    }
                }
            }
        }
    }
}
