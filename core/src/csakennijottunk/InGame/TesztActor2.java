package csakennijottunk.InGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class TesztActor2 extends OneSpriteStaticActor {
    public TesztActor2(MyGame game, float x, float y) {
        super(game, "Fishermanhand.png");
        this.setX(x);
        this.setY(y);
        this.setSize(75,75);
        this.setOrigin(37.5F,10);
        this.setZIndex(80);
    }
}
