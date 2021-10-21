package csakennijottunk;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class TesztActor2 extends OneSpriteStaticActor {
    public TesztActor2(MyGame game, float x, float y) {
        super(game, "Fishermanhand.png");
        this.setX(x);
        this.setY(y);
    }
}
