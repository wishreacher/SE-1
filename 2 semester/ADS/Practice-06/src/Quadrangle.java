public class Quadrangle extends Shape{
    Point a, b, c, d;

    Quadrangle(Point a, Point b, Point c, Point d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double getArea(){
        double p = halfPerimeter();
        return Math.sqrt((p - distance(a, b)) * (p - distance(b, c)) * (p - distance(c, d)) * (p - distance(d, a)));
    }

    public double getPerimeter(){
        return distance(a, b) + distance(b, c) + distance(c, d) + distance(d, a);
    }

    private double halfPerimeter(){
        return getPerimeter() / 2;
    }

    protected double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
    }
}
