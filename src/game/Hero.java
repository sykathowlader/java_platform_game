package game;

import city.cs.engine.*;

/**
 * Class for creating the main character
 * */
public class Hero extends Walker {
    private static final Shape heroShape = new PolygonShape(
            -1.8f,-2.47f,
            -1.36f,2.46f,
            0.85f,2.47f,
            1.44f,1.84f,
            1.8f,-2.47f);


    private static final BodyImage heroImage =
            new BodyImage("data/personaggio.png", 5f);

    private int life;
    private int coins;

    //private int books;
    /**
     * Initialize the character
     * */
    public Hero(World world) {
        super(world, heroShape);
        addImage(heroImage);
        //this.setAlwaysOutline(true);

        life = 5;
        coins=0;
    }
    /**
     * Method to set the number of lives of the character
     * @param life set number of lives
     * */
    public void setLife(int life){
        this.life = life;
    }
    /**
     * Method to get the number of lives left of the Hero
     * @return number of lives left
     * */

    public int getLife(){
        return life;
    }
/**
 * Method to set the Number of Coins
 * @param coins set the number of coins
 * */
    public void setCoins(int coins){
        this.coins = coins;
    }

    /**
     * Method to get the number of coins
     * @return the number of coins
     * */
    public int getCoins(){
        return coins;
    }

    }



