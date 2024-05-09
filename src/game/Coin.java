package game;

import city.cs.engine.*;
/**
 * Class to define the Coin
 * */
public class Coin extends DynamicBody {
    private static final Shape coinShape = new CircleShape(1f);
    private static final BodyImage coinImage =
            new BodyImage("data/coin.png", 2f);
/**
 * Initialize the coin
 * */
    public Coin(World world) {
        super(world, coinShape);
        addImage(coinImage);
        //this.setAlwaysOutline(true);
    }


}