package csakennijottunk.InGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class FlyActor extends OneSpriteStaticActor {

    public FlyActor(MyGame game, float x, float y) {
        super(game, "Fisherman.png");
        setWidth(5);
        setHeight(5);
        setPosition(x,y);
    }

}
