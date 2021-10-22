package csakennijottunk.credit;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.InGame.BasicVariables;
import csakennijottunk.InGame.Ls;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class CreditStage extends MyStage {
    Ls labelStyle;
    Ls labelStyle2;
    Ls labelStyle3;
    Ls labelStyle4;
    Ls labelStyle5;
    CreditActor MenuBg;
    MusicActor m;
    MusicActor2 m2;
    ClickListener mc1;
    ClickListener mc2;
    CreditlistActor Developers;
    BasicVariables basicVariables;
    Music music = game.getMyAssetManager().getMusic("music.wav");
    public CreditStage(MyGame game) {
        super(new ResponseViewport(90), game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        MenuBg = new CreditActor(game);
        addActor(MenuBg);
        Developers = new CreditlistActor(game);
        addActor(Developers);
        m = new MusicActor(game);
        m2 = new MusicActor2(game);
        m2.setZIndex(100);
        basicVariables = new BasicVariables();
        if (basicVariables.getIsPlaying() == true) {
            addActor(m);
        }
        else{
            addActor(m2);
        }
        m.setZIndex(110);
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
