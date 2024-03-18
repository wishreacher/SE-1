/*
    Написати клас геометрична фігура, в якому визначити стандартні методи і поля.

    Написати похідні класи коло, чотирикутник, трикутник, в яких перевизначити методи базового класу.

    Написати клас прямокутник який розширить чотирикутник.
 */
public class Shape {
    public static class Point {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public String name;
    public double getArea(){
        return 0;
    }

    public double getPerimeter(){
        return 0;
    }
}


