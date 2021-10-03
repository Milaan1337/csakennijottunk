package csakennijottunk.credit;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class CreditActor extends OneSpriteStaticActor {
    public CreditActor(MyGame game) {
        super(game, "MenuBackground.png");
        this.setSize(170, 90);
        this.setPosition(-45, 0);



    }
}
