package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

/**
 * A class to set the view of the Game
 */
public class GameView extends UserView {

    private Image background;
    private Hero hero;
    private GameLevel level;
    private Game game;

/**
 *a constructor to set the size of the game view
 * @param level determines which level to size
 * @param width choose the width
 * @param height choose the height
 */
    public GameView(Game game, GameLevel level, int width, int height) {
        super(level, width, height);
        this.level=level;
        this.game=game;
        hero = level.getHero();
        background = new ImageIcon("data/background.gif").getImage();

    }

    /**
     * a method to select the Hero from the current Level
     * **/
    @Override
    public void setWorld(World world) {
        super.setWorld(world);
        hero = ((GameLevel)world).getHero();
    }

    /**
     * a method to display image in the background
     * */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, 700, 500, this);
    }
    /**
     * a method to display score and points in the foreground
     * */
    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);
        g.setColor(Color.white);
        if (hero.getLife() >= 0) {
            g.drawString("Lives left:" + hero.getLife(), 40, 20);
        } else {
            g.drawString("GAME OVER", 40, 20);
            level.stop();
        }
        g.drawString("Coins:" + hero.getCoins(), 40, 40);
        if(game.getLevel() instanceof Level1){
            g.drawString("You are in Level 1", 40, 60);
        }
        else if(game.getLevel() instanceof Level2){
            g.drawString("You are in Level 2", 40, 60);
        }
        else if(game.getLevel() instanceof Level3){
            g.drawString("You are in Level 3", 40, 60);
        }
        if(game.getLevel() instanceof Level3 && game.getLevel().isComplete()){
            game.getLevel().stop();
            g.drawString("Well done!! Game completed", 40, 80);

        }



    }

}
