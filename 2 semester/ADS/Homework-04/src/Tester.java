public class Tester {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(1, 1, 3, 3);
        Rectangle r2 = new Rectangle(2, 2, 4, 4);
        System.out.println(r1);
        System.out.println(r2);
        r1.shift(1, 1);
        System.out.println(r1);
        System.out.println(r1.isInside(2, 2));
        System.out.println(r1.union(r2));
        System.out.println(r1.intersection(r2));
    }
}
