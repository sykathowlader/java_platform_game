package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 *Class to deal with the collision between the Hero and the Ball
 * */
public class BallHit implements CollisionListener {

    private Ball ball;
    private Hero hero;
    private static SoundClip ballSound;
    public double initial_volume = 0.5;

    static {
        try {
            ballSound = new SoundClip("data/ballSound.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    public BallHit(Ball b, Hero h){
        this.ball = b;
        this.hero= h;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Hero) {
            ballSound.setVolume(initial_volume);
            ballSound.play();
            hero.setLife(hero.getLife()-1);
            System.out.println("Number of lives:"+hero.getLife());
            e.getReportingBody().destroy();
        }
        else if(e.getOtherBody() instanceof StaticBody){
            e.getReportingBody().destroy();
        }
    }
}