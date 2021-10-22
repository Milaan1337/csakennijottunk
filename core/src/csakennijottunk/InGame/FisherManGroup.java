package csakennijottunk.InGame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class FisherManGroup extends MyGroup {
    public float degree = 45;
    public float v0 = 100;
    public FisherManHandActor fisherManHandActor;
    public FisherManActor fisherManActor;
    public Vector2 topsolders = new Vector2(210,310);
    public Vector2 arm = new Vector2(154,11);

    public FisherManGroup(MyGame game) {
        super(game);
        addActor(fisherManActor = new FisherManActor(game));
        addActor(fisherManHandActor = new FisherManHandActor(game));
        fisherManHandActor.setOrigin(topsolders.x, topsolders.y);

    }

    public enum Handtype{
        hand,
        fishingrod
    }

    void set_angle(float degree){
        this.degree = degree;
        fisherManHandActor.setRotation(degree);
    }

    void set_speed(float v0){
        this.v0 = v0;
    }

    void set_hand(Handtype handtype){

    }

    Vector2 get_handEnd(){
        Vector2 r = new Vector2(getX(),getY());
        r.add(topsolders);
        Vector2 forgatott = new Vector2(arm);
        forgatott.rotate(fisherManHandActor.getRotation());
        r.add(forgatott);
        return  r;
    }
}
