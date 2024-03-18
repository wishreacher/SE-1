/*
    - задається вісьмома точками
    - задається координатами трьох вершин основни, довжиною та кутом нахила ребра AE
    - задається координатою вершини основи а, довжиною ребер аб і ад там кутом між ними, довжиною
        та кутом нахила ребра ае
 */

public class Parallelepiped {
    
    public Point a, b, c, d, e, f, g, h;

    //first constructor
    public Parallelepiped(Point a, Point b, Point c, Point d, Point e, Point f, Point g, Point h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }

    //second constructor
    public Parallelepiped(Point a, Point b, Point c, double lengthAE, double angleAE) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = new Point(a.x + lengthAE, a.y, a.z);
        this.e = new Point(a.x, a.y, a.z + lengthAE);
        this.f = new Point(b.x, b.y, b.z + lengthAE);
        this.g = new Point(c.x + lengthAE, c.y, c.z);
        this.h = new Point(c.x, c.y, c.z + lengthAE);
    }

    //third constructor
    public Parallelepiped(Point a, double lengthAB, double lengthAD, double angleAB, double angleAD, double lengthAE, double angleAE) {
        this.a = a;
        this.b = new Point(a.x + lengthAB, a.y, a.z);
        this.c = new Point(a.x, a.y + lengthAD, a.z);
        this.d = new Point(a.x + lengthAB, a.y + lengthAD, a.z);
        this.e = new Point(a.x, a.y, a.z + lengthAE);
        this.f = new Point(a.x + lengthAB, a.y, a.z + lengthAE);
        this.g = new Point(a.x, a.y + lengthAD, a.z + lengthAE);
        this.h = new Point(a.x + lengthAB, a.y + lengthAD, a.z + lengthAE);
    }

    public double baseArea(){
        return Math.sqrt(Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y), 2) + Math.pow((b.z - a.z), 2)) *
                Math.sqrt(Math.pow((c.x - a.x), 2) + Math.pow((c.y - a.y), 2) + Math.pow((c.z - a.z), 2));
    }

    public double getHeight(){
        return Math.sqrt(Math.pow((e.x - a.x), 2) + Math.pow((e.y - a.y), 2) + Math.pow((e.z - a.z), 2));
    }

    public double volume(){
        return baseArea() * getHeight();
    }

    public double diagonal(){
        return Math.sqrt(Math.pow((g.x - a.x), 2) + Math.pow((g.y - a.y), 2) + Math.pow((g.z - a.z), 2));
    }
}
