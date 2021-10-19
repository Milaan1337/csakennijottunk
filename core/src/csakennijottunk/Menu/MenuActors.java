package csakennijottunk.Menu;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import csakennijottunk.InGame.InGameScreen;
import csakennijottunk.credit.CreditScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;


public class MenuActors extends OneSpriteStaticActor {
    ClickListener c1;
    public MenuActors(MyGame game) {
        super(game, "badlogic.jpg");
        this.setSize(24,12);
        this.setPosition(-20,12);
        this.setZIndex(2);
        this.addListener(c1 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPop();
            }
        });
    }
}

class CreditLabel2 extends MyLabel {
    public CreditLabel2(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setPosition(43,65);

    }
}

class PlayLabel2 extends MyLabel{
    public PlayLabel2(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setPosition(43,65);

    }
}

class Ls2 extends Label.LabelStyle {
    public Ls2(MyGame game) {
        super(game.getMyAssetManager().getFont("Highman.ttf"), Color.WHITE);
    }
}

class MenuActors2 extends OneSpriteStaticActor {
    ClickListener c2;
    public MenuActors2(MyGame game) {
        super(game, "badlogic.jpg");
        this.setSize(24,12);
        this.setPosition(45 - 12,12);
        this.addListener(c2 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new InGameScreen(game));
            }
        });
    }
}

class BackGroundActor extends OneSpriteStaticActor {
    public BackGroundActor(MyGame game) {
        super(game, "MenuBackground.png");
        this.setSize(170,90);
        this.setPosition(-45,0);
        this.setZIndex(0);
    }
}
class Creditactor extends OneSpriteStaticActor {
    ClickListener b2;
    public Creditactor(MyGame game) {
        super(game, "buttonblue.png");
        this.setSize(24, 12);
        this.setPosition(86, 12);
        this.addListener(b2 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new CreditScreen (game));
            }
        });


    }
}

class MusicActor extends OneSpriteStaticActor {
    ClickListener d2;
    boolean isMuted = false;
    public MusicActor(MyGame game) {
        super(game, "SoundON.png");
        this.setSize(10, 10);
        this.setPosition(115, 0);
    }
}

class MusicActor2 extends OneSpriteStaticActor {
    ClickListener d2;
    boolean isMuted = false;
    public MusicActor2(MyGame game) {
        super(game, "SoundOFF.png");
        this.setSize(10, 10);
        this.setPosition(115, 0);
    }
}