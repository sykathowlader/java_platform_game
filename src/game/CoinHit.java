package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Class to deal with the collision between the coin and the Hero
 * */
public class CoinHit implements CollisionListener {
    private Coin coin;
    private Hero hero;
    private static SoundClip coinSound;
    private Game game;
    private GameLevel level;
    private double volume;

    static {
        try {
            coinSound = new SoundClip("data/coin_sound.wav");
            System.out.println("Loading books sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    public CoinHit(Game game, GameLevel level, Coin b, Hero h){
        this.coin = b;
        this.hero= h;
        this.level=level;
        this.game=game;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Hero) {
            coinSound.setVolume(0.5);
            coinSound.play();
            hero.setCoins(hero.getCoins()+1);
            System.out.println("Number of coins:"+hero.getCoins());
            e.getReportingBody().destroy();
            if(level.isComplete()){
                game.goToNextLevel();
            }

        }
        else if(e.getOtherBody() instanceof StaticBody){
            e.getReportingBody().destroy();
        }
    }
}