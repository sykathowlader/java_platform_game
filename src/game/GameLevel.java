package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * an abstract class that is the base of all the levels
 * */
public abstract class GameLevel extends World {
    private Hero hero;
    private SoundClip gameMusic;
    private double volume;

/**
 * constructor to initialize GameLevel
 * */
    public GameLevel(Game game){
        try {
            gameMusic = new SoundClip("data/game_back.wav");   // Open an audio input stream
            volume=0.5;
            gameMusic.setVolume(volume);
            gameMusic.loop();                              // Set it to continous playback (looping)




        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
        //make the ground
       Shape shape = new BoxShape(18, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -13f));

        //make the walls
        Shape wallShape = new BoxShape(0.5f,8);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-18f,-4));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(18f,-4));



        hero = new Hero(this);
        hero.setPosition(new Vec2(1,-6));


    }

    /**
     * a method to get the Hero of the game
     * @return Hero
     * */
    public Hero getHero(){
        return hero;
    }

    /**
     * an abstract method to determine whether a level is complete or not
     * */
    public abstract boolean isComplete();


    /**
     * a method to turn the volume down
     * */
    public void back_volume_up(){
        if(0.1<=volume && volume <=0.8){
        volume=volume+0.1;
        System.out.println(volume);
        }

        gameMusic.setVolume(volume);

    }
    /**
     * a method to turn the volume down
     * */
    public void back_volume_down(){
        if(volume>=0.2 && volume <=0.9){
        volume=volume-0.1;
        System.out.println(volume);
        gameMusic.setVolume(volume);
        }
    }



}


