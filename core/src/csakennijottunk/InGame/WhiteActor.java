package csakennijottunk.InGame;

import hu.csanyzeg.master.Math.Ballistics2;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class WhiteActor extends OneSpriteStaticActor {
    float xPos;
    float yPos;
    @Override
    public void act(float delta) {
        super.act(delta);
        if (this.getY() >= yPos)
        this.setPosition(this.getX(),this.getY() - 5);
    }

    public WhiteActor(MyGame game, float x, float y) {
        super(game, "badlogic.jpg");
        xPos = x;
        yPos = y;
        this.setSize(100,100);
        this.setPosition(0,1000);

    }
}
