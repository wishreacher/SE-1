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

import acm.program.ConsoleProgram;

public class StudentInfo extends ConsoleProgram {
    public void run(){
        println();

        /*
        //testing default constructor
        Student defaultStudent = new Student();

        //testing constructor with 2 parameters
        Student Ivan = new Student("Ivan", "of Applied Mathematics");
        Student Petro = new Student("Petro", "of Philosophy");


        println(defaultStudent);
        println(Ivan);
        println(Petro);
        Petro.setYear(2);
        println(Petro);
         */

        StudentFI defaultStudent = new StudentFI();
        StudentFI Volodymyr = new StudentFI("Volodymyr", "of SE",
                "weed");
        StudentFI Misha = new StudentFI("Misha", "of SE", "REVO");
        println(defaultStudent);
        println(Volodymyr);
        println(Misha);
        Volodymyr.increaseDepressionLevel();
        println(Volodymyr.getName() + "'s depression level increased to " + Volodymyr.getDepressionLevel());
    }
}
