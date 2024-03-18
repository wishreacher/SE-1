public class Triangle extends Shape{
    Point a, b, c;

    Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea(){
        double p = halfPerimeter();
        return Math.sqrt(p * (p - distance(a, b)) * (p - distance(b, c)) * (p - distance(c, a)));
    }

    private double halfPerimeter(){
        return (distance(a, b) + distance(b, c) + distance(c, a)) / 2;
    }

    private double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
    }
}
