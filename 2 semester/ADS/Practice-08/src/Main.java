import java.io.IOException;

/*
    Написати програму, що формує групу студентів.

    Інформація про студентів (ПІБ, середній бал, адреса і т.д.) вводиться з клавіатури.

    Групу, студента та введення інформації оформити у вигляді окремих класів.

    Написати клас тестер який заповнює групу, виводить інформацію про групу студентів та
    повертає студента/ів з найкращим і найгіршим балом.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Group group = new Group();
        while(true){
            System.out.println("Entering student's information ");

            System.out.println("\nEnter student's name: ");
            String name = DataInput.getString();

            System.out.println("Enter student's average score: ");
            long averageScore = DataInput.getLong();

            System.out.println("Enter student's address: ");
            String address = DataInput.getString();

            Student student = new Student(name, averageScore, address);
            group.addStudent(student);
            System.out.println("1 - add another student, 2 - continue");

            String answer = DataInput.getString();

            while(!answer.equals("1") && !answer.equals("2")){
                System.out.println("Wrong input! Please enter 1 or 2.");
                answer = DataInput.getString();
            }
            if(answer.equals("2")){
                break;
            }
        }

        group.printStudents();
        System.out.println("Best student: " + group.getBestStudent().getName());
        System.out.println("Worst student: " + group.getWorstStudent().getName());
    }
}
