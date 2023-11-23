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

    GLabel start_text = new GLabel("Atari Breakout.\n (press space to start)");
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

        int kegel = (int)((Variables.appWidth/2.7) * (menu_height/2.5) / 1000);

        start_text.setFont("TimesNewRoman-" + kegel);
        double start_text_x = (Variables.appWidth - start_text.getWidth() * 1.1);
        double start_text_y = (menu_height / 2) + Variables.brickYOffset + (start_text.getAscent() / 2);
        start_text.setLocation(start_text_x, start_text_y);
        start_text.setColor(Color.decode("#fdfefe"));

        win_text.setFont("TimesNewRoman-" + kegel);
        double win_text_x = (Variables.appWidth - start_text.getWidth() * 1.1);
        double win_text_y = (menu_height / 2) + Variables.brickYOffset + (start_text.getAscent() / 2);
        win_text.setLocation(win_text_x, win_text_y);
        win_text.setColor(Color.decode("#fdfefe"));



        lose_text.setFont("TimesNewRoman-" + kegel);
        double lose_text_x = (Variables.appWidth - start_text.getWidth() * 1.1);
        double lose_text_y = (menu_height / 2) + Variables.brickYOffset + (start_text.getAscent() / 2);
        lose_text.setLocation(lose_text_x, lose_text_y);
        lose_text.setColor(Color.decode("#fdfefe"));

        lose_background.setLocation(0, lose_text_y - 2*(start_text.getAscent()));
        win_background.setLocation(0, lose_text_y - 2*(start_text.getAscent()));

        startMenu.add(start_text);

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
