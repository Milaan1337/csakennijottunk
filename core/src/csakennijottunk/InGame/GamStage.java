package csakennijottunk.InGame;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;

import hu.csanyzeg.master.Math.Ballistics2;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class GamStage extends MyStage {

    public Vector2 fisherMan = new Vector2(200, 190);
    public Vector2 fishingRod = new Vector2(10, 10);
    public MyLabel vLabel;
    IngameBackground ingameBackground2;
    Music music = game.getMyAssetManager().getMusic("music.wav");
    MusicActor m;
    MusicActor2 m2;
    ClickListener d1;
    ClickListener d2;
    BasicVariables basicVariables;
    FisherManGroup fisherManActor;

    public void generateFlying(){
        ArrayList<Actor> actors = new ArrayList<Actor>();
        for (Actor a:getActors()) {
            if (a instanceof FlyActor){
                actors.add(a);
            }
        }
        for (Actor a:actors) {
            getActors().removeValue(a, true);
        }
        Ballistics2 ballistics2 = new Ballistics2(fisherManActor.v0, MathUtils.degreesToRadians * fisherManActor.degree, fisherManActor.get_handEnd().x, fisherManActor.get_handEnd().y);
        for(float x = fisherManActor.get_handEnd().x; x < getViewport().getWorldWidth(); x+=20) {
            addActor(new FlyActor(game, x, ballistics2.getY(x)));
        }
    }

    public Vector2 getFishingRodEnd(){
        Vector2 fishingRodEnd = new Vector2(fishingRod);
        fishingRodEnd.rotate(fisherManActor.degree);
        fishingRodEnd.add(fisherMan);
        return fishingRodEnd;
    }

    public GamStage(MyGame game) {
        super(new ResponseViewport(2048), game);
        //addActor(new GameActor(game));
        addBackButtonScreenBackByStackPopListener();
        addListener(new ClickListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                System.out.println("x= " + x  + " y= " + y);
                fisherManActor.set_angle(heightToDegree(y));
                fisherManActor.set_speed(widthToSpeed(x));
                vLabel.setText("" + (int)fisherManActor.degree + "°");
                generateFlying();
                super.touchDragged(event, x, y, pointer);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                addActor(new FishFoodActor(game, new Ballistics2(fisherManActor.v0, MathUtils.degreesToRadians * fisherManActor.degree, fisherManActor.get_handEnd().x, fisherManActor.get_handEnd().y), 10));
            }
        });
        addActor(vLabel = new MyLabel(game, "", new Label.LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), null)));
        addActor(fisherManActor = new FisherManGroup(game));
        //addActor(horgaszman = new FisherManActor(game, fisherMan.x, fisherMan.y));
        //addActor(new TesztActor(game, fishingRod.x, fishingRod.y));
        //addActor(fishermanHandActor = new FisherManHandActor(game, getFishingRodEnd().x, getFishingRodEnd().y));
        m = new MusicActor(game);
        m.setSize(56.88888888888889f, 56.88888888888889f);
        m.setPosition(853, 0);
        m2 = new MusicActor2(game);
        m2.setSize(56.88888888888889f, 56.88888888888889f);
        m2.setPosition(853, 0);
        m2.setZIndex(-5);
        basicVariables = new BasicVariables();
        if (basicVariables.getIsPlaying() == true) {
            addActor(m);
        }
        else{
            addActor(m2);
        }
        m.setZIndex(-5);
        if (basicVariables.getIsPlaying() == true) {
            music.play();
        }
        m.addListener(d1 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                stopMusic();
                m.remove();
                addActor(m2);
            }
        });


        m2.addListener(d2 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                playMusic();
                m2.remove();
                addActor(m);
            }
        });
        ingameBackground2 = new IngameBackground(game);
        //addActor(ingameBackground2);
        //ingameBackground2.setZIndex(-95);

        addActor(vLabel = new MyLabel(game, "ASD", new Label.LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), null)));
        //addActor(new TesztActor(game, fishingRod.x, fishingRod.y));
        //addActor(fishermanHandActor = new FisherManHandActor(game, 0,0));

    }

    public float widthToSpeed(float x) {
        float d = x / getViewport().getWorldWidth() * 100;
        return d < 0 ? 0 : d > 100 ? 100 : d;
    }

    public float heightToDegree(float y){
        float d = y / getViewport().getWorldHeight() * 90;
        return d < 0 ? 0 : d > 85 ? 85 : d;
    }

    public boolean getState(){
        return basicVariables.getIsPlaying();
    }

    public void playMusic(){
        if (basicVariables.getIsPlaying() == false){
            music.play();
        }
        basicVariables.setIsPlaying(true);
    }

    public void stopMusic(){
        if (basicVariables.getIsPlaying() == true){
            music.pause();
        }
        basicVariables.setIsPlaying(false);
    }

}
