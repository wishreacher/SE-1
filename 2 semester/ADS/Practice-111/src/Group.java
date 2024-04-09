import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Group{
    private ArrayList<Student> students;

    public Group(){
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }

    public void removeStudent(int index){
        students.remove(index);
    }

    public Student getStudent(int index){
        return students.get(index);
    }

    public int getStudentsCount(){
        return students.size();
    }

    public void clear(){
        students.clear();
    }

    public void sortByName(){
        Collections.sort(students, new Comparator<Student>(){
            public int compare(Student s1, Student s2){
                return s1.getName().compareTo(s2.getName());
            }
        });
    }

    public void sortByAge(){
        Collections.sort(students, new Comparator<Student>(){
            public int compare(Student s1, Student s2){
                return s1.getAge() - s2.getAge();
            }
        });
    }

    public void sortByCourse(){
        Collections.sort(students, new Comparator<Student>(){
            public int compare(Student s1, Student s2){
                return s1.getCourse() - s2.getCourse();
            }
        });
    }

    public void printStudents(){
        for(Student student : students){
            System.out.println("Name: " + student.getName() + ", Age: " + student.getAge() + ", Course: " + student.getCourse());
        }
    }
}