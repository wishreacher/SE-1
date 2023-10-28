/*
    Написати програму, що виводить привітання на екран (приклад з лекції, традиційна програма HelloWorld).

    Завантажте архів з початковим кодом проекту. Імпортуйте проект з розархівованого архіву. Виконайте завдання. Збережіть зміни.

    Заархівуйте проект і завантажте його назад як результат.

    + 3 різних текста різним шрифтом

    File: Task1.java
    Author: Федорич Володимир
 */


import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class Task1 extends GraphicsProgram{
    public void run(){
        this.setSize(400, 400);

        GLabel label1 = new GLabel("I hate this class", 100, 100);
        GLabel label2 = new GLabel("Help", 100, 200);
        GLabel label3 = new GLabel("I'm losing my mind", 100, 300);

        label1.setFont("SansSerif-18");
        label1.setColor(Color.RED);

        label2.setFont("TimesNewRoman-25");
        label2.setColor(Color.BLUE);

        label3.setFont("Tahoma-32");
        label3.setColor(Color.BLACK);

        add(label1);
        add(label2);
        add(label3);
    }
}
