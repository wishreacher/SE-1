public class Tester {
    public static void main(String[] args) {
        Parallelepiped p1 = new Parallelepiped(new Point(0, 1, 0),
                new Point(0, 0, 0),
                new Point(1, 1, 0),
                new Point(1, 1, 0),
                new Point(0, 0, 1),
                new Point(1, 0, 1),
                new Point(0, 1, 1),
                new Point(1, 1, 1));

        Parallelepiped p2 = new Parallelepiped(new Point(0, 1, 0),
                new Point(0, 0, 0),
                new Point(1, 1, 0),
                1, 60);

        Parallelepiped p3 = new Parallelepiped(new Point(0, 0, 0),
                1, 1, 60, 60, 1, 60);

        System.out.println("Base area of p1: " + p1.baseArea());
        System.out.println("Height of p1: " + p1.getHeight());
        System.out.println("Volume of p1: " + p1.volume());
        System.out.println("Diagonal of p1: " + p1.diagonal());
        System.out.println("Base area of p2: " + p2.baseArea());
        System.out.println("Height of p2: " + p2.getHeight());
        System.out.println("Volume of p2: " + p2.volume());
        System.out.println("Diagonal of p2: " + p2.diagonal());
        System.out.println("Base area of p3: " + p3.baseArea());
        System.out.println("Height of p3: " + p3.getHeight());
        System.out.println("Volume of p3: " + p3.volume());
        System.out.println("Diagonal of p3: " + p3.diagonal());
    }
}
