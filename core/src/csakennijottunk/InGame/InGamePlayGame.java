package csakennijottunk.InGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class InGamePlayGame extends MyGame {
    public InGamePlayGame(boolean debug) {
        super(debug);
    }

    @Override
    public void create() {
        super.create();
        setScreen(new InGamePlayScreen(this));
    }
}
