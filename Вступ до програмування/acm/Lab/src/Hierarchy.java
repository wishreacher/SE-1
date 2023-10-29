/*
    Написати програму, що малює часткову діаграму класів acm.program, як показано в прикладі:

    Діаграма має вписуватись у розміри вікна і розташовуватися по центру вікна.

    File: Hierarchy.java
    Author: Федорич Володимир
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Hierarchy extends GraphicsProgram {
    int windowWidth;
    int windowHeight;
    public void run() {
        setSize(900, 500);
        windowWidth = getWidth();
        windowHeight = getHeight();
        double mainClassWidth = windowWidth * 0.4;
        double mainClassHeight = windowHeight * 0.2;
        double mainClassX = (windowWidth - mainClassWidth) / 2;
        double mainClassY = (windowHeight - mainClassHeight) / 2;

        drawMainElement(mainClassX, mainClassY, mainClassWidth, mainClassHeight);
        drawDependantElements(mainClassX, mainClassY, mainClassWidth, mainClassHeight);
    }

    //draws the top element
    private void drawMainElement(double mainClassX, double mainClassY, double mainClassWidth, double mainClassHeight){
        GRect mainClass = new GRect(mainClassX, mainClassY, mainClassWidth, mainClassHeight);
        mainClass.setFilled(true);
        mainClass.setColor(Color.CYAN);
        add(mainClass);

        GLabel mainClassName = new GLabel("Main Class");
        mainClassName.setFont("SansSerif-18");
        double mainClassNameX = mainClassX + (mainClassWidth - mainClassName.getWidth()) / 2;
        double mainClassNameY = mainClassY + (mainClassHeight + mainClassName.getAscent()) / 2;
        mainClassName.setLocation(mainClassNameX, mainClassNameY);
        add(mainClassName);
    }

    //draws 3 elements which are connected by arrows to the main element
    private void drawDependantElements(double mainClassX, double mainClassY, double mainClassWidth, double mainClassHeight){
        double classWidth = windowWidth * 0.2;
        double classHeight = windowHeight * 0.2;
        double classSpacing = windowWidth * 0.15;

        double x = (windowWidth - (classWidth * 3 + classSpacing * 2)) / 2;
        double y = mainClassY + mainClassHeight + 20;

        for (int i = 0; i < 3; i++) {
            GRect dependentClass = new GRect(x, y, classWidth, classHeight);
            dependentClass.setFilled(true);
            dependentClass.setColor(Color.CYAN);
            add(dependentClass);

            String className = switch (i) {
                case 0 -> "Class1";
                case 1 -> "Class2";
                case 2 -> "Class3";
                default -> "";
            };

            //adds text within dependent elements
            GLabel dependentClassName = new GLabel(className);
            dependentClassName.setFont("SansSerif-18");
            double dependentClassNameX = x + (classWidth - dependentClassName.getWidth()) / 2;
            double dependentClassNameY = y + (classHeight + dependentClassName.getAscent()) / 2;
            dependentClassName.setLocation(dependentClassNameX, dependentClassNameY);
            add(dependentClassName);

            //arrow connection
            GLine arrow = new GLine(mainClassX + mainClassWidth / 2, mainClassY + mainClassHeight,
                    x + classWidth / 2, y);
            add(arrow);

            x += classWidth + classSpacing;
        }
    }
}
