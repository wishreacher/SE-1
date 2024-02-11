public class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public void feed(Animal animal) {
        System.out.println(this.name + " is feeding the " + animal.getClass().getName() + " named " + animal.getName());
        animal.feed();
    }

    public void pet(Animal animal) {
        System.out.println(this.name + " is petting the " + animal.getClass().getName() + " named " + animal.getName());
        animal.pet();
    }

    public void inspect(Animal animal) {
        animal.inspect();
    }
}