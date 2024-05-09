package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import java.util.Random;

/**
 * Class to determine the frequency of the coins falling
 * */
public class CoinTiming implements StepListener {
    private GameLevel level;
    private Game game;
    private int counter;
    private Hero hero;
    private Random random_number;
    private int i;

    public CoinTiming(GameLevel level, Game game, int i) {
        this.level = level;
        this.counter = 0;
        this.hero = level.getHero();
        this.i = i;
        this.game=game;
        level.addStepListener(this);
        random_number = new Random();
    }

    @Override
    public void preStep(StepEvent stepEvent) {

        if (counter % i == 0) {
            Coin coin = new Coin(level);
            float x = random_number.nextFloat() * 25 - 10;
            coin.setPosition(new Vec2(x, 15f));
            game.CoinHit coinhit = new game.CoinHit(game, level, coin, hero);
            coin.addCollisionListener(coinhit);


        }
        counter++;

    }


    @Override
    public void postStep(StepEvent stepEvent) {


    }
}
