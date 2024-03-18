import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {
//        Shape rectangle = new Rectangle(point(0, 0), point(0, 1), point(1, 1), point(1, 0));
//        Shape circle = new Circle(point(0, 0), 1);
//        Shape triangle = new Triangle(point(0, 0), point(0, 1), point(1, 0));
//
//        System.out.println("Area of rectangle: " + rectangle.getArea());
//        System.out.println("Perimeter of rectangle: " + rectangle.getPerimeter());
//        System.out.println("Area of circle: " + circle.getArea());
//        System.out.println("Perimeter of circle: " + circle.getPerimeter());
//        System.out.println("Area of triangle: " + triangle.getArea());
//        System.out.println("Perimeter of triangle: " + triangle.getPerimeter());

        System.out.println("Creating department");
        System.out.print("\033[H\033[2J");
    }

    private static Shape.Point point(double x, double y) {
        return new Shape.Point(x, y);
    }
}
