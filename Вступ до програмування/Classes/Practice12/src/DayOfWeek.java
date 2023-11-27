/*
    У розкладі рейсів літаків дні тижня позначаються номерами від 1 до 7.
    Припустимо, що в програмі дні тижня подаються enum типом Weekd.
    Написати програму, що у відповідь на введення номера дня виводить текстове подання дня тижня.

    File: DayOfWeek.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;


public class DayOfWeek extends ConsoleProgram {
    enum Weekd {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    public void run(){
        while(true){
            int day = readInt("Enter day number: ");
            while(day < 1 || day > 7){
                println("Error: day must be between 1 and 7");
                day = readInt("Enter day number: ");
            }
            Weekd dayOfWeek = getDayOfWeek(day);
            println("Day of week: " + dayOfWeek);
            println("Next day of week: " + getNextDayOfWeek(dayOfWeek));
            handleExit();
        }
    }

    private Weekd getDayOfWeek(int day) {
        switch(day){
            case 1:
                return Weekd.MONDAY;
            case 2:
                return Weekd.TUESDAY;
            case 3:
                return Weekd.WEDNESDAY;
            case 4:
                return Weekd.THURSDAY;
            case 5:
                return Weekd.FRIDAY;
            case 6:
                return Weekd.SATURDAY;
            case 7:
                return Weekd.SUNDAY;
            default:
                return Weekd.SUNDAY;
        }
    }
    private String getNextDayOfWeek(Weekd day) {
        switch(day){
            case MONDAY:
                return Weekd.TUESDAY.toString();
            case TUESDAY:
                return Weekd.WEDNESDAY.toString();
            case WEDNESDAY:
                return Weekd.THURSDAY.toString();
            case THURSDAY:
                return Weekd.FRIDAY.toString();
            case FRIDAY:
                return Weekd.SATURDAY.toString();
            case SATURDAY:
                return Weekd.SUNDAY.toString();
            case SUNDAY:
                return Weekd.MONDAY.toString();
            default:
                return "Error: day must be between 1 and 7";
        }
    }

    private void handleExit(){
        int exit = readInt("Enter 0 to exit and 1 to continue: ");
        while(exit != 0 && exit != 1){
            println("Error: value must be 0 or 1");
            exit = readInt("Enter 0 to exit and 1 to continue: ");
        }
        if(exit == 0){
            exit();
        }
    }
}
