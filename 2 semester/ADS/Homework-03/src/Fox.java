public class Fox extends Animal{

    public Fox(String name, int age) {
        super(name, age);
    }

    public void feed() {
       super.feed();
        System.out.println("  /\\   /\\   \n" +
                "  //\\\\_//\\\\     ____\n" +
                "  \\_     _/    /   /\n" +
                "   / * * \\    /^^^]\n" +
                "   \\_\\O/_/    [   ]\n" +
                "    /   \\_    [   /\n" +
                "    \\     \\_  /  /\n" +
                "     [ [ /  \\/ _/\n" +
                "    _[ [ \\  /_/");
        System.out.println("Yum-yum");
    }

    public void pet() {
        super.pet();
        System.out.println("  _,-=._              /|_/|\n" +
                "  `-.}   `=._,.-=-._.,  @ @._,\n" +
                "     `._ _,-.   )      _,.-'\n" +
                "        `    G.m-\"^m`m'     ");
        System.out.println("Ururu");
    }
}
