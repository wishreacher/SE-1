import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {
        StudentGrades grades = new StudentGrades();

        System.out.println("Enter grades to add to the array\n-------------------");
        gradeInput(grades);
        //grades.printInfo();


        while(true){
            System.out.println("\n1 - add students, \n2 - sort by grade");
            int choice = DataInput.getInt();
            while(choice != 1 && choice != 2 && choice != 3){
                System.out.println("Wrong input. Enter 1 or 2");
                choice = DataInput.getInt();
            }
            switch (choice){
                case 1 -> {
                    gradeInput(grades);
                }
                case 2 ->{
                    if(grades.getGrades().length == 0){
                        System.out.println("Student array is empty");
                        continue;
                    }
                    switch(askForSortOrder()){
                        case 1 -> {
                            grades.sort(grades.getGrades(), StudentGrades.sortOrder.ASCENDING);
                        }
                        case 2 ->{
                            grades.sort(grades.getGrades(), StudentGrades.sortOrder.DESCENDING);
                        }
                    }
                }
            }
            System.out.println(grades);
        }
    }

    public static void gradeInput(StudentGrades grades) throws IOException {
        System.out.println("Entering student grade");
        if(grades == null && grades.getGrades().length == 0){
            askForStudentGrade(grades);
        }
        while(true){
            System.out.println("1 - add a new student. 0 - stop adding");
            int choice = DataInput.getInt();
            if(choice == 0){
                System.out.println(grades);
                System.out.println("-------------------");
                break;
            } else if(choice == 1){
                askForStudentGrade(grades);
            } else{
                System.out.println("Please enter 1 or 0");
            }
        }
    }

    private static void askForStudentGrade(StudentGrades studentGrades) throws IOException {
        int grade;

        System.out.println("Enter grade:");
        grade = DataInput.getInt();

        studentGrades.addGrade(limitValue(grade));
    }


    public static int limitValue(int value) {
        if (value < 0) {
            return 0;
        } else if (value > 100) {
            return 100;
        } else {
            return value;
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
