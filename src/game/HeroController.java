package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Class to control the Hero
 * */
public class HeroController implements KeyListener{

    private static final float WALKING_SPEED = 3;
    private Hero hero;
    private Game game;

    //private HashMap<Body, BodyImage> hiddenImages = null;
    /**
     * Initialize the controller
     * */
    public HeroController(Game game, Hero h){
        this.game=game;
        this.hero = h;
    }


    @Override
    /**
     * Method to move the character based on specific key pressed
     * */
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_LEFT) {
            hero.startWalking(-WALKING_SPEED*2);
        } else if (code == KeyEvent.VK_RIGHT) {
            hero.startWalking(WALKING_SPEED*2);
        }
        else if (code == KeyEvent.VK_UP){
            hero.jump(12);
        }
        else if(code == KeyEvent.VK_ESCAPE){
            game.toggleMenu();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            hero.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            hero.stopWalking();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    public void updateHero(Hero hero){
        this.hero = hero;
    }
}
