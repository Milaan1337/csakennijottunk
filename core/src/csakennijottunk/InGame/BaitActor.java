package csakennijottunk.InGame;

import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

import hu.csanyzeg.master.Math.Ballistics2;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleOverlapsUtil;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;

public class BaitActor extends BallisticActor {

    protected float lastDamilTime = 0f;
    protected float damilTimeStep = 0.005f;
    protected Vector<WhiteActor> whiteActorVector = new Vector<>();

    public BaitActor(MyGame game, Ballistics2 ballistics, float waterHeight) {
        super(game, "Bait.png", ballistics, waterHeight);
        setSize(128,128);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (flying) {
            while (elapsedTime >= lastDamilTime) {
                float fally = (endpoint.y - startpoint.y) * (ballistics2.getPosition(lastDamilTime * speed).x - startpoint.x) / (endpoint.x - startpoint.x) + startpoint.y;
                WhiteActor w = new WhiteActor(game,
                        ballistics2.getPosition(lastDamilTime * speed).x, ballistics2.getPosition(getElapsedTime() * speed).y,
                        ballistics2.getPosition(lastDamilTime * speed).x, fally,
                        (falltime - elapsedTime * speed) / (speed * 0.7f)
                );
                whiteActorVector.add(w);
                getStage().addActor(w);
                lastDamilTime += damilTimeStep;
            }
        }
    }

    @Override
    public boolean remove() {
        for(WhiteActor b : whiteActorVector){
            b.remove();
        }
        whiteActorVector.clear();
        return super.remove();
    }
}
