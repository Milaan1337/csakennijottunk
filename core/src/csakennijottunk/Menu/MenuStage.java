package csakennijottunk.Menu;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import csakennijottunk.InGame.BasicVariables;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class MenuStage extends MyStage {
    BackGroundActor h;
    MusicActor m;
    MusicActor2 m2;
    ClickListener mc1;
    ClickListener mc2;
    Ls2 ls2;
    PlayLabel playLabel2;
    CreditLabel creditLabel2;
    ExitLabel exitLabel;
    BasicVariables basicVariables;
    Music music = game.getMyAssetManager().getMusic("music.mp3");
    public MenuStage(MyGame game) {
        super(new ResponseViewport(90), game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        ls2 = new Ls2(game);
        playLabel2 = new PlayLabel(game,"Play",ls2);
        playLabel2.setPositionMiddle();
        addActor(playLabel2);
        playLabel2.setPosition(35,10);
        creditLabel2 = new CreditLabel(game,"Credit",ls2);
        creditLabel2.setPositionMiddle();
        addActor(creditLabel2);
        creditLabel2.setPosition(90, 10);
        exitLabel = new ExitLabel(game,"Exit",ls2);
        exitLabel.setPositionMiddle();
        addActor(exitLabel);
        exitLabel.setPosition(-20, 10);
        h = new BackGroundActor(game);
        addActor(h);
        h.setZIndex(-10);
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
