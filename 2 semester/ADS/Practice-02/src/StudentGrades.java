/*
    Написати клас StudentsGrades, що містить приватний масив цілих чисел, в якому зберігаються оцінки групи студентів
    (оцінки можуть мати значення від 0 до 100).
    Клас повинен містити публічні методи для зчитування масиву (getter), присвоєння йому значення іншого масиву (setter)
    та додавання даних до нього (adder), а також методи, які повертають такі статистичні дані:

    максимальна оцінка в групі
    мінімальна оцінка в групі
    середній бал групи
    кількість студентів в яких бал вищий за середній
    кількість студентів в яких бал нижчий за середній
    кількість студентів з відмінною оцінкою
    кількість студентів з оцінкою "добре"
    кількість студентів з оцінкою "задовільно"
    кількість студентів з оцінкою "не задовільно"
    вивести всі оцінки (метод toString())
    Оцінки задаються від 0 до 100. "0-59" - незадовільно, "60-70" - задовільно, "71-90" - добре, "91-100" - відмінно.

    Написати клас-тестер із функцією main, в ході якої створюється об'єкт класу StudentsGrades,
    зчитуються з клавіатури оцінки студентів та друкуються усі вищеперераховані статистичні дані.

    ---------------------------------------------------------------------------------
    До попереднього практичного додати метод, що вміє сортувати масивоцінок студентів.
    Реалізувати можливість сортувати як за зростанням так і за спаданням.

    Реалізувати метод, що перевіряє, що масив правильно відсортований.

    Має бути реалізований власний метод сортування.
    Оберіть той, що вам простіше реалізувати
 */

public class StudentGrades {
    private int[] grades;

    enum sortOrder {
        ASCENDING,
        DESCENDING
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < grades.length; i++) {
            s.append(grades[i]).append("\n");
        }
        return s.toString();
    }

    public void setGradesArray(int[] newArray) {
        grades = newArray;
    }

    public int[] getGrades(){
        return grades;
    }

    public void addGrade(int grade) {
        if(grades == null){
            int[] newGrades = new int[1];
            newGrades[0] = boundNumber(grade);
            grades = newGrades;
        } else{
            int[] newGrades = new int[grades.length + 1];
            for (int i = 0; i < grades.length; i++) {
                newGrades[i] = grades[i];
            }
            newGrades[grades.length] = boundNumber(grade);
            grades = newGrades;
        }
    }

    public void printInfo(){
        System.out.println("Max Grade: " + Practice1Getters
                .getMaxGrade(grades));
        System.out.println("Min Grade: " + Practice1Getters
                .getMinGrade(grades));
        System.out.println("Average: " + Practice1Getters
                .getAverage(grades));
        System.out.println("Amount of nerds: " + Practice1Getters
                .amountOfNerds(grades));
        System.out.println("Amount of suckers: " + Practice1Getters
                .amountOfSuckers(grades));
        System.out.println("Amount of vidminno: " + Practice1Getters
                .getVidminno(grades));
        System.out.println("Amount of dobre: " + Practice1Getters
                .getDobre(grades));
        System.out.println("Amount of zadovilno: " + Practice1Getters
                .getZadovilno(grades));
        System.out.println("Amount of nezadovilno: " + Practice1Getters
                .getNezadovilno(grades));
    }

    public boolean isSorted(int[] array, sortOrder order){
        switch(order){
            case ASCENDING -> {
                for(int i = 0; i < array.length - 1; i++){
                    if(array[i] > array[i + 1]){
                        return false;
                    }
                }
            }
            case DESCENDING -> {
                for(int i = 0; i < array.length - 1; i++){
                    if(array[i] < array[i + 1]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void sort(int[] array, sortOrder order){
        boolean didSwap = true;

        switch(order){
            case ASCENDING -> {
                while(didSwap){
                    didSwap = false;
                    for(int i = 0; i < array.length - 1; i++){
                        if(array[i] > array[i + 1]){
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
                        if(array[i] < array[i + 1]){
                            didSwap = true;
                            swap(array, i, i + 1);
                        }
                    }
                }
            }
        }
    }

    public static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public String arrayToString(int[] array){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            s.append(array[i]).append("\n");
        }
        return s.toString();
    }

    public static int boundNumber(int num) {
        return Math.min(Math.max(num, 0), 100);
    }
}
