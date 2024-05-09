package game;

/**
 * Class for level 3 of the game
 * */
public class Level3  extends GameLevel {

    public Level3(Game game) {

        super(game);

        BallTiming balltiming = new BallTiming(this, 30);
        CoinTiming cointiming = new CoinTiming(this, game, 30);
    }

    @Override
    public boolean isComplete() {
        if (getHero().getCoins() >= 20)
            return true;
        else
            return false;
    }


}