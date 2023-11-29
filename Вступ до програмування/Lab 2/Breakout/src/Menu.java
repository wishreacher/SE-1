import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;


public class Menu extends GraphicsProgram {
    double menuHeight = Variables.appHeight / 2;
    GLabel startLabel = new GLabel("Breakout");
    GLabel startDescription = new GLabel("Use mouse to control the paddle. Press 1, 2 or 3 to select level");
    GLabel authorLabel = new GLabel("Made by: Fedorych Volodymyr");
    GCompound startMenu = new GCompound();

    /**
     * Constructor for the Menu class
     */
    public Menu(){
        int kegel = (int)((Variables.appWidth/2.7) * (menuHeight/2.5) / 1000);

        menuTextSetup(kegel);
    }

    /**
     * Method that sets up the menu text
     * @param kegel - font size
     */
    private void menuTextSetup(int kegel) {
        startLabel.setFont("TimesNewRoman-" + kegel);
        double startLabel_x = 20;
        double startLabel_y = (menuHeight / 2) + Variables.brickYOffset + (startLabel.getAscent() / 2);
        startLabel.setLocation(startLabel_x, startLabel_y);
        startLabel.setColor(Color.WHITE);

        startDescription.setFont("TimesNewRoman-" + kegel/2);
        double startDescription_y = startLabel_y + 25;
        startDescription.setLocation(startLabel_x, startDescription_y);
        startDescription.setColor(Color.decode("#fdfefe"));

        authorLabel.setFont("TimesNewRoman-" + kegel/2);
        double authorLabel_y = startLabel_y + 50;
        authorLabel.setLocation(startLabel_x, authorLabel_y);
        authorLabel.setColor(Color.decode("#fdfefe"));

        startMenu.add(startLabel);
        startMenu.add(startDescription);
        startMenu.add(authorLabel);
    }

    /**
     * Menu getter
     */
    public GObject getStartMenuGObject(){
        return startMenu;
    }
}
