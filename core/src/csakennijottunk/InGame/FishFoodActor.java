package csakennijottunk.InGame;

import hu.csanyzeg.master.Math.Ballistics2;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class FishFoodActor extends BallisticActor {

    public FishFoodActor(MyGame game, Ballistics2 ballistics, float waterHeight) {
        super(game, "Fishfoodactor.png", ballistics, waterHeight);
        setSize(100,100);
    }
}
