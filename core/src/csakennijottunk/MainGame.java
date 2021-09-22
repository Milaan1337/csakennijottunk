package csakennijottunk;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class MainGame extends MyGame {
    public MainGame(boolean debug) {
        super(debug);
    }

    @Override
    public void create() {
        super.create();
        setScreen(new MenuScreen(this));
    }
}
