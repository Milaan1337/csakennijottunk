package csakennijottunk.Menu;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class MenuStage extends MyStage {
    MenuActors e;
    Creditactor k;
    MenuActors2 b;
    BackGroundActor h;
    MusicActor m;
    MusicActor2 m2;
    ClickListener d2;
    ClickListener d3;
    static boolean isPlaying = true;
    Music music = game.getMyAssetManager().getMusic("music.wav");
    public MenuStage(MyGame game) {
        super(new ResponseViewport(90), game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        e = new MenuActors(game);
        addActor(e);
        e.setZIndex(1);
        b = new MenuActors2(game);
        addActor(b);
        b.setZIndex(0);
        h = new BackGroundActor(game);
        addActor(h);
        h.setZIndex(-10);
        k = new Creditactor(game);
        addActor(k);
        k.setZIndex(-5);
        m = new MusicActor(game);
        addActor(m);
        m.setZIndex(-5);
        m2 = new MusicActor2(game);
        m2.setZIndex(-5);
        if (isPlaying == true) {
            music.play();
            //isPlaying = true;
        }
        m.addListener(d2 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                stopMusic();
                m.remove();
                addActor(m2);
            }
        });


        m2.addListener(d3 = new ClickListener(){
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
        return isPlaying;
    }

    public void playMusic(){
        if (isPlaying == false){
            music.play();
        }
        isPlaying = true;
    }

    public void stopMusic(){
        if (isPlaying == true){
            music.pause();
        }
        isPlaying = false;
    }
}
