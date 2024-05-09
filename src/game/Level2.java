package game;

/**
 * Class for level 2 of the game
 * */
public class Level2  extends GameLevel {

    public Level2(Game game) {

        super(game);

        BallTiming balltiming = new BallTiming(this, 50);
        CoinTiming cointiming = new CoinTiming(this, game, 50);
    }

    @Override
    public boolean isComplete() {
        if (getHero().getCoins() == 10)
            return true;
        else
            return false;
    }

}