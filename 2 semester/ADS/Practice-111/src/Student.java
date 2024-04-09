public class Student{
    private String name;
    private int age;
    private int course;

    public Student(String name, int age, int course){
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getCourse(){
        return course;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setCourse(int course){
        this.course = course;
    }
}