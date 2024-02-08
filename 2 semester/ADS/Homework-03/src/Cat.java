public class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }

    public void feed() {
        super.feed();
        System.out.println("           __..--''``---....___   _..._    __\n" +
                " /// //_.-'    .-/\";  `        ``<._  ``.''_ `. / // /\n" +
                "///_.-' _..--.'_    \\                    `( ) ) // //\n" +
                "/ (_..-' // (< _     ;_..__               ; `' / ///\n" +
                " / // // //  `-._,_)' // / ``--...____..-' /// / //");
        System.out.println("prrrrrr");
    }

    public void pet() {
        super.pet();
        System.out.println("      |\\      _,,,---,,_\n" +
                "ZZZzz /,`.-'`'    -.  ;-;;,_\n" +
                "     |,4-  ) )-,_. ,\\ (  `'-'\n" +
                "    '---''(_/--'  `-'\\_)  ");
        System.out.println("Meow");
    }
}
