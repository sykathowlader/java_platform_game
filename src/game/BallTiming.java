package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import java.util.Random;
/**
 * Class to determine the frequency of the balls falling
 * */
public class BallTiming implements StepListener {
    private GameLevel level;
    private int counter;
    private  Hero hero;
    private Random random_number;
    private int i;

    public BallTiming(GameLevel level, int i) {
        this.level=level;
        this.counter=0;
        this.hero= level.getHero();
        this.i=i;
        level.addStepListener(this);
        random_number=new Random();
    }

    @Override
    public void preStep(StepEvent stepEvent) {

        if (counter%i==0){
            Ball ball= new Ball(level);
            float x=random_number.nextFloat()*25-10;
            ball.setPosition(new Vec2(x,15f));
            BallHit ballhit = new BallHit(ball, hero);
            ball.addCollisionListener(ballhit);

        }
        counter++;

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }

}
