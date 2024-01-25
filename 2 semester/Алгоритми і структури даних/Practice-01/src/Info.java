public class Info {
    public static void main(String[] args) {
        StudentGrades grades = new StudentGrades();
        System.out.println("Enter grades");

        while(true){
            int input = DataInput.getInt();
            if(input >= 0){
                grades.addGrade(input);
            } else{
                break;
            }
        }

        System.out.println(grades);
        System.out.println(grades.sort(grades.getGradesArray(), StudentGrades.sortType.ascending));
        System.out.println(grades.sort(grades.getGradesArray(), StudentGrades.sortType.descending));
    }
}
