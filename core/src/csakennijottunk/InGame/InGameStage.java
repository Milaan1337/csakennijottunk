package csakennijottunk.InGame;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.Label;
import csakennijottunk.Menu.MenuStage;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class InGameStage extends MyStage {
    Header header;
    Ls labelStyle;
    MenuStage ms;
    BasicVariables basicVariables;
    PlayLabel1 playLabel1;
    MusicActor m;
    MusicActor2 m2;
    ClickListener mc1;
    ClickListener mc2;
    Music music = game.getMyAssetManager().getMusic("music.wav");
    public InGameStage(MyGame game) {
        super(new ResponseViewport(90), game);
        labelStyle = new Ls(game);
        playLabel1 = new PlayLabel1(game, "Start",labelStyle);
        addActor(playLabel1);
        //MyLabel moneyLabel = new MyLabel(game,"Ugy tunik meg nincsen horgaszbotod. Vegyel egyet!", labelStyle);
        //addActor(moneyLabel);
        //moneyLabel.setFontScale((float) 0.1);
        //moneyLabel.setFontScale((float) 0.15, (float) 0.1);
        //moneyLabel.setPosition(0,90-28);
        //moneyLabel.setHeight(10);
        //moneyLabel.setZIndex(20);

        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        basicVariables = new BasicVariables();
        //boolean isRod = basicVariables.vanBot();
        //if (isRod == false) {
           // rodShop = new InActors(game);
           // addActor(rodShop);
       // }

        m = new MusicActor(game);
        m2 = new MusicActor2(game);
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
        m.addListener(mc1 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                stopMusic();
                m.remove();
                addActor(m2);
            }
        });


        m2.addListener(mc2 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                playMusic();
                m2.remove();
                addActor(m);
            }
        });

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
