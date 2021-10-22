package csakennijottunk.InGame;

import hu.csanyzeg.master.Math.Ballistics2;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class FishFoodActor extends OneSpriteStaticActor {
    protected Ballistics2 ballistics2;
    protected float waterHeight;
    protected boolean flying = true;

    public FishFoodActor(MyGame game, Ballistics2 ballistics, float waterHeight) {
        super(game, "Fishfoodactor.png");
        this.ballistics2 = ballistics;
        this.waterHeight = waterHeight;
        setWidth(100);
        setHeight(100);

    }



    @Override
    public void act(float delta) {
        super.act(delta);
        if (flying) {
            if (getX() < ballistics2.getX(waterHeight)[1]) {
                setPosition(ballistics2.getPosition(getElapsedTime() * 5).x, ballistics2.getPosition(getElapsedTime() * 5).y);
            } else {
                setPosition(ballistics2.getPosition(ballistics2.getElapsedTimeFromY(waterHeight)[1]).x, ballistics2.getPosition(ballistics2.getElapsedTimeFromY(waterHeight)[1]).y);
                flying = false;
            }
        }
    }
}
