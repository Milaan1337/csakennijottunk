package csakennijottunk.InGame;

import hu.csanyzeg.master.Math.Ballistics2;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class WhiteActor extends OneSpriteStaticActor {
    float fromx, fromy, tox, toy;
    float falltime;
    @Override
    public void act(float delta) {
        super.act(delta);
        if (this.getY() > toy) {
            this.setY(fromy - (fromy - toy) * (elapsedTime / falltime));
        }
        else {
            this.setY(toy);
        };
    }

    public WhiteActor(MyGame game, float fromx, float fromy, float tox, float toy, float falltime) {
        super(game, "Greencircle.png");
        setSize(3,3);
        this.fromx = fromx;
        this.fromy = fromy;
        this.tox = tox;
        this.toy = toy;
        this.falltime = falltime;
        setPosition(fromx, fromy);
    }
}
