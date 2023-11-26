import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;


public class Menu extends GraphicsProgram {
    double menu_height = Variables.appHeight / 2;
    GRect win_background = new GRect(0, Variables.brickDelta, Variables.appWidth , menu_height/4);
    GRect lose_background = new GRect(0, Variables.brickYOffset, Variables.appWidth , menu_height/4);

    GLabel start_text1 = new GLabel("Breakout");
    GLabel start_text2 = new GLabel("Use mouse to control the paddle");
    GLabel start_text3 = new GLabel("Press 1, 2 or 3 to select difficulty");
    GLabel win_text = new GLabel("You won!");
    GLabel lose_text= new GLabel("You lost. ;(");

    GCompound startMenu = new GCompound();
    GCompound winMenu = new GCompound();
    GCompound loseMenu = new GCompound();
    public Menu(){
        win_background.setFilled(true);
        win_background.setColor(Color.decode("#117a65"));

        lose_background.setFilled(true);
        lose_background.setColor(Color.decode("#7b241c"));

        int kegel = 20; //(int)((Variables.appWidth/2.7) * (menu_height/2.5) / 1000);

        start_text1.setFont("TimesNewRoman-" + kegel);
        double start_text1_x = (Variables.appWidth - start_text1.getWidth()) / 2;
        double start_text1_y = (menu_height / 2) + Variables.brickYOffset + (start_text1.getAscent() / 2);
        start_text1.setLocation(start_text1_x, start_text1_y);
        start_text1.setColor(Color.decode("#fdfefe"));

        start_text2.setFont("TimesNewRoman-" + kegel);
        double start_text2_x = (Variables.appWidth - start_text2.getWidth()) / 2;
        double start_text2_y = start_text1_y + 25;
        start_text2.setLocation(start_text2_x, start_text2_y);
        start_text2.setColor(Color.decode("#fdfefe"));

        start_text3.setFont("TimesNewRoman-" + kegel);
        double start_text3_x = (Variables.appWidth - start_text3.getWidth()) / 2;
        double start_text3_y = start_text1_y + 50;
        start_text3.setLocation(start_text3_x, start_text3_y);
        start_text3.setColor(Color.decode("#fdfefe"));

        win_text.setFont("TimesNewRoman-" + kegel);
        double win_text_x = (Variables.appWidth - start_text1.getWidth() * 1.1);
        double win_text_y = (menu_height / 2) + Variables.brickYOffset + (start_text1.getAscent() / 2);
        win_text.setLocation(win_text_x, win_text_y);
        win_text.setColor(Color.decode("#fdfefe"));

        lose_text.setFont("TimesNewRoman-" + kegel);
        double lose_text_x = (Variables.appWidth - start_text1.getWidth() * 1.1);
        double lose_text_y = (menu_height / 2) + Variables.brickYOffset + (start_text1.getAscent() / 2);
        lose_text.setLocation(lose_text_x, lose_text_y);
        lose_text.setColor(Color.decode("#fdfefe"));

        lose_background.setLocation(0, lose_text_y - 2*(start_text1.getAscent()));
        win_background.setLocation(0, lose_text_y - 2*(start_text1.getAscent()));

        startMenu.add(start_text1);
        startMenu.add(start_text2);
        startMenu.add(start_text3);

        winMenu.add(win_background);
        winMenu.add(win_text);

        loseMenu.add(lose_background);
        loseMenu.add(lose_text);
    }

    public GObject getStartMenuGObject(){
        return startMenu;
    }
    public GObject getWinMenuGObject(){
        return winMenu;
    }
    public GObject getLoseMenuGObject(){
        return loseMenu;
    }
}
