package game;

/**
 * Class for Level 1 of the game
 * */
public class Level1  extends GameLevel {



    public Level1(Game game) {

        super(game);
        BallTiming balltiming = new BallTiming(this, 100);
        CoinTiming cointiming = new CoinTiming(this, game,100);
    }

    @Override
    public boolean isComplete() {
        if (getHero().getCoins() == 5)
            return true;
        else
            return false;
    }

}