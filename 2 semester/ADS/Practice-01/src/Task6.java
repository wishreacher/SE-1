/*
    Написати клас StudentsGrades, що містить приватний масив цілих чисел, в якому зберігаються оцінки групи студентів
    (оцінки можуть мати значення від 0 до 100).
    Клас повинен містити публічні методи для зчитування масиву (getter), присвоєння йому значення іншого масиву (setter)
    та додавання даних до нього (adder), а також методи, які повертають такі статистичні дані:

    //TODO друге практичне тут теж є
    максимальна оцінка в групі
    мінімальна оцінка в групі
    середній бал групи
    кількість студентів в яких бал вищий за середній
    кількість студентів в яких бал нижчий за середній
    кількість студентів з відмінною оцінкою
    кількість студентів з оцінкою "добре"
    кількість студентів з оцінкою "задовільно"
    кількість студентів з оцінкою "не задовільно"
    TODO вивести всі оцінки (метод toString())
    Оцінки задаються від 0 до 100. "0-59" - незадовільно, "60-70" - задовільно, "71-90" - добре, "91-100" - відмінно.

    Написати клас-тестер із функцією main, в ході якої створюється об'єкт класу StudentsGrades,
    зчитуються з клавіатури оцінки студентів та друкуються усі вищеперераховані статистичні дані.
 */

public class Task6 {
    private int[] grades;

    enum sortType {
            ascending,
            descending
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < grades.length; i++) {
            s.append(grades[i]).append("\n");
        }
        return s.toString();
    }

    public int[] getGradesArray() {
        return grades;
    }

    public void setGradesArray(int[] newArray) {
        grades = newArray;
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
        System.out.println("Max Grade: " + getMaxGrade(grades));
        System.out.println("Min Grade: " + getMinGrade(grades));
        System.out.println("Average: " + getAverage());
        System.out.println("Amount of nerds: " + amountOfNerds());
        System.out.println("Amount of suckers: " + amountOfSuckers());
        System.out.println("Amount of vidminno: " + getVidminno());
        System.out.println("Amount of dobre: " + getDobre());
        System.out.println("Amount of zadovilno: " + getZadovilno());
        System.out.println("Amount of nezadovilno: " + getNezadovilno());
    }

    public int getMaxGrade(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public int getMinGrade(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public double getAverage() {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return sum / grades.length;
    }

    public int amountOfNerds() {
        double average = getAverage();
        int nerds = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > average) {
                nerds++;
            }
        }
        return nerds;
    }

    public int amountOfSuckers() {
        double average = getAverage();
        int nerds = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < average) {
                nerds++;
            }
        }
        return nerds;
    }

    public int getVidminno() {
        int n = 0;
        for (int i = 0; i < grades.length; i++) {
            if (91 <= grades[i] && grades[i] <= 100) {
                n++;
            }
        }
        return n;
    }

    public int getZadovilno() {
        int n = 0;
        for (int i = 0; i < grades.length; i++) {
            if (60 <= grades[i] && grades[i] <= 70) {
                n++;
            }
        }
        return n;
    }

    public int getDobre() {
        int n = 0;
        for (int i = 0; i < grades.length; i++) {
            if (71 <= grades[i] && grades[i] <= 90) {
                n++;
            }
        }
        return n;
    }

    public int getNezadovilno() {
        int n = 0;
        for (int i = 0; i < grades.length; i++) {
            if (0 <= grades[i] && grades[i] <= 59) {
                n++;
            }
        }
        return n;
    }

    public String sort(int[] array, sortType type){
        int[] initialArray = array;
        int[] sortedArray = new int[0];

        while(initialArray != null){
            int peak;
            switch(type){
                case ascending -> peak = getMinGrade(initialArray);
                case descending -> peak = getMaxGrade(initialArray);
                case null, default -> peak = 0;
            }
            //add peak element to a sorted array
            if(sortedArray == null){
                int[] newGrades = new int[1];
                newGrades[0] = peak;
                sortedArray = newGrades;
            } else{
                int[] intermediateArray = new int[sortedArray.length + 1];
                for (int i = 0; i < sortedArray.length; i++) {
                    intermediateArray[i] = sortedArray[i];
                }
                intermediateArray[sortedArray.length] = peak;
                sortedArray = intermediateArray;
            }

            //remove this element from given array
            int[] intermediateArray = new int[initialArray.length - 1];
            int j = 0;
            for (int i = 0; i < initialArray.length; i++) {
                if(initialArray[i] != peak){
                    intermediateArray[j++] = initialArray[i];
                }
            }
            initialArray = intermediateArray;
            if (initialArray.length == 0) break;
        }
        return arrayToString(sortedArray);
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
