public class Rectangle extends Quadrangle{
    Rectangle(Point a, Point b, Point c, Point d){
        super(a, b, c, d);
    }

    public double getArea(){
        return distance(a, b) * distance(b, c);
    }

    public double getPerimeter(){
        return 2 * (distance(a, b) + distance(b, c));
    }
}
