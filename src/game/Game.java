package game;

import javax.swing.*;
import java.awt.*;

/**
 *Main game entry point
 */
public class Game {

    private GameView view;
    private HeroController controller;
    private GameLevel level;
    private boolean menuVisible;
    private ControlPanel controlPanel;
    private JFrame frame;
    private SettingsPanel settingsPanel;
    private boolean paused;


    /** Initialise a new Game. */
    public Game() {
        menuVisible = false;
        paused=false;

        level = new Level1(this);

        view = new GameView(this, level,700, 500);






        controller = new HeroController(this, level.getHero());
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));



        frame = new JFrame("City Game");
        frame.add(view);
        controlPanel = new ControlPanel(this);
        settingsPanel = new SettingsPanel(this, level);

        //frame.add(controlPanel.mainPanel, BorderLayout.WEST);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        //  JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        level.start();
    }
    /**
     * Method to go to NEXT level
     * */
    public void goToNextLevel(){

        if (level instanceof Level1){
            level.stop();
            level = new Level2(this);
            view.setWorld(level);
            controller.updateHero(level.getHero());
            level.start();
            System.out.println("You're now in level 2");
        }
        else if(level instanceof Level2){
            level.stop();
            level= new Level3(this);
            view.setWorld(level);
            controller.updateHero(level.getHero());
            level.start();
            System.out.println("You're now in level 3");
        }
        else if (level instanceof Level3){

            System.out.println("Well done! Game complete.");
         //   level.stop();

        }

    }



    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }

    /**
     * Method to show and hide the control Panel
     * */
    public void toggleMenu(){
        if(menuVisible){
            frame.remove(controlPanel.mainPanel);
            frame.pack();
            menuVisible = false;
        }
        else{
            frame.add(controlPanel.mainPanel, BorderLayout.WEST);
            frame.pack();
            menuVisible = true;
        }

    }

    /**
     * Method to transition from Main Menu to Settings Menu
     * */
    public void transitionToSettings(){
        frame.remove(controlPanel.mainPanel);
        frame.add(settingsPanel.mainPanel, BorderLayout.WEST);
        frame.pack();

    }
    /**
     * Method to transition back to Main Menu from the Settings Menu
     * */
    public void transitionToMain(){
        frame.remove(settingsPanel.mainPanel);
        frame.add(controlPanel.mainPanel, BorderLayout.WEST);
        frame.pack();

    }

    /**
     * Method to pause/unpause the game
     * */
    public void pause(){
        if (paused){
            level.start();
            paused = false;
    }
        else{
            level.stop();
            paused=true;

        }
    }

    /**
     * Method to get the current level
     * @return current level
     * */
    public GameLevel getLevel(){
        return level;
    }

}