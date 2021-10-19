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

class Ls2 extends Label.LabelStyle {
    public Ls2(MyGame game) {
        super(game.getMyAssetManager().getFont("Highman.ttf"), Color.WHITE);
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

class MusicActor extends OneSpriteStaticActor {
    ClickListener d2;
    boolean isMuted = false;
    public MusicActor(MyGame game) {
        super(game, "SoundON.png");
        this.setSize(10, 10);
        this.setPosition(115, 0);
    }
}
class PlayLabel extends MyLabel {
    ClickListener b1;
    public PlayLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setPosition(43,65);
        this.addListener(b1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new InGameScreen(game));
            }
        });

    }
}

class ExitLabel extends MyLabel {
    ClickListener b1;
    public ExitLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setPosition(43,65);
        this.addListener(b1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPop();
            }
        });

    }
}

class CreditLabel extends MyLabel{
    ClickListener a1;
    public CreditLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setPosition(43,65);
        this.setZIndex(15);
        this.addListener(a1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new CreditScreen(game));
            }
        });
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