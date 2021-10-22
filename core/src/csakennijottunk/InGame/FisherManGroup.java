package csakennijottunk.InGame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class FisherManGroup extends MyGroup {
    public FisherManHandActor fisherManHandActor;
    public FisherManActor fisherManActor;

    public FisherManGroup(MyGame game) {
        super(game);
        addActor(fisherManActor = new FisherManActor(game));
        addActor(fisherManHandActor = new FisherManHandActor(game));
    }

    public enum Handtype{
        hand,
        fishingrod
    }

    void set_angle(float degree){
        fisherManHandActor.setRotation(degree);
    }

    void set_hand(Handtype handtype){

    }

    Vector2 get_handEnd(){
        return new Vector2(0,0);
    }
}
