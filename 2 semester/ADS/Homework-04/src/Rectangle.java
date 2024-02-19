/*
    Створити клас Rectangle, що буде описувати прямокутник і містити методи необхідні для роботи з ним.
    Клас, має чотири поля - x1, y1, x2 і y2, що відповідають за кути прямокутника.

    Методи:  переміщення прямокутника на вказану відстань;
    перевірка, чи знаходиться точка в середині прямокутника;
    метод, що повертає об'єднання даного прямокутника з іншим (найменший прямокутник, що містить обидва);
    перетин двух прямокутників;
    перевизначений метод toString.

    В класі Rectangle не повинно бути ніяких введень-виведень, тільки геттери-сеттери.
    Введення-виведення має бути повністю винесене у клас-тестувальник.
 */
public class Rectangle {
    private int x1, y1, x2, y2; // координати прямокутника

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Rectangle() {
        this(0, 0, 0, 0);
    }

    public String toString() {
        return "Rectangle{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }

    public void shift(int dx, int dy) {
        x1 += dx;
        y1 += dy;
        x2 += dx;
        y2 += dy;
    }

    public boolean isInside(int x, int y) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }

    public Rectangle union(Rectangle r) {
        Rectangle res = new Rectangle();
        res.x1 = Math.min(x1, r.x1);
        res.y1 = Math.min(y1, r.y1);
        res.x2 = Math.max(x2, r.x2);
        res.y2 = Math.max(y2, r.y2);
        return res;
    }

    public Rectangle intersection(Rectangle r, Rectangle r2) {
        //i need a method that uses both rectangles
        Rectangle res = new Rectangle();
        res.x1 = Math.max(x1, r.x1);
        res.y1 = Math.max(y1, r.y1);
        res.x2 = Math.min(x2, r.x2);
        res.y2 = Math.min(y2, r.y2);
        return res;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}
