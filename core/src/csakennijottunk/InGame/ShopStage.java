package csakennijottunk.InGame;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class ShopStage extends MyStage {
    BasicVariables basicVariables;
    RodShopLabel RodShopLabel;
    Ls labelStyle;
    Music music = game.getMyAssetManager().getMusic("music.wav");
    MusicActor musicActor;
    MusicActor2 musicActor2;
    ClickListener mc1;
    ClickListener mc2;
    public ShopStage(MyGame game) {
        super(new ResponseViewport(90), game);
        labelStyle = new Ls(game);
        RodShopLabel = new RodShopLabel(game, "FishingRod", labelStyle);
        addActor(RodShopLabel);


        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        basicVariables = new BasicVariables();
        musicActor = new MusicActor(game);
        musicActor2 = new MusicActor2(game);
        musicActor2.setZIndex(50);
        basicVariables = new BasicVariables();
        if (basicVariables.getIsPlaying() == true) {
            addActor(musicActor);
        }
        else{
            addActor(musicActor2);
        }
        musicActor.setZIndex(50);
        if (basicVariables.getIsPlaying() == true) {
            music.play();
        }
        musicActor.addListener(mc1 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                stopMusic();
                musicActor.remove();
                addActor(musicActor2);
            }
        });


        musicActor2.addListener(mc2 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                playMusic();
                musicActor2.remove();
                addActor(musicActor);
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
