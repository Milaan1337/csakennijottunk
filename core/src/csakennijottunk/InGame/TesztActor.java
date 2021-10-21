package csakennijottunk.InGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class TesztActor extends OneSpriteStaticActor {
    public TesztActor(MyGame game,float x, float y) {
        super(game, "Fisherman.png");
        this.setX(x);
        this.setY(y);
        this.setSize(100,100);
        this.setZIndex(79);
    }
}
