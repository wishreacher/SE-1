public class Task6Tester {
    public static void main(String[] args) {
        Task6 grades = new Task6();
        System.out.println("Enter grades. To stop enter any negative number.");

        while(true){
            int input = DataInput.getInt();
            if(input >= 0){
                grades.addGrade(input);
            } else{
                break;
            }
        }

        grades.printInfo();
        System.out.println(grades); // This is the toString() method that we overrode in Task6.java

//        System.out.println(grades.sort(grades.getGradesArray(), Task6.sortType.ascending));
//        System.out.println(grades.sort(grades.getGradesArray(), Task6.sortType.descending));
    }
}
