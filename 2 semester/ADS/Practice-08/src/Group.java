public class Group {
    private Student[] students = new Student[0];

    public void addStudent(Student student){
        Student[] temp = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            temp[i] = students[i];
        }
        temp[students.length] = student;
        students = temp;
    }

    public void printStudents(){
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getAverageScore() + " " + student.getAddress());
        }
    }

    public Student getBestStudent(){
        Student bestStudent = students[0];
        for (Student student : students) {
            if (student.getAverageScore() > bestStudent.getAverageScore()) {
                bestStudent = student;
            }
        }
        return bestStudent;
    }

    public Student getWorstStudent(){
        Student worstStudent = students[0];
        for (Student student : students) {
            if (student.getAverageScore() < worstStudent.getAverageScore()) {
                worstStudent = student;
            }
        }
        return worstStudent;
    }
}