public class Circle extends Shape{
    Point center;
    double radius;

    Circle(Point center, double radius){
        this.center = center;
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
}
