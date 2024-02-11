public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void feed() {

    }

    public void pet() {
    }

    public void inspect() {
        System.out.println(this.getClass().getName() + " named " + this.getName() + " is " + this.getAge() + " years old");
    }
}
