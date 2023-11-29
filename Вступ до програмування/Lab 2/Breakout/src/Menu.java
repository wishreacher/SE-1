import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;


public class Menu extends GraphicsProgram {
    double menuHeight = Variables.appHeight / 2;
    GRect winBackground = new GRect(0, Variables.brickDelta, Variables.appWidth , menuHeight/4);
    GRect loseBackground = new GRect(0, Variables.brickYOffset, Variables.appWidth , menuHeight/4);

    GLabel startLabel = new GLabel("Breakout");
    GLabel startDescription = new GLabel("Press 1, 2 or 3 to select level");
    GLabel winText = new GLabel("You won!");
    GLabel loseText= new GLabel("You lost.");

    GLabel authorLabel = new GLabel("Made by: Fedorych Volodymyr");

    GCompound startMenu = new GCompound();
    GCompound winMenu = new GCompound();
    GCompound loseMenu = new GCompound();
    public Menu(){
        int kegel = (int)((Variables.appWidth/2.7) * (menuHeight/2.5) / 1000);

        menuTextSetup(kegel);
        winUISetup(kegel);
        loseUISetup(kegel);
    }

    private void loseUISetup(int kegel) {
        loseBackground.setFilled(true);
        loseBackground.setColor(Color.decode("#7b241c"));

        loseText.setFont("TimesNewRoman-" + kegel);
        double loseText_x = (Variables.appWidth - startLabel.getWidth() * 1.1);
        double loseText_y = (menuHeight / 2) + Variables.brickYOffset + (startLabel.getAscent() / 2);
        loseText.setLocation(loseText_x, loseText_y);
        loseText.setColor(Color.decode("#fdfefe"));

        loseBackground.setLocation(0, loseText_y - 2*(startLabel.getAscent()));
        loseMenu.add(loseBackground);
        loseMenu.add(loseText);
    }

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

    private void winUISetup(int kegel){
        winBackground.setFilled(true);
        winBackground.setColor(Color.decode("#117a65"));
        
        winText.setFont("TimesNewRoman-" + kegel);
        double winText_x = (Variables.appWidth - startLabel.getWidth() * 1.1);
        double winText_y = (menuHeight / 2) + Variables.brickYOffset + (startLabel.getAscent() / 2);
        winText.setLocation(winText_x, winText_y);
        winText.setColor(Color.decode("#fdfefe"));

        winBackground.setLocation(0, (menuHeight / 2) + Variables.brickYOffset + (startLabel.getAscent() / 2) - 2*(startLabel.getAscent()));

        winMenu.add(winBackground);
        winMenu.add(winText);
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
