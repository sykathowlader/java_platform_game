package game;

import city.cs.engine.*;
/**
 * Class to define the Ball
 * */
public class Ball extends DynamicBody {
    private static final Shape ballShape = new CircleShape(1f);
    private static final BodyImage ballImage =
            new BodyImage("data/fireball.png", 2f);
/**
 * Initialize the ball
 * */
    public Ball(World world) {
        super(world, ballShape);
        addImage(ballImage);
        //this.setAlwaysOutline(true);
    }


}